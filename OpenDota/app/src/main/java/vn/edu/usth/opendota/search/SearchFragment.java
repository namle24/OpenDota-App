package vn.edu.usth.opendota.search;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapter.SearchAdapter;

public class SearchFragment extends Fragment {

    private RecyclerView rcvUser;
    private SearchAdapter userAdapter;
    private List<User> userList;
    private androidx.appcompat.widget.SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        rcvUser = view.findViewById(R.id.rcv_users);
        searchView = view.findViewById(R.id.search_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rcvUser.setLayoutManager(linearLayoutManager);

        userList = getListUsers();
        userAdapter = new SearchAdapter(userList);
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

    private List<User> getListUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.avarta2, "NamLee", "ID: 185476982", R.drawable.rank_icon_8));
        list.add(new User(R.drawable.avarta3, "Minh", "ID: 185476982", R.drawable.rank_icon_8b));
        list.add(new User(R.drawable.avarta4, "Nghia", "ID: 408523961", R.drawable.rank_icon_6));
        list.add(new User(R.drawable.anhlong1, "Duc", "ID: 233507135", R.drawable.rank_icon_7));
        list.add(new User(R.drawable.avatar_1, "Qminh", "ID: 1856746982", R.drawable.rank_icon_6));
        return list;
    }
}



