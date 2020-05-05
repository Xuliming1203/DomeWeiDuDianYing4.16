package com.bw.domeweidudianying416.view.activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.domeweidudianying416.R;
import com.bw.domeweidudianying416.base.BaseActivity;
import com.bw.domeweidudianying416.base.BasePresenter;
import com.bw.domeweidudianying416.presenter.MoviePresenter;
import com.bw.domeweidudianying416.view.fragment.DressFragment;
import com.bw.domeweidudianying416.view.fragment.MeFragment;
import com.bw.domeweidudianying416.view.fragment.MovieFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends BaseActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb)
    RadioGroup rb;
    List<Fragment> fragments=new ArrayList<>();
    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }


    @Override
    protected void initView() {
        MovieFragment movieFragment=new MovieFragment();
        DressFragment dressFragment=new DressFragment();
        MeFragment meFragment=new MeFragment();
        fragments.add(movieFragment);
        fragments.add(dressFragment);
        fragments.add(meFragment);

    }

    @Override
    protected void initData() {
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rb.check(rb.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);
                        break;


                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
