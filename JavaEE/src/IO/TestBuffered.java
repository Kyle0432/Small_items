package IO;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

/*
 * �������			�ڵ������ļ�����                                ����������������һ��,���������ļ�������Ч�ʣ�
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStream		FileOutputStream		BufferedOutputStream  (flush())
 * Reader			FileReader				BufferedReader  (readLine())
 * Writer			FileWriter				BufferedWriter  (flush())
 */
public class TestBuffered {
	//�ı��ĸ��Ʒ���
	@Test
	public void testBufferedReader(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File file = new File("dbcp.txt");
			File file1 = new File("dbcp3.txt");
			FileReader fr = new FileReader(file);
			
			FileWriter fw = new FileWriter(file1);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
//			char[] c = new char[1024];
//			int len;
//			while((len = br.read(c))!= -1){
//				String str = new String(c, 0, len);
//				System.out.print(str);
//			}
			
			String str;
			while((str = br.readLine()) != null){
//				System.out.println(str);
				bw.write(str + "\n");
//				bw.newLine();
				bw.flush();
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}
	@Test
	public void testCopyFile(){
		long start = System.currentTimeMillis();
		String src = "C:/Users/Think/Desktop/kyle.jpg";
		String dest = "C:/Users/Think/Desktop/kyle5.jpg";
		CopyFile(src,dest);
		long end = System.currentTimeMillis();
		System.out.println("����ʱ��Ϊ:"+(end-start));
	}
	//ʹ�û�����ʵ���ļ��ĸ��Ʒ���
	public void CopyFile(String src,String dest){
		File file1 = new File(src);
		File file2 = new File(dest);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			 bis = new BufferedInputStream(fis);
			 bos = new BufferedOutputStream(fos);
			byte[] b = new byte[1024];
			int len;
			while((len = bis.read(b)) != -1){
				bos.write(b, 0, len);
				bos.flush();//ˢ��
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
//ʹ��BufferedInputStream��BufferedOutputStreamʵ�ַ��ı��ļ��ĸ���
   @Test
   public void testBufferedInputOutputStream(){
	   //1,�ṩ����,д�����ļ�
	   File file1 = new File("C:/Users/Think/Desktop/kyle.jpg");
	   File file2 = new File("C:/Users/Think/Desktop/kyle5.jpg");
	   //2,������Ӧ�Ľڵ�����FileInputStream FileOutputStream
	   BufferedInputStream bis = null;
	   BufferedOutputStream bos = null;
	   try {
		FileInputStream fis = new FileInputStream(file1);
		FileOutputStream fos = new FileOutputStream(file2);
	   //3,�������Ľڵ��� �Ķ�����Ϊ�βδ��ݸ��������Ĺ�������
		   bis = new BufferedInputStream(fis);
		   bos = new BufferedOutputStream(fos);
	   //4,�����ʵ���ļ����ƵĲ���
		   byte[] b = new byte[1024];
		   int len;
		   while((len = bis.read(b)) != -1){
			   bos.write(b, 0, len);
			   bos.flush();//�������һ��Ҫ��flushˢ�� 
		   }
	}catch (IOException e) {
		e.printStackTrace();
	}finally{
		if(bos != null){
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(bis != null){
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
	  }	   
   }
}
