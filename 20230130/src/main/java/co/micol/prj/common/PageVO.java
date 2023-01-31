package co.micol.prj.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageVO {
	private int first;
	private int last;
	
	//페이지 구하는 메소드 -> 만들어놓고 상속 받아서 다른 클래스에서 사용할 수 있음
}
