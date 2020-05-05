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
import com.bw.domeweidudianying416.entity.FuMovieEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间：2020/4/28
 * 作者：徐黎明
 * 类的作用：
 */
public class FuAdapter extends RecyclerView.Adapter<FuAdapter.FuViewHolder> {

    private Context context;
    private List<FuMovieEntity.ResultBean> result;

    public FuAdapter(Context context, List<FuMovieEntity.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public FuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter_tui, null);
        return new FuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuViewHolder holder, int position) {
        FuMovieEntity.ResultBean resultBean = result.get(position);
        Glide.with(context)
                .load(resultBean.getLogo())
                .into(holder.ivTui);
        holder.tvName.setText(resultBean.getName());
        holder.tvDress.setText(resultBean.getAddress());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class FuViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_tui)
        ImageView ivTui;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_dress)
        TextView tvDress;
        public FuViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
