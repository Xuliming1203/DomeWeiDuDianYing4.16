package com.bw.domeweidudianying416.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 时间：2020/4/8
 * 作者：徐黎明
 * 类的作用：
 */
public  abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P presenter;
    private Unbinder bind;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
         bind = ButterKnife.bind(this);
        presenter=initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract int layoutId();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract void initData();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatch();
        }
        if (bind != null) {
            bind.unbind();
        }
    }
}
