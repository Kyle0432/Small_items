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
	    	System.out.println("运行时间为:"+(end - start));
	    }
	//实现文件复制的方法
	 public void copyFile(String src,String dest){
		 //1,提供读入,写出的文件
		 File file1 = new File(src);
		 File file2 = new File(dest);
		 //2,提供相应的流
		 FileInputStream fis = null;
		 FileOutputStream fos = null;
		 try{
			 fis = new FileInputStream(file1);
			 fos = new FileOutputStream(file2);
		 //3,实现文件的复制
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
	//从硬盘读取一个文件，并写入到另一个位置。（相当于文件的复制）
	@Test
	public void testFileInputOutputStream(){
		//1,提供读入,写出的文件
		File file1 = new File("C:/Users/Think/Desktop/kyle.jpg");
		File file2 = new File("C:/Users/Think/Desktop/kyle2.jpg");
		//2,提供相应的流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			 fis = new FileInputStream(file1);
			 fos = new FileOutputStream(file2);
			//3,实现文件的复制
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
		//2,创建一个FileOutputStream的对象,将file的对象作为形参传递给FileOutputStream的构造器里
		FileOutputStream fos = null;
		try {
			//1,创建一个File对象,表明要写入的文件位置
			//输出的物理文件可以不存在,当执行过程中,若不存在,会自动的创建,若存在,会将原有的文件覆盖
			File file = new File("hello3.txt");
			fos = new FileOutputStream(file);
			//3,写入的操作
			fos.write(new String("I Love You !").getBytes());//将字符串转化字节数组
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos != null){
				//4,关闭输出流
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
			byte[] b = new byte[5];//读取到的数据要写入的数组
			int len;
			//表示第一次读5个,第二次读4个,所以len第一次为5第二次为3
			//然后第一次循环5次,读出5个字节来,第二次循环4次读出4个字节来
			while((len = fis.read(b)) != -1){
				// 方式1,for (int i = 0; i < len; i++) {
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
	// 使用try-catch的方式处理如下的异常更合理:保证流的关闭操作一定可以执行
	@Test
	public void testFileInputStream2(){
		// 2.创建一个FileInputStream类的对象
		FileInputStream fis = null;
		try {
			// 1.创建一个File类的对象。
			File file1 = new File("hello1.txt");
			fis = new FileInputStream(file1);
			// 3.调用FileInputStream的方法，实现file文件的读取。
			int b;
			while((b = fis.read())!= -1){
				System.out.print((char)b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{//因为不管try-catch不管出不出现异常 close一定要执行的
			if(fis != null){//以防空指针异常
				try {
					// 4.关闭相应的流
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}			
	}
// 从硬盘存在的一个文件中，读取其内容到程序中。使用FileInputStream
// 要读取的文件一定要存在。否则抛FileNotFoundException
   @Test
   public void testFileInputStream1() throws Exception{
	   //1,创建一个File类的对象
	   File file = new File("hello1.txt");
	   //2,创建一个FileInputStream类的对象
	   FileInputStream fis = new FileInputStream(file);
	   //3,调用FileInputStream的方法,实现file文件的读取。
	   /*
	    * read();读取文件的一个字节.当执行到文件结尾时,返回-1
	    */
	   int b;
	   while((b = fis.read()) != -1){
		   System.out.println((char)b);
	   }
	   //4,关闭相应的流
	   fis.close();
   }
}
