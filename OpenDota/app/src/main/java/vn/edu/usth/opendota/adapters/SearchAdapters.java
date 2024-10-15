package vn.edu.usth.opendota.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.Profile;

public class SearchAdapters extends RecyclerView.Adapter<SearchAdapters.ProfileViewHolder> {
    private List<Profile> profileList;
    private Context context;
    private OnProfileClickListener listener;

    public interface OnProfileClickListener {
        void onProfileClick(Profile profile);
    }

    public SearchAdapters(Context context, OnProfileClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void submit(List<Profile> profiles) {
        this.profileList = profiles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_my_profile, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        Profile profile = profileList.get(position);
        holder.nameTextView.setText(profile.getName());
        holder.itemView.setOnClickListener(v -> listener.onProfileClick(profile));
    }

    @Override
    public int getItemCount() {
        return profileList != null ? profileList.size() : 0;
    }

    static class ProfileViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.profile_name);        }
    }
}
