package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestFileInputOutputStream {
	 @Test
	    public void testCopyFile(){
		    long start = System.currentTimeMillis();
	    	String src = "C:/Users/Think/Desktop/kyle.jpg";
	    	String dest = "C:/Users/Think/Desktop/kyle3.jpg";
	    	copyFile(src,dest);
	    	Long end = System.currentTimeMillis();
	    	System.out.println("����ʱ��Ϊ:"+(end - start));
	    }
	//ʵ���ļ����Ƶķ���
	 public void copyFile(String src,String dest){
		 //1,�ṩ����,д�����ļ�
		 File file1 = new File(src);
		 File file2 = new File(dest);
		 //2,�ṩ��Ӧ����
		 FileInputStream fis = null;
		 FileOutputStream fos = null;
		 try{
			 fis = new FileInputStream(file1);
			 fos = new FileOutputStream(file2);
		 //3,ʵ���ļ��ĸ���
			 byte[] b = new byte[1024];
			 int len;
			 while((len = fis.read(b)) != -1){
				 fos.write(b, 0, len);
			 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 if(fis != null){
				 try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
			 if(fos != null){
				 try {
					 fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		 }
	 }
	//��Ӳ�̶�ȡһ���ļ�����д�뵽��һ��λ�á����൱���ļ��ĸ��ƣ�
	@Test
	public void testFileInputOutputStream(){
		//1,�ṩ����,д�����ļ�
		File file1 = new File("C:/Users/Think/Desktop/kyle.jpg");
		File file2 = new File("C:/Users/Think/Desktop/kyle2.jpg");
		//2,�ṩ��Ӧ����
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			 fis = new FileInputStream(file1);
			 fos = new FileOutputStream(file2);
			//3,ʵ���ļ��ĸ���
			byte[] b = new byte[20];
			int len;
			while((len = fis.read(b))!= -1){
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void testFileOutputStream(){
		//2,����һ��FileOutputStream�Ķ���,��file�Ķ�����Ϊ�βδ��ݸ�FileOutputStream�Ĺ�������
		FileOutputStream fos = null;
		try {
			//1,����һ��File����,����Ҫд����ļ�λ��
			//����������ļ����Բ�����,��ִ�й�����,��������,���Զ��Ĵ���,������,�Ὣԭ�е��ļ�����
			File file = new File("hello3.txt");
			fos = new FileOutputStream(file);
			//3,д��Ĳ���
			fos.write(new String("I Love You !").getBytes());//���ַ���ת���ֽ�����
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos != null){
				//4,�ر������
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void testFileInputStream3(){
		FileInputStream fis = null;
		try {
			File  file = new File("hello1.txt");
			fis = new FileInputStream(file);
			byte[] b = new byte[5];//��ȡ��������Ҫд�������
			int len;
			//��ʾ��һ�ζ�5��,�ڶ��ζ�4��,����len��һ��Ϊ5�ڶ���Ϊ3
			//Ȼ���һ��ѭ��5��,����5���ֽ���,�ڶ���ѭ��4�ζ���4���ֽ���
			while((len = fis.read(b)) != -1){
				// ��ʽ1,for (int i = 0; i < len; i++) {
				// System.out.print((char) b[i]);
				// }
				String str = new String(b,0,len);
				System.out.println(str);
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// ʹ��try-catch�ķ�ʽ�������µ��쳣������:��֤���Ĺرղ���һ������ִ��
	@Test
	public void testFileInputStream2(){
		// 2.����һ��FileInputStream��Ķ���
		FileInputStream fis = null;
		try {
			// 1.����һ��File��Ķ���
			File file1 = new File("hello1.txt");
			fis = new FileInputStream(file1);
			// 3.����FileInputStream�ķ�����ʵ��file�ļ��Ķ�ȡ��
			int b;
			while((b = fis.read())!= -1){
				System.out.print((char)b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{//��Ϊ����try-catch���ܳ��������쳣 closeһ��Ҫִ�е�
			if(fis != null){//�Է���ָ���쳣
				try {
					// 4.�ر���Ӧ����
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}			
	}
// ��Ӳ�̴��ڵ�һ���ļ��У���ȡ�����ݵ������С�ʹ��FileInputStream
// Ҫ��ȡ���ļ�һ��Ҫ���ڡ�������FileNotFoundException
   @Test
   public void testFileInputStream1() throws Exception{
	   //1,����һ��File��Ķ���
	   File file = new File("hello1.txt");
	   //2,����һ��FileInputStream��Ķ���
	   FileInputStream fis = new FileInputStream(file);
	   //3,����FileInputStream�ķ���,ʵ��file�ļ��Ķ�ȡ��
	   /*
	    * read();��ȡ�ļ���һ���ֽ�.��ִ�е��ļ���βʱ,����-1
	    */
	   int b;
	   while((b = fis.read()) != -1){
		   System.out.println((char)b);
	   }
	   //4,�ر���Ӧ����
	   fis.close();
   }
}
