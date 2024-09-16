package vn.edu.usth.opendota.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.search.User;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.UserViewHolder> {
    private List<User> mListUser;

    public SearchAdapter(List<User> mListUser) {
        this.mListUser = mListUser;
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
        if (user == null)  {
            return;
        }

        holder.imgUser.setImageResource(user.getImage());
        holder.tvName.setText(user.getName());
        holder.tvID.setText(String.valueOf(user.getId()));
        holder.tvRank.setImageResource(user.getImage());
    }

    @Override
    public int getItemCount() {
        if (mListUser != null) {
            return mListUser.size();
        }
        return 0;
    }

    public void filterList(List<User> filteredList) {
        this.mListUser = filteredList;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView imgUser;
        private TextView tvName;
        private TextView tvID;
        private ImageView tvRank;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.img_user);
            tvName = itemView.findViewById(R.id.name);
            tvID = itemView.findViewById(R.id.ID);
            tvRank = itemView.findViewById(R.id.user_rank);
        }
    }
}