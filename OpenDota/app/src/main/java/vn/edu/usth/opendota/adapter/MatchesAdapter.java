package vn.edu.usth.opendota.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.Matches;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private List<Matches> matches = new ArrayList<>();

    public void submit(List<Matches> newList) {
        matches = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.khung_trandau, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding(position);
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitle;
        private final TextView tvKda;
        private final TextView tvTimeEnded;
        private final TextView idDuration;
        private final ImageView avatar;
        private final View lineView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvKda = itemView.findViewById(R.id.tv_kda);
            tvTimeEnded = itemView.findViewById(R.id.tv_time_ended);
            idDuration = itemView.findViewById(R.id.id_duration);
            avatar = itemView.findViewById(R.id.avatar);
            lineView = itemView.findViewById(R.id.line_view);
        }

        public void binding(Integer position) {
            Matches item = matches.get(position);

            String mode = item.getModes();
            tvTitle.setText(mode);

            String kda = item.getKills() + "/" + item.getDeaths() + "/" + item.getAssists();
            tvKda.setText(kda);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date date = new Date(item.getStartTime());
            String formattedDate = sdf.format(date);
            tvTimeEnded.setText(formattedDate);

            long duration = item.getDuration();
            long minutes = duration / 60;
            long seconds = duration % 60;
            String formattedTime = String.format("%02d:%02d", minutes, seconds);
            idDuration.setText(formattedTime);

            avatar.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), item.getAvatarResId()));


            if (item.isWin()) {
                lineView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), android.R.color.holo_green_dark));
            } else {
                lineView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), android.R.color.holo_red_dark));
            }
        }
    }
}
