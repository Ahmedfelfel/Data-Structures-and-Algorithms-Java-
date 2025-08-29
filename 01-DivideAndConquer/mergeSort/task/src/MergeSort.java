public class MergeSort<T> extends Sorter<T> {
    public void sort(Comparable<T>[] arr, int left, int right) {
        // Implement the merge sort method which recursively divides array and invoke the merging
        if(left<right)
        {
            int mid =(right + left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void sort(Comparable<T>[] arr) {
        // DO NOT TOUCH. This is an alias method.
        sort(arr, 0, arr.length - 1);
    }

    public void merge(Comparable<T>[] arr, int left, int mid, int right) {
        // Implement merging method here
        int n1 = mid-left+1;
        int n2 = right-mid;
        @SuppressWarnings("unchecked")
        Comparable<T>[] L = (Comparable<T>[])new Comparable[n1];
        @SuppressWarnings("unchecked")
        Comparable<T>[] R = (Comparable<T>[])new Comparable[n2];
        for(int x=0;x<n1;x++)
        {
            L[x]=arr[left+x];
        }
        for(int x=0;x<n2;x++)
        {
            R[x]=arr[mid+x+1];
        }
        int i=0,j=0;
        int k=left;
        while(i<n1&&j<n2)
        {
            if(L[i].compareTo((T)R[j])<=0)
            {
                arr[k]=L[i];
                i++;
            }
            else
            {
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            arr[k]=R[j];
            j++;
            k++;
        }
    }

    public void merge(Comparable<T>[] arr, int left, int right) {
        // DO NOT TOUCH. This is an alias method.
        int size = right - left + 1;
        int mid = left + (size) / 2;
        merge(arr, left, mid, right);
    }
}