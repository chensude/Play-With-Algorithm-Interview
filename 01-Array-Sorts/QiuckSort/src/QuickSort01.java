
/**
 * 第一版快速排序，单路快排
 */
public class QuickSort01<T> {



    public static <T extends Comparable<T>> void sort(T[] arr ,int n) {

        quickSort(arr,0,n-1);
        //测试正确与否
        //TestHelper.printArray(arr);
    }

    //对【l+1...j] 和【j+1...r]区间进行快速排序
    //使得排好序的[l...j]<v,[j+1...r]>v
    private static <T extends Comparable<T>> void quickSort(T[] arr, int l,int r) {

        if(l>=r) {
            return;
        }
        //核心patition过程
        int p = partition(arr,l,r);

        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }
   // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static <T extends Comparable<T>> int partition(T[] arr, int l, int r) {

        //参考点
        T v = arr[l];
        int j= l;// arr[l+1...j] < v ; arr[j+1...i) > v
        for(int i=l+1;i<=r;i++) {
            if(arr[i].compareTo(v)<0) {
                Util.swap(arr,++j,i);
            }
        }
        Util.swap(arr,l,j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] arr= {9,8,7,6,5,4,3,2,1};
        int n=9;
        QuickSort01.sort(arr,n);
    }
}
