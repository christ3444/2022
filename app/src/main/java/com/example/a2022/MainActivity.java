package com.example.a2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation btn_navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        btn_navigation = findViewById(R.id.btn_navigation);





        btn_navigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_month));
        btn_navigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_day));
        btn_navigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_calendar));
        //btn_navigation.add(new MeowBottomNavigation.Model(5,R.drawable.ic_add));

        btn_navigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

               /* if(item.getId()==5) {
                    Intent intent = new Intent(Objectif.this, AddActivity.class);
                    startActivity(intent);
                } else{ */
                Fragment fragment = null;

                switch (item.getId()) {

                    case 1:
                        fragment = new WeekFragment();
                        break;
                    case 2:
                        fragment = new YearFragment();
                        break;
                    case 3:
                            fragment = new MonthFragment();
                        break;
                }
                loadFragment(fragment);
            }
            // }
        });

        btn_navigation.show(1,true);

        btn_navigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                // Toast.makeText(getApplicationContext(),"vous avez clickez" + item.getId(),Toast.LENGTH_LONG).show();
            }
        });
        btn_navigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

                // Toast.makeText(getApplicationContext(),"reset" + item.getId(),Toast.LENGTH_LONG).show();

            }
        });

    }











    public void loadFragment(Fragment fragment){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }

}