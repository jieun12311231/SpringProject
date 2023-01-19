package co.micol.prj.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired // 어떤 것을 dao를 사용할것인지
	private MemberService memberService;

	@RequestMapping("/memberListSelect.do")
	public String memberListSelect(Model model) {

		model.addAttribute("list", memberService.memberListSelect());

		return ("member/memberListSelect");
	}

	@PostMapping("/memberLogin.do") // post방식만 처리를 하겠다
	public String memberLogin(MemberVO vo, Model model, HttpSession session) {// Model model : 이전에 request라고 생각하면됨
		vo = memberService.memberSelect(vo);
		if (vo != null) { // vo객체에 값이 존재한다면
			// ▼▼▼세션에 담을 값
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("author", vo.getMemberAuthor());
			session.setAttribute("name", vo.getMemberName());

//			model.addAttribute("vo", vo);  //로그인 성공 유무만 알리면 되기떄문에 굳이 vo에 값 담을 필요없음 
			model.addAttribute("message", vo.getMemberName() + "님 환영합니다");
		} else {
			model.addAttribute("message", "아이디 또는 비밀번호가 틀립니다");
		}

		return "member/memberMessage"; // 로그인 성공했을때 보여주고자 하는 페이지
	}

	@RequestMapping("/memberLoginForm.do") // 단순 호출은 get이나 requestMapping이 나음
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}

	@RequestMapping("/memberLogout.do")
	public String memberLogout(HttpSession session, Model model) {
		model.addAttribute("message", session.getAttribute("name")+"님 정상적으로 로그아웃되었습니다.");
		session.invalidate();

		return "member/memberMessage";
	}
}
