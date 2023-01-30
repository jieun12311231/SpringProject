package co.micol.prj.notice.web;

import java.io.File;
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
		//
		vo = noticeService.noticeSelect(vo);
		if(vo.getNoticeFile() != null) {
			String fileDir = vo.getNoticeFileDir();
			
			int fileLength = fileDir.length(); 
			int fileCutIndex = fileDir.lastIndexOf('_');
			
			String fileCut = fileDir.substring(fileCutIndex, fileLength);
			
			model.addAttribute("file",fileCut);
			
			System.out.println("사진떠라"+model);
			System.out.println(fileCut);
		}else {
			model.addAttribute("file","첨부파일이 없습니다.");
		}
		
		model.addAttribute("notice", noticeService.noticeSelect(vo));
		return "notice/noticeSelect";
	}

	@RequestMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeInsertForm";
	}

	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) { // form에 있는 file이 여기 담겼다고 생각하면 됨
		String saveFolder = servletContext.getRealPath("/resources/upload/"); // 파일 저장 위치
		if (!file.isEmpty()) { // 비어 있으면 true /비어있지않으면 false
			// 첨부 파일이 존재하면 -> 비어있으면 true를 반환하기때문에 !를 달아서 false로 만들어서 진행함
			String fileName = UUID.randomUUID().toString(); // 랜덤으로 파일이름을 지정함
			fileName ="_"+ fileName + file.getOriginalFilename(); // 랜덤으로 만들어진 uuid + 원본 파일이름
			File uploadFile = new File(saveFolder, fileName);
			try {
				file.transferTo(uploadFile); // 실제 파일을 저장하기(물리적으로 저장)
			} catch (Exception e) {
				e.printStackTrace();
			}
			vo.setNoticeFile(file.getOriginalFilename()); // 원본 파일 명
			vo.setNoticeFileDir(saveFolder + fileName); // 디렉토리 포한 원본 파일 명 //원본 파일을 불러올수있음 => 물리적 위치
			
		} // 파일이 없으면 바로 db에 저장 되도록
		noticeService.noticeInsert(vo);
		return "redirect:/noticeList.do";
	}

	@RequestMapping("/noticeEditForm.do")
	public String noticeEditForm(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.noticeSelect(vo));
		return "notice/noticeEditForm";
	}

//✔내가 한 방법
	@PostMapping("/noticeEdit.do")
	public String noticeEdit(NoticeVO vo, MultipartFile file, Model model) {
		String saveFolder = servletContext.getRealPath("/resources/upload/"); // 파일 저장 위치
		if (!file.isEmpty()) { // 비어 있으면 true /비어있지않으면 false
			// 첨부 파일이 존재하면 -> 비어있으면 true를 반환하기때문에 !를 달아서 false로 만들어서 진행함
			String fileName = UUID.randomUUID().toString(); // 랜덤으로 파일이름을 지정함
			fileName ="_"+ fileName + file.getOriginalFilename(); // 랜덤으로 만들어진 uuid + 원본 파일이름
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

	// ✔ModelAndView사용하는 방법 -> 최근에는 잘 사용하지않음// 무거움 
//	@PostMapping("/noticeEdit.do")
//	public ModelAndView noticeEdit(NoticeVO vo, ModelAndView mv) {
//		int n = noticeService.noticeUpdate(vo);
//		if (n != 0) {
//			mv.addObject("notice", noticeService.noticeSelect(vo));
//			mv.setViewName("notice/noticeSelect"); // 돌아갈 페이지
//		} else {
//			mv.addObject("message", "수정이 정상적으로 처리되지 못했습니다");
//			mv.setViewName("notice/noticeError");
//		}
//		return mv;
//	}

	// ✔Model 사용하는 방법 -> 최근에 권장하는 방법 / model은 인터페이스라서 가벼움 
//	@PostMapping("/noticeEdit.do")
//	public String noticeEdit(NoticeVO vo,MultipartFile file, Model model) {
//		String viewPage = null;
//		int n = noticeService.noticeUpdate(vo);
//		if (n != 0) {
//			model.addAttribute("notice", noticeService.noticeSelect(vo));
//			viewPage="notice/noticeSelect"; // 돌아갈 페이지
//		} else {
//			model.addAttribute("message", "수정이 정상적으로 처리되지 못했습니다");
//			viewPage="notice/noticeError";
//		}
//		return viewPage;
//	}

	@RequestMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo) {
		vo = noticeService.noticeSelect(vo);  //id만 넘어오기 때문에 id값을 통해서 vo자체를 불러오게함
		// 실제 올라가있는 첨부파일도 지울수 있도록 만들어 보기
		if(vo.getNoticeFile() != null) {
			System.out.println("noticeDeldte=> "+vo);
			File file = new File(vo.getNoticeFileDir());  
			//vo에 있는 파일 경로를 꺼내와서 file에 담음 -> 이 경로에 있는 파일을 가지고와서 file에 담음 
			
			file.delete(); //경로에서 찾아온 파일을 delete
			
		}
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
