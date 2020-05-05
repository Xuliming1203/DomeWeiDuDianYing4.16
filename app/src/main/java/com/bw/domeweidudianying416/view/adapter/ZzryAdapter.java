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
import com.bw.domeweidudianying416.entity.ZZRYEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间：2020/4/7
 * 作者：徐黎明
 * 类的作用：
 */
public class ZzryAdapter extends RecyclerView.Adapter<ZzryAdapter.ZzryViewHolder> {



    private Context context;
    private List<ZZRYEntity.ResultBean> result;

    public ZzryAdapter(Context context, List<ZZRYEntity.ResultBean> result) {

        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public ZzryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter_zzry, null);
        return new ZzryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZzryViewHolder holder, int position) {
        ZZRYEntity.ResultBean resultBean = result.get(position);
        Glide.with(context)
                .load(resultBean.getImageUrl())
                .into(holder.zzryIv);
        holder.zzryTv.setText(resultBean.getScore()+"分");
        holder.zzryTv2.setText(resultBean.getName());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class ZzryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.zzry_iv)
        ImageView zzryIv;
        @BindView(R.id.zzry_tv)
        TextView zzryTv;
        @BindView(R.id.zzry_tv2)
        TextView zzryTv2;
        public ZzryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
