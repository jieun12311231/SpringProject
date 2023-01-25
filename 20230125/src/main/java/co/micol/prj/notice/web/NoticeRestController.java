package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.notice.service.NoticeService;

@RestController // @RestController => @Controller + @ResponseBody
// 외부 api사용할때 많이 사용함 (get방식으로 많이 사용)
//-> @ResponseBody가 포함 된것이기때문에 안적어줘도됨

//★ Ajax호출 전용 => RestController
//호출한 페이지에서 돌려주고싶을때 사용하는것 
public class NoticeRestController {
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "/AjaxSearchList.do", produces = "application/json;charset=UTF-8")

	public String ajaxSearchList( // 여기 써도 됨
			@RequestParam("key") String key,   //vo객체에 담겨지지 않고 넘어오는 파라미터 
			@RequestParam("val") String val, 
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
}
