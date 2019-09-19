import java.util.Random;

public class Main {
    public static void main(String[] args){
        int[] data = new int[100];
        Random random = new Random();
        for(int i = 0;i<100;i++){
            data[i] = random.nextInt(100)+1;
        }
        QuickSort quickSort = new QuickSort(data);
        quickSort.sort(0,data.length-1);
        for(int i = 0;i<100;i++){
            System.out.print(data[i]+ " ");
        }

    }
}
