package A�����������3;

public class TestBoyAndGirl {
	//�������ʵ����   ����ʵ�����Ķ����޷��ٷ�������� �������ڷ����������
    public static void main(String[] args) {
    	Boy boy = new Boy();
    	boy.setName("kyle");
    	boy.setAge(19);
    	Girl girl = new Girl();
    	girl.setName("Barbed");
    	
    	boy.marry(girl);
    	boy.shout();
    	System.out.println();
    	girl.marry(boy);
	}     
}
class Boy{
	private String name;
	private int age;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void marry(Girl girl){
		System.out.println("��ҪȢ: "+girl.getName());
	}
	public void marry(Boy boy){
	   System.out.println("��Ҫ�޸�: "+boy.getName());
	}
	public void shout(){
		if(this.age >= 22){
			System.out.println("���ǵ��˽���������");
		}else{
			System.out.println("���ǻ���̸̸�����ɣ�");
		}
	}
}
class Girl{
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public void marry(Boy boy){
		System.out.println("��Ҫ�޸�: "+boy.getName() );
		boy.marry(this);/*���������this:��ʾ˭�����������˭����this,
		                                                  ��Ȼ������������girl������ø÷���,
		                                                     ���������this���൱��girl����*/
	}
}
