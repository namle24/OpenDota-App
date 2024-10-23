package vn.edu.usth.opendota.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.ProPlayerProfile;

public class ProfileAdapters extends RecyclerView.Adapter<ProfileAdapters.ViewHolder> {

    private final List<ProPlayerProfile> proPlayerProfiles = new ArrayList<>();
    private final Context context;
    private final OnItemClickListener onItemClickListener;

    public ProfileAdapters(Context context, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void submit(List<ProPlayerProfile> newList) {
        proPlayerProfiles.clear();
        proPlayerProfiles.addAll(newList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_profile_frame, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return proPlayerProfiles.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProPlayerProfile item = proPlayerProfiles.get(position);

        holder.profile_id.setText(String.valueOf(item.getAccountID()));
        holder.profile_name.setText(item.getName());

        String avatarUrl = item.getAvatarmedium();
        if (avatarUrl != null && !avatarUrl.isEmpty()) {
            Picasso.get().load(avatarUrl).into(holder.profile_avar);
        } else {
            holder.profile_avar.setImageResource(R.drawable.no_item);
        }

        // Kiểm tra trạng thái yêu thích và cập nhật nút trái tim
        boolean isFavourite = checkIfFavourite(item);
        holder.heart.setSelected(isFavourite);  // Đảm bảo nút trái tim hiển thị đúng trạng thái yêu thích

        // Xử lý sự kiện click vào trái tim
        holder.heart.setOnClickListener(v -> {
            boolean newState = !holder.heart.isSelected();
            holder.heart.setSelected(newState);  // Cập nhật trạng thái ngay lập tức khi click

            if (newState) {
                addToFavourites(item);
            } else {
                removeFromFavourites(item);
            }
        });

        // Xử lý sự kiện click vào mục người chơi
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(item));
    }


    // Kiểm tra nếu người chơi đã được thêm vào danh sách yêu thích
    private boolean checkIfFavourite(ProPlayerProfile proPlayerProfile) {
        List<ProPlayerProfile> favourites = getFavourites();
        for (ProPlayerProfile fav : favourites) {
            if (fav.getAccountID() == proPlayerProfile.getAccountID()) {
                return true;
            }
        }
        return false;
    }

    // Lấy danh sách người chơi yêu thích từ SharedPreferences
    private List<ProPlayerProfile> getFavourites() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("favorite_profiles", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("favorites_list", null);
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<ProPlayerProfile>>() {
            }.getType();
            return gson.fromJson(json, type);
        }
        return new ArrayList<>();
    }

    // Lưu danh sách người chơi yêu thích vào SharedPreferences
    private void saveFavourites(List<ProPlayerProfile> favourites) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("favorite_profiles", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favourites);
        editor.putString("favorites_list", json);
        editor.apply();
    }

    // Thêm người chơi vào danh sách yêu thích
    private void addToFavourites(ProPlayerProfile proPlayerProfile) {
        List<ProPlayerProfile> favourites = getFavourites();
        favourites.add(proPlayerProfile);
        saveFavourites(favourites);
    }

    // Xóa người chơi khỏi danh sách yêu thích
    private void removeFromFavourites(ProPlayerProfile proPlayerProfile) {
        List<ProPlayerProfile> favourites = getFavourites();
        favourites.removeIf(fav -> fav.getAccountID() == proPlayerProfile.getAccountID());
        saveFavourites(favourites);
    }

    public interface OnItemClickListener {
        void onItemClick(ProPlayerProfile proPlayerProfile);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView profile_avar;
        public final TextView profile_id;
        public final TextView profile_name;
        public final ImageButton heart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_name = itemView.findViewById(R.id.profile_name);
            profile_avar = itemView.findViewById(R.id.profile_avar);
            profile_id = itemView.findViewById(R.id.profile_id);
            heart = itemView.findViewById(R.id.heart_button);
        }
    }
}
