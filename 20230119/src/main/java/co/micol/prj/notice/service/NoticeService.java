package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;
//서비스 인터페이스
public interface NoticeService {
	List<NoticeVO> noticeSelectList();  
	NoticeVO noticeSelect(NoticeVO vo);
}
