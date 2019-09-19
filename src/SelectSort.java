/**
 * 选择排序，
 */
public class SelectSort {
    int[] data;
    public SelectSort(int[] data){
        this.data = data;
    }

    //普通的选择排序
    public int[] sort(){
        int length = data.length;
        for(int i = 0;i<length-1;i++){
            int min = i;
            for(int j = i+1;j<length;j++){
                if(data[min]>data[j])
                    min = j;
            }
            swap(i,min);
        }
        return data;
    }

    //既然是选择排序，那么我们可以一次选择最大值和最小值
    public int[] optimizeSort(){
        int left,right;
        left = 0;
        right = data.length-1;
        while (left<right){
            int min = left;
            int max = right;
            for(int i = left;i<=right;i++){
                if(data[min]>data[i])
                    min = i;
                if(data[max]<data[i])
                    max = i;
            }
            //注意，最大值在最小位置，最小值在最大位置。或者其他有可能事结果不正确的情况，要做下面的修正
            swap(left,min);
            if(max==left)
                max = min;
            swap(right,max);
            left++;
            right--;
        }


        return data;
    }

    private void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
