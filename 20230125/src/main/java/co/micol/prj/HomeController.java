package co.micol.prj;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home( Model model) {
		return "home";
	}
	
	@RequestMapping("/home.do")  //메소드의 오버라이딩 : 전달인자 개수, 리턴벨유에 따라서 같은 메소드지만 다른 역할을 하게하는것 
	public String home() {
		return "home";
	}
	
}
