package co.micol.prj.shop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.shop.map.ShopMapper;
import co.micol.prj.shop.vo.ShopCustomerVO;
import co.micol.prj.shop.vo.ShopEmployeeVO;
import co.micol.prj.shop.vo.ShopMemberVO;
import co.micol.prj.shop.vo.ShopUserVO;
@Service
public class ShopServiceImpl implements ShopService {
@Autowired
private ShopMapper shopMapper;
	@Override
	public List<Map<String, Object>> getCustomerList() {
		return shopMapper.getCustomerList();
	}
	//객체 타입으로 리스트 받기 
	@Override
	public List<ShopCustomerVO> getCustomerList2() {
		return shopMapper.getCustomerList2();
	}

	
	@Override
	public List<ShopUserVO> getShopList() {
		return shopMapper.getShopList();
	}

	@Override
	public ShopMemberVO loginCheck(ShopMemberVO vo) {
		return shopMapper.loginCheck(vo);
	}

	@Override
	public boolean isIdCheck(String id) {
		return shopMapper.isIdCheck(id);
	}

	@Override
	public int setShopUserInsert(ShopUserVO vo) {
		return shopMapper.setShopUserInsert(vo);
	}

	@Override
	public int setShopCustomerInsert(ShopCustomerVO vo) {
		return shopMapper.setShopCustomerInsert(vo);
	}

	@Override
	public int setShopMemberInsert(ShopMemberVO vo) {
		return shopMapper.setShopMemberInsert(vo);
	}
	
	
	@Override
	public List<ShopEmployeeVO> getEmployeeList() {
		return shopMapper.getEmployeeList();
	}
	@Override
	public int setShopEmployeeInsert(ShopEmployeeVO vo) {
		return shopMapper.setShopEmployeeInsert(vo);
	}


}
