package vn.edu.usth.opendota.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.opendota.R;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup themeRadioGroup;

    private enum Theme {
        LIGHT("Light", R.id.theme_light),
        DARK("Dark", R.id.theme_dark),
        CLASSIC_LIGHT("ClassicLight", R.id.theme_classicLight),
        CLASSIC_DARK("ClassicDark", R.id.theme_classicDark),
        PEARL_DARK("PearlDark", R.id.theme_pearlDark);

        private final String name;
        private final int radioId;

        Theme(String name, int radioId) {
            this.name = name;
            this.radioId = radioId;
        }

        public String getName() {
            return name;
        }

        public int getRadioId() {
            return radioId;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_settings); // Set the layout for this activity

        themeRadioGroup = findViewById(R.id.theme_radio_group);
        Button applyButton = findViewById(R.id.apply_button);

        loadSelectedTheme();

        applyButton.setOnClickListener(v -> applyTheme());
    }

    private void applyTheme() {
        int selectedId = themeRadioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Please select a theme", Toast.LENGTH_SHORT).show();
            return;
        }

        String selectedTheme = getThemeName(selectedId);

        saveSelectedTheme(selectedTheme);
        Toast.makeText(this, "Theme changed to " + selectedTheme, Toast.LENGTH_SHORT).show();

        // Recreate the activity to apply the new theme
        recreate();
    }

    private String getThemeName(int selectedId) {
        for (Theme theme : Theme.values()) {
            if (theme.getRadioId() == selectedId) {
                return theme.getName();
            }
        }
        return Theme.LIGHT.getName();
    }

    private void saveSelectedTheme(String theme) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putString("theme_key", theme).apply();
    }

    private void loadSelectedTheme() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String selectedTheme = sharedPreferences.getString("theme_key", Theme.LIGHT.getName());

        for (Theme theme : Theme.values()) {
            if (theme.getName().equals(selectedTheme)) {
                themeRadioGroup.check(theme.getRadioId());
                break;
            }
        }
    }
}
