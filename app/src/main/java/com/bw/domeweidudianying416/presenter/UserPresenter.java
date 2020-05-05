package com.bw.domeweidudianying416.presenter;

import com.bw.domeweidudianying416.base.BasePresenter;
import com.bw.domeweidudianying416.contracl.UserContracl;
import com.bw.domeweidudianying416.entity.UserEntity;
import com.bw.domeweidudianying416.model.UserModel;

/**
 * 时间：2020/4/11
 * 作者：徐黎明
 * 类的作用：
 */
public class UserPresenter extends BasePresenter<UserModel, UserContracl.View> implements UserContracl.Presenter {
    @Override
    protected UserModel initModel() {
        return new UserModel();
    }

    @Override
    public void getresgin(String nickName, String pwd, String email, String code) {
        initModel().getresgin(nickName, pwd, email, code, new UserContracl.ModelCallBack() {
            @Override
            public void success(UserEntity userEntity) {
                if (getView() != null) {
                    getView().success(userEntity);
                }
            }

            @Override
            public void fshibai(Throwable throwable) {
                if (getView() != null) {
                    getView().fshibai(throwable);
                }
            }
        });
    }

    @Override
    public void getlogin(String email, String pwd) {
        initModel().getlogin(email, pwd, new UserContracl.ModelCallBack() {
            @Override
            public void success(UserEntity userEntity) {
                if (getView() != null) {
                    getView().success(userEntity);
                }
            }

            @Override
            public void fshibai(Throwable throwable) {
                if (getView() != null) {
                    getView().fshibai(throwable);
                }
            }
        });
    }

    @Override
    public void getyzm(String email) {
        initModel().getyzm(email,  new UserContracl.ModelCallBack() {
            @Override
            public void success(UserEntity userEntity) {
                if (getView() != null) {
                    getView().success(userEntity);
                }
            }

            @Override
            public void fshibai(Throwable throwable) {
                if (getView() != null) {
                    getView().fshibai(throwable);
                }
            }
        });
    }
}
