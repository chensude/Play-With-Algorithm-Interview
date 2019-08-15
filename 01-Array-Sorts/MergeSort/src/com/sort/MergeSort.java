package com.sort;

/**
 * 归并排序
 * 向下递归，最后归并有序的数组
 */
public class MergeSort {
    public static <T extends Comparable<T>>  void sort(T[] arr,int n) {
        //对【0...n]区间的数组进行归并排序
        sortRecusion(arr,0,n-1);
        //TestHelper.printArray(arr);
    }

    public static <T extends Comparable<T>>  void sortRecusion(T[] arr,int l,int r) {

        if(l>=r){
            return;
        }
        int mid = (l+r)/2;
        //对【l...mid]区间的数组进行归并排序
        sortRecusion(arr,l,mid);
        //对【mid+1,r]区间的数组进行归并排序
        sortRecusion(arr,mid+1,r);
        merge(arr,l,mid,r);


    }

    //对有序的数组向上进行merge
    private static  <T extends Comparable<T>>  void merge(T[] arr, int l, int mid, int r) {
        T[] aux = (T[])new Comparable[r-l+1];
        //开辟一个同等的空间
        for(int i=l;i<=r;i++) {
            aux[i-l]=arr[i];
        }

        int i =l,j=mid+1;
        for(int k=l;k<=r;k++) {
            if(i>mid) {
                arr[k]=aux[j-l];
                j++;
            }else if(j>r) {
                arr[k]=aux[i-l];
                i++;
            }else if(aux[i-l].compareTo(aux[j-l])<0) {
                arr[k]=aux[i-l];
                i++;
            }else {
                arr[k]=aux[j-l];
                j++;
            }
        }
    }

}
