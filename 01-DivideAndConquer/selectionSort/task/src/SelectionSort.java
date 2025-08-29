public class SelectionSort<T> extends Sorter<T> {
    public void sort(Comparable<T>[] arr) {
        /* TODO: implement the selection sort algorithm here */
        int minindex=-1;
        int n =arr.length;
        for (int i = 0; i < n-1; i++)
        {
            minindex=i;
         for (int j = i+1; j < n; j++)
         {
            if (arr[minindex].compareTo((T)arr[j])>0) {
                minindex=j;
            }
         }
         swap(arr,i,minindex);
        }
    }
    public void swap(Comparable<T>[] arr, int i, int j) {
        /* implement swapping method */
        Comparable<T> tmp = arr[i];
        arr[i]= arr[j];
        arr[j]= tmp;
    }
}