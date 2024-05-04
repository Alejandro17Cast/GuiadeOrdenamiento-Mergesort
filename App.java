public class App {
    private static int left;

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);

        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Tamaños de los subarreglos
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Arreglos temporales
        int[] tempLeft = new int[sizeLeft];
        int[] tempRight = new int[sizeRight];

        // Copia datos arreglos temporales
        for (int i = 0; i < sizeLeft; i++) {
            tempLeft[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            tempRight[j] = arr[mid + 1 + j];
        }

        // Fuciona los subarreglos en el arrglo original
        int i = 0, j = 0;
        int k = left; // indice inicial

        while (i < sizeLeft && j < sizeRight) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }

        // Si hay elementos restante en tempLeft los copia

        while (i < sizeLeft) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }
        // Si hay elementos restante en tempRight los copia

        while (j < sizeRight) {
            arr[k] = tempRight[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82 };
        int n = arr.length;

        mergeSort(arr, left = 0, n - 1);

        System.out.println("Arreglo ordenado: ");
        for (int num : arr) {
            System.out.println(num + " ");
        }
    }
}
