package analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<int[]> findTriplets(int[] arr) {
        List<int[]> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i < arr.length-1; i++){
            for(int j=i+1; j< arr.length; j++){
                int k = -(arr[i] + arr[j]);
                int index = BinarySearch.ascendingBinarySearch(arr, k, 0, arr.length-1);
                if(index > -1 && arr[i] < arr[j] && arr[j] < k){
                    triplets.add(new int[]{arr[i], arr[j], k});
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
        List<int[]> triplets = ThreeSum.findTriplets(arr);
        for(int a[] : triplets){
            System.out.println(" is " + Arrays.toString(a));
        }

    }
}
