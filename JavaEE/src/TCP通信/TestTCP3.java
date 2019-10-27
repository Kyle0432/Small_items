package TCPͨ��;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/*
 * TCP����������ӿͻ��˷����ļ�������ˣ�����˱��浽���ء�
 * �����ء����ͳɹ������ͻ��ˡ����ر���Ӧ�����ӡ�
 */
public class TestTCP3 {
    @Test
    public void Client(){
    	//1,����Socket�Ķ���
		Socket socket = null;
		//2,�ӱ��ػ�ȡһ���ļ����͸������
		OutputStream os = null;
		FileInputStream fis = null;
		//3,���������ڷ���˵���Ϣ
		InputStream is = null;
		try {
			socket = new Socket(InetAddress.getByName("192.168.0.104"),7878);
			os = socket.getOutputStream();
			fis = new FileInputStream(new File("kyle.jpg"));
			byte[] b = new byte[1024];
			int len;
			while((len = fis.read(b)) != -1){
				os.write(b, 0, len);
			}
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte[] b1 = new byte[1024];
			int len1;
			while((len1 = is.read(b1)) != -1){
				String str = new String(b1,0,len1);
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
	     //4,�ر���Ӧ������Socket����   
			if(is != null){
		        try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
    @Test
    public void Server(){
    	//1,����һ��ServerSocket�Ķ���
		ServerSocket ss = null;
		//2,����accept()���� ,����һ��Socket�Ķ���
		Socket s = null;
		//3,���ӿͻ��˷�������Ϣ���浽����
		InputStream is = null;
		FileOutputStream fos = null;
		//4,����"���ճɹ�"����Ϣ�������ͻ���
		OutputStream os = null;
		try {
			ss = new ServerSocket(7878);
			s = ss.accept();
			is = s.getInputStream();
			fos = new FileOutputStream(new File("kyle1.jpg"));
			byte[] b = new byte[1024];
			int len;
			while((len = is.read(b)) != -1){
				fos.write(b, 0, len);
			}
			System.out.println("�յ�������"+s.getInetAddress().getHostAddress()+"���ļ�");
			os = s.getOutputStream();
			os.write("�㷢�͵�ͼƬ���Ѿ��ɹ�����".getBytes());
		}  catch (IOException e) {
			e.printStackTrace();
		}finally{
	    	//5.�ر���Ӧ������Socket��ServerSocket�Ķ���
			if(os != null){
				try {
					os.close();
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
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(ss != null){
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
		}
    }
}
