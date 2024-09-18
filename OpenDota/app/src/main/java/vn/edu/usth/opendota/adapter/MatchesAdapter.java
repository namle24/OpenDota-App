package vn.edu.usth.opendota.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.matches.Matches;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {
    private List<Matches> matches = new ArrayList<>();
    private OnClickListener onClickListener;

    public void submit(List<Matches> newList) {
        matches = newList;
        notifyDataSetChanged();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.khung_trandau, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Matches item = matches.get(position);

        holder.itemView.setOnClickListener(view -> {
            if (onClickListener != null) {
                onClickListener.onClick(position, item);
            }
        });

        String mode = item.getModes();
        holder.tvTitle.setText(mode);

        String kda = item.getKills() + "/" + item.getDeaths() + "/" + item.getAssists();
        holder.tvKda.setText(kda);

        holder.tvTimeEnded.setText(item.getStartTime());
        holder.idDuration.setText(item.getDuration());

        holder.avatar.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), item.getAvatarResId()));

        if (item.isWin()) {
            holder.lineView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.winProgress));
        } else {
            holder.lineView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.looseProgress));
        }
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public interface OnClickListener {
        void onClick(int position, Matches match);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
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
    }
}