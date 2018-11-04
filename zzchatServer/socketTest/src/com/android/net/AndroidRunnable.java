package com.android.net;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
 
public class AndroidRunnable implements Runnable {
 
	Socket socket = null;
 
	public AndroidRunnable(Socket socket) {
		this.socket = socket;
	}
 
	@Override
	public void run() {
		// ��android�ͻ������hello worild
		String line = null;
		InputStream input;
		OutputStream output;
		String str = "hello world!";
		System.out.println("hello");
		try {
			//��ͻ��˷�����Ϣ
			output = socket.getOutputStream();
			input = socket.getInputStream();
			BufferedReader bff = new BufferedReader(
					new InputStreamReader(input));
			output.write(str.getBytes("gbk"));
			output.flush();
			//��ر�socket  
			socket.shutdownOutput();
			//��ȡ�ͻ��˵���Ϣ
			while ((line = bff.readLine()) != null) {
				System.out.print(line);
			}
			//�ر����������
			output.close();
			bff.close();
			input.close();
			socket.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
}
