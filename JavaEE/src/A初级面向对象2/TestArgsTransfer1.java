package A初级面向对象2;

public class TestArgsTransfer1 {
 public static void main(String[] args) {
	 TestArgsTransfer1 tt1 = new TestArgsTransfer1();
	 DataSwap ds = new DataSwap();
	 System.out.println("ds.i:" + ds.i + " ds.j:" + ds.j);
	 tt1.swap(ds);
	 System.out.println(ds);
	 System.out.println("ds.i:" + ds.i + " ds.j:" + ds.j);
   }
/*形参是引用数据类型的：将实参的引用类型变量的值
 （对应的堆空间的对象实体的首地址值）传递给形参的引用类型变量。*/
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
