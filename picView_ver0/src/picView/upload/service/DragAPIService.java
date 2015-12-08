package picView.upload.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import picView.upload.model.NaverSearch;
import picView.member.model.AuthInfo;
import picView.picture.model.Picture;
import picView.picture.model.PictureDao;

@Service
public class DragAPIService {
	
	//private UploadDao dao;
	
	private PictureDao dao;
	
	/*@Autowired
	public void setDao(UploadDao dao) {
		this.dao = dao;
	}*/
	
	@Autowired
	public void setDao(PictureDao dao) {
		this.dao = dao;
	}
	

	public void post_upload(MultipartHttpServletRequest multipartRequest, Picture picture, 
			HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
		
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int mem_no = authInfo.getMem_no();
		
		System.out.println("------------------------------------");
		System.out.println("제목=" + picture.getPic_title());
		 System.out.println("태그는????" + picture.getTag_name());
		 Iterator<String> itr =  multipartRequest.getFileNames();
	        while (itr.hasNext()) {
	        	
	        	MultipartFile mpf = multipartRequest.getFile(itr.next());
	        	//pic.add(mpf);
	            String originFileName = mpf.getOriginalFilename();
	            Calendar calendar = Calendar.getInstance();
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	            String newFileName = dateFormat.format(calendar.getTime()) + "_" +originFileName;
	            System.out.println("newFilename = " + newFileName);
	            int size = 20 * 1024 * 1024; //20mb
	            String uploadPath = request.getRealPath("upload");
	            mpf.transferTo(new File(uploadPath,newFileName));
	              picture.setPic_add(newFileName);
	        	  picture.setMem_no(mem_no);
	        	  picture.setGood_count(0);
	        	  picture.setPic_count(0);
	        	  System.out.println(picture.toString());
	        	  picture.setPic_color("red");
	        	  dao.insertPicture(picture);
	        }
	}

	public void search_api(Model model,HttpServletRequest request){
		String urlString="";
		NaverSearch naver = null;
		
		try{
			String[]  search_category = request.getParameterValues("category_chk");
			String[]  search_chk = request.getParameterValues("search");
			String target = "";
			String search_word = "";
			for(int i=0;i<search_category.length;i++){
				target = search_category[i];
		    }	
			for(int i=0;i<search_chk.length;i++){
				search_word = search_chk[i];
		    }	
			urlString= "http://openapi.naver.com/search?key=cb7e429c8b584c3bf57c9bc93fc48768&query="+search_word+"&target="+target;
		
			System.out.println(urlString);
			
			URL url = new URL(urlString);
			List<NaverSearch> final_list  = new ArrayList<NaverSearch>();
			URLConnection URLconnection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection)URLconnection;
			
			int responseCode = httpConnection.getResponseCode();
			if(responseCode ==HttpURLConnection.HTTP_OK){
				InputStream in = httpConnection.getInputStream();
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(in);
				
				Element root = doc.getDocumentElement();
				Node channelNode = doc.getElementsByTagName("channel").item(0);
				NodeList list = channelNode.getChildNodes();
				System.out.println(channelNode.getChildNodes());
				for(int i=0;i<list.getLength();i++){
					naver = new NaverSearch();
					
					naver.setTarget(target);
					if(list.item(i).getNodeName().equals("item")){
						NodeList list2 = list.item(i).getChildNodes();
						
						for(int j=0;j<list2.getLength();j++){
							String content = list2.item(j).getTextContent();
		           				content = content.replaceAll("\n", "");
		           				content = content.replaceAll("<b>", "");
		           				content = content.replaceAll("</b>", "");
		           				if(target.equals("book")){
		           			 	
			           				if(list2.item(j).getNodeName().equals("title")){
			           					naver.setTitle(content);
			           				}
			           				if(list2.item(j).getNodeName().equals("image")){
			           					naver.setImage(content);
			           				}
			           				if(list2.item(j).getNodeName().equals("author")){
			           					naver.setAuthor(content);
			           				}
			           				if(list2.item(j).getNodeName().equals("price")){
			           					naver.setPrice(content);
			           				}
			           				if(list2.item(j).getNodeName().equals("publisher")){
			           					naver.setPublisher(content);
			           				}
			           				if(list2.item(j).getNodeName().equals("pubdate")){
			           					naver.setPubdate(content);
			           				}
			           				if(list2.item(j).getNodeName().equals("description")){
			           					naver.setDescription(content);
			           				}
		           				}else if(target.equals("encyc")){
		           					if(list2.item(j).getNodeName().equals("title")){
		           						System.out.println(" title= " + list2.item(j).getTextContent());
			           					naver.setTitle(content);
			           				}
		           					if(list2.item(j).getNodeName().equals("description")){
		           						System.out.println(" description= " + list2.item(j).getTextContent());
			           					naver.setDescription(content);
			           				}
		           					if(list2.item(j).getNodeName().equals("thumbnail")){
		           						System.out.println(" thumbnail= " + list2.item(j).getTextContent());
			           					naver.setImage(content);
			           				}
		           				}
		           				
						}//안 for문 끝
						final_list.add(naver);
					}
				}//바깥 for문 끝
				model.addAttribute("final_list", final_list);
				
				for(int i=0;i<final_list.size();i++){
					System.out.println("책번호 " + i +"   " + final_list.get(i).toString());
				}
			}
		}catch (Exception e) {
	        e.printStackTrace();
        }
		
		
	}
}
