package co.micol.prj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //-> IOC컨테이너에 올려라 ->
public class HomeController {
	
	@RequestMapping("/")  // '// 로 요청이 들어오면  home으로 이동시켜라 
	
	public String home() {
		return "home";  //-> DispatcherServle는 controller에서 받은 것을 ViewResolver에 넘겨서 /WEB-INF/views/home.jsp 로 만들어서 넘겨줌 
	}
	
}
