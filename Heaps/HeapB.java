import java.util.*;

public class HeapB {

    static class heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {

            arr.add(data);

            int x = arr.size() - 1;
            int para = (x - 1) / 2;

            while (arr.get(x) < arr.get(para)) {
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(para));
                arr.set(para, temp);

                x = para;
                para = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        private void heapify(int i) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }

        }

        public int remove() {
            // step 1 - swap first and last ele
            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Remove last ele
            arr.remove(arr.size() - 1);

            // step 3- call heapify
            heapify(0);

            return data;

        }
    }

    public static void heapSort(int arr[]) {
        // Step 1 - Build maxHeap
        int n = arr.length;

        for (int i = n / 2; i >= 0; i--) {

            heapify(arr, i, n);
        }

        // Step 2 - push larger to end
        for (int i = n - 1; i > 0; i--) {

            // Swap(largest first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i); // Call for n-1,..........1
        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {

            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {
       int  ropes[]  = {4, 3, 2, 6};

       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int i=0; i<ropes.length; i++){
        pq.add(ropes[i]);
       }

       int res = 0;
       while(pq.size() > 1){
        int rop1 = pq.remove();
        int rop2 = pq.remove();

        res += rop1 + rop2;
        pq.add(rop1 + rop2);
       }

       System.out.println("The minimun cost for connecting the ropes "+res);
    }
}
