package BB�߼�������2;
/*
 * ���ھֲ��ڲ����ʹ��
 */
public class TestInnerClass1 {

}
class OuterClass{
	    //�ֲ��ڲ���
		//���µ�ʹ�÷�ʽ����
		public void method1(){		
			class InnnerClass{
				
			}
      }
/*
 * ����ʹ��һ��������ʹ�䷵��ֵΪĳ�����ӿڵĶ���
 * ����������ӿ��ڷ����ڲ�����
 */
	//ʹ�÷�ʽһ
		public Comparable getComparable(){
			//1,����һ��ʵ��Comparable�ӿڵ���:�ֲ���
			class MyComparable implements Comparable{
				@Override
				public int compareTo(java.lang.Object o) {
					return 0;
				}
			}
			//2.����һ��ʵ����Ķ���
			return new MyComparable();
		}
}