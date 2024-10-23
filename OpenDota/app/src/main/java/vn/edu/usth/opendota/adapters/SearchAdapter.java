package vn.edu.usth.opendota.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.ProPlayerProfile;
import vn.edu.usth.opendota.utils.PrefUtil;


public abstract class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHolder>{
    private Context context;
    private List<ProPlayerProfile> arrayListUser;
    private IOnSearchAdapterListener listener;



    private final String TAG = SearchAdapter.class.getSimpleName();

    public SearchAdapter(Context context, List<ProPlayerProfile> arrayListUser, IOnSearchAdapterListener listener){
        this.context = context;
        this.arrayListUser = arrayListUser;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_profile_frame,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        final ProPlayerProfile user = arrayListUser.get(position);
        if (user == null) {
            return;
        }

        // Cập nhật trạng thái yêu thích từ PrefUtil
        boolean isFavorited = PrefUtil.isFavorite(context, String.valueOf(user.getAccountID()));
        user.setFavorited(isFavorited);

        holder.userName.setText(user.getName());
        holder.userID.setText(String.valueOf(user.getAccountID()));
        Picasso.get().load(user.getAvatarmedium()).into(holder.imgAvatar);

        // Đặt đúng hình ảnh cho nút trái tim
        holder.ivFavorite.setImageResource(user.isFavorited() ? R.drawable.baseline_favorite_24 : R.drawable.heart_icon);

        holder.cardViewItem.setOnClickListener(view -> listener.onClickItem(user));

        holder.ivFavorite.setOnClickListener(view -> {
            if (user.isFavorited()) {
                listener.onClickFavorite(user);  // Gọi hàm để xử lý yêu thích
                PrefUtil.removeFavorite(context, user);  // Xóa khỏi danh sách yêu thích
                user.setFavorited(false);
            } else {
                listener.onClickFavorite(user);  // Gọi hàm để xử lý yêu thích
                PrefUtil.addToFavorites(context, user);  // Thêm vào danh sách yêu thích
                user.setFavorited(true);
            }
            notifyItemChanged(position);  // Cập nhật lại giao diện
        });
    }


    @Override
    public int getItemCount () {
        if (arrayListUser != null) {
            return arrayListUser.size();
        }
        return 0;
    }

    public abstract void onClickItem(ProPlayerProfile user);

    public abstract void onClickFavorite(ProPlayerProfile user);


    public class MyHolder extends RecyclerView.ViewHolder {
        private CardView cardViewItem;
        private CircleImageView imgAvatar;
        private ImageButton ivFavorite;
        private TextView userName;
        private TextView userID;

        public MyHolder(@NonNull View itemView) { // khai bao thanh phan co trong item_file
            super(itemView);
            cardViewItem = itemView.findViewById(R.id.profile_frame);
            userName=itemView.findViewById(R.id.profile_name);
            userID=itemView.findViewById(R.id.profile_id);
            imgAvatar=itemView.findViewById(R.id.profile_avar);
            ivFavorite=itemView.findViewById(R.id.heart_button);
        }
    }


    public interface IOnSearchAdapterListener{
        void onClickItem(ProPlayerProfile user);
        void onClickFavorite(ProPlayerProfile user);
    }
}