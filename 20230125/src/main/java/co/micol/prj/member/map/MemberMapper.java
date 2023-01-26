package co.micol.prj.member.map;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberListSelect();  //전체 회원 조회

	MemberVO memberSelect(MemberVO vo);  //회원 상세 조회

	int memberInset(MemberVO vo);

	int memberUpdate(MemberVO vo);

	int memberDelete(MemberVO vo);
	
	boolean isIdCheck(String id); //아이디 중복체크 
}
