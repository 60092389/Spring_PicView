package picView.album.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.album.model.Album;
import picView.album.model.AlbumDao;
import picView.album.model.CommandAlbum;
import picView.album.model.Group_Pic;

import picView.picture.model.Picture;

@Service
public class AlbumService {

	private AlbumDao dao;

	@Autowired
	public void setDao(AlbumDao dao) {
		this.dao = dao;
	}

	// 앨범첫페이지에서 앨범리스트 출력
	public List<String> albumpiclist(int mem_no) {
		// 회원의 앨범 리스트를가져옴
		List<Album> albumlist = dao.albumlist(mem_no);
		List<Picture> albumpiclist = new ArrayList<Picture>();
		// 회원의 앨범의 그룹리스트 가져옴
		List<Group_Pic> gp = new ArrayList<Group_Pic>();
		
		List<String> pic_add = new ArrayList<String>();
		
		for (int i = 0; i < albumlist.size(); i++) {
			
				gp = dao.grouplist(albumlist.get(i).getAlb_no());
			
			
				for (int j = 0; j < 1; j++) {
				
					albumpiclist = dao.albumpiclist(gp.get(j).getPic_no());	
					pic_add.add(albumpiclist.get(j).getPic_add());
					
					}
		}

		return pic_add;
	}

	public List<Album> albumlist(int mem_no) {
		return dao.albumlist(mem_no);
	}

	public List<Picture> listpic(int mem_no) {
		return dao.piclist(mem_no);
	}

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

		System.out.println("c");
		System.out.println(album.getAlb_no());
		Group_Pic group = new Group_Pic();

		String[] count = ca.getPic_no().split(",");
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
	
	public void deleteAlbum(int alb_no){
		dao.deleteGroup(alb_no);
		dao.deleteAlbum(alb_no);
		
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
				listpic.add(pic);
			}else{
			Picture pic = dao.selectPicture(pic_no[i]);
			listpic.add(pic);
			System.out.println("listpic 출력과정 :" + pic_no[i]);
			}
		}
		System.out.println(listpic.get(0).getPic_no());
		
		return listpic;
	}
	

}
