package picView.picture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.picture.model.Picture;
import picView.picture.model.PictureDao;

@Service
public class PictureService {
		private PictureDao picDao;

		@Autowired
		public void setPicDao(PictureDao picDao) {
			this.picDao = picDao;
		}
		
		//날짜목록 가져오기
		public List<Picture> dateListPicture(int mem_no){
			return picDao.PictureDate(mem_no);
		}
		
		//사진목록 가져오는 서비스
		public List<Picture> listPicture(int mem_no){
			return picDao.PictureList(mem_no);
		}
	
}
