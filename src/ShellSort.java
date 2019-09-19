/**
 * 希尔排序的思想是使数组中任意间隔为h的元素都是有序的。这样的数组被称为h有序数组。
 * 话句话说一个h有序数组就是h个相互独立的有序数组编织在一起组成一个数组。
 * 在排序的时候，如果h很大，我们就可以将元素移动到很远的地方，为实现更小的h有序创造方便。
 * 用这种方式，对于任意以1结尾的h序列，我们都能够将数组排序。
 */
public class ShellSort {
    int[] data;
    public ShellSort(int[] data){
        this.data = data;
    }
    public void sort(){
        int length = data.length;
        int h = 1;
        while (h<length/3)
            h = 3*h+1;
        while (h>=1){
            for(int i = h;i<length;i++){
                for(int j = i;j>=h;j-=h){
                    if(data[j]<data[j-h])
                        swap(j,j-h);
                }
            }
            h = h/3;
        }
    }

    private void swap(int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
