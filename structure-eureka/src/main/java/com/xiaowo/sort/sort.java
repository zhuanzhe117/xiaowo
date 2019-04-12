package com.xiaowo.sort;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by gu.haiyan on 2017/7/12.
 * 八大排序
 */
public class sort {

    //选择排序
    public static void choose(int[] a ,int n){
        for (int i = 0; i < n-1; i++) {//每趟从未排序中得到一个最小值，一共需要n-1趟，即0到n-2
            int min = i;
            for (int j = i+1; j < n; j++) {//类似三个数中找最小的，先假设第一个是最小的
                if (a[j] < a[min]){
                    min = j;
                }
            }
            if(min != i) {//该趟中，i处的元素就是最小的，则不需要换了，否则交换
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
    //堆排序1，是对选择排序的优化------------开始

    public static void heapSort1(int[] array){
        int length=array.length;
        initHeap(array, length);//初始化稳定堆
        System.out.println("初始化堆后：" + Arrays.toString(array));
        switchData(array,0,length-1);//交换第一个元素和本轮最后一个元素
        //二叉树排序
        for (int length2 = length - 1; length2 > 1 ; length2--) {//循环length - 2次
            int index=0;
            while(2 * index + 1 < length2){//只要有左孩子节点就可能产生交换，进入循环
                if (2 * index + 2 < length2) {//左右孩子都有
                    int max = index;
                    if (array[max] < array[2 * index + 1]) {
                        max = 2 * index + 1;
                    }
                    if (array[max] < array[2 * index + 2]) {
                        max = 2 * index + 2;
                    }
                    if (max != index) {
                        switchData(array, index, max);
                        index = max;
                    }else {
                        break;//max==index，表示节点最大，下面的堆都是稳定的，不用继续循环
                    }
                }
                if (2 * index + 1 < length2 && 2 * index + 2 >= length2) {//只有左孩子，没有右孩子
                    if (array[index] < array[2 * index + 1]) {
                        switchData(array, index, 2 * index + 1);
                    }else {
                        break;//2 * index + 1==index，表示节点最大，下面的堆都是稳定的，不用继续循环
                    }
                }
            }
            switchData(array, 0, length2 - 1);//交换第一个元素和本轮最后一个元素
        }
    }
    //初始化堆
    public static void initHeap(int[] array,int length){

        int high=length-1;
        boolean isChange=false;
        for(int k=(high-1)/2;k >= 0;k--){
            //找到最后一个父节点
            int left=2*k+1;
            int right=left+1;
            //判断是否有节点
            if(left<=high){
                int max=left;
                if(right<=high){
                    if(array[left]<array[right]){
                        max=right;
                    }
                }
                //将最大值跟父节点交换
                if(array[max] > array[k]){
                    isChange=true;
                    switchData(array,max,k);
                }
            }
        }
        if(isChange){//如果一次就能完成稳定堆的初始化，则不再需要递归调用，以达到优化算法的目的
            initHeap(array,length);
            System.out.println("递归："+Arrays.toString(array));
        }
    }

    //交换数组中两个数的方法，因为要多次用到，封装成一个方法；
    public static void switchData(int[] array,int index1 ,int index2){
        array[index1] ^= array[index2];
        array[index2] ^= array[index1];
        array[index1] ^= array[index2];
    }

    //堆排序1，是对选择排序的优化------------结束

    //堆排序2，是对选择排序的优化------------开始

    public static void heapSort(Object[] a){
        int len = a.length;
        //构建堆
        for(int i=(len-1)/2;i>=0;i--){
            heapAdjust(a,i,len);
        }

        //输出堆顶元素并调整建新堆的过程
        int count = len-1;
        while(count > 0 ){
            //交换堆顶与最后一个值
            swap(a,0,count);
            count -- ;
            heapAdjust(a,0,count);
        }
    }

    /**
     * 调整某一个节点及其左右子节点的位置 ，并选择左右节点中的较大者
     * 继续向下调整
     */
    private static void heapAdjust(Object[] a,int i,int len){
        Object parent = a[i];
        for(int j = (i+1) * 2 - 1;j < len; j = (j+1) * 2 - 1){   //沿着左右节点中的较小者继续往下搜索
            if(j < len-1 && ((Comparable)a[j]).compareTo(a[j+1]) < 0 ){
                ++j;        //如果左节点较大过度到右节点
            }
            if(((Comparable)parent).compareTo(a[j]) > 0) //左右节点均小于父节点则不必要继续向下搜索
                break;
            a[i] = a[j];
            i = j ;
        }
        a[i] = parent;      //parent插入到正确的位置
    }

    /**
     * 交换数组中两元素的值
     */
    private static void swap(Object[] a,int i,int j){
        Object temp = null;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //堆排序2，是对选择排序的优化------------结束




    //冒泡排序 3,6,12,8
    public static void bubble(int[] a ,int n){
        boolean flag;
        for (int i = 0; i < n-1; i++) {
            flag = true;
            for (int j = 0; j < n-1-i; j++) {//第i趟的时候，已经排好的数是i个，一共有n个数，所以最后一个是n-i，索引是n-i-1，j最大值是这个数的前一个
                if (a[j+1] < a[j]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
            }
            if(flag) return;
        }
    }

    //快速排序，是对冒泡排序的优化-----------开始
    public static void quickSort(int arr[],int _left,int _right){
        int left = _left;
        int right = _right;
        int temp = 0;
        if(left <= right){   //待排序的元素至少有两个的情况
            temp = arr[left];  //待排序的第一个元素作为基准元素
            while(left != right){   //从左右两边交替扫描，直到left = right

                while(right > left && arr[right] >= temp)
                    right --;        //从右往左扫描，找到第一个比基准元素小的元素
                arr[left] = arr[right];  //找到这种元素arr[right]后与arr[left]交换

                while(left < right && arr[left] <= temp)
                    left ++;         //从左往右扫描，找到第一个比基准元素大的元素
                arr[right] = arr[left];  //找到这种元素arr[left]后，与arr[right]交换

            }
            arr[right] = temp;    //基准元素归位
            quickSort(arr,_left,left-1);  //对基准元素左边的元素进行递归排序
            quickSort(arr, right+1,_right);  //对基准元素右边的进行递归排序
        }
    }

    //快速排序，是对冒泡排序的优化-----------结束

    //插入排序
    public static void insertion(int[] a, int n){
        for (int i = 1; i < n; i++) {
            int temp =  a[i];
            int j = i-1;
            while (j>=0 && a[j]>temp){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }

    //希尔排序

    //欧几里得算法
    public static int getGreatestCommonDivisor(int m,int n){
        while (n != 0){
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public static void getIncSeq(int[] a){
        int n = a.length;
        int start =0;
        int count =1;
        int tempStart =0;
        int tempCount =1;
        for (int i = 1; i < n; i++) {
            if (a[i-1]<a[i]){
                tempCount ++;
            }else {
                if (tempCount>count){
                    count = tempCount;
                    start = tempStart;
                }
                tempStart = i;
                tempCount = 1;
            }
            if(i==(n-1)){
                if (tempCount>count){
                    count = tempCount;
                    start = tempStart;
                }
            }
        }
        System.out.println(MessageFormat.format("start:{0} count:{1}" ,start,count));
    }

    public static void getSeq(int[] a){
        int n = a.length;
        int start =0;
        int end =0;

        for(int i =0;i<n-1;i++){
            start = i;
            while (i+1<n && a[i]<a[i+1]){
                i++;
            }
            if( (i-end-1) > (end -start)){
                start = end +1;
                end =i;
            }
        }
        System.out.println(MessageFormat.format("start:{0} end:{1}" ,start,end));
    }

    public static void main(String[] args) {
        int[] a = {1,0,3,5,1,4,0,7,9,13};
//        getSeq(a);
//        int[] a = {3,7,10,11,12,15,24};
//        bubble(a ,7);
//        int[] a = {7,3,24,12,5};
//        insertion(a,5);
//        for (int i = 0; i < 5; i++) {
//            System.out.print(" " + a[i]);
//        }
//        int result = getGreatestCommonDivisor(100,25);
//        System.out.println("result = [" + result + "]");


        //测试堆排序1
        //6,5,3,1,8,7,2,4
//        int[] array = {6,5,3,1,8,7,2,4};
//        initHeap(array,8);


        //测试堆排序2
//        Integer[] array = {6,5,3,1,8,7,2,4};
//        heapSort(array);

        //测试快速排序
        //6,5,3,1,8,7,2,4
//        int[] array = {6,5,3,1,8,7,2,4};
//        quickSort(array,0,array.length-1);

    }
}
