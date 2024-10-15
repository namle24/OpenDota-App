package vn.edu.usth.opendota.profile.overview;

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
import vn.edu.usth.opendota.models.ProPlayerObj;
import vn.edu.usth.opendota.models.RecentMatchesObj;
import vn.edu.usth.opendota.search.SearchAdapter;


public class RecentMatchesAdapter extends RecyclerView.Adapter<RecentMatchesAdapter.MyRecentMatchHolder> {
    private Context context;
    private ArrayList<ProPlayerObj> arrayListUser;
    private ArrayList<RecentMatchesObj> arrayRecentMatches;
    private final String TAG = SearchAdapter.class.getSimpleName();

    public RecentMatchesAdapter(Context context, ArrayList<RecentMatchesObj> arrayRecentMatches) {
        this.context = context;
        this.arrayRecentMatches=arrayRecentMatches;
    }

    @NonNull
    @Override
    public MyRecentMatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recentmatch_match_item, parent, false);
        return new MyRecentMatchHolder(view);

    }


    // bind data len list
    @Override
    public void onBindViewHolder(@NonNull MyRecentMatchHolder holder, int position) {
        final RecentMatchesObj match = arrayRecentMatches.get(position);
        if (match == null) {
            return;
        }
        holder.rmLength.setText(match.getDuration()+"");
        holder.rmKDA.setText(match.getSkill()+"/"+match.getDeaths()+"/"+match.getAssists());
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class MyRecentMatchHolder extends RecyclerView.ViewHolder {
        private CardView cardViewItem;
        private ImageView rmHero;
        private TextView rmMode;
        private TextView rmEnded;
        private TextView rmLength;
        private TextView rmKDA;


        public MyRecentMatchHolder(@NonNull View itemView) { // khai bao thanh phan co trong item_file
            super(itemView);
            rmHero = itemView.findViewById(R.id.img);
            rmMode = itemView.findViewById(R.id.ID);
            rmEnded = itemView.findViewById(R.id.ID);
            rmLength = itemView.findViewById(R.id.ID);
            rmLength = itemView.findViewById(R.id.ID);
            rmKDA = itemView.findViewById(R.id.img);
        }
    }
}

