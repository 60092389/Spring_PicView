package picView.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.cate.model.Category;
import picView.cate.model.CategoryDao;
import picView.cate.model.GroupCategory;
import picView.member.model.Member;
import picView.member.model.MemberCommand;
import picView.member.model.MemberDao;

@Service
public class MemberService {
	private MemberDao memberDao;
	private CategoryDao cateDao;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	public void setCateDao(CategoryDao cateDao) {
		this.cateDao = cateDao;
	}

	public void insertMember(MemberCommand mc) throws Exception {
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

		// 회원 소속카테고리 등록

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

}
