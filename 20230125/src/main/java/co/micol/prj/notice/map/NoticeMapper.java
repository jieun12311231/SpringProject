package co.micol.prj.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	
	List<NoticeVO> noticeList();  //전체 리스트
	
	NoticeVO noticeSelect(NoticeVO vo); // 상세조회
	
	int noticeInsert(NoticeVO vo);  //등록
	
	int noticeUpdate(NoticeVO vo);  //수정
	
	int noticeDelete(NoticeVO vo);  //삭제
	
	List<NoticeVO> noticeSearch(@Param("key") String key,@Param("val") String val);  //검색
	//key가 날아오면 key로 사용을 하겠다 
	//val이 날아오면 value로 사용을 하겠다
	//두개이상의 매개변수가잇으면 반드시 @Param을 사용해야함
	
	int noticeHitUpdate(int id);  //조회수 증가용 
}
