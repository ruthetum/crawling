package sessionCrawling;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {
	private static final String LOGIN_URL = "https://everytime.kr/user/login";
	private static final String API_URL = "https://api.everytime.kr";
	private static String ID = "아이디";
	private static String PW = "비밀번호";
	private static Map<String, String> cookies;
	
	public static void main(String[] args) throws IOException {
		// 1. login
		Response loginResponse = (Response) Jsoup.connect(LOGIN_URL)
				.data("userid", ID)
				.data("password", PW)
				.data("redirect", "/")
				.method(Method.POST)
				.execute();
		
//		System.out.println(" - PAGE STATUS CODE : " + loginResponse.statusCode());
//		Document doc = loginResponse.parse();
//		System.out.println("" + doc.toString());
		
		// 2. Session 정보 담기
		cookies = loginResponse.cookies();
		
		// 3. 게시판에 접근
		Document doc = Jsoup.connect(API_URL+"/find/board/article/list")
				.cookies(cookies)
				.data("id", "370444")
				.data("limit_num", "20")
				.data("start_num", "20")
				.data("moiminfo", "True")
				.get();
		
		// 확인
//		System.out.println("" + doc.toString());
		
		// 4. AJAX 활용해서 JSON 조회
		// 5. JSON 데이터를 통해 자유게시판 제목 출력
		Elements elements = doc.select("article");
		
		int idx = 0;
		for (Element element : elements) {
			System.out.println(++idx + " : " + element.attr("title"));
		}
		
	}
}
