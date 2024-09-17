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

public class SearchFragment extends Fragment {

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

    private List<User> getListUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.avarta2, "NamLee", "ID: 185476982"));
        list.add(new User(R.drawable.avarta3, "Minh", "ID: 185476982"));
        list.add(new User(R.drawable.avarta4, "Nghia", "ID: 408523961"));
        list.add(new User(R.drawable.anhlong1, "Duc", "ID: 233507135"));
        list.add(new User(R.drawable.avatar_1, "Qminh", "ID: 1856746982"));
        return list;
    }
}
