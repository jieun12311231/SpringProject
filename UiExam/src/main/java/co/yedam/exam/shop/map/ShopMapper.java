package co.yedam.exam.shop.map;

import java.util.List;
import java.util.Map;

import co.yedam.exam.shop.vo.ShUserVO;
import co.yedam.exam.shop.vo.ShopCustomerVO;
import co.yedam.exam.shop.vo.ShopEmployeeVO;
import co.yedam.exam.shop.vo.ShopMemberVO;

public interface ShopMapper {
	List<Map<String, Object>> getCoustomerList();  //고객정보리스트 보기(맵 구조로 받음)
	List<ShUserVO> getShopList();  //상점주 리스트 보기
	
	List<ShopCustomerVO> getCustomerList();  //고객정보를 객체로 받아오기
	
	
	ShopMemberVO loginCheck(ShopMemberVO vo);  //로그인 하기
	boolean isIdCheck(String id);  //아이디 중복체크
	
	int setShopUser(ShUserVO vo);  //상점주 추가
	int setCoustomer(ShopCustomerVO vo);  //고객 정보 추가
	int setMember(ShopMemberVO vo);      //아이디 패스워드 구분 입력
	
	//직원
	List<ShopEmployeeVO> getEmployeeList();
	int setShopEmployeeInsert(ShopEmployeeVO vo); 
}
