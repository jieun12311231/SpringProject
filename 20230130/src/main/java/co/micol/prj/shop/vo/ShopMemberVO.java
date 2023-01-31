package co.micol.prj.shop.vo;

import co.micol.prj.common.PageVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

//extends PageVO -> 페이징 처리하기 위해서 이런방식으로 사용함 
public class ShopMemberVO extends PageVO {  //최상위 테이블 => MasterTable
	private String shId;
	private String shPassword;
	private String shGubun;
}
