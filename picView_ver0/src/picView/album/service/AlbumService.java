package picView.album.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import picView.album.model.Album;
import picView.album.model.AlbumDao;
import picView.album.model.AlbumResult;
import picView.album.model.CommandAlbum;
import picView.album.model.Group_Pic;
import picView.cate.model.Category;
import picView.follow.model.Follow;
import picView.follow.model.FollowDao;
import picView.member.model.MemberDao;
import picView.picture.model.Picture;

@Service
public class AlbumService {

	private AlbumDao dao;
	private MemberDao memberDao;
	private FollowDao followDao;

	@Autowired
	public void setDao(AlbumDao dao) {
		this.dao = dao;
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
	public void setFollowDao(FollowDao followDao){
		this.followDao = followDao;
	}

	
	// 앨범첫페이지에서 앨범리스트 출력
	public List<String> albumpiclist(int mem_no, int fri_no) {
		
		List<Picture> albumpiclist = new ArrayList<Picture>();
		// 회원의 앨범의 그룹리스트 가져옴
		List<Group_Pic> gp = new ArrayList<Group_Pic>();
		
		//가져올 회원의 앨범 리스트
		List<Album> albumlist = new ArrayList<Album>();
		
		Follow follow = new Follow();
		
		follow.setMem_no(mem_no);
		follow.setFollow_fri_no(fri_no);
		
		List<Follow> fol_list = followDao.followCheck(follow);
		
		int relation = -1;
		
		Album album = new Album();
		album.setMem_no(fri_no);
		// 회원의 앨범 리스트를가져옴
		if(mem_no == fri_no){
			//자신의 사진첩에 들어왔을때			
			albumlist = dao.albumlist(album);
			relation = 1;//나자신
		}else{
			//다른사람의 사진첩에 들어올때
			
			if(fol_list.size() == 0){
				album.setAlb_open("1");
				albumlist = dao.albumlist(album);
				relation = 5;//아무관계아님				
			}
			
			for(int i=0; i<fol_list.size(); i++){
				System.out.println("fol_list 불러오기 "+i);
				if(fol_list.get(i).getMem_no() == mem_no &&
							fol_list.get(i).getFollow_check().equals("1")){
					album.setAlb_open("1");
					relation = 2; //나만 상대방 팔로우
					
					System.out.println("나만 상대방 팔로우");
					
					albumlist = dao.albumlist(album);
				}
				if(fol_list.get(i).getMem_no() == mem_no &&
						fol_list.get(i).getFollow_check().equals("2")){
		
					album.setAlb_open("1");
					relation = 3; //상대방만 나 팔로우
					
					System.out.println("상대방만 나 팔로우");
					
					albumlist = dao.albumlist(album);
				}
				if(fol_list.get(i).getMem_no() == mem_no &&
						fol_list.get(i).getFollow_check().equals("3")){
					album.setAlb_open("2");
					relation = 4; //맞팔상태(친구)
					
					System.out.println("맞팔 상태");
				
					albumlist = dao.albumlist(album);
					
				}				
			}			
		}
		
		List<String> pic_add = new ArrayList<String>();
		System.out.println("albumlist :"+ albumlist.size());
		for (int i = 0; i < albumlist.size(); i++) {
			
				gp = dao.grouplist(albumlist.get(i).getAlb_no());
				System.out.println("aaaa"+gp.get(0).getPic_no());
				
			
				for (int j = 0; j < 1; j++) {
					albumpiclist = dao.albumpiclist(gp.get(j).getPic_no());	
					pic_add.add(albumpiclist.get(j).getPic_add());
					
					}
		}

		return pic_add;
	}

	public AlbumResult albumlist(int mem_no, int fri_no) {
		//가져올 회원의 앨범 리스트
		List<Album> albumlist = new ArrayList<Album>();
			
		Follow follow = new Follow();
			
		follow.setMem_no(mem_no);
		follow.setFollow_fri_no(fri_no);
		
		List<Follow> fol_list = followDao.followCheck(follow);
			
		int relation = -1;		
		
		AlbumResult albumResult = new AlbumResult();
		
		Album album = new Album();		
		album.setMem_no(fri_no);		
		if(mem_no == fri_no){
			//자신의 사진첩에 들어왔을때			
			albumlist = dao.albumlist(album);
			relation = 1;//나자신
			albumResult.setAlbumlist(albumlist);
			albumResult.setRelation(relation);
			
		}else{
			//다른사람의 사진첩에 들어올때
			
			if(fol_list.size() == 0){
				album.setAlb_open("1");
				albumlist = dao.albumlist(album);
				relation = 5;//아무관계아님
				
				albumResult.setAlbumlist(albumlist);
				albumResult.setRelation(relation);
			}
			
			for(int i=0; i<fol_list.size(); i++){
				System.out.println("fol_list 불러오기 "+i);
				if(fol_list.get(i).getMem_no() == mem_no &&
							fol_list.get(i).getFollow_check().equals("1")){
					album.setAlb_open("1");
					relation = 2; //나만 상대방 팔로우
					
					System.out.println("나만 상대방 팔로우");
					
					albumlist = dao.albumlist(album);
					
					albumResult.setAlbumlist(albumlist);
					albumResult.setRelation(relation);
				}
				if(fol_list.get(i).getMem_no() == mem_no &&
						fol_list.get(i).getFollow_check().equals("2")){
		
					album.setAlb_open("1");
					relation = 3; //상대방만 나 팔로우
					
					System.out.println("상대방만 나 팔로우");
					
					albumlist = dao.albumlist(album);
					
					albumResult.setAlbumlist(albumlist);
					albumResult.setRelation(relation);
				}
				if(fol_list.get(i).getMem_no() == mem_no &&
						fol_list.get(i).getFollow_check().equals("3")){
					album.setAlb_open("2");
					relation = 4; //맞팔상태(친구)
					
					System.out.println("맞팔 상태");
				
					albumlist = dao.albumlist(album);
					
					albumResult.setAlbumlist(albumlist);
					albumResult.setRelation(relation);
					
				}				
			}			
		}
		
		
		return albumResult;
	}

	public List<Picture> listpic(int mem_no) {
		List<Picture> listpic =  dao.piclist(mem_no);
		int category_no = 0;
		Category catelist = new Category();
		for(int i =0; i< listpic.size(); i++){
			category_no = listpic.get(i).getCategory_no();
			catelist = dao.categorylist(category_no);
			if(listpic.get(i).getTag_name() == null){
				listpic.get(i).setTag_name(catelist.getCategory_name());
			}
				
		}
		return listpic;
		
	}
	
	//트랜잭션 처리
	@Transactional(propagation=Propagation.REQUIRED,
			rollbackFor={Exception.class})
	public void insertAlbum(CommandAlbum ca) throws Exception {
		Album album = new Album();

		album.setMem_no(ca.getMem_no());
		album.setAlb_name(ca.getAlb_name());
		album.setAlb_content(ca.getAlb_content());
		album.setAlb_word(ca.getAlb_word());
		album.setAlb_open(ca.getAlb_open());

		System.out.println("b");
		dao.insertAlbum(album);
		System.out.println("c");

		// 주의사항!! 여기서 지금 alb_word 를 가져오고있다. alb_word는 앨범들의 고유의 키워드로 생각해서가져왔다.
		// 동일한 앨범키워드가 생기면안된다.( 추후 동일한 앨범키워드일경우는 같은앨범키워드안에 앨범에 넣을 예정)
		album = dao.selectAlbum_no(ca.getAlb_word());

		if(album.getAlb_no() == 0){
			throw new Exception("앨범이 없습니다.");
		}
		System.out.println("c");
		System.out.println(album.getAlb_no());
		Group_Pic group = new Group_Pic();

		String[] count = ca.getPic_no().split(",");
		if(count == null){
			
		}
		System.out.println("d==" + count[0]);
		for (int i = 1; i < count.length; i++) {
			System.out.println("e==" + count[i]);
			int pic_no = Integer.parseInt(count[i]);
			group.setPic_no(pic_no);
			group.setAlb_no(album.getAlb_no());
			dao.insertGroup(group);
		}

	}
	public Album detailAlbum(int alb_no){
		return dao.detailAlbum(alb_no);
	}
	
	public List<String> detailAlbumPic(int alb_no){
		
		List<Group_Pic> gp = dao.grouplist(alb_no);
		List<String> albumlist = new ArrayList<String>();
		System.out.println("gpgpgpgpgpp"+gp.size());
		if(gp.size() == 1){
			List<Picture> albumlist2 = dao.albumpiclist(gp.get(0).getPic_no());
			albumlist.add(albumlist2.get(0).getPic_add());
		}else if(gp.size() != 1){
		for(int i =0; i < gp.size(); i++){
			System.out.println("a"+dao.albumpiclist(gp.get(1).getPic_no()));
			Picture albumlist2 = dao.selectPicture(gp.get(i).getPic_no());
			System.out.println("b"+albumlist2.getPic_add());
			albumlist.add(albumlist2.getPic_add());
		}
		}
		
		return albumlist;
	}
	public List<String> detailAlbumPicname(int alb_no){
		List<Group_Pic> gp = dao.grouplist(alb_no);
		List<String> albumlist = new ArrayList<String>();
		//System.out.println("gpgpgpgpgpp"+gp.size());
		if(gp.size() == 1){
			List<Picture> albumlist2 = dao.albumpiclist(gp.get(0).getPic_no());
			albumlist.add(albumlist2.get(0).getPic_add());
		}else if(gp.size() != 1){
		for(int i =0; i < gp.size(); i++){
			System.out.println("a"+dao.albumpiclist(gp.get(1).getPic_no()));
			Picture albumlist2 = dao.selectPicture(gp.get(i).getPic_no());
			System.out.println("b"+albumlist2.getPic_title());
			albumlist.add(albumlist2.getPic_title());
		}
		}
		
		return albumlist;
	}
	
	public List<Integer> detailAlbumPicno(int alb_no){
		List<Group_Pic> gp = dao.grouplist(alb_no);
		List<Integer> albumlist = new ArrayList<Integer>();
		//System.out.println("gpgpgpgpgpp"+gp.size());
		if(gp.size() == 1){
			List<Picture> albumlist2 = dao.albumpiclist(gp.get(0).getPic_no());
			albumlist.add(albumlist2.get(0).getPic_no());
		}else if(gp.size() != 1){
		for(int i =0; i < gp.size(); i++){
			System.out.println("a"+dao.albumpiclist(gp.get(1).getPic_no()));
			Picture albumlist2 = dao.selectPicture(gp.get(i).getPic_no());
			System.out.println("b"+albumlist2.getPic_title());
			albumlist.add(albumlist2.getPic_no());
		}
		}
		
		return albumlist;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,
			rollbackFor={Exception.class})
	public void deleteAlbum(int alb_no) throws Exception{
		try {
			System.out.println("하나라도 되라");
			dao.deleteGroup(alb_no);
			dao.deleteAlbum(alb_no);
			
		} catch (Exception e) {
			throw new Exception("삭제 에러");
		}
		
		
	}
	
	public CommandAlbum updateget(CommandAlbum ca){
		
		Album album = new Album();
		album = dao.selectAlbum_no(ca.getAlb_word());
		String[] count = ca.getPic_no().split(",");
		Group_Pic group = new Group_Pic();
		for (int i = 1; i < count.length; i++) {
			System.out.println("e==" + count[i]);
			int pic_no = Integer.parseInt(count[i]);
			group.setPic_no(pic_no);
			group.setAlb_no(album.getAlb_no());
			dao.insertGroup(group);
		}
		return ca;
	}
	
	
	public List<Picture> grouplist(int alb_no){
		List<Picture> listpic = new ArrayList<>();
		List<Group_Pic> gp = dao.grouplist(alb_no);
		Category catelist = new Category();
		System.out.println("gp 몇개? : " +gp.size());
		int pic_no[] = new int[100];
		for(int cnt=0; cnt< gp.size(); cnt++){
			pic_no[cnt] = gp.get(cnt).getPic_no();
			System.out.println("pic_no배열값 : "+pic_no[cnt]);
		}
		System.out.println("함더확인"+pic_no);
		for(int i =0; i< gp.size(); i++){
			if(gp.size() == 1){
				Picture pic = dao.selectPicture(pic_no[0]);
				if(pic.getTag_name() ==null){
					catelist = dao.categorylist(pic.getCategory_no());
					pic.setTag_name(catelist.getCategory_name());
				}
			
				listpic.add(pic);
			}else{
			Picture pic = dao.selectPicture(pic_no[i]);
			if(pic.getTag_name() ==null){
				catelist = dao.categorylist(pic.getCategory_no());
				pic.setTag_name(catelist.getCategory_name());
			}
			
			listpic.add(pic);
			System.out.println("listpic 출력과정 :" + pic_no[i]);
			}
		}
		System.out.println(listpic.get(0).getPic_no());
		
		return listpic;
	}
	
	public void albumlevel(Album levelcommand){

		dao.albumlevel(levelcommand);
		
	
	}
	
	public List<Picture> pic_search(String pic_search){
		return dao.pic_search(pic_search);
	}
	

}
