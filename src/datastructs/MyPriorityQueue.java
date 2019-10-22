package datastructs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyPriorityQueue<T extends Comparable<T>> {
    int heapSize;
    int heapCapacity;
    List<T> heap;


    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public T peek() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    public MyPriorityQueue(Collection<T> elems){
        heap = new ArrayList<>(elems.size());

        for(T elem : elems){
            add(elem);
        }
    }

    public void add(T elem){

        if(elem == null) throw new IllegalArgumentException();
        if(heapSize < heapCapacity){
            heap.set(heapSize, elem);
        }else{
            heap.add(elem);
            heapCapacity++;
        }
        swim(heapSize);
        heapSize++;
    }

    private void swim(int k){
        int parent = (k-1)/2;

        while(k > 0 && less(k, parent)){
            swap(k, parent);
            k = parent;
            parent = (k-1)/2;
        }
    }

    private boolean less(int i, int j){
        T elem_i = heap.get(i);
        T elem_j = heap.get(j);
      return elem_i.compareTo(elem_j) <= 0;

    }

    private void swap(int i, int j){
        T elem_i = heap.get(i);
        T elem_j = heap.get(j);

        heap.set(i, elem_j);
        heap.set(j, elem_i);
    }

    private void sink(int k){
        while(true){
            int left = 2*k+1;
            int right = 2*k+2;

            int smallest = left;
            if(right < heapSize && less(right, left)) smallest = right;

            if(left >= heapSize || less(k, smallest)) break;

            swap(k, smallest);
            k = smallest;
        }
    }

    public boolean remove(T elem){
        if(elem == null) throw new IllegalArgumentException();

        for (int i= 0; i < heapSize; i++){
            if(elem.equals(heap.get(i))){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    private T removeAt(int k){
        if(isEmpty()) return null;
        heapSize--;

        T removed_elem = heap.get(k);
        swap(k, heapSize);
        heap.set(heapSize, null);

        if(k == heapSize) return removed_elem;

        T elem = heap.get(k);
        sink(k);
        if(heap.get(k).equals(elem)) swim(k);

        return removed_elem;
    }

    public T poll(){
       return removeAt(0);
    }

    public boolean isMinHeap(int k){
        if(k >= heapSize) return true;

        int left = 2*k+1;
        int right = 2*k+2;

        if(left < heapSize && !less(k,left)) return false;
        if(right < heapSize && !less(k,right)) return false;

        return isMinHeap(left) && isMinHeap(right);
    }

    public static void main(String[] args) {
        System.out.println("hello");
        List<Integer> list = Arrays.asList(4,2,9,1,6,7,5);
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>(list);

        System.out.println(queue.isMinHeap(0));
        for(int i = 0; i < queue.size(); i++){
            System.out.print(queue.poll() + " ");
        }
    }
}
