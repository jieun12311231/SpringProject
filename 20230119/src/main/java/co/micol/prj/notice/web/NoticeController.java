package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController { // notice에 관련된것들은 다 여기에 적으면 됨
	
	@Autowired // dao를 Autowired화 시킴
	private NoticeService noticeService; // dao 자동 주입 // 기존의 방법 : NoticeService noticeService = new NoticeServiceImpl();
	//관례적으로 같은 이름을 사용함

	
	
	//▼▼컨트롤러가 가지고 있는 메소드▼▼

	@RequestMapping("/noticeList.do") // 하나의 중괄호에서만 적용이 됨 //사용 유무에는 상관없이 무조건 model은 넣어줘야한다고 생각하면됨!
	public String noticeList(Model model) { // Model : 폼에 전달할 값을 담는 객체 (매개변수로만 적으면 됨)-> return value의 폼으로 전달
		
		//model에 담을때는 addAttribute을 사용해서 담아줌  
		model.addAttribute("list", noticeService.noticeSelectList()); // db가서 데이터를 담아 와라 나중에 읽을때는 list로 읽으면 됨
		// 변수명, 실행할값 -> 결과를 list에 담음 noticeDao.noticeSelectList()의 리턴타입(List<NoticeVO>)으로 list에 담김
		// 결과를 돌려주기 위해서model에 담음

		model.addAttribute("message", "이것은 리스트 테스트입니다"); // addAttribute에 변수명(jsp에서 사용할 변수) , 담을 데이터를 넣어주면됨
		return "notice/noticeList";
	}// 중괄호 안은 실행할 command

	@RequestMapping("/noticeSelect.do")
	public String noticeSelect(Model model,NoticeVO vo) {  //상세조회할때 내가 보내는 변수이름이 vo객체명과 일치하면 자동으로찾아줌 
		//기존의 방법
//		NoticeVO vo = new NoticeVO();
//		vo=noticeService.noticeSelect(vo);
//		vo.setNoticeId(87);  //id가 87번인 사람의 상세정보
//		model.addAttribute("vo", vo);
		
		model.addAttribute("vo",noticeService.noticeSelect(vo));
		
		// 여기에 수행할 명령을 기술
		return "notice/noticeSelect";
	}
}
