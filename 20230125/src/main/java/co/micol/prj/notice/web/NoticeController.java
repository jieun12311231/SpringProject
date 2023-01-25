package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired  //-> setter에 의한 주입방법
	NoticeService noticeService;
	
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {  
	
		//Model객체에 db결과 실어서 보냄  --> 메소드에 의한 의존 주입 
		model.addAttribute("notices",noticeService.noticeList());  

		return "notice/noticeList";
	}
	
	/*
	@RequestMapping(value ="/AjaxSearchList.do",produces="application/json;charset=UTF-8")
//	@ResponseBody  //호출한 페이지에 결과를 돌려줌 /이렇게 단독으로 써도되고 //RestController에서는 사용하지않음!!
	public @ResponseBody String ajaxSearchList(  //여기 써도 됨 
			@RequestParam("key")String key, 
			@RequestParam("val")String val,
			Model model) {
		String str = null;
		ObjectMapper json = new ObjectMapper();
		System.out.println(val);
		try {
			str = json.writeValueAsString(noticeService.noticeSearch(key, val));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(str);
		
		return str;
}
*/
	}
