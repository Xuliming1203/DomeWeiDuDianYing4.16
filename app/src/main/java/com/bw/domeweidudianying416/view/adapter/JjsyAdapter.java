package com.bw.domeweidudianying416.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.domeweidudianying416.R;
import com.bw.domeweidudianying416.entity.JJSYEntity;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间：2020/4/19
 * 作者：徐黎明
 * 类的作用：
 */
public class JjsyAdapter extends RecyclerView.Adapter<JjsyAdapter.JjsyViewHolder> {

    private Context context;
    private List<JJSYEntity.ResultBean> result;

    public JjsyAdapter(Context context, List<JJSYEntity.ResultBean> result) {

        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public JjsyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter_jjsy, null);
        return new JjsyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JjsyViewHolder holder, int position) {
        JJSYEntity.ResultBean resultBean = result.get(position);
        Glide.with(context)
                .load(resultBean.getImageUrl())
                .into(holder.jjsyIv);
        holder.jjsyTv1.setText(resultBean.getName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
        String format=simpleDateFormat.format(resultBean.getReleaseTime());
        holder.jjsyTv2.setText(format+"上映");
        holder.jjsyTv3.setText(resultBean.getWantSeeNum()+"人想看");
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class JjsyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.jjsy_iv)
        ImageView jjsyIv;
        @BindView(R.id.jjsy_tv1)
        TextView jjsyTv1;
        @BindView(R.id.jjsy_tv2)
        TextView jjsyTv2;
        @BindView(R.id.jjsy_tv3)
        TextView jjsyTv3;
        public JjsyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
