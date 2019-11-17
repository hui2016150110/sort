public class HeapSort {
    private int[] arr;//第一个元素不存储数据
    private int length;
    public HeapSort(int[] arr){
        this.arr = arr;
        length = arr.length;
    }
    
    public void buildHeap(){
        for(int i = length/2;i>=1;i--){
            heapify(i,length);
        }
    }

    //一个元素从上往下堆化
    private void heapify(int i,int length){
        int pos = i;
        while (pos<length){
            int maxPos = pos;
            if(length>2*pos&&arr[2*pos]>arr[pos]) maxPos = 2*pos;
            if(length>2*pos+1&&arr[2*pos+1]>arr[maxPos]) maxPos = 2*pos+1;
            if(pos==maxPos) break;
            swap(pos,maxPos);
            pos = maxPos;
        }

    }
    public void sort(){
        buildHeap();
        int k = length;
        while (k>1){
            swap(1,k-1);//与最后一个元素交换
            k--;
            heapify(1,k);
        }
    }
    private void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
