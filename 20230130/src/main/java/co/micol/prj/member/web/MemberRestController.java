package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.micol.prj.member.service.MemberService;

@RestController // 호출한 페이지로 결과를 리턴함(API, ajax처리)
//@Controller -> 결과를 내가 원하는 페이지로 보낼수있음
public class MemberRestController {
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/AjaxMemberIdCheck.do", produces = "application/json;charset=UTF-8")
	public String ajaxMemberIdCheck(String id) {
		// Mapper에서 존재하면 0 존재하지 않으면 1로 넘겨줌
		// -> db에 존재하면 false 존재하지 않으면 true

		boolean b = memberService.isIdCheck(id); // 결과값이 1또는 0 -> mybatis에서 1이면 true 0이면 false

//		String result = "true";  //db에 존재하지않음 -> 사용가능(회원가입가능)
//		if(!b) {
//			result = "false";  // db에 존재함 -> 사용 불가능(회원가입x)
//		}

		String str = (b == true) ? "true" : "false";

		System.out.println(str);
		return str;
	}
}
