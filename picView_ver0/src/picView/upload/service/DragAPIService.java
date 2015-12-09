package picView.upload.service;

import java.awt.image.BufferedImage;
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

import javax.imageio.ImageIO;
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
	            String color_Name = uploadPath + "\\"+newFileName;
	            
	            
	            mpf.transferTo(new File(uploadPath,newFileName));
	            
	            BufferedImage image = null;
	            
	            try {
	                image = ImageIO.read(new File(color_Name));
	            } catch (IOException e) {
	                throw e;
	            }
	            
	            int width = image.getWidth();
	            int height = image.getHeight();
	            
	            System.out.println("width, height : " + width + ", " + height);

	            ArrayList list = new ArrayList();
	            
	          
	            
	            for(int i=0;i<width;i++){
	            	for(int j=0;j<height;j++){
	            		list.add(image.getRGB(i, j));
	            	}
	            }
	            System.out.println(list.size());
	            int r[] = new int[list.size()]; 
	            int g[] = new int[list.size()];
	            int b[] = new int[list.size()];
	            
	            int pix;
	            	//빨, 갈, 주, 분, 노, 연, 초, 하늘, 파, 보, 핫핑, 흰, 회, 검
	            int cnt_R=0,cnt_BR=0,cnt_O=0,cnt_P=0,cnt_Y=0,cnt_YG=0,cnt_G=0,cnt_S=0,
	            		cnt_B=0,cnt_V=0,cnt_HP=0,cnt_H=0,cnt_GR=0,cnt_BA=0;
	            
	            for(int i=0;i<list.size();i++){
	            	pix = (int) list.get(i);
	            	r[i] = (pix >> 16) & 0xff;
	            	g[i] = (pix >> 8) & 0xff;
	            	b[i] = (pix) & 0xff;
	            	
	            	int cR= r[i], cG = g[i] , cB = b[i];
	            	
	            	//초록
	            	if((cR<=140 && cG>=150 && cG<=200 && cB<=130) ||
	            			(cR<140 && cG>=220 && cB<=100)) {
	            		cnt_G++;
	            	}
	            	//노랑
	            	if((cR>=240 && cG>=220 && cB<=150) ||
	            			(cR>=220 && cG>=210 && cG<=240 && cB<=150)||
	            			(cR>=200 && cG>=170 && cG<=200 && cB<=70)){
	             		cnt_Y++;
	            	}
	            	//흰색
	            	if(cR>=220 && cG>=220 && cB>=220){
	            		cnt_H++;
	            	}
	            	//회색
	            	if(cR>=60 && cR<=220){
	            		if(cR==cG&&cR==cB&&cG==cB){
	            			cnt_GR++;
	            		}
	            	}
	            	//검정
	            	if(cR<=10 && cG<=10 && cB<=10){
	            		cnt_BA++;
	            	}
	            	
	            	//분홍
	            	if((cR==255 && cG>=160 && cG<=210 && cB>=160 && cB<=230)||
	            			(cR>=210 && cR<=255 && cG>=110 && cG<=180 && cB>=110 && cB<=180)){
	            		cnt_P++;
	            	}
	            	
	            	//빨강
	            	if(cR>=230 && cR<=255 && cG>=0 && cG<=60 && cB>=0 && cB<=80){
	            		cnt_R++;
	            	}
	            	//하늘
	            	if((cR>=10 && cR<=25 && cG>=180 && cG<=190 && cB>=200) ||
	            			(cR>=60 && cR<=120 && cG>=180 && cG<=230 && cB>=220 && cB<=255)){
	            		cnt_S++;
	            	}
	            	//파랑
	            	if((cR<=50 && cG<=60 && cB>=150 && cB<=255)||
	            			(cR<=60 && cG<=130 && cB>=150 && cB<=255)){
	            		cnt_B++;
	            	}
	            	//갈색
	            	if(cR>=120 && cR<=200 && cG>=50 && cG<=80 && cB<=50){
	            		cnt_BR++;
	            	}
	            	//보라
	            	if((cR>=130 && cR<=210 && cG<=60 && cB>=200 && cB<=255)||
	            			(cR>=120 && cR<=150 && cG<=100 && cB>=130 &&cB<200)){
	            		cnt_V++;
	            	}
	            	//연두
	            	if((cR>140 && cR<=170 && cG>=200 && cB<=80)||
	            			(cR>=170 && cR<=210 && cG>=220 && cB<=150)){
	            		cnt_YG++;
	            	}
	            	//핫핑크
	            	if(cR>=200 && cG<=100 && cB>=130 && cB<=170){
	            		cnt_HP++;
	            	}
	            	//주황
	            	if(cR>=230 && cG>=120 && cG<=180 && cB<=50){
	            		cnt_O++;
	            	}
	            }
	            
	            int[] allColor = {cnt_R,cnt_BR,cnt_O,cnt_P,cnt_Y,cnt_YG,cnt_G,cnt_S,
	            		cnt_B,cnt_V,cnt_HP,cnt_H,cnt_BA,cnt_GR}; 
	            
	            String[] colorName={"red", "brown", "orange", "pink", "yellow",
	            		"yGreen", "green", "sky", "blue", "violet",
	            		"hotPink", "white", "black", "gray"};
	           
	            //내림차순 정렬
	            int cnt = allColor.length;
	            for(int i=0; i<(cnt-1); i++){
	    			for(int j=i+1; j<cnt; j++){
	    				if(allColor[i]  < allColor[j]){
	    					int temp=allColor[i];
	    					allColor[i]=allColor[j];
	    					allColor[j]=temp;
	    					
	    					//색상 정렬
	    					String colorTemp = colorName[i];
	    					colorName[i] = colorName[j];
	    					colorName[j] = colorTemp;
	    				}
	    			}
	    		}
	            for(int sort:allColor){
	            	System.out.print(sort+"\t");
	            }
	            System.out.println();
	            for(String sort:colorName){
	            	System.out.print(sort+"\t");
	            }
	            
	            picture.setPic_add(newFileName);
	            picture.setMem_no(mem_no);
	        	picture.setGood_count(0);
	        	picture.setPic_count(0);
	        	picture.setPic_color(color(colorName, allColor));
	        	dao.mem_pic_count(mem_no);//사진 갯수 증가
	        	dao.insertPicture(picture);
	        }
	}
	public static String color(String[] colorName, int[] allColor){
		String color[] = new String[3];
		
		for(int i=0;i<3;i++){
			color[i] = colorName[i];
			if(allColor[i]==0){
				color[i]="";
			}
		}
		
		String total_color = color[0]+","+color[1]+","+color[2];
	
		System.out.println("색깔?????????????" + total_color);
		return total_color;
	}

	public void search_api(Model model,HttpServletRequest request){
		String urlString="";
		NaverSearch naver = null;
		
		try{
			String target = request.getParameter("target");
			String  search_word = request.getParameter("search");
			String display="";
			if(target.equals("book")){
				display = "10";
			}else{
				display = "5";
			}
			
			System.out.println("target === " + target);
			
			System.out.println("search_word = " + search_word);
			urlString= "http://openapi.naver.com/search?key=cb7e429c8b584c3bf57c9bc93fc48768&query="+search_word+"&display="+display+"&target="+target;
		
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
		           				System.out.println("target =====" + target);
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
			           					naver.setPerson_title(content);
			           				}
		           					if(list2.item(j).getNodeName().equals("description")){
		           						System.out.println(" description= " + list2.item(j).getTextContent());
			           					naver.setPerson_description(content);
			           				}
		           					if(list2.item(j).getNodeName().equals("thumbnail")){
		           						System.out.println(" thumbnail= " + list2.item(j).getTextContent());
			           					naver.setPerson_image(content);
			           				}
		           				}else if(target.equals("image")){
		           					if(list2.item(j).getNodeName().equals("title")){
		           						System.out.println(" title= " + list2.item(j).getTextContent());
			           					naver.setImage_title(content);
			           				}
		           					
		           					if(list2.item(j).getNodeName().equals("thumbnail")){
		           						System.out.println(" thumbnail= " + list2.item(j).getTextContent());
			           					naver.setImage_thumbnail(content);
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
