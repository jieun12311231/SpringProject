package co.yedam.exam.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yedam.exam.shop.service.ShopService;
import co.yedam.exam.shop.vo.ShUserVO;
import co.yedam.exam.shop.vo.ShopCustomerVO;
import co.yedam.exam.shop.vo.ShopEmployeeVO;
import co.yedam.exam.shop.vo.ShopMemberVO;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/customerList.do")
	public String customerList(Model model) {
		model.addAttribute("customers", shopService.getCoustomerList());
		return "shop/customerList";
	}
	
	@GetMapping("/shopList.do")
	public String shopList(Model model) {
		model.addAttribute("shops", shopService.getShopList());
		return "shop/shopList";
	}
	
	@GetMapping("/getCustomerList.do")  //객체중심으로 설계 했을때
	public String getCustomerList(Model model) {
		model.addAttribute("customers", shopService.getCustomerList());
		return "shop/getCustomerList";
	}

	
	@RequestMapping("/setMemberJionForm.do")
	public String setMemberJionForm() {
		return "shop/setMemberJionForm";
	}
	
	@PostMapping("/shopCustomerJoin.do")
	public String shopMemberJoin(ShopCustomerVO vo, ShopMemberVO svo, Model model) {
		String message = null;
		vo.setShCustomerId(svo.getShId());  //아이디값을 넣는다.
		int n = shopService.setMember(svo);  //멤버에 저장하고
		if(n != 0) {
			int m = shopService.setCoustomer(vo);  //개별테이블에 저장
			if(m != 0) {
				message = "회원가입이 정상적으로 처리 되었다.";
			}else {
				message = "회원가입이 실패했습니다.";
			}
		}else {
			message = "회원가입이 실패했습니다.";
		}
		model.addAttribute("message", message);
		return "shop/shopMessage";
	}
	
	@PostMapping("/shopUserJoin.do")
	public String shopUserJoin(ShUserVO vo, ShopMemberVO svo, Model model) {
		vo.setShUserId(svo.getShId());
		int n = shopService.setMember(svo);
		if (n != 0) {
			int m = shopService.setShopUser(vo);
			if (m != 0) {
				System.out.println(vo);
				System.out.println(svo);
				model.addAttribute("message", "점주 가입 완료");
			} else {
				model.addAttribute("message", "가입 실패");
			}
		} else {
			model.addAttribute("message", "가입 실패");
		}
		return "shop/shopMessage";
	}
	
	@PostMapping("/shopEmployeeJoin.do")
	public String shopEmployeeJoin(Model model, ShopMemberVO svo,ShopEmployeeVO vo) {  //emp vo 를 넣어주고 동작 시키면 된다.
		vo.setShEmployeeId(svo.getShId());
		int n = shopService.setMember(svo);
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
