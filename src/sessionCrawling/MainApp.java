package sessionCrawling;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainApp {
	private static final String LOGIN_URL = "https://everytime.kr/user/login";
	private static final String URL = "https://everytime.kr/";
	private static String ID = "아이디를 입력해주세연";
	private static String PW = "비번을 입력해주세연";
	
	public static void main(String[] args) throws IOException {
		// 1. login
		Response loginResponse = (Response) Jsoup.connect(LOGIN_URL)
				.data("userid", ID)
				.data("password", PW)
				.data("autologin", "1")
				.method(Method.POST)
				.execute();
		
		System.out.println(" - PAGE STATUS CODE : " + loginResponse.statusCode());
		Document doc = loginResponse.parse();
		System.out.println("" + doc.toString());
		
		// 2. Session 정보 담기
		
		// 3. 게시판에 접근
		
		// 4. AJAX 활용해서 JSON 조회
		
		// 5. JSON 데이터를 통해 자유게시판 제목 출력
	}
}
