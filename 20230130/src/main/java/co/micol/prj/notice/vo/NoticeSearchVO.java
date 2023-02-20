package co.micol.prj.notice.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeSearchVO {  //key와 val을 받기위해 vo를 따로 만들어줌
	private String key;
	private String val; 
}
