package A�����������2;

public class TestArgsTransfer1 {
 public static void main(String[] args) {
	 TestArgsTransfer1 tt1 = new TestArgsTransfer1();
	 DataSwap ds = new DataSwap();
	 System.out.println("ds.i:" + ds.i + " ds.j:" + ds.j);
	 tt1.swap(ds);
	 System.out.println(ds);
	 System.out.println("ds.i:" + ds.i + " ds.j:" + ds.j);
   }
/*�β��������������͵ģ���ʵ�ε��������ͱ�����ֵ
 ����Ӧ�Ķѿռ�Ķ���ʵ����׵�ֵַ�����ݸ��βε��������ͱ�����*/
  public void swap(DataSwap ds){
	  int temp = ds.i;
	  ds.i = ds.j;
	  ds.j = temp;
	  System.out.println(ds);
  }
}
class DataSwap{
	int i = 10;
	int j = 5;
}
