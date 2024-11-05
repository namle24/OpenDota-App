package vn.edu.usth.opendota.adapters;

import static android.content.ContentValues.TAG;
import static vn.edu.usth.opendota.utils.Db.getGameModeNameById;
import static vn.edu.usth.opendota.utils.Db.getHeroNameByID;
import static vn.edu.usth.opendota.utils.Db.getLobbyTypeNameById;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.Matches;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private List<Matches> matches = new ArrayList<>();
    public static final String TAG = "MATCHES Adapters";


    public MatchesAdapter(Context context, ArrayList<Matches> listRecentMatches) {
    }

    @SuppressLint("NotifyDataSetChanged")
    public void submit(List<Matches> newList) {
        matches = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_matches_frame, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitle;
        private final TextView tvKda;
        private final TextView tvTimeEnded;
        private final TextView idDuration;
        private final ImageView avatar;
        private final View lineview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvKda = itemView.findViewById(R.id.tv_kda);
            tvTimeEnded = itemView.findViewById(R.id.tv_time_ended);
            idDuration = itemView.findViewById(R.id.id_duration);
            avatar = itemView.findViewById(R.id.avatar);
            lineview = itemView.findViewById(R.id.line_view);
        }


    }
    @Override
    public int getItemCount() {
        return matches.size();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MatchesAdapter.ViewHolder holder, int position) {
        Matches item = matches.get(position);

        int gamemode = (int) item.getGameMode();
        int type = (int) item.getLobbyType();
        String mode = getGameModeNameById(gamemode) + " " + getLobbyTypeNameById(type);
        holder.tvTitle.setText(mode);

        String kda = item.getKills() + "/" + item.getDeaths() + "/" + item.getAssists();
        holder.tvKda.setText(kda);


        Date date = new Date(item.getStartTime() * 1000);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(date);
        holder.tvTimeEnded.setText(formattedDate);

        int minutes = (int) (item.getDuration() / 60);
        int seconds = (int) (item.getDuration() % 60);
        @SuppressLint("DefaultLocale") String formattedTime = String.format("%02d:%02d", minutes, seconds);
        holder.idDuration.setText(formattedTime);

        int heroId = (int) item.getHeroID();
        String heroName = getHeroNameByID(heroId);
        String imageUrl = "https://cdn.dota2.com/apps/dota2/images/heroes/"+heroName+"_full.png";
        Log.d(TAG,"ID: " + item.getHeroID()+ " - URL: " + imageUrl);
        Picasso.get().load(imageUrl).into(holder.avatar);

        int playerSlot = (int) item.getPlayerSlot();
        if (playerSlot >= 0 && playerSlot <= 127) { // Radiant team
            if (item.getRadiantWin()) {
                holder.lineview.setBackgroundResource(R.drawable.gradient_win_color); // Radiant wins
            } else {
                holder.lineview.setBackgroundResource(R.drawable.gradient_loss_color); // Radiant loses
            }
        } else if (playerSlot >= 128 && playerSlot <= 255) { // Dire team
            if (item.getRadiantWin()) {
                holder.lineview.setBackgroundResource(R.drawable.gradient_loss_color); // Dire wins
            } else {
                holder.lineview.setBackgroundResource(R.drawable.gradient_win_color); // Dire loses
            }
        }
    }
}