
package home.pkg1;

import java.util.Arrays;
public class Home1 {

    
    public static void main(String[] args) {
    

   
        int n = 100000; // حجم البيانات

        int[] r = sorting.getRand(n);
        int[] rev = sorting.getReversed(n);
        int[] p = sorting.getPartial(n);
        int[] s =sorting.getSorted(n);
        
System.out.println("Algorithm       | Random        | Reversed      | Partial       | Sorted");
        System.out.println("-----------------------------------------------------------------------------");
        run("Selection Sort", r, rev, p, s);
        run("Insertion Sort", r, rev, p, s);
        run("Bubble Sort",    r, rev, p, s);
        run("Merge Sort",     r, rev, p, s);
        run("Quick Sort",     r, rev, p, s);
    }

    public static void run(String name, int[] r, int[] rev, int[] p, int[] s) {
        long t1 = test(name, r);
        long t2 = test(name, rev);
        long t3 = test(name, p);
        long t4 = test(name, s);
        System.out.printf("%-15s | %-10d µs | %-10d µs | %-10d µs | %-10d µs%n", name, t1, t2, t3, t4);
    }

    public static long test(String name, int[] original) {
        int[] a = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();

        if (name.equals("Selection Sort")) sorting.selectionSort(a);
        else if (name.equals("Insertion Sort")) sorting.insertionSort(a);
        else if (name.equals("Bubble Sort")) sorting.bubbleSort(a);
        else if (name.equals("Merge Sort")) sorting.mergeSort(a, 0, a.length - 1);
        else if (name.equals("Quick Sort")) sorting.quickSort(a, 0, a.length - 1);

        return (System.nanoTime() - start) / 1000; // بالمايكروثانية
    }
}
    
    

