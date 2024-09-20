package vn.edu.usth.opendota.player_info;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import vn.edu.usth.opendota.R;

public class MatchDetailsActivity extends AppCompatActivity {
    private LinearLayout player_info1, player_info2, player_info3, player_info4, player_info5, player_info6, player_info7, player_info8, player_info9, player_info10,
    layout_hide_show1, layout_hide_show2, layout_hide_show3, layout_hide_show4, layout_hide_show5, layout_hide_show6, layout_hide_show7, layout_hide_show8, layout_hide_show9, layout_hide_show10;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_match_details);
        View toolbar = findViewById(R.id.match_details_topappbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        player_info1=findViewById(R.id.player_info1);
        player_info2=findViewById(R.id.player_info2);
        player_info3=findViewById(R.id.player_info3);
        player_info4=findViewById(R.id.player_info4);
        player_info5=findViewById(R.id.player_info5);
        player_info6=findViewById(R.id.player_info6);
        player_info7=findViewById(R.id.player_info7);
        player_info8=findViewById(R.id.player_info8);
        player_info9=findViewById(R.id.player_info9);
        player_info10=findViewById(R.id.player_info10);




        layout_hide_show1=findViewById(R.id.layout_hide_show1);
        layout_hide_show2=findViewById(R.id.layout_hide_show2);
        layout_hide_show3=findViewById(R.id.layout_hide_show3);
        layout_hide_show4=findViewById(R.id.layout_hide_show4);
        layout_hide_show5=findViewById(R.id.layout_hide_show5);
        layout_hide_show6=findViewById(R.id.layout_hide_show6);
        layout_hide_show7=findViewById(R.id.layout_hide_show7);
        layout_hide_show8=findViewById(R.id.layout_hide_show8);
        layout_hide_show9=findViewById(R.id.layout_hide_show9);
        layout_hide_show10=findViewById(R.id.layout_hide_show10);








        player_info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isvisible =layout_hide_show1.getVisibility();
                if (isvisible==View.VISIBLE) {
                    layout_hide_show1.setVisibility(View.GONE);
                }else {
                    layout_hide_show1.setVisibility(View.VISIBLE);
                }
            }
        });

        player_info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isvisible =layout_hide_show2.getVisibility();
                if (isvisible==View.VISIBLE) {
                    layout_hide_show2.setVisibility(View.GONE);
                }else {
                    layout_hide_show2.setVisibility(View.VISIBLE);
                }
            }
        });

        player_info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isvisible =layout_hide_show3.getVisibility();
                if (isvisible==View.VISIBLE) {
                    layout_hide_show3.setVisibility(View.GONE);
                }else {
                    layout_hide_show3.setVisibility(View.VISIBLE);
                }
            }
        });

        player_info4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isvisible =layout_hide_show4.getVisibility();
                if (isvisible==View.VISIBLE) {
                    layout_hide_show4.setVisibility(View.GONE);
                }else {
                    layout_hide_show4.setVisibility(View.VISIBLE);
                }
            }
        });

        player_info5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isvisible =layout_hide_show5.getVisibility();
                if (isvisible==View.VISIBLE) {
                    layout_hide_show5.setVisibility(View.GONE);
                }else {
                    layout_hide_show5.setVisibility(View.VISIBLE);
                }
            }
        });

        player_info6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isvisible =layout_hide_show6.getVisibility();
                if (isvisible==View.VISIBLE) {
                    layout_hide_show6.setVisibility(View.GONE);
                }else {
                    layout_hide_show6.setVisibility(View.VISIBLE);
                }
            }
        });

        player_info7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isvisible =layout_hide_show7.getVisibility();
                if (isvisible==View.VISIBLE) {
                    layout_hide_show7.setVisibility(View.GONE);
                }else {
                    layout_hide_show7.setVisibility(View.VISIBLE);
                }
            }
        });

        player_info8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isvisible =layout_hide_show8.getVisibility();
                if (isvisible==View.VISIBLE) {
                    layout_hide_show8.setVisibility(View.GONE);
                }else {
                    layout_hide_show8.setVisibility(View.VISIBLE);
                }
            }
        });

        player_info9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isvisible =layout_hide_show9.getVisibility();
                if (isvisible==View.VISIBLE) {
                    layout_hide_show9.setVisibility(View.GONE);
                }else {
                    layout_hide_show9.setVisibility(View.VISIBLE);
                }
            }
        });

        player_info10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isvisible =layout_hide_show10.getVisibility();
                if (isvisible==View.VISIBLE) {
                    layout_hide_show10.setVisibility(View.GONE);
                }else {
                    layout_hide_show10.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
