package jobkorea;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {
	
	private static String URL = "http://www.jobkorea.co.kr/Search/?";
	
	public static void main(String[] args) throws IOException {
		String KEY_WORD = "jquery";
		
		// 1. Document를 가져온다
		Document doc = Jsoup.connect(URL + getParameter(KEY_WORD, 3)).get();
		
		// 2. 목록을 가져온다
		//System.out.println(""+doc.toString());
		Elements elements = doc.select(".list-default .clear li div .post-list-corp a");
		
		// 3. 목록(배열)에서 정보를 가져온다 .
		int idx = 0;
		for (Element element : elements) {
			System.out.println("(" + ++idx + ")");
			System.out.println("" + element.text());
			System.out.println("==================================");
		}
	}
	
	
	/**
	 * URL 완성
	 * @param KEY_WORD
	 * @param PAGE
	 * @return 
	 */
	public static String getParameter(String KEY_WORD, int PAGE) {
		return "stext=" + KEY_WORD +"&Page_No="+PAGE;
	}
}
