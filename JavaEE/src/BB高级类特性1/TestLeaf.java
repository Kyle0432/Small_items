package BB�߼�������1;
class Root{
	static{
		System.out.println("Root�ľ�̬��ʼ����");
	}
	public Root(){
		System.out.println("Root���޲���������");
	}
	{
		System.out.println("Root����ͨ��ʼ����");
	}
}
class Mid extends Root{
	static{
		System.out.println("Mid�Ǿ�̬��ʼ����");
	}
	{
		System.out.println("Mid����ͨ��ʼ����");
	}
	public Mid(){
		System.out.println("Mid���޲εĹ�����");
	}
	public Mid(String msg){
		//���ñ������صĹ�����
		this();
		System.out.println("Mid�Ĵ�����������,�����ֵ��"+ msg);
	}
}
class Leaf extends Mid{
	static{
		System.out.println("Leaf�ľ�̬��ʼ����");
	}
	{
		System.out.println("Leaf����ͨ��ʼ����");
	}
	public Leaf(){
		//���ø��ຬ�εĹ�����
		super("�й��");
		System.out.println("ִ��Leaf�Ĺ�����");
	}
}
public class TestLeaf {
   public static void main(String[] args) {
	   new Leaf();//����Leaf()�޲ι�����
	   System.out.println();
}
}
