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
import com.bw.domeweidudianying416.entity.RMDYEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间：2020/4/7
 * 作者：徐黎明
 * 类的作用：
 */
public class RmdyAdapter extends RecyclerView.Adapter<RmdyAdapter.RmdyViewHolder> {



    private Context context;
    private List<RMDYEntity.ResultBean> result;

    public RmdyAdapter(Context context, List<RMDYEntity.ResultBean> result) {

        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public RmdyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter_rmdy, null);
        return new RmdyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RmdyViewHolder holder, int position) {
        RMDYEntity.ResultBean resultBean = result.get(position);

        Glide.with(context)
                .load(resultBean.getImageUrl())
                .into(holder.rmdyIv2);

        holder.rmdyTv3.setText(resultBean.getScore()+"");
        holder.rmdyTv4.setText(resultBean.getName());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class RmdyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rmdy_iv2)
        ImageView rmdyIv2;
        @BindView(R.id.rmdy_tv3)
        TextView rmdyTv3;
        @BindView(R.id.rmdy_tv4)
        TextView rmdyTv4;
        public RmdyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
