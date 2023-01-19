package co.micol.prj.member.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.member.map.MemberMapper;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired  // 자동으로 매퍼를 끌고옴 
	private MemberMapper memberMapper;

	@Override
	public List<MemberVO> memberListSelect() {
		return memberMapper.memberListSelect();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return memberMapper.memberSelect(vo);
	}

	@Override
	public int memberInset(MemberVO vo) {
		return memberMapper.memberInset(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return memberMapper.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return memberMapper.memberDelete(vo);
	}

	@Override
	public boolean isIdCheck(String id) {
		return memberMapper.isIdCheck(id);
	}

}
