package A�����������1;
                      /*���ز����� :����������ܲ��ܱ�����ʱ�õ�������
                                                           �������������System.out.println()��ֱ�Ӵ�ӡ�����;
                                                           �Ϳ��Բ���дҪ���صķ���,��������������ֵʱ
                                                           Ҫ�õ�һ����ʱ����Ҫд���ܷŻ�ֵ�ķ���.*/
public class ArrayUtil {
	public static void main(String[] args) {
		int[] arr ={21,32,64,23,99,75,35,55,65,77,113,11};
		ArrayUtil au = new ArrayUtil();		
		System.out.println("���ֵΪ:"+au.getMax(arr));//��������Ҳ����дnew int[]{21,32,64,23,99,75,35,55,65,77,113,11}
		System.out.println("��СֵΪ��"+au.getMin(arr));
		System.out.println("�ܺ�Ϊ:"+au.getSum(arr));
		System.out.println("ƽ��ֵΪ:"+au.avg(arr));
		System.out.println("����������Ԫ��:");
		System.out.println(au.reverse(arr));	
		au.printArray(arr);
	}
//����������ֵ
	public int getMax(int[]arr){
		int max = arr[0];
		for(int i = 1; i < arr.length;i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}		
		return	max;			
	}
//���������Сֵ
	public int getMin(int[] arr){
		int min = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(min > arr[i]){
				min = arr[i];
			}
		}
		return min;
	}
//��������Ԫ��
	public void printArray(int[] arr){
		for(int i = 0 ; i < arr.length; i++){
			System.out.println(arr[i]+"\t");
		}
	}
//�������ƽ����
	public int avg(int[] arr){
		int sum = getSum(arr);
		return sum/arr.length;
	}
//��������ܺ�
	public int getSum(int[] arr){
		int sum = 0 ;//�˴����ܲ���ֵ,�����Զ�Ĭ��Ϊ0
		for(int i = 0 ; i < arr.length;i++){
			sum += arr[i];
		}
		return sum;
	}
//����ķ�ת
	public int[] reverse(int [] arr){
		/*��ʾ������±꿪ʼ��һ��������Ľ�β���һ��,
		�±�x�������С���±�y���,Ȼ��x������������ӣ�
		y��������ļ�С*/
		for(int x = 0, y = arr.length-1; x < y;x++,y--){
			swap(arr,x,y);
		}
		return arr;//����int[]���͵����Է��ص���һ������
	}
//�������������
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
//������ʱ��������
	public void swap(int[] arr,int i ,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
