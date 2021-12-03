package Sort.MergeSort;// -*- coding: utf-8 -*-

/**
 * Project: SortTrain
 * Creator: yanking
 * Create time: 2021-11-22 13:51
 * IDE: IntelliJ IDEA
 * Introduction:
 */

class MergeSort {
    public static void main(String[] args) {
        int[] A = {2,1,34,66,212,5,90,24,17,16,15};
//        int[] A = {1,5,3, 6};
//        insertSort(A);
//         selectSort(A);
//        System.out.println(A.length);
        mergeSort(A,0,A.length-1);
//        merge(A,0,(A.length-0)/2,A.length);
//        System.out.println("==================");
        for (int i = 0;i<A.length;i++ ) {
            System.out.print(A[i]+"\t\t");
        }


    }
    public static void insertSort(int[] A){
        int key;
        int i = 0;
        for (int j = 1;j<A.length ;++j) {
            i = j-1;
            key = A[j];
            while(i>=0&&A[i]>key){
                A[i+1]=A[i];
                --i;
            }
            A[i+1] = key;
        }

    }


    public static void selectSort(int[] A){
/**
 * 简单选择排序
 */
        int temp = 0;
        for (int i = 0;i < A.length-1;i++ ) {
            for (int j = i + 1;j<A.length ;++j) {
                if (A[i]>A[j]) {
                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
    }

    public static void merge(int[] A,int p, int q, int r){
        //归并排序
        int n1 = q-p+1;
        int n2 = r-q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i=0;i<n1;++i) {
            L[i] = A[p+i];
        }
        for (int j=0;j<n2 ;++j) {
            R[j] = A[q+j+1];
        }
        int i = 0; int j = 0;int k = p;
        while(i < L.length&&j<R.length){
            if (L[i]<R[j]) {
                A[k++] = L[i++];
            }else{
                A[k++] = R[j++];
            }
        }
        while(i<L.length){
            A[k++] = L[i++];
        }
        while(j<R.length){
            A[k++] = R[j++];
        }
    }


    public static void mergeSort(int[] A,int p,int r){
        if (p<r) {
            int q = (r+p)/2;
            mergeSort(A,p,q);
            mergeSort(A,q+1,r);
            merge(A,p,q,r);
        }

    }

}