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

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.ProPlayerProfile;

public class ProfileAdapters extends RecyclerView.Adapter<ProfileAdapters.ViewHolder> {

    private List<ProPlayerProfile> proPlayerProfiles = new ArrayList<>();
    private Context context;

    public ProfileAdapters(Context context) {
        this.context = context;
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
        return proPlayerProfiles.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapters.ViewHolder holder, int position) {
        ProPlayerProfile item = proPlayerProfiles.get(position);
        holder.profile_id.setText(String.valueOf(item.getAccountID()));
        holder.profile_name.setText(item.getName());
        String avatarUrl = (String) item.getAvatarfull();
        if (avatarUrl != null && !avatarUrl.isEmpty()) {
            Picasso.get().load(avatarUrl).into(holder.profile_avar);
        } else {
            holder.profile_avar.setImageResource(R.drawable.no_item);
        }
        boolean isFavourite = checkIfFavourite(item);
        holder.heart.setSelected(isFavourite);

        holder.heart.setOnClickListener(v -> {
            boolean newState = !holder.heart.isSelected();
            holder.heart.setSelected(newState);

            if (newState) {
                addToFavourites(item);
            } else {
                removeFromFavourites(item);
            }
        });
    }

    private boolean checkIfFavourite(ProPlayerProfile proPlayerProfile) {
        List<ProPlayerProfile> favourites = getFavourites();
        for (ProPlayerProfile fav : favourites) {
            if (fav.getAccountID() == proPlayerProfile.getAccountID()) {
                return true;
            }
        }
        return false;
    }

    private List<ProPlayerProfile> getFavourites() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("favorite_profiles", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("favorites_list", null);
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<ProPlayerProfile>>() {}.getType();
            return gson.fromJson(json, type);
        }
        return new ArrayList<>();
    }

    private void saveFavourites(List<ProPlayerProfile> favourites) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("favorite_profiles", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favourites);
        editor.putString("favorites_list", json);
        editor.apply();
    }

    private void addToFavourites(ProPlayerProfile proPlayerProfile) {
        List<ProPlayerProfile> favourites = getFavourites();
        favourites.add(proPlayerProfile);
        saveFavourites(favourites);
    }

    private void removeFromFavourites(ProPlayerProfile proPlayerProfile) {
        List<ProPlayerProfile> favourites = getFavourites();
        favourites.removeIf(fav -> fav.getAccountID() == proPlayerProfile.getAccountID());
        saveFavourites(favourites);
    }
}
