import java.util.Random;

public class Main {
    public static void main(String[] args){
        int[] data = new int[1000];
        Random random = new Random();
        data[0] = 0;
        for(int i = 1;i<1000;i++){
            data[i] = random.nextInt(100)+1;
        }
        HeapSort heapSort = new HeapSort(data);
        heapSort.sort();
        for(int i = 0;i<1000;i++){
            System.out.print(data[i]+ " ");
        }

    }
}
