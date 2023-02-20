package co.micol.prj.shop.map;

import java.util.List;
import java.util.Map;

import co.micol.prj.shop.vo.ShopCustomerVO;
import co.micol.prj.shop.vo.ShopEmployeeVO;
import co.micol.prj.shop.vo.ShopMemberVO;
import co.micol.prj.shop.vo.ShopUserVO;

public interface ShopMapper {

	List<Map<String, Object>> getCustomerList(); // 고객정보리트스 보기(맵구조로 받음-> 보가 확장되어있지않음)//여기가 Map이면 mapper에서 resultType을
													// map으로 줘야함!!
	List<ShopUserVO> getShopList(); // 상점주 리스트 보기 (보가 확장되어있어서 list형태로 받음)

	List<ShopCustomerVO> getCustomerList2();
	
	List<ShopEmployeeVO> getEmployeeList();

	// 로그인 masterVo만 가지고 확인가능
	ShopMemberVO loginCheck(ShopMemberVO vo); // 아이디 값을 넘겨도 되지만 shopMemberVO에 다 담음

	boolean isIdCheck(String id); // 아이디 중복 체크

	// insert - master에 추가하고 나머지에 추가되어야함
	int setShopUserInsert(ShopUserVO vo); // 상점주 추가

	int setShopCustomerInsert(ShopCustomerVO vo); // 고객 정보 추가

	int setShopMemberInsert(ShopMemberVO vo); // 아이디 패스워드 구분 입력
	
	int setShopEmployeeInsert(ShopEmployeeVO vo); // 직원 추가
}
