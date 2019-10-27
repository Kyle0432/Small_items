package TCP通信;

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
 * TCP编程例三：从客户端发送文件给服务端，服务端保存到本地。
 * 并返回“发送成功”给客户端。并关闭相应的连接。
 */
public class TestTCP3 {
    @Test
    public void Client(){
    	//1,创建Socket的对象
		Socket socket = null;
		//2,从本地获取一个文件发送给服务端
		OutputStream os = null;
		FileInputStream fis = null;
		//3,接收来自于服务端的信息
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
	     //4,关闭相应的流和Socket对象   
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
    	//1,创建一个ServerSocket的对象
		ServerSocket ss = null;
		//2,调用accept()方法 ,返回一个Socket的对象
		Socket s = null;
		//3,将从客户端发来的信息保存到本地
		InputStream is = null;
		FileOutputStream fos = null;
		//4,发送"接收成功"的信息反馈给客户端
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
			System.out.println("收到来自于"+s.getInetAddress().getHostAddress()+"的文件");
			os = s.getOutputStream();
			os.write("你发送的图片我已经成功接收".getBytes());
		}  catch (IOException e) {
			e.printStackTrace();
		}finally{
	    	//5.关闭相应的流和Socket及ServerSocket的对象
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
