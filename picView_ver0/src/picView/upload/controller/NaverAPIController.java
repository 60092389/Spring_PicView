package picView.upload.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import picView.upload.model.NaverSearch;
import picView.upload.service.DragAPIService;


@Controller
public class NaverAPIController {
	
	private DragAPIService service;
	
	
	@Autowired
	public void setService(DragAPIService service) {
		this.service = service;
	}

	@RequestMapping(value="/jsp/upload/map_api",method=RequestMethod.GET)
	public String get_map(){
		return "upload/view_trip";
	}
	
	@RequestMapping(value="/jsp/upload/map_post",method=RequestMethod.POST)
	public String map_api(@RequestParam String place,Model model) throws IOException{
		System.out.println("-----------------------");
		String search = place;
		String url ="";
		String search2= search.replaceAll(" ", "");
		
		try{
			
			url = "http://openapi.map.naver.com/api/geocode?key=63a683902e9d30dc3c7226cb1e57599f&encoding=euc-kr&coord=LatLng&output=json&query="+search2;
			
			System.out.println("url= " + url);
			URLEncoder.encode(search, "UTF-8");
			// java.net.URL
			URL urlAll = new URL(url);
			// Connection 객체를 InputStreamReader로 읽고 utf-8로 인코딩.
			InputStreamReader isr = new InputStreamReader(urlAll.openConnection().getInputStream(), "euc-kr");

			// org.json.simple.JSONObject 객체로 형변환
			JSONObject object = (JSONObject)JSONValue.parseWithException(isr);
			// 해당 객체에 담긴 key 값으로 원하는 데이터를 가져온다.
			JSONObject obj = (JSONObject) object.get("result");
			// item 배열
			JSONArray items = (JSONArray)obj.get("items");
			 
	            for(int i=0; i<items.size(); i++){
	               JSONObject personObject = (JSONObject) items.get(i);
	               JSONObject point = (JSONObject)personObject.get("point");
	               /*System.out.println(point.get("x"));
	               System.out.println(point.get("y"));*/
	               model.addAttribute("x", point.get("x").toString());
	               model.addAttribute("y", point.get("y").toString());
	               model.addAttribute("x_y", point.get("x").toString() +"," + point.get("y").toString());
	               model.addAttribute("address", personObject.get("address"));
	              
	            }
		}catch(UnsupportedEncodingException e){
			System.out.println(e);
		}catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	    return "upload/view_trip";
	}
	
	@RequestMapping(value="/jsp/upload/search_api",method=RequestMethod.POST)
	public String search_api(Model model,HttpServletRequest request){
		//XML를 제공하는 싸이트의 URL를 변수에 저장
		
		service.search_api(model,request);

		return "upload/popup_api";
	}
	
	@RequestMapping(value="/jsp/upload/test")
	public String test(ModelMap modelmap){
		System.out.println(modelmap.get("title"));
		return "upload/search";
	}
}
