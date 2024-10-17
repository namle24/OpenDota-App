package vn.edu.usth.opendota.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.RecentMatchesObj;
import vn.edu.usth.opendota.utils.Db;
import vn.edu.usth.opendota.utils.Util;


public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.matchesViewHolder> {
    private Context context;
    ArrayList<RecentMatchesObj> listMatches;

    public MatchesAdapter(Context context, ArrayList<RecentMatchesObj> listMatches) {
        this.context=context;
        this.listMatches = listMatches;
    }

    @NonNull
    @Override
    public matchesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_matches_frame,parent,false);
        return new matchesViewHolder(view);
    }

    @Override
    // bind data len list
    public void onBindViewHolder(@NonNull matchesViewHolder holder, int position) {
        RecentMatchesObj model = listMatches.get(position);
        holder.mode.setText(Util.getGameModeNameById(model.getGame_mode())+"\n"+Util.getLobbyTypeNameById(model.getLobby_type()));
        holder.ended.setText(Util.getDateByTimeStamp(model.getStart_time()));
        holder.length.setText(Util.getDurationStr(model.getDuration()));
        holder.KDA.setText(model.getKills() + "/" + model.getDeaths() + "/" + model.getAssists());
    }

    @Override
    public int getItemCount() {
        if (listMatches != null) {
            return listMatches.size();
        }
        return 0;
    }

    public static class matchesViewHolder extends RecyclerView.ViewHolder {
        private CardView cardViewItem;
        private ImageView hero;
        private TextView mode;
        private TextView ended;
        private TextView length;
        private TextView KDA;

        public matchesViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewItem=itemView.findViewById(R.id.layout_item_file);
            hero=itemView.findViewById(R.id.rm_hero);
            mode=itemView.findViewById(R.id.re_mode);
            ended=itemView.findViewById(R.id.rm_ended);
            length=itemView.findViewById(R.id.rm_length);
            KDA=itemView.findViewById(R.id.rm_K_D_A);
        }
    }
}
