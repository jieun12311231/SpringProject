package co.micol.prj.notice.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.notice.map.NoticeMapper;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;
@Service //DAO임을 알려주는것 -> 컴테이너로 올라감   서비스 그룹에 담기게 되고 호출할때는 인터페이스이름(NoticeService)으로 호출하면됨

public class NoticeServiceImpl implements NoticeService {
	
	@Autowired  //바로 밑에 줄에만 적용이 됨  -> 이거 자체가 repository
	private NoticeMapper noticeMapper;  //자동 주입 : mybatis 및 DataSoures가 // 레파지토리에 자동 등록 
	//관례적으로 클래스명과 같음!!!
	
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		
		return noticeMapper.noticeSelectList();
	}
	
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		
		return noticeMapper.noticeSelect(vo);
	}
	

}
