/**
 * 插入排序以及优化
 */
public class InsertSort {
    int[] data;
    public InsertSort(int[] data){
        this.data = data;
    }

    public int[] sort(){
        int length = data.length;
        for(int i = 1;i<length;i++){
            for(int j = i;j>0&&data[j]<data[j-1];j--){
                swap(j,j-1);
            }
        }
        return data;
    }

    //优化后的插入排序，不要进行交换操作，直接让前面的一个数覆盖掉后面的一个数，然后在将这个数插入正确的位置。
    public int[] optimizeSort(){
        int length = data.length;
        for(int i = 1;i<length;i++){
            int temp = data[i];
            int j;
            for(j = i;j>0;j--){
                if(temp<data[j-1])
                    data[j] = data[j-1];
                else
                    break;
            }
            data[j] = temp;
        }
        return data;
    }

    private void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
