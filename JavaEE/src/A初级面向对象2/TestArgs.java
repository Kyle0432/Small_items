package A�����������2;
/*
 * �ɱ�������βεķ�����
 * 1.��ʽ�����ڷ������βΣ� �������� ... �β���
 * 2.�ɱ�������βεķ�����ͬ���ķ���֮�乹������
 * 3.�ɱ�������β��ڵ���ʱ��������0��ʼ���������������ԡ�
 * 4.ʹ�ÿɱ����βεķ����뷽�����β�ʹ��������һ�µġ�
 * 5.�������д��ڿɱ�������βΣ���ôһ��Ҫ�����ڷ����βε����
 * 6.��һ�������У��������һ���ɱ�������βΡ�
 */
public class TestArgs {
public static void main(String[] args) {
	TestArgs tt = new TestArgs();
	tt.sayHello("hello �й�","hello ����","hello �ϲ�","hello ����");
	System.out.println(tt.getSum(2,4,7,9,33));
}
//�����ĸ�������������
//������һ�����������صĿɱ�������βεķ����Ժ�,���µ�����������ʡ��
 public void sayHello(){
	 System.out.println("hello world");
 }
 public void sayHello(String str1){
	 System.out.println("hello"+str1);
 }
 //�ɱ�������βεķ���
 public void sayHello(String ... args){
	 for(int i = 0; i < args.length;i++){
		 System.out.println(args[i]+"$");
	 }
 }
 //�ɱ�����βε�ʹ������
 public int getSum(int i,int j){
	 return i+j;
 }
 public int getSum(int i,int j ,int k){
	 return i + j + k;
 }
 //�ɱ��βθ������ۼ�
 public int getSum(int ... args){
	 int sum = 0;
	 for(int i = 0 ; i < args.length; i++){
		 sum += args[i];
	 }
	 return sum;//���ر��� Ҫ�ö�Ӧ���������ͽ���
 }
}
