public class Activity1 extends IntegerManager implements PrintPretty {
    public static void main(String[] args) throws Exception {
        Activity1 thingy = new Activity1();
        thingy.buildList();
        thingy.printPretty();
        thingy.shuffle();
        thingy.printPretty();
        // thingy.selectionSort();
        // thingy.printPretty();
        // thingy.selectionSort(true);
        // thingy.printPretty();
        // thingy.insertionSort();
        // thingy.printPretty();
        // thingy.insertionSort(true);
        // thingy.printPretty();
        thingy.mergeSort(thingy.nums);
        thingy.printPretty();
    }

    @Override
    void buildList() {
        nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 101); // Math.random(61)+10;
        }
    }

    public void printPretty() {
        System.out.println("\n ====== ARRAY ====== (size : " + nums.length + ")");
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    @Override
    void shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int r = (int) (Math.random() * nums.length);

            int temp = nums[i];
            nums[i] = nums[r];
            nums[r] = temp;

        }
    }

    @Override
    void insertionSort() {
        // verbose sort
        // outer loop
        for (int j = 1; j < nums.length; j++) {
            int temp = nums[j]; // will stealing souls
            // while loop that goes backwards
            int i = j - 1;
            while (i > -1 && nums[i] > temp) {
                // shift over
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = temp; // complete the three part swap - realse the soul in wills finger
            System.out.print("\n\nINSERTION SORT PASS # " + j + ":");
            printPretty();
        }

    }

    void insertionSort(boolean highToLow) {
        if (!highToLow) {
            selectionSort();
            return;
        }
        // outer loop
        for (int j = 1; j < nums.length; j++) {
            int temp = nums[j]; // will stealing souls
            // while loop that goes backwards
            int i = j - 1;
            while (i > -1 && nums[i] < temp) {
                // shift over
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = temp; // complete the three part swap - realse the soul in wills finger

        }

    }

    void selectionSort(boolean highToLow) {
        if (!highToLow) {
            selectionSort();
            return;
        }
        for (int outer = 0; outer < nums.length - 1; outer++) {
            // find the smallest
            int largest_index = outer;
            // inner loop to search for smallest
            for (int inner = outer + 1; inner < nums.length; inner++) {
                if (nums[inner] > nums[largest_index]) {
                    largest_index = inner;
                }
                // three part swap outer loop with

                int temp = nums[largest_index];
                nums[largest_index] = nums[outer];
                nums[outer] = temp;

            }
            // three part swap outer loop with
        }
    }

    @Override
    void selectionSort() {
        // TODO Auto-generated method stub
        // outer loop
        for (int outer = 0; outer < nums.length - 1; outer++) {
            // find the smallest
            int smallest_index = outer;
            // inner loop to search for smallest
            for (int inner = outer + 1; inner < nums.length; inner++) {
                if (nums[inner] < nums[smallest_index]) {
                    smallest_index = inner;
                }
                // three part swap outer loop with

                int temp = nums[smallest_index];
                nums[smallest_index] = nums[outer];
                nums[outer] = temp;
            }
            // three part swap outer loop with
        }
        // find the smallest
        // inner loop to search for smallest

    }

    @Override
    void mergeSort(int [] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = nums[i];
        }
        for (int i = mid; i < n; i++) {
            // subtracts mid to offset
            r[i - mid] = nums[i];
        }
        mergeSort(l);
        mergeSort(r);

        // you cant get to this next line until the base case hits

        merge(nums, l, r, mid, n - mid);
    }

    void merge(int [] nums, int[] l, int[] r, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                nums[k++] = l[i++];
            } else {
                nums[k++] = r[j++];
            }
        }
        // there is only left remaining
        while (i < left) {
            nums[k++] = l[i++];
        }
        // there i only right remainging
        while (j < right) {
            nums[k++] = r[j++];

        }
    }

    @Override
    int pickRandom() {
        int r = (int) (Math.random() * nums.length);
        return r;

    }

    int binarySearch(int something) {
        // start in the middle
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;

            if (nums[middle] == something)
                return middle;
            else if (nums[middle] > something) {

                high = middle - 1;

            } else if (nums[middle] < something) {
                low = middle + 1;
            }
            return something;
        }
        return -1;
    }
}
