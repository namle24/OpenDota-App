package vn.edu.usth.opendota.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import vn.edu.usth.opendota.MainActivity;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.favourite.FavouritesActivity;
import vn.edu.usth.opendota.search.SearchActivity;


public class SettingActivity extends AppCompatActivity {
    private RelativeLayout relativeLayoutSetting;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        relativeLayoutSetting = findViewById(R.id.relative_layout_setting);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        int storedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
        relativeLayoutSetting.setBackgroundColor(storedColor);

        // Retrieve the stored color and text color from SharedPreferences
//        int storedTextColor = sharedPreferences.getInt("selected_text_color", getResources().getColor(R.color.black));
//        textView = findViewById(R.id.);
//        textView.setTextColor(storedTextColor);

        RadioGroup radioGroup = findViewById(R.id.Themes);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                int color = 0;
                int text_color = 0;
                int tool_bar_color = 0;
                int background_color = 0;
                int navigation_color = 0;
                int navigation_icon_color = 0;

                if (checkedId == R.id.Theme_Hyperfuse) {
                    color = getResources().getColor(R.color.hyper_fuse);
                    text_color = getResources().getColor(R.color.white);
                    tool_bar_color = getResources().getColor(R.color.hyper_fuse_bar);
                    Toast.makeText(SettingActivity.this, "Hyperfuse selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.Theme_SkyDolch) {
                    color = getResources().getColor(R.color.sky_dolch);
                    text_color = getResources().getColor(R.color.black);
                    tool_bar_color = getResources().getColor(R.color.sky_dolch_bar);
                    Toast.makeText(SettingActivity.this, "Sky Dolch selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.Theme_Default) {
                    color = getResources().getColor(R.color.background);
                    text_color = getResources().getColor(R.color.white);
                    tool_bar_color = getResources().getColor(R.color.item);
                    Toast.makeText(SettingActivity.this, "Default selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.Theme_Invisibility) {
                    color = getResources().getColor(R.color.invisibility);
                    text_color = getResources().getColor(R.color.black);
                    tool_bar_color = getResources().getColor(R.color.invisibility_bar);
                    Toast.makeText(SettingActivity.this, "Invisibility selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.Theme_FUWA_FUWA_PINK) {
                    color = getResources().getColor(R.color.white);
                    text_color = getResources().getColor(R.color.black);
                    tool_bar_color = getResources().getColor(R.color.pink);
                    background_color = getResources().getColor(R.color.white);
                    navigation_color = getResources().getColor(R.color.pink);
                    navigation_icon_color = getResources().getColor(R.color.black);
                    Toast.makeText(SettingActivity.this, "Fuwa Fuwa pink selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.Theme_NightDota) {
                    color = getResources().getColor(R.color.white);
                    text_color = getResources().getColor(R.color.white);
                    tool_bar_color = getResources().getColor(R.color.licorice);
                    background_color = getResources().getColor(R.color.black);
                    navigation_color = getResources().getColor(R.color.CARD);
                    navigation_icon_color = getResources().getColor(R.color.white);
                    Toast.makeText(SettingActivity.this, "Night dota selected", Toast.LENGTH_SHORT).show();
                }

                relativeLayoutSetting.setBackgroundColor(background_color);


                setRadioButtonsTextColor(text_color);
                setToolbarBackgroundColor(tool_bar_color);
                updateNavigationViewColors(navigation_color, navigation_icon_color);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("selected_color", background_color);
                editor.putInt("selected_text_color", text_color);
                editor.apply();
            }
        });



        relativeLayoutSetting = findViewById(R.id.relative_layout_setting);
        Toolbar toolbar = findViewById(R.id.setting_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.setting_drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);

                if (id == R.id.nav_home){
                    Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else if (id == R.id.nav_favourite){
                    Intent intent = new Intent(SettingActivity.this, FavouritesActivity.class);
                    startActivity(intent);
                    finish();
                } else if (id == R.id.nav_search){
                    Intent intent = new Intent(SettingActivity.this, SearchActivity.class);
                    startActivity(intent);
                    finish();
                } else if (id == R.id.nav_setting){
                    Intent intent = new Intent(SettingActivity.this, SettingActivity.class);
                    startActivity(intent);
                    finish();
                }

                return true;
            }
        });
    }

    private void setRadioButtonsTextColor(int color) {
        RadioButton[] radioButtons = {
                findViewById(R.id.Theme_Default),
                findViewById(R.id.Theme_SkyDolch),
                findViewById(R.id.Theme_Hyperfuse),
                findViewById(R.id.Theme_Invisibility),
                findViewById(R.id.Theme_FUWA_FUWA_PINK),
                findViewById(R.id.Theme_NightDota)
        };

        for (RadioButton radioButton : radioButtons) {
            radioButton.setTextColor(color);
        }
    }

    private void setToolbarBackgroundColor(int color) {
        Toolbar toolbar = findViewById(R.id.setting_toolbar);
        toolbar.setBackgroundColor(color);
    }

    private void updateNavigationViewColors(int navigation_color, int navigation_icon_color) {
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setBackgroundColor(navigation_color);
        navigationView.setItemIconTintList(ColorStateList.valueOf(navigation_icon_color));
    }
}

