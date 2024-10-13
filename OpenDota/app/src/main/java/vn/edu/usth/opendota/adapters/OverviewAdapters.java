package vn.edu.usth.opendota.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.Overview;

public class OverviewAdapters extends RecyclerView.Adapter<OverviewAdapters.ViewHolder> {

    private List<Overview> overviews = new ArrayList<>();
    private Context context;

    public OverviewAdapters() {
        this.context = context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void submit(List<Overview> newList) {
        overviews.clear();
        overviews.addAll(newList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_overview, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView ow_avar;
        private final TextView ow_name;
        private final TextView ow_win;
        private final TextView ow_lose;
        private final TextView ow_winrate;
        private final ImageView ow_ranked;
        private final TextView ow_url;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ow_avar = itemView.findViewById(R.id.ow_avar);
            ow_name = itemView.findViewById(R.id.ow_name);
            ow_win = itemView.findViewById(R.id.ow_win);
            ow_lose = itemView.findViewById(R.id.ow_lose);
            ow_winrate = itemView.findViewById(R.id.ow_winrate);
            ow_ranked = itemView.findViewById(R.id.ow_ranked);
            ow_url = itemView.findViewById(R.id.ow_profile_steam);

        }
    }

    @Override
    public int getItemCount() {
        return overviews.size();
    }

    @Override
    public void onBindViewHolder(@NonNull OverviewAdapters.ViewHolder holder, int position) {
        Overview item = overviews.get(position);

        String avatarUrl = String.valueOf(item.getProfile().getAvatarfull());
        Picasso.get().load(avatarUrl).into(holder.ow_avar);

        holder.ow_name.setText(String.valueOf(item.getProfile().getName()));
        holder.ow_win.setText("WINS\n"+item.getWinlose().getWin());
        holder.ow_lose.setText("LOSE\n"+ item.getWinlose().getLose());

        int total = Integer.parseInt(String.valueOf(item.getWinlose().getWin() + item.getWinlose().getLose()));
        String winrate = (total > 0) ? String.format("%.2f%%", (double) item.getWinlose().getWin() / total * 100) : "N/A";
        holder.ow_winrate.setText("WINRATE\n"+winrate);

        holder.ow_url.setText(item.getProfile().getProfileurl());


    }


}