package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

/*
 * 标准的输入输出流：
 * 标准的输出流：System.out
 * 标准的输入流：System.in
 * 
 * 题目：
 * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
 * 直至当输入“e”或者“exit”时，退出程序。
 */
public class TestOtherStream {
	/*
	 * 如何实现字节流与字符流之间的转换：
	 * 转换流：InputStreamReader  OutputStreamWriter
	 * 编码：字符串  --->字节数组
	 * 解码：字节数组--->字符串
	 */
    @Test
    public void test1(){
    	BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			FileInputStream fis = new FileInputStream(new File("hello1.txt"));
			FileOutputStream fos = new FileOutputStream(new File("hello2.txt"));
			//解码
			InputStreamReader isr = new InputStreamReader(fis,"GBK");
			//编码
			OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");    	
			br = new BufferedReader(isr);
			bw = new BufferedWriter(osw);
			String str;
			while((str = br.readLine()) != null){
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(br != null){
		    	try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
		}
    }
}
