package vn.edu.usth.opendota.adapters;

import static vn.edu.usth.opendota.utils.Db.getHeroNameByID;
import static vn.edu.usth.opendota.utils.Db.getLocalizedNameByID;

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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.Heroes;

public class HeroesAdapters extends RecyclerView.Adapter<HeroesAdapters.ViewHolder> {

    private static final String TAG = "HEROES Ap";
    private List<Heroes> heroes;
    public HeroesAdapters(Context context, List<Heroes> heroes) {
        this.heroes = heroes;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void submit(List<Heroes> newList) {
        heroes = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_heroes_frame, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull HeroesAdapters.ViewHolder holder, int position) {
        Heroes item = heroes.get(position);

        int heroId = (int) item.getHeroID();
        String heroName = getHeroNameByID(heroId);
        String imageUrl = "https://cdn.dota2.com/apps/dota2/images/heroes/" + heroName + "_full.png";
        Picasso.get().load(imageUrl).into(holder.heroes_avar);

        String localname = getLocalizedNameByID(heroId);
        holder.heroes_name.setText(localname);

        int total = (int) item.getGames();
        holder.heroes_played.setText(String.valueOf(total));

        String winrate = String.format("%.2f%%", ((float) item.getWin() / total) * 100);
        holder.heroes_winrate.setText(winrate);

        long lastPlayedTimestamp = item.getLastPlayed();
        Date lastPlayedDate = new Date(lastPlayedTimestamp * 1000);
        Date currentTime = new Date();
        long differenceInMillis = currentTime.getTime() - lastPlayedDate.getTime();
        long differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24);

        if (differenceInDays > 0) {
            holder.heroes_lastplay.setText(differenceInDays + " days ago");
        } else {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("HH");
            holder.heroes_lastplay.setText(sdf.format(lastPlayedDate) + " hours ago");
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView heroes_avar;
        private final TextView heroes_name;
        private final TextView heroes_played;
        private final TextView heroes_winrate;
        private final TextView heroes_lastplay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heroes_name = itemView.findViewById(R.id.heroes_name);
            heroes_avar = itemView.findViewById(R.id.heroes_avar);
            heroes_played = itemView.findViewById(R.id.heroes_played);
            heroes_lastplay = itemView.findViewById(R.id.heroes_lastplay);
            heroes_winrate = itemView.findViewById(R.id.heroes_winrate);
        }
    }
}
