package com.world.hello.recycleview;

import java.util.ArrayList;

/**
 * 模拟数据集合
 * Created by chengguo on 2016/5/30.
 */
public class DemoApp {
    //获取要显示的数据（初始化数据）
    public static ArrayList<SampleModel> getSampleData(int size) {
        ArrayList<SampleModel> sampleData = new ArrayList<SampleModel>(size);
        for (int i = 0; i < size; i++) {
            sampleData.add(new SampleModel("新的列表项 " + i));
        }

        return sampleData;
    }
}
