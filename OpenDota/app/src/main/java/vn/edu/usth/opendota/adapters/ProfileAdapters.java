package vn.edu.usth.opendota.adapters;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.Profile;

public class ProfileAdapters extends RecyclerView.Adapter<ProfileAdapters.ViewHolder> {

    private List<Profile> profiles = new ArrayList<>();
    private Context context;

    public ProfileAdapters(Context context) {
        this.context = context;

    }

    @SuppressLint("NotifyDataSetChanged")
    public void submit(List<Profile> newList) {
        profiles.clear();
        profiles.addAll(newList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_profile_frame, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView profile_avar;
        private final TextView profile_id;
        private final TextView profile_name;
        private final ImageButton heart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profile_name = itemView.findViewById(R.id.profile_name);
            profile_avar = itemView.findViewById(R.id.profile_avar);
            profile_id = itemView.findViewById(R.id.profile_id);
            heart = itemView.findViewById(R.id.heart_button);
        }

    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapters.ViewHolder holder, int position) {
        Profile item = profiles.get(position);

        // Hiển thị thông tin người dùng
        holder.profile_id.setText(String.valueOf(item.getAccountID()));
        holder.profile_name.setText(item.getName());
        String avatarUrl = (String) item.getAvatarfull(); // Ép kiểu Object thành String
        if (avatarUrl != null && !avatarUrl.isEmpty()) {
            Picasso.get().load(avatarUrl).into(holder.profile_avar);
        } else {
            // Nếu avatar URL không hợp lệ, dùng ảnh mặc định
            holder.profile_avar.setImageResource(R.drawable.no_item);
        };

        // Kiểm tra xem profile này có phải là yêu thích không
        boolean isFavourite = checkIfFavourite(item);
        holder.heart.setSelected(isFavourite);

        // Xử lý sự kiện khi bấm vào nút trái tim
        holder.heart.setOnClickListener(v -> {
            boolean newState = !holder.heart.isSelected();
            holder.heart.setSelected(newState);

            if (newState) {
                // Thêm profile vào danh sách yêu thích
                addToFavourites(item);
            } else {
                // Bỏ profile khỏi danh sách yêu thích
                removeFromFavourites(item);
            }
        });
    }

    // Hàm kiểm tra nếu profile đã nằm trong danh sách yêu thích
    private boolean checkIfFavourite(Profile profile) {
        List<Profile> favourites = getFavourites();
        for (Profile fav : favourites) {
            if (fav.getAccountID() == profile.getAccountID()) {
                return true;
            }
        }
        return false;
    }

    // Lấy danh sách profile yêu thích từ SharedPreferences
    private List<Profile> getFavourites() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("favorite_profiles", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("favorites_list", null);
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Profile>>() {}.getType();
            return gson.fromJson(json, type);
        }
        return new ArrayList<>();
    }

    // Lưu danh sách yêu thích vào SharedPreferences
    private void saveFavourites(List<Profile> favourites) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("favorite_profiles", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favourites);
        editor.putString("favorites_list", json);
        editor.apply();
    }

    // Thêm profile vào danh sách yêu thích
    private void addToFavourites(Profile profile) {
        List<Profile> favourites = getFavourites();
        favourites.add(profile);
        saveFavourites(favourites);
    }

    // Xóa profile khỏi danh sách yêu thích
    private void removeFromFavourites(Profile profile) {
        List<Profile> favourites = getFavourites();
        favourites.removeIf(fav -> fav.getAccountID() == profile.getAccountID());
        saveFavourites(favourites);
    }
}
