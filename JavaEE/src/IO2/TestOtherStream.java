package IO2;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;
import org.omg.CORBA.DataOutputStream;

public class TestOtherStream {
	@Test
	public void testData1(){
		DataInputStream dis = null;
		try{
			dis = new DataInputStream(new FileInputStream(new File("data.txt")));
//			byte[] b = new byte[20];
//			int len;
//			while((len = dis.read(b)) != -1){
//				System.out.println(new String(b,0,len));
//			}
			String str = dis.readUTF();
			System.out.println(str);
			boolean b = dis.readBoolean();
			System.out.println(b);
			long l = dis.readLong();
			System.out.println(l);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(dis != null){
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
//��������������������������͡�String���ֽ����������:DataInputStream DataOutputStream
	@Test
	public void testDate(){
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(new File("date.txt")));
			
			dos.write_string("�Ұ��㣬����ȴ��֪����");
			dos.write_boolean(true);
			dos.write_long(1432522344);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(dos != null){
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	// ��ӡ�����ֽ�����PrintStream �ַ�����PrintWriter
	@Test
	public void printStreamWriter(){
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(new File("print.txt"));
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		//������ӡ�����,����Ϊ�Զ�ˢ��ģʽ(д�뻻�з����ֽ�'\n'ʱ����ˢ�����������)
		PrintStream ps = new PrintStream(fos,true);
		if(ps != null){//�ѱ�׼�����(����̨���)�ĳ��ļ�
			System.setOut(ps);
		}
		for(int i = 0; i<= 255; i++){
			System.out.println((char)i);
			if(i%50 == 0){//ÿ50������һ��
				System.out.println();//����
			}
		}
		ps.close();
	}
}
