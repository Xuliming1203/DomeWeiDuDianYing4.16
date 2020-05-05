package com.bw.domeweidudianying416.model;

import com.bw.domeweidudianying416.api.SearchApiService;
import com.bw.domeweidudianying416.contracl.SearchContracl;
import com.bw.domeweidudianying416.entity.CinemaSearchEntity;
import com.bw.domeweidudianying416.entity.MovieSearchEntity;
import com.bw.domeweidudianying416.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间：2020/5/5
 * 作者：徐黎明
 * 类的作用：
 */
public class SearchModel implements SearchContracl.Model {

    @Override
    public void moviesearch(String keyword, int page, int count, SearchContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(SearchApiService.class)
                .moviesearch(keyword, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieSearchEntity>() {
                    @Override
                    public void accept(MovieSearchEntity movieSearchEntity) throws Exception {
                        if (modelCallBack != null) {
                            modelCallBack.success(movieSearchEntity);
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
    public void cinemasearch(int page, int count, String cinemaName, SearchContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(SearchApiService.class)
                .cinemasearch( page, count,cinemaName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CinemaSearchEntity>() {
                    @Override
                    public void accept(CinemaSearchEntity cinemaSearchEntity) throws Exception {
                        if (modelCallBack != null) {
                            modelCallBack.success(cinemaSearchEntity);
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
