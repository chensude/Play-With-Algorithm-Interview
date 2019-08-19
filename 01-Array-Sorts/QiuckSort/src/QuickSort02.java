/**
 * 开始排序第二版，双路快排
 * 主要是partition的过程不一样
 */
public class QuickSort02 {


    public static <T extends Comparable<T>> void sort(T[] arr ,int n) {

        quickSort(arr,0,n-1);
        //测试正确与否
        TestHelper.printArray(arr);
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

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
      swap( arr, l , (int)(Math.random()*(r-l+1))+l );
        //参考点
        T v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v

        int i=l+1,j=r;
        while (true) {
            //<0,不管，直到碰到=v

            while( i <= r && arr[i].compareTo(v) < 0 )
                i ++;

            while( j >= l+1 && arr[j].compareTo(v) > 0 )
                j --;
            if( i > j )
                break;
            //交换两个等于V
            swap(arr,i,j);
            i++;
            j--;
        }
       swap(arr,l,j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] arr= {9,8,7,6,5,4,3,2,1};
        int n=9;
        QuickSort02.sort(arr,n);
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
