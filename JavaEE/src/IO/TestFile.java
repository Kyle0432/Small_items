package IO;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 * java.io.File��
 * 1.���������롢�����ص��ࡢ�ӿڵȶ�������java.io����
 * 2.File��һ���࣬�����й�������������󡣴˶����Ӧ��һ���ļ���.txt .avi .doc .ppt .mp3 .jpg�����ļ�Ŀ¼
 * 3.File���������ƽ̨�޹صġ�
 * 4.File�еķ��������漰����δ�����ɾ�����������ȵȡ�ֻҪ�漰�ļ����ݵģ�File������Ϊ���ģ�������io������ɡ�
 * 5.File��Ķ�����Ϊio���ľ�����Ĺ��������βΡ�
 */
public class TestFile {
	/*
	 *  createNewFile()
		delete()
		mkDir():����һ���ļ�Ŀ¼��ֻ�����ϲ��ļ�Ŀ¼���ڵ�����£����ܷ���true
		mkDirs():����һ���ļ�Ŀ¼�����ϲ��ļ�Ŀ¼�����ڣ�һ������
		list()
		listFiles()
	 */
	@Test
	public void test3() throws IOException{
		File file1 = new File("d:/io/helloworld.txt");
		System.out.println(file1.delete());//ɾ�����ļ�
		if(!file1.exists()){
			boolean b = file1.createNewFile();
			System.out.println(b);//������ļ������ھʹ����µ��ļ�
		}
		File file2 = new File("d:/io1/io2");
		if(!file2.exists()){
			boolean b = file2.mkdirs();
			System.out.println(b);
		}
		File file3 = new File("d:/java Files");
		String[] strs = file3.list();//�ļ�����ļ���һһ�оٳ���
		for(int i= 0; i < strs.length;i++){
			System.out.println(strs[i]);
		}
		System.out.println();
		File[] files = file3.listFiles();
		for(int i = 0; i< files.length;i++){
			System.out.println(files[i].getName());//һһ��ȡ�ļ���
		}
	}
	/*
	 *  exists()
		canWrite()
		canRead()
		isFile()
		isDirectory()
		lastModified()
		length()

	 */
	@Test
	public void test2(){
		File file1 = new File("d:/io/helloworld.txt");
		File file2 = new File("d:/io/io1");
		
		System.out.println(file1.exists());//���ļ��Ƿ����
		System.out.println(file1.canWrite());//�ܷ�д
		System.out.println(file1.canRead());//�ܷ��ȡ
		System.out.println(file1.isFile());//�Ƿ�Ϊ�ļ�
		System.out.println(file1.isDirectory());//�Ƿ�ΪĿ¼
		System.out.println(new Date(file1.lastModified()));//���һ���޸ĵ�ʱ��
		System.out.println(file1.length());//�ļ��ֽڳ���
		
		System.out.println();
		
		System.out.println(file2.exists());//���ļ��Ƿ����
		System.out.println(file2.canWrite());//�ܷ�д
		System.out.println(file2.canRead());//�ܷ��ȡ
		System.out.println(file2.isFile());//�Ƿ�Ϊ�ļ�
		System.out.println(file2.isDirectory());//�Ƿ�ΪĿ¼
		System.out.println(new Date(file2.lastModified()));//���һ���޸ĵ�ʱ��
		System.out.println(file2.length());//�ļ��ֽڳ���
		
		
	}
	/*
	 * ·����
	 * ����·���������̷����ڵ��������ļ�·��
	 * ���·�����ڵ�ǰ�ļ�Ŀ¼�µ��ļ���·��
	 * 
	 *  getName()
		getPath()
		getAbsoluteFile()
		getAbsolutePath()
		getParent()
		renameTo(File newName)

	 */
	@Test
	public void test1(){
		File file1 = new File("d:/io/helloworld.txt");
		File file2 = new File("hello.txt");
		
		File file3 = new File("d:/io/io1");
		File file4 = new File("d:/io2");
		
		System.out.println(file1.getName());//��ȡ�ļ���
		System.out.println(file1.getPath());//��ȡ�ļ�·��
		System.out.println(file1.getParent());//��ȡ�ļ���һ��Ŀ¼
		System.out.println(file1.getAbsolutePath());//��ȡ�ļ��ľ���·��
		System.out.println(file1.getAbsoluteFile());//��ȡ�ļ��ľ����ļ�
		
		System.out.println();
		
		System.out.println(file3.getName());//��ȡ�ļ���
		System.out.println(file3.getPath());//��ȡ�ļ�·��
		System.out.println(file3.getParent());//��ȡ�ļ���һ��Ŀ¼
		System.out.println(file3.getAbsolutePath());//��ȡ�ļ��ľ���·��
		System.out.println(file3.getAbsoluteFile());//��ȡ�ļ��ľ����ļ�
		
		//renameTo(File newName):������
		//file1.renameTo(file2): file1������Ϊfile2.Ҫ��:file1�ļ�һ������,file2һ��������
		
		//�ļ�����������
		boolean b = file1.renameTo(file2);
		System.out.println(b);
		
		//Ŀ¼��������
		boolean b1 = file3.renameTo(file4);
		System.out.println(b1);
	}
}
