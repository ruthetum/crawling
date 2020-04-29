package sessionCrawling;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainApp {
	private static final String LOGIN_URL = "https://everytime.kr/login";
	private static final String URL = "https://everytime.kr/";
	private static String ID = "아이디 입력하기";
	private static String PW = "비밀번호 입력하기";
	
	public static void main(String[] args) throws IOException {
		Connection.Response loginForm = Jsoup.connect(LOGIN_URL)
				.method(Connection.Method.GET)
				.execute();
		
		Connection.Response mainPage = Jsoup.connect(LOGIN_URL)
				.data("userid", ID)
				.data("password", PW)
				.data("redirect", "/")
				.cookies(loginForm.cookies())
				.followRedirects(true)
				.method(Connection.Method.POST)
				.execute();
		
		Map<String, String> cookies = mainPage.cookies();
		
//		Document doc = Jsoup.connect(URL).cookies(cookies).get();
		Document doc = Jsoup.connect(URL).cookies(cookies).execute().parse();
		
		System.out.println(doc);
		
		
		
		// 1. login
//		Response loginResponse = (Response) Jsoup.connect(LOGIN_URL)
//				.data("userid", ID)
//				.data("password", PW)
//				.data("autologin", "1")
//				.method(Method.POST)
//				.execute();
//		
//		System.out.println(" - PAGE STATUS CODE : " + loginResponse.statusCode());
//		Document doc = loginResponse.parse();
//		System.out.println("" + doc.toString());
		
		// 2. Session 정보 담기
		
		// 3. 게시판에 접근
		
		// 4. AJAX 활용해서 JSON 조회
		
		// 5. JSON 데이터를 통해 자유게시판 제목 출력
	}
}
