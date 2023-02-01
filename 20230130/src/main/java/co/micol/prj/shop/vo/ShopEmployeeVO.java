package co.micol.prj.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShopEmployeeVO extends ShopMemberVO{
	private String shEmployeeName;
	private String shEmployeePart;
	private String shEmployeeStartDate;
	private String shEmployeeLastDate;
	private String shEmployeePosition;
	private String shEmployeeId;
}
