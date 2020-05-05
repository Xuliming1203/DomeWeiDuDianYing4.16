package com.bw.domeweidudianying416.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.domeweidudianying416.R;
import com.bw.domeweidudianying416.base.BaseActivity;
import com.bw.domeweidudianying416.contracl.UserContracl;
import com.bw.domeweidudianying416.entity.UserEntity;
import com.bw.domeweidudianying416.presenter.UserPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<UserPresenter> implements UserContracl.View {


    @BindView(R.id.et_login_email)
    EditText etLoginEmail;
    @BindView(R.id.et_login_pwd)
    EditText etLoginPwd;
    @BindView(R.id.bt_login_mima)
    Button btLoginMima;
    @BindView(R.id.tv_zhang)
    TextView tvZhang;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_weixin)
    Button btWeixin;

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected UserPresenter initPresenter() {
        return new UserPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void success(UserEntity userEntity) {
        if ("0000".equals(userEntity.getStatus())) {
            Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }

    @Override
    public void fshibai(Throwable throwable) {

    }



    @OnClick({R.id.bt_login_mima, R.id.tv_zhang, R.id.bt_login, R.id.bt_weixin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login_mima:
                break;
            case R.id.tv_zhang:
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_login:
                String email = etLoginEmail.getText().toString();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pwd = etLoginPwd.getText().toString();
                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getlogin(email,pwd);
                break;
            case R.id.bt_weixin:
                break;
        }
    }
}
