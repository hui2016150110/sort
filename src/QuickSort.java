/**
 * 快速排序
 */
public class QuickSort {
    int[] data;
    public QuickSort(int[] data){
        this.data = data;
    }

    public void sort(int left,int right){
        //递归结束
        if(left>=right)
            return;
        int j = partition(left,right);
        sort(left,j-1);
        sort(j+1,right);
    }

    private int partition(int left,int right){
        int pivot = data[left];
        int i = left,j = right+1;
        /**
         * 从左开始找到第一个比pivot大的数，从右开始找到第一个比pivot小的数，交换这两个数
         * 直到他们相遇，然后与pivot交换，即最后确定pivot的位置，并且返回这个位置。
         */
        while (true){
            while (data[++i]<pivot)
                if(i==right)
                    break;
            while (data[--j]>pivot)
                if(j==left)
                    break;
            if(i>=j)
                break;
            swap(i,j);
        }
        swap(left,j);
        return j;
    }
    private void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
