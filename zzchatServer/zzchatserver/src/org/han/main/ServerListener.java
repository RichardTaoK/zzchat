package org.han.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//实现多线程就要将socket传递给多线程，让多线程去执行具体的操作，实现多线程就要继承thread类，要么实现runnable接口
public class ServerListener extends Thread{
	private ServerSocket serverSocket;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//1.启动serversocket
			serverSocket =new ServerSocket(27777,27);
			while(true) {
				//2.侦听连接
				Socket socket=serverSocket.accept();
				//无scoket接入的话，程序会一直阻塞，一旦有socket接入就会返回一个socket
				//由于一个服务器必然会有多个客户端连接，所以给每个socket连接分配一个线程并且开启线程，紧着勋魂进入阻塞，直到有下一个连接建立，重复上述步骤
				
				System.out.println("服务器启动啦.....");
				System.out.println("socket"+socket);
				ChatSocket chatSocket=new ChatSocket(socket);
				
				chatSocket.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
