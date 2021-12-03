// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-25 16:22
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Sort.HeapSort;

import Sort.HeapSort.MinHeapUtils.MinHeapUtils;

import java.util.ArrayList;

public class MinHeap {
    public static void main(String[] args) {
        ArrayList<Integer> heap = new ArrayList<Integer>();
        int[] data = {2, 4, 6, 123, 32, 88, 18, 3211, 3, 2, 1, 88, 66, 55, 40, 98};
        insertList(heap, data);
        MinHeapUtils minHeapUtils = new MinHeapUtils();
        minHeapUtils.bulidMinHeap(heap, heap.size());
//        minHeapUtils.HeapSortByMin(heap);
        for (Integer integer : heap) {
            System.out.print(integer + "\t\t");
        }
        minHeapUtils.HeapModify(heap, 7, 666);
        System.out.println();
        minHeapUtils.deleteHeap(heap, heap.size() - 1);
        for (Integer integer : heap) {
            System.out.print(integer + "\t\t");
        }

    }

    public static void insertList(ArrayList<Integer> heap, int[] data) {
        for (int datum : data) {
            heap.add(datum);
        }

    }
}
