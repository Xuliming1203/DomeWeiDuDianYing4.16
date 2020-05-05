package com.bw.domeweidudianying416.view.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.bw.domeweidudianying416.R;
import com.bw.domeweidudianying416.base.BaseFragment;
import com.bw.domeweidudianying416.contracl.MovieContracl;
import com.bw.domeweidudianying416.entity.JJSYEntity;
import com.bw.domeweidudianying416.entity.RMDYEntity;
import com.bw.domeweidudianying416.entity.XBannerEntity;
import com.bw.domeweidudianying416.entity.ZZRYEntity;
import com.bw.domeweidudianying416.presenter.MoviePresenter;
import com.bw.domeweidudianying416.view.activity.MovieSearchActivity;
import com.bw.domeweidudianying416.view.adapter.JjsyAdapter;
import com.bw.domeweidudianying416.view.adapter.RmdyAdapter;
import com.bw.domeweidudianying416.view.adapter.ZzryAdapter;
import com.stx.xhb.androidx.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends BaseFragment<MoviePresenter> implements MovieContracl.View {


    @BindView(R.id.rv_zzry)
    RecyclerView rvZzry;
    @BindView(R.id.rv_jjsy)
    RecyclerView rvJjsy;
    @BindView(R.id.rv_rmdy)
    RecyclerView rvRmdy;
    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.dingwei)
    ImageView dingwei;
    @BindView(R.id.home_tv)
    TextView homeTv;
    @BindView(R.id.sousuo)
    ImageView sousuo;

    @Override
    protected int layoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    protected MoviePresenter initPresenter() {
        return new MoviePresenter();
    }

    @Override
    protected void initView(View view) {
        //沉浸式
        rvZzry.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        rvJjsy.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRmdy.setLayoutManager(new GridLayoutManager(getContext(), 3));
        presenter.getxbanner();
        presenter.getzzry(1, 10);
        presenter.getjjsy(13918, "158778410955313918", 1, 10);
        presenter.getrmzy(1, 10);
        ;

    }

    @Override
    protected void initData() {

    }

    @Override
    public void success(Object object) {
        if (object instanceof XBannerEntity) {
            List<String> list = new ArrayList<>();
            List<XBannerEntity.ResultBean> result = ((XBannerEntity) object).getResult();
            for (int i = 0; i < result.size(); i++) {
                list.add(result.get(i).getImageUrl());
            }
            xbanner.setData(list, null);
            xbanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(getContext()).load(list.get(position)).into((ImageView) view);
                }
            });
        } else if (object instanceof ZZRYEntity) {
            List<ZZRYEntity.ResultBean> result = ((ZZRYEntity) object).getResult();
            ZzryAdapter zzryAdapter = new ZzryAdapter(getActivity(), result);
            rvZzry.setAdapter(zzryAdapter);
        } else if (object instanceof JJSYEntity) {
            List<JJSYEntity.ResultBean> result = ((JJSYEntity) object).getResult();
            JjsyAdapter jjsyAdapter = new JjsyAdapter(getActivity(), result);
            rvJjsy.setAdapter(jjsyAdapter);
        } else if (object instanceof RMDYEntity) {
            List<RMDYEntity.ResultBean> result = ((RMDYEntity) object).getResult();
            RmdyAdapter rmdyAdapter = new RmdyAdapter(getActivity(), result);
            rvRmdy.setAdapter(rmdyAdapter);
        }

    }

    @Override
    public void fshibai(Throwable throwable) {

    }

    @OnClick({R.id.dingwei, R.id.sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dingwei:
                break;
            case R.id.sousuo:
                Intent intent=new Intent(getActivity(), MovieSearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
