package picView.member.model;

import java.util.List;

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
	
	public List<Member> listSearchFri(){
		return myTemplate.getMapper(MemberMapper.class).listSearchMem();
	}
	
	public void minusPic_count(int mem_no){
		myTemplate.getMapper(MemberMapper.class).minusPic_count(mem_no);
	}

}
