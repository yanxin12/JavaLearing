// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-25 15:32
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Sort.HeapSort;

// 应该使用Java动态数组ArrayList
public class HeapSort {
    public static void main(String[] args) {
        int[] heap = {2, 4, 6, 123, 32, 18};
        int temp = 0;
        for (int i = heap.length; i >= 0; --i) {
            temp = heap[heap.length - 1];
            heap[heap.length - 1] = heap[0];
            heap[0] = temp;
            heap = heap.clone();
            MaxHeap.buildMaxHeap(heap);
        }
    }
}
