package A初级面向对象1;
                      /*返回不返回 :看这个方法能不能被调用时得到东西，
                                                           如果方法里面有System.out.println()可直接打印出结果;
                                                           就可以不用写要返回的方法,如果像求数组最大值时
                                                           要得到一个数时必须要写个能放回值的方法.*/
public class ArrayUtil {
	public static void main(String[] args) {
		int[] arr ={21,32,64,23,99,75,35,55,65,77,113,11};
		ArrayUtil au = new ArrayUtil();		
		System.out.println("最大值为:"+au.getMax(arr));//括号里面也可以写new int[]{21,32,64,23,99,75,35,55,65,77,113,11}
		System.out.println("最小值为："+au.getMin(arr));
		System.out.println("总和为:"+au.getSum(arr));
		System.out.println("平均值为:"+au.avg(arr));
		System.out.println("遍历的数组元素:");
		System.out.println(au.reverse(arr));	
		au.printArray(arr);
	}
//求数组的最大值
	public int getMax(int[]arr){
		int max = arr[0];
		for(int i = 1; i < arr.length;i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}		
		return	max;			
	}
//求数组的最小值
	public int getMin(int[] arr){
		int min = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(min > arr[i]){
				min = arr[i];
			}
		}
		return min;
	}
//遍历数组元素
	public void printArray(int[] arr){
		for(int i = 0 ; i < arr.length; i++){
			System.out.println(arr[i]+"\t");
		}
	}
//求数组的平均数
	public int avg(int[] arr){
		int sum = getSum(arr);
		return sum/arr.length;
	}
//求数组的总和
	public int getSum(int[] arr){
		int sum = 0 ;//此处不能不赋值,不会自动默认为0
		for(int i = 0 ; i < arr.length;i++){
			sum += arr[i];
		}
		return sum;
	}
//数组的反转
	public int[] reverse(int [] arr){
		/*表示数组的下标开始第一个和数组的结尾最后一个,
		下标x序号总是小于下标y序号,然后x序号慢慢的增加，
		y序号慢慢的减小*/
		for(int x = 0, y = arr.length-1; x < y;x++,y--){
			swap(arr,x,y);
		}
		return arr;//它是int[]类型的所以返回的是一个数组
	}
//对数组进行排序
	public int[] sort(int[] arr){
		for(int i = 0; i<arr.length-1;i++){
			for(int j = 0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
				}
			}
		}
		return arr;
	}
//数组临时交换方法
	public void swap(int[] arr,int i ,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
