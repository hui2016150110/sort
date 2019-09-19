/**
 * 普通冒泡排序，和带哨兵的冒泡排序（优化）
 */
public class BubbleSort {
    int[] data;
    public BubbleSort(int[] data){
        this.data = data;
    }

    //普通的冒泡排序算法
    public int[] sort(){
        int length = data.length;
        for(int i = 0;i<length-1;i++){
            for(int j = 0;j<length-1-i;j++){
                if(data[j]>data[j+1]){
                    swap(j,j+1);
                }
            }
        }
        return data;
    }

    //优化后的冒泡排序,添加一个判断，如果这一趟没有交换，就说明数组有序，直接退出
    public int[] firstOptimizeSort(){
        int length = data.length;
        boolean flag = false;
        for(int i = 0;i<length-1;i++){
            flag = false;
            for(int j = 0;j<length-1-i;j++){
                if(data[j]>data[j+1]){
                    flag = true;
                    swap(j,j+1);
                }
            }
            if(!flag)
                return data;
        }
        return data;
    }

    /*
     优化一仅仅适用于连片有序而整体无序的数据(例如：1， 2，3 ，4 ，7，6，5)。
     但是对于前面大部分是无序而后边小半部分有序的数据(1，2，5，7，4，3，6，8，9，10)排序效率也不可观，
     对于种类型数据，我们可以继续优化。既我们可以记下最后一次交换的位置，后边没有交换，必然是有序的，
     然后下一次排序从第一个比较到上次记录的位置结束即可。*/

    public int[] secondOptimizeSort(){
        int length = data.length;
        int lastPos = length-1;
        int k = lastPos;
        boolean flag = false;
        for(int i = 0;i<length-1;i++){
            flag = false;
            for(int j = 0;j<k;j++){
                if(data[j]>data[j+1]){
                    swap(j,j+1);
                    lastPos = j;
                    flag = true;
                }
            }
            if(!flag)
                return data;
            k = lastPos;
        }
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    private void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
