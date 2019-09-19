/**
 * 两种归并排序
 */
public class MergeSort {
    int[] data;
    int[] aux;//辅助数组
    public MergeSort(int[] data){
        this.data = data;
        aux = new int[data.length];//为辅助数组开辟空间
    }

    private void merge(int left,int mid,int right){
        for(int i = left;i<=right;i++){
            aux[i] = data[i];
        }
        int i = left,j = mid;
        int k = left;
        for(;i<mid&&j<=right;){
            if(aux[i]>aux[j])
                data[k++] = aux[j++];
            else if(aux[i]<=aux[j])
                data[k++] = aux[i++];
        }
        if(i>=mid){
            for(;j<=right;){
                data[k++] = aux[j++];
            }
        }
        if(j>right){
            for(;i<mid;){
                data[k++] = aux[i++];
            }
        }
    }

    //自顶向下的归并排序
    public void fromTopToBottomSort(int left,int right){
        if(left>=right)
            return;
        int mid = (left+right)/2;
        fromTopToBottomSort(left,mid);
        fromTopToBottomSort(mid+1,right);
        merge(left,mid+1,right);
    }

    //自底向上的归并排序
    public void fromBottomToTopSort() {
        int size = 1;
        int length = data.length;
        for(;size<length;size = size+size){
            for(int left = 0;left<length-size;left += size+size)
                merge(left,left+size,Math.min(size+size+left-1,length-1));
        }
    }
}
