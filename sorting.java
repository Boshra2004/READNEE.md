
package home.pkg1;


import java.util.Random;

public class sorting {

    // 1. Selection Sort
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) min = j;
            }
            int t = a[min]; a[min] = a[i]; a[i] = t;
        }
    }

    // 2. Insertion Sort
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) { a[j + 1] = a[j]; j--; }
            a[j + 1] = key;
        }
    }

    // 3. Bubble Sort (مُحسّنة لتقليل العمليات إذا كانت المصفوفة مرتبة)
    public static void bubbleSort(int[] a) {
        boolean swapped;
        for (int i = 0; i < a.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // 4. Merge Sort
    public static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }
    private static void merge(int[] a, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) temp[k++] = (a[i] < a[j]) ? a[i++] : a[j++];
        while (i <= m) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];
        System.arraycopy(temp, 0, a, l, temp.length);
    }

    // 5. Quick Sort (مع اختيار Pivot عشوائي لتجنب Stack Overflow)
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }
    private static int partition(int[] a, int low, int high) {
        int randomIndex = low + new Random().nextInt(high - low + 1);
        int temp = a[randomIndex]; a[randomIndex] = a[high]; a[high] = temp;

        int pivot = a[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                int t = a[i]; a[i] = a[j]; a[j] = t;
            }
        }
        int t = a[i + 1]; a[i + 1] = a[high]; a[high] = t;
        return i + 1;
    }

    // توليد المصفوفات
    public static int[] getRand(int n) {
        int[] a = new int[n]; Random r = new Random();
        for (int i = 0; i < n; i++) a[i] = r.nextInt(100000);
        return a;
    }
    public static int[] getSorted(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }
    public static int[] getReversed(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = n - i;
        return a;
    }
    public static int[] getPartial(int n) {
        int[] a = getSorted(n);
        for (int i = 0; i < n * 0.2; i++) {
            int x = (int)(Math.random() * n), y = (int)(Math.random() * n);
            int t = a[x]; a[x] = a[y]; a[y] = t;
        }
        return a;
    }
}