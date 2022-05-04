public class Challenge1 {
    /***
     * Get the nth number in the fibonacci sequence given n
     * Alternatively given a number F, print out whether it's a fibonacci number and what the closest index n in the
     * fibonacci sequence is.
     * @param n
     * Print boolean True/False (Whether the input is a fibonacci number) and Integer i (the closest index n in the fibonacci sequence)
     */

    private static void fibIndex (long n, long f){
        // Case for negative input and 0
        if (n < 0) System.out.println("F is not a fibonacci number");
        if (n == 0) System.out.println("F is a fibonacci number and its index is 0");

        // Find nth number in fibonacci sequence
        long first = 0;
        long second = 1;

        long index = -1;
        long nonFibIndex = -1;

        for (long i = 1; i <= n; i++) {
            if (f == first){
                index = i;
            }else if (first < f && f < second){
                // if f is not fibonacci number find the closest index
                nonFibIndex = Math.abs(f - first) > Math.abs(f - second) ? (i + 1) : i;
            }
            long temp = first;
            first = second;
            second += temp;
        }

        // Case 1. F <= n and F is Fibonacci number;
        // Case 2. F <= n and F is not Fibonacci number;
        // Case 3. F > n
        if (index != -1){
            System.out.println("F: " + f + " is a fibonacci number and its index is: " + index);
        }else if (nonFibIndex != -1){
            System.out.println("F: " + f + " is not a fibonacci number and the closest index is: " + nonFibIndex);
        }else{
            System.out.println("F: " + f + " is not in range n and the closest index in sequence is: " + (n + 1));
        }

    }

}
