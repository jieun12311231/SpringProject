package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeList();  //전체 리스트
	NoticeVO noticeSelect(NoticeVO vo); // 상세조회
	int noticeInsert(NoticeVO vo);  //등록
	int noticeUpdate(NoticeVO vo);  //수정
	int noticeDelete(NoticeVO vo);  //삭제
	
	List<NoticeVO> noticeSearch(String key,String val);  //검색
}
