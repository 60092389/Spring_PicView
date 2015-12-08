package picView.upload.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import picView.upload.model.KoreaSearch;

@Controller
public class KoreaAPIController {
	
	@RequestMapping(value="/jsp/upload/korea_api",method=RequestMethod.POST)
	public String korea_api(@RequestParam String search,Model model) throws IOException{
		//XML를 제공하는 싸이트의 URL를 변수에 저장
		System.out.println("----------------------");
		
		String urlString="";
		String search_word = search;
		String search2= search_word.replaceAll(" ", "");
		String search_Key = URLEncoder.encode(search2,"UTF-8");
		KoreaSearch korea = null;
		try {
			urlString= "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?ServiceKey=prxzVMGoac8WetBnOWKoD6amOqXpYg1AEWwTW7m2%2BT40LKjEuJzEbOgNrXpfY5nEyDpBhqkgUYfAFcJLJUucMg%3D%3D&keyword="+search_Key+"&areaCode=&sigunguCode=&cat1=&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A";
			
			URL url = new URL(urlString);
			List<KoreaSearch> final_list  = new ArrayList<KoreaSearch>();
			URLConnection URLconnection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection)URLconnection;
			
			int responseCode = httpConnection.getResponseCode();
			if(responseCode ==HttpURLConnection.HTTP_OK){
				InputStream in = httpConnection.getInputStream();
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(in);
				
				Element root = doc.getDocumentElement();
				System.out.println("최상위=" + root.getNodeName());
				
				Node channelNode = doc.getElementsByTagName("body").item(0).getFirstChild();
				
				NodeList list = channelNode.getChildNodes();
				for(int i=0;i<list.getLength();i++){
					korea = new KoreaSearch();
					korea.setFirstimage("");
					if(list.item(i).getNodeName().equals("item")){
						NodeList list2 = list.item(i).getChildNodes();
						for(int j=0;j<list2.getLength();j++){
							
							System.out.println("j= " + j + " content= " + list2.item(j).getTextContent()+" i=" + i );
							String content = list2.item(j).getTextContent();
		           				System.out.println("name:"+list2.item(j).getNodeName() + "value:"+content);
		           				content = content.replaceAll("\n", "");
		           				content = content.replaceAll("<b>", "");
		           				content = content.replaceAll("</b>", "");
		           				
		           			 	
		           				if(list2.item(j).getNodeName().equals("addr1")){
		           					korea.setAddr1(content);
		           				}
		           				if(list2.item(j).getNodeName().equals("addr2")){
		           					korea.setAddr2(content);
		           				}
		           				if(list2.item(j).getNodeName().equals("contentid")){
		           					korea.setContentid(content);
		           				}
		           				if(list2.item(j).getNodeName().equals("contenttypeid")){
		           					korea.setContenttypeid(content);
		           				}
		           				if(list2.item(j).getNodeName().equals("firstimage")){
		           					korea.setFirstimage(content);
		           				}
		           				if(list2.item(j).getNodeName().equals("title")){
		           					korea.setTitle(content);
		           				}
		           				
		           				
						}//안 for문 끝
						final_list.add(korea);
					}
				}//바깥 for문 끝
				model.addAttribute("final_list", final_list);
				
				for(int i=0;i<final_list.size();i++){
					System.out.println("정보 " + i +"   " + final_list.get(i).toString());
				}
				
			}
			
			
			
			
        } catch (Exception e) {
	        e.printStackTrace();
        }

		return "upload/korea_api";
	}
}
