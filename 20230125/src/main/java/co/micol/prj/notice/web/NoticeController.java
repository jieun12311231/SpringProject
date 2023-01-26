package co.micol.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired // -> setter에 의한 주입방법
	NoticeService noticeService;

	@Autowired
	ServletContext servletContext; // 실 경로를 가져오기 위해 사용함 (자동으로 들어옴)

	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		// Model객체에 db결과 실어서 보냄 --> 메소드에 의한 의존 주입
		model.addAttribute("notices", noticeService.noticeList());
		System.out.println("noticeList =>" + model);
		return "notice/noticeList";
	}

	@PostMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.noticeSelect(vo));
		return "notice/noticeSelect";
	}

	@RequestMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeInsertForm";
	}
	
	
//	@PostMapping(value = "/noticeInsert.do")
//	   public String noticeInsert(NoticeVO vo, MultipartFile file) {
//
//	      // 파일 저장 위치 설정
//	      String saveFolder = servletContext.getRealPath("/resources/upload/");
//
//	      // 실제로 파일 저장하는 것
//	      // ↓ file이 비어있으면 true 반환
//	      if (!file.isEmpty()) {
//	         String fileName = UUID.randomUUID().toString(); // 파일 이름 중복되지 않게 하기 위해서 설정(동일한 파일을 올려도 중복되지 않게끔 설정)
//	         fileName += "_" + file.getOriginalFilename();
//	         // 업로드파일 설정
//	         File uploadFile = new File(saveFolder, fileName);
//	         try {
//	            System.out.println("파일을 업로드합니다.");
//	            file.transferTo(uploadFile);
//	            vo.setNoticeFile(fileName); // 원본 파일명
//	            vo.setNoticeFileDir(saveFolder + fileName); // 물리적 파일 저장 위치
//	         } catch (IllegalStateException | IOException e) {
//	            e.printStackTrace();
//	         }
//	      }
//	      noticeService.noticeInsert(vo);
//
//	      // db 저장 루틴
//	      // redirect : view로 가지 않고 바로 .do로 가게 하는 것
//	      return "redirect:noticeList.do";
//	   }
//	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) { // form에 있는 file이 여기 담겼다고 생각하면 됨
//		System.out.println("noticeInsert => " + vo);
		String saveFolder = servletContext.getRealPath("/resources/upload/"); // 파일 저장 위치
		if (!file.isEmpty()) { // 비어 있으면 true /비어있지않으면 false
			// 첨부 파일이 존재하면 -> 비어있으면 true를 반환하기때문에 !를 달아서 false로 만들어서 진행함
			String fileName = UUID.randomUUID().toString(); // 랜덤으로 파일이름을 지정함
			fileName = fileName + "_" + file.getOriginalFilename(); // 랜덤으로 만들어진 uuid + 원본 파일이름
			File uploadFile = new File(saveFolder, fileName);
			try {
				file.transferTo(uploadFile); // 실제 파일을 저장하기(물리적으로 저장)
				System.out.println("사진저장됨");
				vo.setNoticeFile(file.getOriginalFilename()); // 원본 파일 명
				vo.setNoticeFileDir(saveFolder + fileName); // 디렉토리 포한 원본 파일 명 //원본 파일을 불러올수있음 => 물리적 위치
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(vo);
		} // 파일이 없으면 바로 db에 저장 되도록
		int cnt = noticeService.noticeInsert(vo); // db저장
		System.out.println("=============왔니");
		System.out.println(cnt);
		System.out.println(vo+"=============왔니");

		return "redirect:/noticeList.do";
	}

	@RequestMapping("/noticeEditForm.do")
	public String noticeEditForm(NoticeVO vo, Model model) {
		vo = noticeService.noticeSelect(vo);
		model.addAttribute("notice", vo);
		return "notice/noticeEditForm";
	}

	@RequestMapping("/noticeEdit.do")
	public String noticeEdit(NoticeVO vo, MultipartFile file) {
		String saveFolder = servletContext.getRealPath("/resources/upload/"); // 파일 저장 위치
		if (!file.isEmpty()) { // 비어 있으면 true /비어있지않으면 false
			// 첨부 파일이 존재하면 -> 비어있으면 true를 반환하기때문에 !를 달아서 false로 만들어서 진행함
			String fileName = UUID.randomUUID().toString(); // 랜덤으로 파일이름을 지정함
			fileName = fileName + "_" + file.getOriginalFilename(); // 랜덤으로 만들어진 uuid + 원본 파일이름
			File uploadFile = new File(saveFolder, fileName);
			try {
				file.transferTo(uploadFile); // 실제 파일을 저장하기(물리적으로 저장)
			} catch (Exception e) {
				e.printStackTrace();
			}
			vo.setNoticeFile(file.getOriginalFilename()); // 원본 파일 명
			vo.setNoticeFileDir(saveFolder + fileName); // 디렉토리 포한 원본 파일 명 //원본 파일을 불러올수있음 => 물리적 위치

		} // 파일이 없으면 바로 db에 저장 되도록
		noticeService.noticeUpdate(vo); // db저장

		return "redirect:/noticeList.do";
	}

	@RequestMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo) {
		System.out.println("삭제 호출되었니");
		System.out.println("삭제 보 => " + vo);

		noticeService.noticeDelete(vo);

		return "redirect:/noticeList.do";
	}

	/*
	 * @RestController를 사용하지 않을때
	 * 
	 * @RequestMapping(value
	 * ="/AjaxSearchList.do",produces="application/json;charset=UTF-8")
	 * // @ResponseBody //호출한 페이지에 결과를 돌려줌 /이렇게 단독으로 써도되고 //RestController에서는
	 * 사용하지않음!! public @ResponseBody String ajaxSearchList( //여기 써도 됨 (리턴타입 앞에 적어주기)
	 * 
	 * @RequestParam("key")String key,
	 * 
	 * @RequestParam("val")String val, Model model) { String str = null;
	 * ObjectMapper json = new ObjectMapper(); System.out.println(val); try { str =
	 * json.writeValueAsString(noticeService.noticeSearch(key, val)); } catch
	 * (JsonProcessingException e) { e.printStackTrace(); } System.out.println(str);
	 * 
	 * return str; }
	 */
}
