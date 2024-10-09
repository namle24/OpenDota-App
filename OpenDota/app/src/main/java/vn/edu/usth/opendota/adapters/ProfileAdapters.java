package vn.edu.usth.opendota.adapters;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.Profile;

public class ProfileAdapters extends RecyclerView.Adapter<ProfileAdapters.ViewHolder> {

    private List<Profile> profiles = new ArrayList<>();

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

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ProfileAdapters.ViewHolder holder, int position) {
        Profile item = profiles.get(position);

        Log.d(TAG, "Heroes Details: " + item.toString());

        String accid = String.valueOf(item.getAccountID());
        holder.profile_id.setText(accid);

        String accname = item.getName();
        holder.profile_name.setText(accname);

        String accavar = (String) item.getAvatarfull();
        Picasso.get().load(accavar).into(holder.profile_avar);

        holder.heart.setSelected(item.getFavourite());

        holder.heart.setOnClickListener(v -> {
            boolean newState = !holder.heart.isSelected();
            holder.heart.setSelected(newState);
            item.setFavourite(newState);
            Log.d(TAG, "Heart button clicked, new state: " + newState);
        });
    }
}