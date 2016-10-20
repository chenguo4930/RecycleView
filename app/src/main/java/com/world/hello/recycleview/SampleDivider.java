package com.world.hello.recycleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 定制分割线
 * Created by chengguo on 2016/5/30.
 */
public class SampleDivider extends RecyclerView.ItemDecoration {
    //默认分割条Drawable资源的Id
    private static final int[] ATTRS = {android.R.attr.listDivider};
    //分割条的Drawable对象
    private Drawable mDicider;

    public SampleDivider(Context context) {
        TypedArray ta = context.obtainStyledAttributes(ATTRS);
        //获取分割条的drawable对象
        mDicider = ta.getDrawable(0);
        //回收ta所占用的空间
        ta.recycle();

    }

    /**
     * 在改方法中绘制了所有列表项之间的分割条
     *
     * @param c
     * @param parent
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent) {

        //获取列表项距离左边源的距离
        int left = parent.getPaddingLeft();
        //获取列表项距离右边源的距离
        int right = parent.getWidth() - parent.getPaddingRight();
        //获取列表的总数
        int childCount = parent.getChildCount();
        //开始绘制这些列表项之间的分割线
        for (int i = 0; i < childCount; i++) {
            //获取当前的列表
            View child = parent.getChildAt(i);
            //获取当前列表项的布局参数信息
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            //计算分割条左上角的的纵坐标
            int top = child.getBottom() + params.bottomMargin;
            //计算分割条右下角的纵坐标
            int bottom = top + mDicider.getIntrinsicHeight();
            //设置分割条绘制的位置
            mDicider.setBounds(left,top,right,bottom);
            //开始绘制当前列表项下方的分割条
            mDicider.draw(c);
        }
    }
}
