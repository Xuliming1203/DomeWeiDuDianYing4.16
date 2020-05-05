package com.bw.domeweidudianying416.view.fragment;


import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.domeweidudianying416.R;
import com.bw.domeweidudianying416.base.BaseFragment;
import com.bw.domeweidudianying416.base.BasePresenter;
import com.bw.domeweidudianying416.view.DressFragment.FuMovieFragment;
import com.bw.domeweidudianying416.view.DressFragment.TuiMovieFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DressFragment extends BaseFragment {

    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.vp)
    ViewPager vp;
    List<Fragment> fragments=new ArrayList<>();
    @Override
    protected int layoutId() {
        return R.layout.fragment_dress;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {
        TuiMovieFragment tuiMovieFragment=new TuiMovieFragment();
        FuMovieFragment fuMovieFragment=new FuMovieFragment();
        FuMovieFragment fuMovieFragment1=new FuMovieFragment();
        fragments.add(tuiMovieFragment);
        fragments.add(fuMovieFragment);
        fragments.add(fuMovieFragment1);
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
    protected void initData() {

    }

}
