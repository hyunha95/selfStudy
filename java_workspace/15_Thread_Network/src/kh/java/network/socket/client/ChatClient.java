package kh.java.network.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static final String SERVER_IP = "localhost"; // 127.0.0.1
	public static final int SERVER_PORT = 7777;
	
	public static void main(String[] args) {
		new ChatClient().start();
	}

	private void start() {
		try {
			// 1. client socket 생성 - server연결 요청
			Socket clientSocket = new Socket(SERVER_IP, SERVER_PORT);
			System.out.println("[" + clientSocket.getInetAddress() + "]에서 [" 
							+ SERVER_IP + ":" + SERVER_PORT + "]로 연결시도...");
			// 2. 소켓 입출력스트림 준비
			BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
			
			// 3. 채팅시작
			Scanner sc = new Scanner(System.in);
			String data = null;
			while((data = br.readLine()) != null) {
				System.out.println("서버 : " + data);
				System.out.print("클라이언트 : ");
				String msg = sc.nextLine();
				pw.println(msg);
				pw.flush();
				
				if("exit".equals(msg)) {
					System.out.println("채팅을 종료합니다...");
					
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
