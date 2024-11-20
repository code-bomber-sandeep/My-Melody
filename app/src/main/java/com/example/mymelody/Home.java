package com.example.mymelody;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

/** @noinspection ALL*/
public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViewPager();
    }


    private void initViewPager() {
        ViewPager vp=findViewById(R.id.view_page);
        TabLayout tb =findViewById(R.id.tab);
        ViewPagerAdapter vpa=new ViewPagerAdapter(getSupportFragmentManager());
        vpa.addFraments(new HomeFragment(),"");
        vpa.addFraments(new searchFragment(),"");
        vpa.addFraments(new libFragment(),"");
        vp.setAdapter(vpa);
        tb.setupWithViewPager(vp);
//        icons
        tb.getTabAt(0).setIcon(R.drawable.baseline_home_24);
        tb.getTabAt(1).setIcon(R.drawable.baseline_search_24);
        tb.getTabAt(2).setIcon(R.drawable.baseline_library_music_24);
    }
    public static class ViewPagerAdapter extends FragmentPagerAdapter implements com.example.mymelody.ViewPagerAdapter {
        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;
        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            this.fragments=new ArrayList<>();
            this.titles =new ArrayList<>();
        }

        void addFraments(Fragment fragment,String title){
            fragments.add(fragment);
            titles.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position){
            return fragments.get(position);
        }
        @Override
        public int getCount(){
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
