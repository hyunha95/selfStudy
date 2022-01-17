package kh.java.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class NetworkStudy {

	public static void main(String[] args) {
		NetworkStudy study = new NetworkStudy();
		study.test1();
//		study.test2();
//		study.test3();

	}

	/**
	 * 인터넷의 resource download
	 */
	private void test3() {
		try {
			URL url = new URL("https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new FileWriter("Integer.html"));
			
			String data = null;
			while((data = br.readLine()) != null) {
				System.out.println(data);
				bw.write(data + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * java.net.URL
	 * - url의 여러 구성요소를 관리하는 객체
	 */
	private void test2() {
		try {
			URL url = new URL("https://www.google.com:443/search?q=java+logo&sxsrf=ALeKk02TmAxP_dZNyqxJyf3yOptbS40R9g:1629277416398&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiT05Otm7ryAhWFGaYKHTmSB2AQ_AUoAXoECAEQAw&biw=974&bih=789#imgrc=n2nvh1yZ-PjVjM");
			System.out.println(url.getProtocol()); // https 웹통신규약
			System.out.println(url.getHost()); // www.google.com
			System.out.println(url.getPort()); // 443
			System.out.println(url.getPath()); // /search
			System.out.println(url.getQuery()); // q=java+logo&sxsrf=ALeKk02TmAxP_dZNyqxJyf3yOptbS40R9g:1629277416398&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiT05Otm7ryAhWFGaYKHTmSB2AQ_AUoAXoECAEQAw&biw=974&bih=789
			System.out.println(url.getRef()); // imgrc=n2nvh1yZ-PjVjM 앵커조회
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * java.net.InetAddress
	 * - domain(hostname)과 ip주소에 대한 정보를 가지고 있다.
	 * - 모두 static메소드이므로, new연산자를 통한 객체생성은 할 수 없다.
	 */
	private void test1() {
		try {
			//외부 컴퓨터에 대한 ip조회
			InetAddress naver = InetAddress.getByName("naver.com");
			System.out.println(naver.getHostAddress());
			
			InetAddress[] navers = InetAddress.getAllByName("naver.com");
			for(InetAddress ip : navers) {
				System.out.println(ip);
			}
			
			// 내컴퓨터에 대한 ip조회
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost.getHostAddress());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
