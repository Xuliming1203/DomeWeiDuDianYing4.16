package com.bw.domeweidudianying416.view.DressFragment;


import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.domeweidudianying416.R;
import com.bw.domeweidudianying416.base.BaseFragment;
import com.bw.domeweidudianying416.contracl.DressMovieContracl;
import com.bw.domeweidudianying416.entity.FuMovieEntity;
import com.bw.domeweidudianying416.presenter.DressMoviePresenter;
import com.bw.domeweidudianying416.view.adapter.FuAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FuMovieFragment extends BaseFragment<DressMoviePresenter> implements DressMovieContracl.View {


    @BindView(R.id.rv_fu)
    RecyclerView rvFu;

    @Override
    protected int layoutId() {
        return R.layout.fragment_fu_movie;
    }

    @Override
    protected DressMoviePresenter initPresenter() {
        return new DressMoviePresenter();
    }

    @Override
    protected void initView(View view) {
        presenter.getfu(13918, "158778006650313918", "116.30551391385724","40.04571807462411",1, 10);
            rvFu.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void sucess(Object object) {
            if (object instanceof FuMovieEntity){
                List<FuMovieEntity.ResultBean> result = ((FuMovieEntity) object).getResult();
                FuAdapter fuAdapter=new FuAdapter(getActivity(),result);
                rvFu.setAdapter(fuAdapter);
            }
    }

    @Override
    public void fshibai(Throwable throwable) {

    }
}
