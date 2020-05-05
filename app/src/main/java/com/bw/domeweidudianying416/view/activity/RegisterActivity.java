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

public class RegisterActivity extends BaseActivity<UserPresenter> implements UserContracl.View {


    @BindView(R.id.et_regis_ni)
    EditText etRegisNi;
    @BindView(R.id.et_regis_email)
    EditText etRegisEmail;
    @BindView(R.id.et_regis_pwd)
    EditText etRegisPwd;
    @BindView(R.id.et_regis_yzm)
    EditText etRegisYzm;
    @BindView(R.id.bt_regis_yzm)
    Button btRegisYzm;
    @BindView(R.id.tv_you)
    TextView tvYou;
    @BindView(R.id.bt_regis)
    Button btRegis;

    @Override
    protected int layoutId() {
        return R.layout.activity_register;
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

    }

    @Override
    public void fshibai(Throwable throwable) {

    }


    @OnClick({R.id.bt_regis_yzm, R.id.tv_you, R.id.bt_regis})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_regis_yzm:
                String nie = etRegisEmail.getText().toString();
                if (TextUtils.isEmpty(nie)){
                    Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getyzm(nie);
                break;
            case R.id.tv_you:
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_regis:
                String ni = etRegisNi.getText().toString();
                if (TextUtils.isEmpty(ni)){
                    Toast.makeText(this, "昵称不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String email = etRegisEmail.getText().toString();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pwd = etRegisPwd.getText().toString();
                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String yzm = etRegisYzm.getText().toString();
                if (TextUtils.isEmpty(yzm)){
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getresgin(ni,email,pwd,yzm);
                break;
        }
    }
}
