package iCampusCrawling;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainApp {
	private static final String LOGIN_URL = "https://icampus.skku.edu/xn-sso/customs/pages/logon-url.php";
	private static String ID = "r";
	private static String PW = "d";
	
	public static void main(String[] args) throws IOException{
		Response loginResponse = (Response) Jsoup.connect(LOGIN_URL)
				.data("userid", ID)
				.data("password", PW)
				.data("login_form_token","이 값 html parser로 찾기")
				.method(Method.POST)
				.execute();

		String sessionId = loginResponse.cookie("PHPSESSID");
		Document doc = loginResponse.parse();
		System.out.println("" + doc.toString());	
				
		// 일단 아이캠퍼스 robots.txt disallow 되어있음. 중단.
	}

}
