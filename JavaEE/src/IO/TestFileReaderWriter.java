package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * ʹ��FileReader��FileWriter ����ʵ���ı��ļ��ĸ��ơ�
 * ���ڷ��ı��ļ�����Ƶ�ļ�����Ƶ�ļ���ͼƬ����ֻ��ʹ���ֽ�����
 */
public class TestFileReaderWriter {
	@Test
	public void testFileReaderWriter(){
		//1,��������Ӧ���ļ�srcһ��Ҫ����,�������쳣,�������Ӧ���ļ�dest���Բ�����,ִ�й������Զ�����
		File file1 = new File("d:/���ݿ�ű�.txt");
		File file2 = new File("d:/���ݿ�ű�1.txt");
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
			char[] c = new char[24];//��ȡ��������Ҫд�������,�÷���ָ����Ҫ��char����
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
