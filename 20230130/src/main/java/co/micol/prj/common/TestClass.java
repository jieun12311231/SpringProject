package co.micol.prj.common;

import co.micol.prj.shop.vo.ShopMemberVO;
import co.micol.prj.shop.vo.ShopUserVO;

public class TestClass {
//상속해서 사용 가능
	public void testVO() {
		ShopMemberVO vo = new ShopMemberVO();
//	vo.first = 10;
//	vo.last = 2;
//	vo.setShId("id");

		vo.getFirst();
		vo.getLast();

		ShopUserVO vo2 = new ShopUserVO();
		vo2.getShId();
	}
}
