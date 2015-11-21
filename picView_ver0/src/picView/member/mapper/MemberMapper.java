package picView.member.mapper;

import picView.member.model.Member;

public interface MemberMapper {
	public void insertMember(Member member);
	public Member selectById(String mem_id);
}
