package co.micol.prj.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//롬복이 자동으로 상속을 해줌 
@Getter
@Setter
@ToString
public class ShopUserVO extends ShopMemberVO{  //상속해놓으면 따로vo에 적어주지않아도 사용이가능함
	private String shUserId;
	private String shUserName;
	private String shUserShopname;
	
	//vo확장 - 상위가 가지고 있는 vo도 적어줌 
	//상위 필드 -id는 이미shUserId로 가지고 있기때문에 굳이 적어줄 필요없음 
//	private String shPassword;
//	private String shGubun;
//	
}
