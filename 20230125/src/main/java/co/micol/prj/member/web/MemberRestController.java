package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.micol.prj.member.service.MemberService;

@RestController
public class MemberRestController {
	@Autowired
	MemberService memberservice;
	
	@RequestMapping(value ="/AjaxMemberIdCheck.do", produces = "application/json;charset=UTF-8")
	public String ajaxMemberIdCheck(String id) {
		
		String result = "1";
		
		boolean b = memberservice.isIdCheck(id);
		
		if(!b) {
			result = "0";
		}
		
		return result;
	}
}
