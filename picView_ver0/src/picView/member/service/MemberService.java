package picView.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.member.model.Member;
import picView.member.model.MemberCommand;
import picView.member.model.MemberDao;

@Service
public class MemberService {
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	public void insertMember(MemberCommand mc) throws Exception{
		Member memberCheck = memberDao.selectById(mc.getId());
		
		if(memberCheck!=null){
			throw new Exception("중복된 아이디");
		}
		
		Member m = new Member();
		
		String mem_birth = mc.getYear()+mc.getMonth()+mc.getDay();
		
		m.setMem_id(mc.getId());
		m.setMem_pwd(mc.getPass());
		m.setMem_name(mc.getName());
		m.setMem_birth(mem_birth);
		m.setMem_sex(mc.getGender());
		
		memberDao.insert(m);
		
	}
	

}
