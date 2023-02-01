package co.micol.prj.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.micol.prj.shop.service.ShopService;
import co.micol.prj.shop.vo.ShopCustomerVO;
import co.micol.prj.shop.vo.ShopEmployeeVO;
import co.micol.prj.shop.vo.ShopMemberVO;
import co.micol.prj.shop.vo.ShopUserVO;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;

	@GetMapping("/customerList.do")
	public String customerList(Model model) {
		model.addAttribute("customers", shopService.getCustomerList());
		return "shop/customerList";
	}

	// 객체 중심으로 설계했을때
	@GetMapping("/getCustomerList2.do")
	public String getCustomerList2(Model model) {
		model.addAttribute("customers2", shopService.getCustomerList2());
		return "shop/getCustomerList2";
	}

	@GetMapping("/shopUserList.do")
	public String shopUserList(Model model) {
		model.addAttribute("shops", shopService.getShopList());
		return "shop/shopUserList";
	}

	// 폼 던지는것도 get으로 하면됨
	@GetMapping("/setMemberJoinForm.do")
	public String setMemberJoinForm() {
		return "shop/setMemberJoinForm";
	}

	@PostMapping("/shopCustomerJoin.do")
	public String shopCustomerJoin(ShopCustomerVO vo, Model model, ShopMemberVO svo) {
		System.out.println("vo => " + vo.getShCustomerId());
		System.out.println("svo => " + svo.getShId());
		vo.setShCustomerId(svo.getShId()); // id를 customer table에 연결하기 위해서 아이디 값을 넣음
		int n = shopService.setShopMemberInsert(svo); // 우선 member table에 저장
		if (n != 0) {
			int m = shopService.setShopCustomerInsert(vo); // 고객을 개별 table에 저장을 함
			System.out.println("vo => " + vo.getShCustomerId());
			if (m != 0) {
				model.addAttribute("message", "회원가입 완");
			} else {
				model.addAttribute("message", "회원가입 실패");
			}
		} else {
			model.addAttribute("message", "회원가입 실패");
		}
		return "shop/shopMessage";
	}

	@PostMapping("/shopUserJoin.do")
	public String shopUserJoin(ShopUserVO vo, Model model, ShopMemberVO svo) {
		vo.setShUserId(svo.getShId());
		int n = shopService.setShopMemberInsert(svo);
		if (n != 0) {
			int m = shopService.setShopUserInsert(vo);
			if (m != 0) {
				System.out.println(vo);
				System.out.println(svo);
				model.addAttribute("message", "점주 가입 완");
			} else {
				model.addAttribute("message", "가입 실패");
			}
		} else {
			model.addAttribute("message", "가입실패");
		}
		return "shop/shopMessage";
	}

	@PostMapping("/shopEmployeeJoin.do")
	public String shopEmployeeJoin(Model model, ShopMemberVO svo,ShopEmployeeVO vo) { // empVO넣어주고 동작 시키면 됨
		vo.setShEmployeeId(svo.getShId());
		int n = shopService.setShopMemberInsert(svo);
		if(n != 0) {
			int m = shopService.setShopEmployeeInsert(vo);
			if(m != 0) {
				model.addAttribute("message","직원 가입 완료");
			}else {
				model.addAttribute("message","직원 가입 실패");
			}
		}else {
			model.addAttribute("message","직원 가입 실패");
		}
		return "shop/shopMessage";
	}
	@GetMapping("/employeeList.do")
	public String employeeList(Model model,ShopEmployeeVO vo) {
		model.addAttribute("employees",shopService.getEmployeeList());
		return "shop/employeeList";
	}
	
}
