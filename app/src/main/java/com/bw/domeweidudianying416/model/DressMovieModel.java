package com.bw.domeweidudianying416.model;

import com.bw.domeweidudianying416.api.DressMovieApiService;
import com.bw.domeweidudianying416.contracl.DressMovieContracl;
import com.bw.domeweidudianying416.entity.FuMovieEntity;
import com.bw.domeweidudianying416.entity.TuiMovieEntity;
import com.bw.domeweidudianying416.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间：2020/4/25
 * 作者：徐黎明
 * 类的作用：
 */
public class DressMovieModel implements DressMovieContracl.Model {
    @Override
    public void gettui(int userId, String sessionId, int page, int count, DressMovieContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(DressMovieApiService.class)
                .gettui(userId, sessionId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TuiMovieEntity>() {
                    @Override
                    public void accept(TuiMovieEntity tuiMovieEntity) throws Exception {
                        if (modelCallBack != null) {
                            modelCallBack.sucess(tuiMovieEntity);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (modelCallBack != null) {
                            modelCallBack.fshibai(throwable);
                        }
                    }
                });
    }

    @Override
    public void getfu(int userId, String sessionId, String longitude, String latitude, int page, int count, DressMovieContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(DressMovieApiService.class)
                .getfu(userId, sessionId, longitude, latitude, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FuMovieEntity>() {
                    @Override
                    public void accept(FuMovieEntity fuMovieEntity) throws Exception {
                        if (modelCallBack != null) {
                            modelCallBack.sucess(fuMovieEntity);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (modelCallBack != null) {
                            modelCallBack.fshibai(throwable);
                        }
                    }
                });
    }
}
