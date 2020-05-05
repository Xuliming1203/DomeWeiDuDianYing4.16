package com.bw.domeweidudianying416.model;

import com.bw.domeweidudianying416.api.MovieApiService;
import com.bw.domeweidudianying416.contracl.MovieContracl;
import com.bw.domeweidudianying416.entity.JJSYEntity;
import com.bw.domeweidudianying416.entity.RMDYEntity;
import com.bw.domeweidudianying416.entity.XBannerEntity;
import com.bw.domeweidudianying416.entity.ZZRYEntity;
import com.bw.domeweidudianying416.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间：2020/4/19
 * 作者：徐黎明
 * 类的作用：
 */
public class MovieModel implements MovieContracl.Model
{
    @Override
    public void getxbanner(MovieContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(MovieApiService.class)
                .getxbanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XBannerEntity>() {
                    @Override
                    public void accept(XBannerEntity xBannerEntity) throws Exception {
                        if (modelCallBack != null) {
                            modelCallBack.success(xBannerEntity);
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
    public void getzzry(int page, int count, MovieContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(MovieApiService.class)
                .getzzry(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZZRYEntity>() {
                    @Override
                    public void accept(ZZRYEntity zzryEntity) throws Exception {
                        if (modelCallBack != null) {
                            modelCallBack.success(zzryEntity);
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
    public void getjjsy(int userId, String sessionId, int page, int count, MovieContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(MovieApiService.class)
                .getjjsy(userId,sessionId,page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JJSYEntity>() {
                    @Override
                    public void accept(JJSYEntity jjsyEntity) throws Exception {
                        if (modelCallBack != null) {
                            modelCallBack.success(jjsyEntity);
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
    public void getrmzy(int page, int count, MovieContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(MovieApiService.class)
                .getrmdy(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RMDYEntity>() {
                    @Override
                    public void accept(RMDYEntity rmdyEntity) throws Exception {
                        if (modelCallBack != null) {
                            modelCallBack.success(rmdyEntity);
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
