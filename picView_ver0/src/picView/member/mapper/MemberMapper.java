package picView.member.mapper;

import java.util.List;

import picView.member.model.Member;

public interface MemberMapper {
	public void insertMember(Member member);
	public Member selectById(String mem_id);
	public List<Member> listSearchMem();
	public void minusPic_count(int mem_no);
	public Member login_check(Member member);
	public Member selectByNo(int mem_no);
}
