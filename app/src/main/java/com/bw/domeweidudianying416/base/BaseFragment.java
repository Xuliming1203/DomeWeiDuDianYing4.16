package com.bw.domeweidudianying416.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 时间：2020/4/8
 * 作者：徐黎明
 * 类的作用：
 */
public abstract class BaseFragment <P extends BasePresenter> extends Fragment implements BaseView {
    public P presenter;
    private Unbinder bind;
    private boolean isinitData=false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(),layoutId(),null);
        bind = ButterKnife.bind(this, view);
        presenter=initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView(view);
        return view;
    }

    protected abstract int layoutId();

    protected abstract P initPresenter();

    protected abstract void initView(View view);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&!isinitData){
            initData();
            isinitData=true;
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatch();
        }
        if (bind != null) {
            bind.unbind();
        }
    }
}
