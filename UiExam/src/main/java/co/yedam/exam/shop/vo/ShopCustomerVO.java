package co.yedam.exam.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShopCustomerVO {//shopmember의 하위(자식)
	
	//test를 위해서 확장하지않고 shopCustomer가 가지고있는 필드만 만들어줌
	private String shCustomerId;
	private String shCustomerName;
	private String shCustomerTel;
	
	//객체 지향형 방법
	private ShopMemberVO shopMember;
}
