package analysis;

public class BinarySearch {
    //return index in array
    public static int ascendingBinarySearch(int[] arr, int k, int lo, int hi){
        int mid;
        while(lo<=hi){
            mid = (hi-lo)/2+lo;
            if(k < arr[mid]){
                hi = mid-1;
            }else if(k > arr[mid]){
                lo = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int descendingBinarySearch(int[] arr, int k, int lo, int hi){
        int mid;
        while(lo<=hi){
            mid = (hi-lo)/2+lo;
            if(k < arr[mid]){
                lo = mid+1;
            }else if(k > arr[mid]){
                hi = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int bitonicSearch(int[] arr, int value, int left, int right){
        int mid = (right-left)/2;
        if(left == right) return -1;
        if(arr[mid] == value) return mid;
        if(arr[mid] > value) {
            int res1 = descendingBinarySearch(arr, value, mid+1, right);
            int res2 = ascendingBinarySearch(arr, value, left, mid-1);
            if(res1 != -1){
                return res1;
            }else{
                return res2;
            }
        }else{
            if(arr[mid-1] > arr[mid]){//peak is on the left
                return bitonicSearch(arr, value, left, mid-1);
            }else {//peak is on the right
                return bitonicSearch(arr, value, mid+1, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,8,12,456,13123};
        int[] des = new int[]{9, 7, 4, 2, 0};
        int[] bitonic = new int[]{1, 3, 5, 9, 7, 4, 2, 0};
        System.out.println("b is " + ascendingBinarySearch(arr, 13128, 0, arr.length-1));
        System.out.println("b is " + descendingBinarySearch(des, 7, 0, arr.length-1));
        System.out.println("b is " + bitonicSearch(bitonic, 6, 0, arr.length-1));
    }
}
