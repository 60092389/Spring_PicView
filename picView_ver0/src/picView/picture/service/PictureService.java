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

import picView.member.model.Member;
import picView.member.model.MemberDao;
import picView.picture.model.Picture;
import picView.picture.model.PictureDao;
import picView.picture.model.UpdatePictureCommand;

@Service
public class PictureService {
		private PictureDao picDao;
		private MemberDao memDao;

		@Autowired
		public void setPicDao(PictureDao picDao) {
			this.picDao = picDao;
		}
				
		@Autowired
		public void setMemDao(MemberDao memDao) {
			this.memDao = memDao;
		}


		//날짜목록 가져오기
		public List<Picture> dateListPicture(int mem_no){
			
			List<Picture> list = picDao.PictureDate(mem_no);
			
			
			for(int i=0; i<list.size(); i++){			
				SimpleDateFormat test = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
				
				Timestamp a = list.get(i).getPic_date();				
				Date b = a;				
				String date = test.format(b);
				
				
				System.out.println("날짜 = "+date);	
				
				
				//System.out.println(year+"년 "+month+"월 "+day+"일");
				
			}			
			
			return picDao.PictureDate(mem_no);
		}
		
		//사진이 갖고 있는 년도 뽑아내서 중복된 년도는 하나만 가져가기
		public List<String> yearListPicture(int mem_no){
			
			List<String> list = picDao.PictureYear(mem_no);

			for(int i=0; i<list.size(); i++){
				System.out.println("년도 : "+list.get(i));
			}
			
			return list;
		}
		
		//사진이 갖고 있는 월 뽑아내서 중복된월은 하나만 가져가기
		public List<String> monthListPicture(int mem_no){
			
			List<String> list = picDao.PictureMonth(mem_no);

			for(int i=0; i<list.size(); i++){
				System.out.println("월수 : "+list.get(i));
			}

			return list;

		}
		
		//사진목록 가져오는 서비스
		public List<Picture> listPicture(int mem_no){
			return picDao.PictureList(mem_no);
		}
		
		public void updatePictureOpen(UpdatePictureCommand upc){
			Picture picture = new Picture();
			
			String pic_nos = upc.getPic_no();
			String[] array_picno = pic_nos.split(",");
			
			for(int i=0; i<array_picno.length; i++){
				int pic_no = Integer.parseInt(array_picno[i]);
				picture.setPic_open(upc.getPic_open());
				picture.setPic_no(pic_no);
				picDao.UpdatePictureOpen(picture);
			}
			
		}
		
		public void updatePictureInfo(UpdatePictureCommand upc){
			
			String pic_nos = upc.getPic_no();
			String[] array_picno = pic_nos.split(",");
			

			
			for(int i=0; i<array_picno.length; i++){
				int pic_no = Integer.parseInt(array_picno[i]);
				Picture picture = picDao.selectByPicno(pic_no);

				if(!upc.getPic_title().equals("")){
					picture.setPic_title(upc.getPic_title());
				}else{
					picture.setPic_title(picture.getPic_title());
				}				
				
				if(!upc.getPic_content().equals("")){
					picture.setPic_content(upc.getPic_content());
				}else{
					picture.setPic_content(picture.getPic_content());
				}			
				
				if(!upc.getPic_open().equals("0")){
					picture.setPic_open(upc.getPic_open());
				}else{
					picture.setPic_open(picture.getPic_open());
				}
				
				if(!upc.getPic_tag().equals("")){	
					
					if(picture.getTag_name() == null){						
						picture.setTag_name(upc.getPic_tag());
					}else{
						
						//중복된 태그명 제외하고 추가하기
						String tag_name = "";					
						
						String tag_check = picture.getTag_name();						
						String[] tag_check_arr = tag_check.split(",");
						
						List<String> list_tag_check = new ArrayList<String>();
						
						for(int j=0; j<tag_check_arr.length; j++){
							list_tag_check.add(tag_check_arr[j]);
						}
						
						String upc_tag_name = upc.getPic_tag();
						String[] upc_tag_arr = upc_tag_name.split(",");
						
						List<String> list_upc_tag = new ArrayList<String>();
						
						for(int j=0; j<upc_tag_arr.length; j++){
							list_upc_tag.add(upc_tag_arr[j]);
						}
						
						for(int p=0; p<list_tag_check.size(); p++){
							for(int j=0; j<list_upc_tag.size(); j++){
								if(list_tag_check.get(p).equals(list_upc_tag.get(j))){
									System.out.println("중복된 태그명 : "+list_upc_tag.get(j));
									list_upc_tag.remove(j);
								}
							}
						}
						
						for(int j=0; j<list_tag_check.size(); j++){
							tag_name += list_tag_check.get(j)+",";
						}
						for(int j=0; j<list_upc_tag.size(); j++){
							tag_name += list_upc_tag.get(j)+",";
						}
						
					
						picture.setTag_name(tag_name);
					//중복된 태그명 제외하고 추가하기 끝
					}					
					
				}else{					
					picture.setTag_name(picture.getTag_name());
				}				
				picDao.UpdatePictureInfo(picture);
			}
			
			
		}
		
		public void deletePicture(String pic_no,int mem_no){
			String[] pic_no_array = pic_no.split(",");
			
			for(int i=0; i<pic_no_array.length; i++){
				int pic_num = Integer.parseInt(pic_no_array[i]);
				picDao.DeletePicture(pic_num);
				memDao.minusPic_count(mem_no);
			}				
		}
		
		//채영
		//보여주기 사진 목록 서비스
		public List<Picture> myShowPicture(Picture picture){
				return picDao.myShowPicture(picture);
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
		public Member memInfo(int pic_no){
			return picDao.memInfo(pic_no);
		}
		
		// 상세보기 - 댓글 갯수
		public int rep_count(int pic_no){
			return picDao.rep_count(pic_no);
		}
		
		// 상세보기 - 사진 리스트
		public List<Picture> pic_list(int pic_no){
			return picDao.pic_list(pic_no);
		}
		
		// 상세보기 - 선택한 사진번호
		public int select_pic(String pic_add){
			return picDao.select_pic(pic_add);
		}
		
		// 상세보기 - 메인 사진
		public String main_pic(int pic_no){
			return picDao.main_pic(pic_no);
		}
		
		// 상세보기 끝
		
		
	
}
