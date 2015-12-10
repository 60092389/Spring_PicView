package picView.follow.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.cate.model.Category;
import picView.cate.model.CategoryDao;
import picView.cate.model.GroupCategory;
import picView.follow.model.Follow;
import picView.follow.model.FollowCommand;
import picView.follow.model.FollowDao;
import picView.follow.model.FollowRecommand;
import picView.member.model.Member;
import picView.member.model.MemberDao;

@Service
public class FollowService {
	final static int DAY_LIMIT = 7;
	private FollowDao followDao;
	private MemberDao memberDao;
	private CategoryDao cateDao;

	@Autowired
	public void setFollowDao(FollowDao followDao) {
		this.followDao = followDao;
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	public void setCateDao(CategoryDao cateDao) {
		this.cateDao = cateDao;
	}

	// 아무관계 없는사람 팔로우하기
	public void addNewFollow(FollowCommand fc) {
		Follow my_follow = new Follow();
		Follow fri_follow = new Follow();

		String mem_nos = fc.getMem_nos();
		String[] mem_nos_arr = mem_nos.split(",");

		System.out.println("service 회원 : " + mem_nos_arr[0]);
		System.out.println("service 친구 : " + mem_nos_arr[1]);

		int my_mem_no = Integer.parseInt(mem_nos_arr[0]);// 회원번호
		int my_fri_no = Integer.parseInt(mem_nos_arr[1]);// 친구추가할 회원번호

		int fri_mem_no = Integer.parseInt(mem_nos_arr[1]);
		int fri_fri_no = Integer.parseInt(mem_nos_arr[0]);

		List<Follow> list = followDao.listFollowCheck(my_mem_no);

		my_follow.setMem_no(my_mem_no);
		my_follow.setFollow_fri_no(my_fri_no);

		fri_follow.setMem_no(fri_mem_no);
		fri_follow.setFollow_fri_no(fri_fri_no);

		my_follow.setFollow_check("1");
		fri_follow.setFollow_check("2");
		followDao.addNewFollow(my_follow);
		followDao.addNewFollow(fri_follow);

	}

	// 나를 팔로우한사람 팔로우하기
	public void addFollow(FollowCommand fc) {
		Follow my_follow = new Follow();
		Follow fri_follow = new Follow();

		String mem_nos = fc.getMem_nos();
		String[] mem_nos_arr = mem_nos.split(",");

		System.out.println("service 회원 : " + mem_nos_arr[0]);
		System.out.println("service 친구 : " + mem_nos_arr[1]);

		int my_mem_no = Integer.parseInt(mem_nos_arr[0]);// 회원번호
		int my_fri_no = Integer.parseInt(mem_nos_arr[1]);// 친구추가할 회원번호

		int fri_mem_no = Integer.parseInt(mem_nos_arr[1]);
		int fri_fri_no = Integer.parseInt(mem_nos_arr[0]);

		my_follow.setMem_no(my_mem_no);
		my_follow.setFollow_fri_no(my_fri_no);

		fri_follow.setMem_no(fri_mem_no);
		fri_follow.setFollow_fri_no(fri_fri_no);

		my_follow.setFollow_check("3");
		fri_follow.setFollow_check("3");
		followDao.updateFollowCheck(my_follow);
		followDao.updateFollowCheck(fri_follow);

	}

	// 나만 팔로우한 상태 취소하기
	public void cancelFollow(FollowCommand fc) {
		Follow my_follow = new Follow();
		Follow fri_follow = new Follow();

		String mem_nos = fc.getMem_nos();
		String[] mem_nos_arr = mem_nos.split(",");

		System.out.println("service 회원 : " + mem_nos_arr[0]);
		System.out.println("service 친구 : " + mem_nos_arr[1]);

		int my_mem_no = Integer.parseInt(mem_nos_arr[0]);// 회원번호
		int my_fri_no = Integer.parseInt(mem_nos_arr[1]);// 친구추가할 회원번호

		int fri_mem_no = Integer.parseInt(mem_nos_arr[1]);
		int fri_fri_no = Integer.parseInt(mem_nos_arr[0]);

		my_follow.setMem_no(my_mem_no);
		my_follow.setFollow_fri_no(my_fri_no);

		fri_follow.setMem_no(fri_mem_no);
		fri_follow.setFollow_fri_no(fri_fri_no);

		my_follow.setFollow_check("1");
		fri_follow.setFollow_check("2");
		followDao.cancelFollow(my_follow);
		followDao.cancelFollow(fri_follow);

	}

	// 맞팔상태에서 나만 팔로우 끊기
	public void cancelEachFollow(FollowCommand fc) {
		Follow my_follow = new Follow();
		Follow fri_follow = new Follow();

		String mem_nos = fc.getMem_nos();
		String[] mem_nos_arr = mem_nos.split(",");

		System.out.println("service 회원 : " + mem_nos_arr[0]);
		System.out.println("service 친구 : " + mem_nos_arr[1]);

		int my_mem_no = Integer.parseInt(mem_nos_arr[0]);// 회원번호
		int my_fri_no = Integer.parseInt(mem_nos_arr[1]);// 친구추가할 회원번호

		int fri_mem_no = Integer.parseInt(mem_nos_arr[1]);
		int fri_fri_no = Integer.parseInt(mem_nos_arr[0]);

		my_follow.setMem_no(my_mem_no);
		my_follow.setFollow_fri_no(my_fri_no);

		fri_follow.setMem_no(fri_mem_no);
		fri_follow.setFollow_fri_no(fri_fri_no);

		my_follow.setFollow_check("2");
		fri_follow.setFollow_check("1");
		followDao.updateFollowCheck(my_follow);
		followDao.updateFollowCheck(fri_follow);

	}

	public List<Follow> listFollow(int mem_no) {

		List<Follow> list = followDao.listFollow(mem_no);

		Timestamp time = null;
		// my_FollowSearch.jsp에서 default_btn 띄우기위해
		list.add(new Follow(0, 0, 0, "0", time));

		return list;
	}

	
	//추천회원에 가져갈 리스트 뽑는 서비스
	public List<FollowRecommand> followRecommand(int mem_no) {
		System.out.println("followRecommand 서비스 입장");
		long diff = 0;
		long diffDays = 0;

		// 추천회원들을 담을 리스트
		List<FollowRecommand> recommand_list = new ArrayList<FollowRecommand>();

		// 전체회원목록
		List<Member> member_list = memberDao.listSearchFri();

		// 자신이 갖고있는 카테고리들
		List<GroupCategory> my_cate = cateDao.member_cate(mem_no);
		
		
		
		// 현재시간과 다른회원의 최종접속일을 계산하기위함
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String now_date = formatter.format(new Date());
		Date end_date = null;
		try {
			end_date = formatter.parse(now_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < member_list.size(); i++) {
			// 자신을 제외한 회원들 중에서뽑기
			if (member_list.get(i).getMem_no() != mem_no) {
				System.out.println("나를 제외한 회원들 : "+member_list.get(i).getMem_name());
				Timestamp temp = member_list.get(i).getMem_last_date();
				Date temp2 = temp;
				String mem_last_date = formatter.format(temp2);
				try {
					Date begin_date = formatter.parse(mem_last_date);

					diff = end_date.getTime() - begin_date.getTime();
					diffDays = diff / (24 * 60 * 60 * 1000);

				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				System.out.println("최종접속일 = "+diffDays);

				Follow follow = new Follow();
				follow.setMem_no(mem_no);
				follow.setFollow_fri_no(member_list.get(i).getMem_no());
				
				List<Follow> follow_check = followDao.followCheck(follow);

				List<GroupCategory> mem_cate 
						= cateDao.member_cate(member_list.get(i).getMem_no());
				
				// 최종접속일이 7일 이내 중
				// 선택한 카테고리들이 있는 회원들 중
				// 자신과 아무팔로우가 없는 회원들 중
				if(diffDays <= DAY_LIMIT && mem_cate.size() != 0 
							&& follow_check.size() == 0 && my_cate.size() != 0){
					
					//친구추천 페이지에 가져갈 리스트를 위한 객체 
					FollowRecommand fr = new FollowRecommand();
					
					String cate_name = "";
					//자신의 카테고리와 다른회원의 카테고리를 비교
					for(int j=0; j<my_cate.size(); j++){
						System.out.println("my_cate_size : "+j);
						for(int k=0; k<mem_cate.size(); k++){
							System.out.println("mem_cate_size : "+k);
							if(my_cate.get(j).getCategory_no() == mem_cate.get(k).getCategory_no()){
								System.out.println("mem_cate_size_if");
								fr.setMem_no(member_list.get(i).getMem_no());
								fr.setMem_id(member_list.get(i).getMem_id());
								fr.setMem_name(member_list.get(i).getMem_name());
								fr.setPic_count(member_list.get(i).getPic_count());
								fr.setMem_pic(member_list.get(i).getMem_pic());
								
								cate_name = cate_name +cateDao.selectCate(my_cate.get(k).getCategory_no())+"&nbsp&nbsp";
								fr.setCategory_name(cate_name);
							}
						}
					}
					if(fr.getMem_name() != null){
						recommand_list.add(fr);
					}
				}				
			}
		}

		return recommand_list;
	}
	

}
