package vn.edu.usth.opendota.player_info;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.opendota.R;

public class fragment_match_details extends AppCompatActivity {
    private static Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_match_details);
        fragment_match_details.toolbar.setNavigationOnClickListener(view -> onBackPressed());

    }
}
