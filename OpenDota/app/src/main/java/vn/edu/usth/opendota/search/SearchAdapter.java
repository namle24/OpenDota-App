package vn.edu.usth.opendota.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.ProPlayerObj;
import vn.edu.usth.opendota.profile.overview.RecentMatchesAdapter;
;

public abstract class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHolder>{
    private Context context;
    private ArrayList<ProPlayerObj> arrayListUser;
    private RecentMatchesAdapter recentMatchesAdapter;

    private IOnSearchAdapterListener listener;



    private final String TAG = SearchAdapter.class.getSimpleName();

    public SearchAdapter(Context context, ArrayList<ProPlayerObj> arrayListUser, IOnSearchAdapterListener listener){
        this.context = context;
        this.arrayListUser = arrayListUser;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        final ProPlayerObj user = arrayListUser.get(position);
        if (user == null) {
            return;
        }

        holder.userName.setText(user.getName());
        holder.userID.setText(String.valueOf(user.getAccountId()));
        Picasso.get().load(user.getAvatarmedium()).into(holder.imgAvatar);

        holder.ivFavorite.setImageResource(user.isFavorited() ? R.drawable.baseline_star_24 : R.drawable.baseline_star_border_24);

        holder.cardViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickItem(user);
            }
        });

        holder.ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.isFavorited()) {
                    listener.onClickFavorite(user);
                    user.setFavorited(false);
                } else {
                    listener.onClickFavorite(user);
                    user.setFavorited(true);
                }
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount () {
        if (arrayListUser != null) {
            return arrayListUser.size();
        }
        return 0;
    }

    public abstract void onClickItem(ProPlayerObj user);

    public abstract void onClickFavorite(ProPlayerObj user);


    public class MyHolder extends RecyclerView.ViewHolder {
        private CardView cardViewItem;
        private ImageView imgAvatar;
        private ImageView ivFavorite;
        private TextView userName;
        private TextView userID;

        public MyHolder(@NonNull View itemView) { // khai bao thanh phan co trong item_file
            super(itemView);
            cardViewItem = itemView.findViewById(R.id.layout_item_file);
            userName=itemView.findViewById(R.id.name);
            userID=itemView.findViewById(R.id.ID);
            imgAvatar=itemView.findViewById(R.id.img);
            ivFavorite=itemView.findViewById(R.id.favorite_button);
        }
    }


    public interface IOnSearchAdapterListener{
        void onClickItem(ProPlayerObj user);
        void onClickFavorite(ProPlayerObj user);

    }
}