package BB�߼�������2;
//�ӿڵ�Ӧ�ã�����ģʽ
public class TestProxy {
    public static void main(String[] args) {
		Object obj = new ProxyObject();
		obj.action();
	}
}
interface Object{
	 void action();
}
//������
class ProxyObject implements Object{
     Object obj;
    public ProxyObject(){
    	System.out.println("�����ഴ���ɹ�");
    	 obj = new Objectlmpl();
    }
	@Override
	public void action() {
		 System.out.println("�����࿪ʼִ��");
		 obj.action();
		 System.out.println("������ִ�н���");
	}	
}
class Objectlmpl implements Object{
	@Override
	public void action() {
		System.out.println("=====�������࿪ʼִ��=====");
		System.out.println("=====����Ĳ���======");
		System.out.println("=====��������ִ�����=====");
	}
}