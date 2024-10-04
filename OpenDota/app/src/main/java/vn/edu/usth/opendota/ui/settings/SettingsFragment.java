package vn.edu.usth.opendota.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import vn.edu.usth.opendota.R;

public class SettingsFragment extends Fragment {

    private Spinner themeSpinner;
    private Button applyButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        themeSpinner = view.findViewById(R.id.theme_spinner);
        applyButton = view.findViewById(R.id.apply_button);

        setupThemeSpinner();
        applyButton.setOnClickListener(v -> applyTheme());

        return view;
    }

    private void setupThemeSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.themes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themeSpinner.setAdapter(adapter);
    }

    private void applyTheme() {
        String selectedTheme = themeSpinner.getSelectedItem().toString();
        saveSelectedTheme(selectedTheme);
        Toast.makeText(getContext(), "Theme changed to " + selectedTheme, Toast.LENGTH_SHORT).show();

        // Tải lại Activity (nếu cần) để áp dụng theme mới
        if (getActivity() != null) {
            getActivity().recreate();
        }
    }

    private void saveSelectedTheme(String theme) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        sharedPreferences.edit().putString("theme_key", theme).apply();
    }
}
