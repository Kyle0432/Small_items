package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * 使用FileReader、FileWriter 可以实现文本文件的复制。
 * 对于非文本文件（视频文件、音频文件、图片），只能使用字节流！
 */
public class TestFileReaderWriter {
	@Test
	public void testFileReaderWriter(){
		//1,输入流对应的文件src一定要存在,否则抛异常,输出流对应的文件dest可以不存在,执行过程中自动创建
		File file1 = new File("d:/数据库脚本.txt");
		File file2 = new File("d:/数据库脚本1.txt");
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(file1);
			fw = new FileWriter(file2);
			char[] c = new char[24];
			int len;
			while((len = fr.read(c)) != -1){
			      fw.write(c,0,len);
			      fw.flush();
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
    @Test
    public void testFileReader(){
    	FileReader fr = null;
    	try {
			File file = new File("d:/Java Files");
			fr = new FileReader(file);
			char[] c = new char[24];//读取到的数据要写入的数组,该方法指定了要用char数组
			int len;
			while((len = fr.read(c)) != -1){
				String str = new String(c,0,len);
				System.out.println(str);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
}
