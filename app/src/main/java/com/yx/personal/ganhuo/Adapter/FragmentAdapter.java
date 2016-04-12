package com.yx.personal.ganhuo.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yx.personal.ganhuo.Bean.WelfareBean;
import com.yx.personal.ganhuo.R;

import java.util.List;

/**
 * Created by YX on 16/4/12.
 */
public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.MyViewHolder> {
    private Context mContext;
    private WelfareBean welfareBean;

    public FragmentAdapter(Context mContext, WelfareBean welfareBean) {
        this.mContext = mContext;
        this.welfareBean = welfareBean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_fuli, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(welfareBean.getResults().get(position).getCreatedAt());
        holder.draweeView.setImageURI(Uri.parse(welfareBean.getResults().get(position).getUrl()));
    }

    @Override
    public int getItemCount() {
        return welfareBean.getResults().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        SimpleDraweeView draweeView;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
            draweeView= (SimpleDraweeView) view.findViewById(R.id.my_image_view);

        }
    }

}