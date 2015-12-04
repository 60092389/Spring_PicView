package picView.member.service;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.cate.model.Category;
import picView.cate.model.CategoryDao;
import picView.cate.model.GroupCategory;
import picView.member.model.MailTest;
import picView.member.model.Member;
import picView.member.model.MemberCommand;
import picView.member.model.MemberDao;

@Service
public class MemberService {
	private MemberDao memberDao;
	private CategoryDao cateDao;
	private MailTest mailTest;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	public void setCateDao(CategoryDao cateDao) {
		this.cateDao = cateDao;
	}
	
	@Autowired
	public void setMailTest(MailTest mailTest) {
		this.mailTest = mailTest;
	}

	public void insertMember(MemberCommand mc) throws Exception {
		//회원가입
		Member memberCheck = memberDao.selectById(mc.getId());

		if (memberCheck != null) {
			throw new Exception("중복된 아이디");
		}

		Member m = new Member();

		String mem_birth = mc.getYear() + mc.getMonth() + mc.getDay();

		m.setMem_id(mc.getId());
		m.setMem_pwd(mc.getPass());
		m.setMem_name(mc.getName());
		m.setMem_birth(mem_birth);
		m.setMem_sex(mc.getGender());

		memberDao.insert(m);
		//회원가입 끝
		
		//회원가입시 회원이 선택한 소속카테고리 등록
		if(mc.getCategory_no() != null){
			GroupCategory gc = new GroupCategory();
			
			int mem_no = memberDao.selectById(mc.getId()).getMem_no();
			
			String category_no_arr = mc.getCategory_no();
			
			System.out.println("선택한 카테고리번호 : " + category_no_arr);
			
			String[] count = category_no_arr.split(",");
			
			for (int i = 0; i < count.length; i++) {
				int category_no = Integer.parseInt(count[i]);
				gc.setMem_no(mem_no);
				gc.setCategory_no(category_no);
				cateDao.insertGroupCate(gc);
			}
		
		}
	//회원가입시 회원이 선택한 소속카테고리 등록 끝
	}
	


	public void sendMailSerivce(MemberCommand mc){
		String subject = "픽뷰 회원가입을 축하드립니다";
		String formatUrl = "velocity.vm";
		
		String user_name = mc.getName();
		String user_mail = mc.getId();
		
		Map<String, Object> textParams = new HashMap<String, Object>();
		
		textParams.put("name", user_name);
		try {
			mailTest.sendMail(user_mail, subject, textParams, formatUrl);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Member> listSearchFri(){
		
		
		return memberDao.listSearchFri();
	}

}
