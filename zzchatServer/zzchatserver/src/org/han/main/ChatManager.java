package org.han.main;

import java.util.List;
import java.util.ArrayList;

// ����һ�������̵߳��࣬��ֹ�������˵��߳�̫�࣬���˹����̵߳��࣬�Ϳ������ɵĶ���Ϣ���п����ת������Ϣ
public class ChatManager {
	
	public ChatManager() {
		
	}
	private static final ChatManager chatManager=new ChatManager();
	List<SocketMsg> socketList=new ArrayList<>();
	
	public static ChatManager getChatManager(){
		return chatManager;
	}
	public void add(SocketMsg cs) {
		socketList.add(cs);
	}
	public void remove(SocketMsg cs) {
		socketList.remove(cs);
	}
}
