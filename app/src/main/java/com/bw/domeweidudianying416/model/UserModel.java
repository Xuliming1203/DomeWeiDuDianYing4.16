package com.bw.domeweidudianying416.model;

import android.widget.Toast;

import com.bw.domeweidudianying416.api.UserApiService;
import com.bw.domeweidudianying416.app.App;
import com.bw.domeweidudianying416.contracl.UserContracl;
import com.bw.domeweidudianying416.entity.UserEntity;
import com.bw.domeweidudianying416.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间：2020/4/11
 * 作者：徐黎明
 * 类的作用：
 */
public class UserModel implements UserContracl.Model {
    @Override
    public void getresgin(String nickName, String pwd, String email, String code, UserContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(UserApiService.class)
                .getregis(nickName, pwd, email, code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserEntity>() {
                    @Override
                    public void accept(UserEntity userEntity) throws Exception {
                        if ("0000".equals(userEntity.getStatus())) {
                            modelCallBack.success(userEntity);
                        } else {
                            Toast.makeText(App.context, "" + userEntity.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void getlogin(String email, String pwd, UserContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(UserApiService.class)
                .getlogin( email, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserEntity>() {
                    @Override
                    public void accept(UserEntity userEntity) throws Exception {
                        if ("0000".equals(userEntity.getStatus())) {
                            modelCallBack.success(userEntity);
                        } else {
                            Toast.makeText(App.context, "" + userEntity.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        modelCallBack.fshibai(throwable);
                    }
                });
    }

    @Override
    public void getyzm(String email, UserContracl.ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().createservice(UserApiService.class)
                .getyzm( email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserEntity>() {
                    @Override
                    public void accept(UserEntity userEntity) throws Exception {
                            modelCallBack.success(userEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        modelCallBack.fshibai(throwable);
                    }
                });
    }
}
