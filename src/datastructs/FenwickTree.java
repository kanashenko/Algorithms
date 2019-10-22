package datastructs;

public class FenwickTree {

    private long[] tree;
    int N;

   public FenwickTree(long values[]){
       if (values == null) throw new IllegalArgumentException("Values cannot be null!");

       values[0] = 0L; //first element is not used
       N = values.length;
       tree = values.clone();

       for(int i=1; i < N; i++){
           int parent = i + LSB(i);
           if (parent < N) tree[parent] += tree[i];
       }
   }

   public long get(int i){
       return sum(i,i);
   }

   // Add 'v' to index 'i', O(log(n))
   public void add(int i, long value){
       while(i < N){
           tree[i] += value;
           i += LSB(i);
       }
   }

   public void set(int i, long value){
       add(i, value - sum(i, i));
   }

    public long sum(int left, int right){
        if (right < left) throw new IllegalArgumentException("Make sure right >= left");
        return indexSum(right) - indexSum(left-1);
    }

   private int LSB(int i){
       return i & -i;
   }

   private long indexSum(int i){
       long sum = 0L;
       while(i > 0){
           sum += tree[i];
           i &= ~LSB(i); // Equivalently, i -= lsb(i);
       }
        return sum;
   }

    @Override
    public String toString() {
        return java.util.Arrays.toString(tree);
    }

    public static void main(String[] args) {
        // The values array must be one based
        long[] values = {0,1,2,2,4};
//               ^ first element does not get used

        FenwickTree ft = new FenwickTree(values);

        System.out.println(ft.sum(1, 4)); // 9, sum all numbers in interval [1, 4] in O(log(n))
        ft.add(3, 1); // Adds +1 to index 3.

        System.out.println(ft.sum(1, 4)); // 10, sum all numbers in interval [1, 4]
        ft.set(4, 0); // Set index 4  to have value zero.

        System.out.println(ft.sum(1, 4)); // 6, sum all numbers in interval [1, 4]
        ft.get(2);    // 2, Get the value at index 2, this is the same as .sum(2, 2)
    }
}
