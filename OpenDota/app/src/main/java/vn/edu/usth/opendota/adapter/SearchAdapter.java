package vn.edu.usth.opendota.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.search.User;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.UserViewHolder> {

    private List<User> mListUser;
    private OnItemClickListener itemClickListener;

    public SearchAdapter(List<User> mListUser, OnItemClickListener itemClickListener) {
        this.mListUser = mListUser;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        User user = mListUser.get(position);
        if (user == null) {
            return;
        }

        holder.imgUser.setImageResource(user.getImage());
        holder.tvName.setText(user.getName());
        holder.tvID.setText(user.getId());

        holder.tvRank.setOnClickListener(v -> {
            boolean isSelected = !v.isSelected();
            v.setSelected(isSelected);

            if (itemClickListener != null) {
                itemClickListener.onItemClick(position, isSelected);
            }
        });

        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(position, user);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListUser != null ? mListUser.size() : 0;
    }

    public void filterList(List<User> filteredList) {
        this.mListUser = filteredList;
        notifyDataSetChanged();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private final CircleImageView imgUser;
        private final TextView tvName;
        private final TextView tvID;
        private final ImageButton tvRank;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.img_user);
            tvName = itemView.findViewById(R.id.name);
            tvID = itemView.findViewById(R.id.ID);
            tvRank = itemView.findViewById(R.id.user_imagerank);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, User user);
        void onItemClick(int position, boolean isSelected);
    }
}
