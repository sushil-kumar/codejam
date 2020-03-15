package utility;

class PermutationArray {

    // The input array for permutation
    private final int arr[];

    // Index array to store indexes of input array
    private int Indexes[];

    // The index of the first "increase"
    // in the Index array which is the smallest
    // i such that Indexes[i] < Indexes[i + 1]
    private int Increase;

    // Constructor
    public PermutationArray(int arr[]) { 
        this.arr = arr; 
        this.Increase = -1; 
        this.Indexes = new int[this.arr.length]; 
    }

    // Initialize and output
    // the first permutation
    public int[] getFirst() {

        // Allocate memory for Indexes array
        this.Indexes = new int[this.arr.length];

        // Initialize the values in Index array
        // from 0 to n - 1
        for (int i = 0; i < Indexes.length; ++i) {
            this.Indexes[i] = i;
        }

        // Set the Increase to 0
        // since Indexes[0] = 0 < Indexes[1] = 1
        this.Increase = 0;

        // Output the first permutation
        return this.Output();
    }

    // Function that returns true if it is
    // possible to generate the next permutation
    public boolean hasNext() {

        // When Increase is in the end of the array,
        // it is not possible to have next one
        return this.Increase != (this.Indexes.length - 1);
    }

    // Output the next permutation
    public int[] getNext() {

        // Increase is at the very beginning
        if (this.Increase == 0) {

            // Swap Index[0] and Index[1]
            this.Swap(this.Increase, this.Increase + 1);

            // Update Increase
            this.Increase += 1;
            while (this.Increase < this.Indexes.length - 1
                    && this.Indexes[this.Increase] > this.Indexes[this.Increase + 1]) {
                ++this.Increase;
            }
        } else {

            // Value at Indexes[Increase + 1] is greater than Indexes[0]
            // no need for binary search,
            // just swap Indexes[Increase + 1] and Indexes[0]
            if (this.Indexes[this.Increase + 1] > this.Indexes[0]) {
                this.Swap(this.Increase + 1, 0);
            } else {

                // Binary search to find the greatest value
                // which is less than Indexes[Increase + 1]
                int start = 0;
                int end = this.Increase;
                int mid = (start + end) / 2;
                int tVal = this.Indexes[this.Increase + 1];
                while (!(this.Indexes[mid] < tVal && this.Indexes[mid - 1] > tVal)) {
                    if (this.Indexes[mid] < tVal) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                    mid = (start + end) / 2;
                }

                // Swap
                this.Swap(this.Increase + 1, mid);
            }

            // Invert 0 to Increase
            for (int i = 0; i <= this.Increase / 2; ++i) {
                this.Swap(i, this.Increase - i);
            }

            // Reset Increase
            this.Increase = 0;
        }
        return this.Output();
    }

    // Function to output the input array
    private int[] Output() {
        int[] arrayOutput = new int[this.arr.length];
        for (int i = 0; i < this.Indexes.length; ++i) {
            arrayOutput[i] = this.arr[this.Indexes[i]];
        }
        return arrayOutput;
    }

    // Swap two values in the Indexes array
    private void Swap(int p, int q) {
        int tmp = this.Indexes[p];
        this.Indexes[p] = this.Indexes[q];
        this.Indexes[q] = tmp;
    }

    public static void main(String args[]) { 
        int[] arr = { 0, 1, 2 }; 
          
        PermutationArray perm = new PermutationArray(arr); 
        print(perm.getFirst()); 
        while (perm.hasNext()) { 
            print(perm.getNext()); 
        } 
    }
    
    private static void print(int[] arr) {
        for (int i=0;i<arr.length;++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}