package vn.edu.usth.opendota.search;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapter.SearchAdapter;
import vn.edu.usth.opendota.player_info.MyProfileActivity;

public class SearchActivity extends Fragment {

    private RecyclerView rcvUser;
    private SearchAdapter userAdapter;
    private List<User> userList;
    private androidx.appcompat.widget.SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        rcvUser = view.findViewById(R.id.rcv_users);
        searchView = view.findViewById(R.id.search_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rcvUser.setLayoutManager(linearLayoutManager);

        userList = getListUsers();
        userAdapter = new SearchAdapter(userList, new SearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, User user) {
                openUserProfile(user);
            }
            @Override
            public void onItemClick(int position, boolean isSelected) {
                Log.i("SearchFragment", "Heart icon at position " + position + " clicked. Selected: " + isSelected);
            }
        });
        rcvUser.setAdapter(userAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(itemDecoration);

        setupSearchView();

        return view;
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
    }

    private void filter(String text) {
        List<User> filteredList = new ArrayList<>();
        for (User user : userList) {
            if (user.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(user);
            }
        }
        userAdapter.filterList(filteredList);
    }

    private void openUserProfile(User user) {
        MyProfileActivity profileFragment = new MyProfileActivity();

        Bundle bundle = new Bundle();
        bundle.putString("userName", user.getName());
        bundle.putString("userId", user.getId());
        profileFragment.setArguments(bundle);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.framelayout, profileFragment)
                .addToBackStack(null)
                .commit();
    }



    private List<User> getListUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.avarta2, "NamLee", "ID: 185476982"));
        list.add(new User(R.drawable.avatar_1, "Minh", "ID: 185476982"));
        list.add(new User(R.drawable.avarta4, "Nghia", "ID: 408523961"));
        list.add(new User(R.drawable.anhlong1, "Duc", "ID: 233507135"));
        list.add(new User(R.drawable.avatar_22, "Qminh", "ID: 1856746982"));

        list.add(new User(R.drawable.anhsi, "Messi", "ID: 154520951"));
        list.add(new User(R.drawable.avarta10, "Ni garami", "ID: 282677100"));
        list.add(new User(R.drawable.ronaldo1, "Ronaldo", "ID: 613456720"));
        list.add(new User(R.drawable.goku, "Leopard", "ID: 778899001"));
        list.add(new User(R.drawable.avatar_7, "SlayerKing", "ID: 123456789"));
        list.add(new User(R.drawable.avatar_8, "StormFury", "ID: 987654321"));
        list.add(new User(R.drawable.avatar_9, "ShadowWalker", "ID: 112233445"));
        list.add(new User(R.drawable.avatar_22, "RogueAssassin", "ID: 998877665"));
        list.add(new User(R.drawable.avatar_21, "VoidHunter", "ID: 889900112"));
        list.add(new User(R.drawable.avatar_19, "PhoenixFlame", "ID: 990011223"));
        list.add(new User(R.drawable.avatar_20, "FrostKnight", "ID: 101010101"));
        list.add(new User(R.drawable.avatar_10, "EarthShaker", "ID: 202020202"));
        list.add(new User(R.drawable.avatar_11, "SkyBreaker", "ID: 303030303"));
        list.add(new User(R.drawable.avatar_12, "ShadowFiend", "ID: 404040404"));
        list.add(new User(R.drawable.avatar_13, "DragonSlayer", "ID: 505050505"));
        list.add(new User(R.drawable.avatar_14, "Wxrdie", "ID: 606060606"));
        list.add(new User(R.drawable.avatar_15, "MCK", "ID: 707070707"));
        list.add(new User(R.drawable.avatar_16, "Tlinh", "ID: 808080808"));
        list.add(new User(R.drawable.avatar_17, "WarGod", "ID: 909090909"));
        list.add(new User(R.drawable.avatar_18, "NightStalker", "ID: 111222333"));
        return list;
    }
}