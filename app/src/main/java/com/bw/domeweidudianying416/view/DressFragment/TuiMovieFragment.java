package com.bw.domeweidudianying416.view.DressFragment;


import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.domeweidudianying416.R;
import com.bw.domeweidudianying416.base.BaseFragment;
import com.bw.domeweidudianying416.contracl.DressMovieContracl;
import com.bw.domeweidudianying416.entity.TuiMovieEntity;
import com.bw.domeweidudianying416.presenter.DressMoviePresenter;
import com.bw.domeweidudianying416.view.adapter.TuiAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuiMovieFragment extends BaseFragment<DressMoviePresenter> implements DressMovieContracl.View {

    @BindView(R.id.rv_tui)
    RecyclerView rvTui;

    @Override
    protected int layoutId() {
        return R.layout.fragment_tui_movie;
    }

    @Override
    protected DressMoviePresenter initPresenter() {
        return new DressMoviePresenter();
    }

    @Override
    protected void initView(View view) {
        presenter.gettui(13918, "158778006650313918", 1, 10);
        rvTui.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void sucess(Object object) {
        if (object instanceof TuiMovieEntity) {
            List<TuiMovieEntity.ResultBean> result = ((TuiMovieEntity) object).getResult();
            TuiAdapter tuiAdapter=new TuiAdapter(getActivity(),result);
            rvTui.setAdapter(tuiAdapter);
        }
    }

    @Override
    public void fshibai(Throwable throwable) {

    }
}
