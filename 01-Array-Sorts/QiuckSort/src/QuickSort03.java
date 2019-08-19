/**
 * 三路快速排序
 */
public class QuickSort03<T> {


    private static  void sort(Comparable[] arr, int l,int r) {


        //递归截止
        if(l>=r) {
            return;
        }

        Comparable v = arr[l];

        Integer lt = l;     // arr[l+1...lt] < v
        Integer gt = r + 1; // arr[gt...r] > v
        Integer i = l+1;    // arr[lt+1...i) == v

        //递归截止
        if(i>=gt) {
            return;
        }

        while( i < gt ){

            if( arr[i].compareTo(v) < 0 ){
                swap( arr, i, lt+1);
                i ++;
                lt ++;
            } else if( arr[i].compareTo(v) > 0 ){
                swap( arr, i, gt-1);
                gt--;
            } else{ // arr[i] == v
                i ++;
            }
        }

        swap( arr, l, lt );
        sort(arr, l, lt - 1);
        sort(arr, gt, r);

    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
        TestHelper.printArray(arr);
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr=Util.generateRandomArray(100,0,100);
        QuickSort03.sort(arr);
    }
}
