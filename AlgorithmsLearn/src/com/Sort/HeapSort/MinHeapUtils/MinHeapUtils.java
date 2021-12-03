// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-25 16:28
 * IDE: IntelliJ IDEA
 * Introduction:
 * 实现最小堆：
 * minnHeapify: 找到该位置最小值
 * bulidMinHeap： 将动态数组构建为最小堆
 * HeapSortByMin: 降序排列动态数组
 * HeapMinmum:     寻找堆中的最小值
 * HeapExtractionMin: 删除堆中的最小值
 * HeapModify :修改指定位置堆的值，并且重建最小堆
 */
package com.Sort.HeapSort.MinHeapUtils;

import java.util.ArrayList;

public class MinHeapUtils {
    // 位置最小值方法
    public void minnHeapify(ArrayList<Integer> heap, int i, int len) {
        int l = 2 * i + 1;
        int R = 2 * i + 2;
        int temp;
        int minimumNum = i;
        if (l < len && heap.get(l) < heap.get(i)) {
            minimumNum = l;
        }
        if (R < len && heap.get(R) < heap.get(minimumNum)) {
            minimumNum = R;
        }
        if (minimumNum != i) {
            // 少的往上走
            swap(heap,minimumNum,i);
            minnHeapify(heap, minimumNum, len);
        }

    }

    // 构建最小堆
    public void bulidMinHeap(ArrayList<Integer> heap, int len) {
        for (int i = (len / 2); i >= 0; --i) {
            minnHeapify(heap, i, len);
        }
    }

    // 最小堆排序
    // 默认数组为最小堆
    public void HeapSortByMin(ArrayList<Integer> heap) {
        int len = heap.size() - 1;
        for (int i = 0; i < heap.size(); i++) {
            swap(heap, 0, len);
            --len;
            bulidMinHeap(heap, len);
        }

    }

    public void swap(ArrayList<Integer> heap, int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // 获取堆中最小值
    public Integer HeapMinmum(ArrayList<Integer> heap) {
        return heap.get(0);
    }

    // 删除堆中最小值
    public void HeapExtractionMin(ArrayList<Integer> heap) {
        swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        bulidMinHeap(heap, heap.size());
    }

    // 修改堆中数据
    public void HeapModify(ArrayList<Integer> heap, int index, int data) {
        heap.set(index, data);
        bulidMinHeap(heap, heap.size());
    }

    // 删除堆中的数据
    public void deleteHeap(ArrayList<Integer> heap, int index) {
        swap(heap, index, heap.size() - 1);
        minnHeapify(heap, index, heap.size());
        heap.remove(heap.size() - 1);
    }

}
