package picView.member.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.member.mapper.MemberMapper;

@Component
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate myTemplate;
	
	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate){
		this.myTemplate = myTemplate;
	}
	
	public Member selectById(String mem_id){
		Member m = null;
		m = myTemplate.getMapper(MemberMapper.class).selectById(mem_id);
		return m;
	}
	
	public void insert(Member member){
		myTemplate.getMapper(MemberMapper.class).insertMember(member);
	}
	

}
