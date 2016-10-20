package com.world.hello.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * recycleView的adapter
 * Created by chengguo on 2016/5/30.
 */
public class SampleRecycleAdapter extends RecyclerView.Adapter<SampleRecycleAdapter.ViewHolder>{

    //保存列表项数据
    private final ArrayList<SampleModel> sampleData = DemoApp.getSampleData(30);

    //创建列表项中显示的控件对象（需要使用Adapter指定泛型）
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //获取列表项控件LinearLayer对象
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(rowView);
    }

    //在该方法中设置列表项中显示的值
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SampleModel rowData = sampleData.get(position);
        holder.textViewSample.setText(rowData.getMessage());
        holder.itemView.setTag(rowData);
    }

    //设置列表项总和
    @Override
    public int getItemCount() {
        return sampleData.size();
    }

    //删除指定列表项的数据
    public void removeData(int position){
        sampleData.remove(position);
        //通知recycleView某个列表项被删除了
        notifyItemRemoved(position);
    }

    //在指定的位置添加一个新的列表项
    public void addItem(int position){
        //使用随机数字
        sampleData.add(position,new SampleModel("新增列表项"+ new Random().nextInt(100)));
        notifyItemInserted(position);
    }

    /**
     * ViewHolder用于存储列表项中显示的控件，（这里只有一个TextView做示例）
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewSample;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewSample = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
