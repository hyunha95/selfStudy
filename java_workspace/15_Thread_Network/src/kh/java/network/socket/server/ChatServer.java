package kh.java.network.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket Programming
 * - process간의 통신을 지원함.
 * - ServerSocket객체를 먼저 생성해서 client의 연결을 기다리고,
 * - client접속요청이 있을 경우 새로운 socket을 생성(accept)해서 통신을 시작한다.
 */
public class ChatServer {
	
	public static final int PORT = 7777;

	public static void main(String[] args) {
		new ChatServer().start();

	}

	private void start() {
		try {
			//1. server socket생성
			ServerSocket serverSocket = new ServerSocket(PORT);
			
			while(true) {
				System.out.println(InetAddress.getLocalHost() + " ChatServer 대기중...");
				
				//2. 클라이언트 연결요청이 있을시 새 소켓을 생성해 통신을 시작
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "]로부터 연결 요청...");
				
				//3. 입출력스트림 준비
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				
				// welcome msg전송
				pw.println("환영합니다!!!");
				pw.flush(); // 버퍼에 내용을 즉시 출력
				
				//4. chat시작
				Scanner sc = new Scanner(System.in);
				String data = null;
				while((data = br.readLine()) != null) {
					if("exit".equals(data)) {
						System.out.println("클라이언트가 채팅을 종료했습니다.");
						break;
					}
					System.out.println("클라이언트 : " + data);
					System.out.print("서버 : ");
					pw.println(sc.nextLine());
					pw.flush();
				}	
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
