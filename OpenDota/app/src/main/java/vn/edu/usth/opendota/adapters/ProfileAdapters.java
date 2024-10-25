package vn.edu.usth.opendota.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
    private static final String KEY_FAVORITES = "favorite_players";
    private final String TAG = ProfileAdapters.class.getSimpleName();
    private final ArrayList<ProPlayerProfile> proPlayerProfiles;
    private final Context context;
    private final OnItemClickListener onItemClickListener;

    public ProfileAdapters(Context context, ArrayList<ProPlayerProfile> proPlayerProfiles, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.proPlayerProfiles = proPlayerProfiles;
        this.onItemClickListener = onItemClickListener;
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
    public void onBindViewHolder(@NonNull ProfileAdapters.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ProPlayerProfile item = proPlayerProfiles.get(position);
        if (item == null) {
            return;
        }
        holder.profile_id.setText(String.valueOf(item.getAccountId()));
        holder.profile_name.setText(item.getName());
        String avatarUrl = (String) item.getAvatarfull();
        if (avatarUrl != null && !avatarUrl.isEmpty()) {
            Picasso.get().load(avatarUrl).into(holder.profile_avar);
        } else {
            holder.profile_avar.setImageResource(R.drawable.no_item);
        }

        holder.heart.setImageResource(item.isFavorited() ? R.drawable.baseline_favorite_24 : R.drawable.heart_icon);

        holder.cardViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(item);
            }
        });

        holder.heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.isFavorited()) {
                    onItemClickListener.onClickFavorite(item);
                    item.setFavorited(false);
                } else {
                    onItemClickListener.onClickFavorite(item);
                    item.setFavorited(true);
                }
                notifyItemChanged(position);
            }
        });

    }


    public interface OnItemClickListener {
        void onItemClick(ProPlayerProfile proPlayerProfile);
        void onClickFavorite(ProPlayerProfile proPlayerProfile);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardViewItem;
        public final ImageView profile_avar;
        private final TextView profile_id;
        private final TextView profile_name;
        private final ImageView heart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewItem = itemView.findViewById(R.id.layout_item_file);
            profile_name = itemView.findViewById(R.id.name);
            profile_avar = itemView.findViewById(R.id.img);
            profile_id = itemView.findViewById(R.id.ID);
            heart = itemView.findViewById(R.id.favorite_button);
        }
    }

}