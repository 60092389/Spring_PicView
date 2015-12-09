package picView.picture.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.perc.PercInstantiator;
import org.springframework.stereotype.Service;

import picView.album.model.AlbumDao;
import picView.album.model.Group_Pic;
import picView.follow.model.Follow;
import picView.follow.model.FollowDao;
import picView.member.model.Member;
import picView.member.model.MemberDao;
import picView.picture.mapper.PictureMapper;
import picView.picture.model.AlbumInfo;
import picView.picture.model.Picture;
import picView.picture.model.PictureDao;
import picView.picture.model.PictureShow;
import picView.picture.model.RecentPicture;
import picView.picture.model.ReplyCount;
import picView.picture.model.UpdatePictureCommand;
import picView.reply.model.ReplyDao;

@Service
public class PictureService {
	private PictureDao picDao;
	private MemberDao memDao;
	private FollowDao followDao;
	private AlbumDao albumDao;
	private ReplyDao replyDao;

	private static final int PAGE_SIZE = 6;

	@Autowired
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Autowired
	public void setPicDao(PictureDao picDao) {
		this.picDao = picDao;
	}

	@Autowired
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}

	@Autowired
	public void setFollowDao(FollowDao followDao) {
		this.followDao = followDao;
	}

	@Autowired
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	// 날짜목록 가져오기
	public List<Picture> dateListPicture(int mem_no) {

		List<Picture> list = picDao.PictureDate(mem_no);

		for (int i = 0; i < list.size(); i++) {
			SimpleDateFormat test = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);

			Timestamp a = list.get(i).getPic_date();
			Date b = a;
			String date = test.format(b);

			/* System.out.println("날짜 = "+date); */

			// System.out.println(year+"년 "+month+"월 "+day+"일");

		}

		return picDao.PictureDate(mem_no);
	}

	// 사진이 갖고 있는 년도 뽑아내서 중복된 년도는 하나만 가져가기
	public List<String> yearListPicture(int mem_no) {

		List<String> list = picDao.PictureYear(mem_no);

		for (int i = 0; i < list.size(); i++) {
			/* System.out.println("년도 : "+list.get(i)); */
		}

		return list;
	}

	// 사진이 갖고 있는 월 뽑아내서 중복된월은 하나만 가져가기
	public List<String> monthListPicture(int mem_no) {

		List<String> list = picDao.PictureMonth(mem_no);

		for (int i = 0; i < list.size(); i++) {
			/* System.out.println("월수 : "+list.get(i)); */
		}

		return list;

	}

	// 사진목록 가져오는 서비스
	public List<Picture> listPicture(int mem_no) {

		System.out.println("-----------listPicture 서비스--------------");

		return picDao.PictureList(mem_no);
	}

	public void updatePictureOpen(UpdatePictureCommand upc) {
		Picture picture = new Picture();

		String pic_nos = upc.getPic_no();
		String[] array_picno = pic_nos.split(",");

		for (int i = 0; i < array_picno.length; i++) {
			int pic_no = Integer.parseInt(array_picno[i]);
			picture.setPic_open(upc.getPic_open());
			picture.setPic_no(pic_no);
			picDao.UpdatePictureOpen(picture);
		}

	}

	public void updatePictureInfo(UpdatePictureCommand upc) {

		String pic_nos = upc.getPic_no();
		String[] array_picno = pic_nos.split(",");

		for (int i = 0; i < array_picno.length; i++) {
			int pic_no = Integer.parseInt(array_picno[i]);
			Picture picture = picDao.selectByPicno(pic_no);

			if (!upc.getPic_title().equals("")) {
				picture.setPic_title(upc.getPic_title());
			} else {
				picture.setPic_title(picture.getPic_title());
			}

			if (!upc.getPic_content().equals("")) {
				picture.setPic_content(upc.getPic_content());
			} else {
				picture.setPic_content(picture.getPic_content());
			}

			if (!upc.getPic_open().equals("0")) {
				picture.setPic_open(upc.getPic_open());
			} else {
				picture.setPic_open(picture.getPic_open());
			}

			if (!upc.getPic_tag().equals("")) {

				if (picture.getTag_name() == null) {
					picture.setTag_name(upc.getPic_tag());
				} else {

					// 중복된 태그명 제외하고 추가하기
					String tag_name = "";

					String tag_check = picture.getTag_name();
					String[] tag_check_arr = tag_check.split(",");

					List<String> list_tag_check = new ArrayList<String>();

					for (int j = 0; j < tag_check_arr.length; j++) {
						list_tag_check.add(tag_check_arr[j]);
					}

					String upc_tag_name = upc.getPic_tag();
					String[] upc_tag_arr = upc_tag_name.split(",");

					List<String> list_upc_tag = new ArrayList<String>();

					for (int j = 0; j < upc_tag_arr.length; j++) {
						list_upc_tag.add(upc_tag_arr[j]);
					}

					for (int p = 0; p < list_tag_check.size(); p++) {
						for (int j = 0; j < list_upc_tag.size(); j++) {
							if (list_tag_check.get(p).equals(list_upc_tag.get(j))) {
								System.out.println("중복된 태그명 : " + list_upc_tag.get(j));
								list_upc_tag.remove(j);
							}
						}
					}

					for (int j = 0; j < list_tag_check.size(); j++) {
						tag_name += list_tag_check.get(j) + ",";
					}
					for (int j = 0; j < list_upc_tag.size(); j++) {
						tag_name += list_upc_tag.get(j) + ",";
					}

					picture.setTag_name(tag_name);
					// 중복된 태그명 제외하고 추가하기 끝
				}

			} else {
				picture.setTag_name(picture.getTag_name());
			}
			picDao.UpdatePictureInfo(picture);
		}

	}

	public void deletePicture(String pic_no, int mem_no) {
		String[] pic_no_array = pic_no.split(",");

		for (int i = 0; i < pic_no_array.length; i++) {
			int pic_num = Integer.parseInt(pic_no_array[i]);

			List<Integer> alb_no_list = albumDao.GroupPicList_By_Pic_no(pic_num);
			for (int j = 0; j < alb_no_list.size(); j++) {
				int alb_no = alb_no_list.get(j);
				Group_Pic group_pic = new Group_Pic();

				if (albumDao.GroupPic_AlbNo_count_By_Alb_no(alb_no) == 1) {
					System.out.println("사진이 소속되있는 앨범에 사진이 하나");
					group_pic.setPic_no(pic_num);
					group_pic.setAlb_no(alb_no);

					albumDao.DeletePicture_In_Album(group_pic);// pic_num에 해당하는
																// Group_pic테이블
																// 값 삭제
					albumDao.deleteAlbum(alb_no);// 지우려는 사진이 그앨범의 유일한 사진이면 앨범도
													// 삭제

				} else if (albumDao.GroupPic_AlbNo_count_By_Alb_no(alb_no) != 1) {
					group_pic.setPic_no(pic_num);
					group_pic.setAlb_no(alb_no);
					albumDao.DeletePicture_In_Album(group_pic);
				}

			}
			picDao.DeletePicture(pic_num);
			memDao.minusPic_count(mem_no);

		}
	}

	// 채영
	// 보여주기 사진 목록 서비스
	public PictureShow myShowPicture(Picture picture, int mem_no) {
		PictureShow pic_show = new PictureShow();
		int relation = -1;
		List<Picture> pic_list = new ArrayList<Picture>();

		int fri_no = picture.getMem_no();

		Follow follow = new Follow();
		follow.setFollow_fri_no(fri_no);
		follow.setMem_no(mem_no);
		List<Follow> fol_list = followDao.followCheck(follow);

		System.out.println("서비스 접속한 사람 : " + mem_no);
		System.out.println("서비스 접속한페이지의 주인 : " + fri_no);

		// 내가 나의페이지를 들어왔을때
		if (fri_no == mem_no) {
			pic_list = picDao.myShowPicture(picture);
			relation = 1;// 나자신일때
			pic_show.setPic_list(pic_list);
			pic_show.setRelation(relation);
		} else {
			System.out.println("주인과 접속자가 다를 때 else문");

			if (fol_list.size() == 0) {
				picture.setPic_open("open");
				relation = 5; // 아무관계아닐때

				System.out.println("아무관계 아닐때");

				pic_list = picDao.myShowPicture(picture);
				pic_show.setPic_list(pic_list);
				pic_show.setRelation(relation);
			}

			for (int i = 0; i < fol_list.size(); i++) {
				System.out.println("fol_list 불러오기 " + i);
				if (fol_list.get(i).getMem_no() == mem_no && fol_list.get(i).getFollow_check().equals("1")) {
					picture.setPic_open("open");
					relation = 2; // 나만 상대방 팔로우

					System.out.println("나만 상대방 팔로우");

					pic_list = picDao.myShowPicture(picture);
					pic_show.setPic_list(pic_list);
					pic_show.setRelation(relation);
				}
				if (fol_list.get(i).getMem_no() == mem_no && fol_list.get(i).getFollow_check().equals("2")) {
					picture.setPic_open("open");
					relation = 3; // 상대방만 나 팔로우

					System.out.println("상대방만 나 팔로우");

					pic_list = picDao.myShowPicture(picture);
					pic_show.setPic_list(pic_list);
					pic_show.setRelation(relation);
				}
				if (fol_list.get(i).getMem_no() == mem_no && fol_list.get(i).getFollow_check().equals("3")) {
					picture.setPic_open("friend");
					relation = 4; // 맞팔상태(친구)

					System.out.println("맞팔 상태");

					pic_list = picDao.myShowPicture(picture);
					pic_show.setPic_list(pic_list);
					pic_show.setRelation(relation);

				}

			}
		}

		System.out.println("가져온 픽리스트의 제목들!");
		for (int i = 0; i < pic_list.size(); i++) {
			System.out.println(pic_list.get(i).getPic_title());
		}

		return pic_show;
	}

	public List<ReplyCount> myShowReply_count(List<Picture> myShowList) {
		List<Integer> count = new ArrayList<Integer>();
		List<ReplyCount> rep_count = new ArrayList<ReplyCount>();

		System.out.println("서비스 마이쇼리스트 사이즈 : " + myShowList.size());

		for (int i = 0; i < myShowList.size(); i++) {

			int pic_no = myShowList.get(i).getPic_no();

			count.add(replyDao.myShowReply_count(pic_no));
			ReplyCount replyCount = new ReplyCount(count.get(i), pic_no);
			rep_count.add(replyCount);
		}

		return rep_count;
	}

	// 상세보기 시작

	// 상세보기 사진 정보
	public Picture detailPicture(int pic_no) {
		return picDao.detailPicture(pic_no);
	}

	// 상세보기 - 태그들
	public String tag_list(int pic_no) {
		return picDao.tag_list(pic_no);
	}

	// 상세보기 - 회원정보(이름, 프로필 사진)
	public Member memInfo(int pic_no) {
		return picDao.memInfo(pic_no);
	}

	// 상세보기 - 댓글 갯수
	public int rep_count(int pic_no) {
		return picDao.rep_count(pic_no);
	}

	// 상세보기 - 사진 리스트
	public List<Picture> pic_list(int pic_no) {
		return picDao.pic_list(pic_no);
	}

	// 상세보기 - 선택한 사진번호
	public int select_pic(String pic_add) {
		return picDao.select_pic(pic_add);
	}

	// 상세보기 - 메인 사진
	public String main_pic(int pic_no) {
		return picDao.main_pic(pic_no);
	}

	// 상세보기 - 좋아요
	public int findGood(int pic_no) {
		return picDao.findGood(pic_no);
	}

	// 상세보기 - 카테고리
	public String findCategory(int pic_no) {
		return picDao.findCategory(pic_no);
	}

	// 상세보기 - 앨범 개수
	public int findAlbum_count(int pic_no) {
		return picDao.findAlbum_count(pic_no);
	}

	// 상세보기 - 앨범 이미지
	public List<String> findAlbum_pic_add(int pic_no) {
		return picDao.findAlbum_pic_add(pic_no);
	}

	// 상세보기 - 앨범 이름
	public List<String> findAlbum_name(int pic_no) {
		return picDao.findAlbum_name(pic_no);
	}

	// 상세보기 - 앨범에 속한 사진 개수
	public List<Integer> findAlbum_pic_count(int pic_no) {
		return picDao.findAlbum_pic_count(pic_no);
	}

	// 상세보기 - 앨범 정보
	public List<AlbumInfo> findAlbum(int pic_no) {
		AlbumInfo albumInfo = new AlbumInfo();
		albumInfo.setPic_add(picDao.findAlbum_pic_add(pic_no));
		albumInfo.setAlb_name(picDao.findAlbum_name(pic_no));
		albumInfo.setAlb_pic_count(picDao.findAlbum_pic_count(pic_no));

		findAlbum(pic_no).add(albumInfo);

		return findAlbum(pic_no);
	}

	// 상세보기 - 조회수 업데이트
	public int update_count(Picture picture) {
		return picDao.update_count(picture);
	}

	// 상세보기 끝

	// 최근사진 보기
	public RecentPicture recent_Pic(int requestPage) {
		int totalCount = picDao.count_Recent();

		int totalPageCount = totalCount / PAGE_SIZE;
		if (totalPageCount % PAGE_SIZE > 0) {// 나머지 글 갯수가 있다면 한페이지 더 추가해주기
			totalPageCount++;
		}
		int startPage = requestPage - (requestPage - 1) % 5;
		int endPage = startPage + 4;

		if (endPage > totalPageCount) {
			endPage = totalPageCount; // 만약 totalPageCount는 7까지인데 endPage는 10이
										// 나오면 8,9,10은
										// 보여줄게 없으므로 totalPageCount와 같게 만들어줘야함
		}
		List<Picture> list = picDao.recent_Pic((requestPage - 1) * PAGE_SIZE);
		return new RecentPicture(list, requestPage, totalPageCount, startPage, endPage);
	}

	public int count_Recent() {
		return picDao.count_Recent();
	}

}
