// -*- coding: utf-8 -*- 
/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-25 12:34
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Sort.HeapSort;

public class MaxHeap {
    /*
实现堆的调整方法
 */
    public static void main(String[] args) {
//        int[] heap = {2, 4, 6, 123, 32, 88, 18, 3211, 3, 2, 1, 88, 66, 55, 40, 98};
        int[] heap = {2, 4, 6, 123, 32, 18};
        buildMaxHeap(heap);
//        maxHeap(heap, 0);
        for (int i : heap) {
            System.out.print(i + "\t\t");
        }

    }

    /*public static void maxHeap(int[] heap, int i) {
        // 左孩子 2*i+1
        // 右孩子 2*i+2
        int maxSite = 0;
        int temp;
        // 判断是否为叶子节点
        // 通过判断节点是否有左孩子判断节点是否是叶子节点
        if ((2 * i + 1) < heap.length) {
            // 最大值和父节点互换
            // 存在右孩子节点
            if ((2 * i + 2) < heap.length) {
                if (heap[i] < heap[2 * i + 1] || heap[i] < heap[2 * i + 2]) {
                    if (heap[2 * i + 1] > heap[2 * i + 2]) {
                        temp = heap[i];
                        heap[i] = heap[2 * i + 1];
                        heap[2 * i + 1] = temp;
                    } else {
                        temp = heap[i];
                        heap[i] = heap[2 * i + 2];
                        heap[2 * i + 2] = temp;
                    }
                }
                maxHeap(heap, 2 * i + 1);
                maxHeap(heap, 2 * i + 2);
            } else {
                // 不存在右孩子节点
                if (heap[2 * i + 1] > heap[i]) {
                    temp = heap[i];
                    heap[i] = heap[2 * i + 1];
                    heap[2 * i + 1] = temp;
                }
                maxHeap(heap, 2 * i + 1);
            }


        }


    }*/
    public static void maxHeap(int[] heap, int i) {
        int l = 2 * i + 1;
        int R = 2 * i + 2;
        int temp = 0, largeNum = i;
        // 判断孩子节点是否大于父亲节点
        if (l < heap.length && heap[l] > heap[i]) {
            largeNum = l;
        }
        if (R < heap.length && heap[R] > heap[largeNum]) {
            largeNum = R;
        }
        if (largeNum != i) {
            temp = heap[largeNum];
            heap[largeNum] = heap[i];
            heap[i] = temp;
            maxHeap(heap, largeNum);
        }

    }

    // 构建最大堆
    public static void buildMaxHeap(int[] A) {
        int len = A.length;
        for (int i = len / 2; i >= 0; --i) {
            maxHeap(A, i);
        }
    }


}



