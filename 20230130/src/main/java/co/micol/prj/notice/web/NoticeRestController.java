package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@RestController // @RestController => @Controller + @ResponseBody
// 외부 api사용할때 많이 사용함 (get방식으로 많이 사용)
//-> @ResponseBody가 포함 된것이기때문에 안적어줘도됨

//★ Ajax호출 전용 => RestController
public class NoticeRestController {
	@Autowired
	NoticeService noticeService;

	// ▶@RequestParam을 사용하는 방법
	// 호출한 페이지에서 돌려주고싶을때 사용하는것 (호출한 페이지로 리턴)=> ajax많이 사용
	// 최근에 많이 사용하는 추세
	@RequestMapping(value = "/AjaxSearchList.do", produces = "application/json;charset=UTF-8")
	public String ajaxSearchList( // 여기 써도 됨
			@RequestParam("key") String key, // vo객체에 담겨지지 않고 넘어오는 파라미터
			@RequestParam("val") String val, Model model) {
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

	// ▶ @RequsetBody를 사용하는 방법 - 넘어오는 곳의 request객체를 Map<String, String>형태로 그대로 받겠다.
	//넘어오면서 한글이 깨지지 않도록하기위해서 produces를 넣어줘야함!
//	@PostMapping(value = "/AjaxSearchListJson.do", produces = "application/json;charset=UTF-8")
//	public String ajaxSearchListJson(@RequestBody Map<String, String> body) { // key:value형태로 들어오기때문에 Map구조로 넣어줘야함
//		String key = body.get("key");
//		String val = body.get("val");
//		String str = null;
//		ObjectMapper json = new ObjectMapper();
//		try {
//			str = json.writeValueAsString(noticeService.noticeSearch(key, val));
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		return str;
//	}
	
	// ▶▶ @RequsetBody를 사용하는 방법  - NoticeSearchVO를 만들어서 vo 객체를 이용하는 방법 -> 더 많이 사용함!!
	@PostMapping(value = "/AjaxSearchListJson.do", produces = "application/json;charset=UTF-8")
//	public String ajaxSearchListJson(@RequestBody NoticeSearchVO vo) { //vo객체를 이용하는 방법
		public String ajaxSearchListJson(@RequestBody NoticeVO vo) { //NoticeVO에도 key,val추가 -> 권장하는방법
		String key = vo.getKey(); //vo는 이름이 일치하는것만 가지고옴!  
		String val = vo.getVal();
		String str = null;
		ObjectMapper json = new ObjectMapper();
		try {
			str = json.writeValueAsString(noticeService.noticeSearch(key, val));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return str;
	}
}
