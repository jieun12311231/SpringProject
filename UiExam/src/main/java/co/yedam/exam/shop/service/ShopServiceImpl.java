package co.yedam.exam.shop.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.exam.shop.map.ShopMapper;
import co.yedam.exam.shop.vo.ShUserVO;
import co.yedam.exam.shop.vo.ShopCustomerVO;
import co.yedam.exam.shop.vo.ShopEmployeeVO;
import co.yedam.exam.shop.vo.ShopMemberVO;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopMapper mapper;
	
	@Override
	public List<Map<String, Object>> getCoustomerList() {
		return mapper.getCoustomerList();
	}
	
	@Override
	public List<ShopCustomerVO> getCustomerList() {  //객체타입으로 리스트 받기
		return mapper.getCustomerList();
	}


	@Override
	public List<ShUserVO> getShopList() {
		return mapper.getShopList();
	}

	@Override
	public ShopMemberVO loginCheck(ShopMemberVO vo) {
		return mapper.loginCheck(vo);
	}

	@Override
	public boolean isIdCheck(String id) {
		return mapper.isIdCheck(id);
	}

	@Override
	public int setShopUser(ShUserVO vo) {
		return mapper.setShopUser(vo);
	}

	@Override
	public int setCoustomer(ShopCustomerVO vo) {
		return mapper.setCoustomer(vo);
	}

	@Override
	public int setMember(ShopMemberVO vo) {
		return mapper.setMember(vo);
	}
	
	//직원
	@Override
	public List<ShopEmployeeVO> getEmployeeList() {
		return mapper.getEmployeeList();
	}
	@Override
	public int setShopEmployeeInsert(ShopEmployeeVO vo) {
		return mapper.setShopEmployeeInsert(vo);
	}


}
