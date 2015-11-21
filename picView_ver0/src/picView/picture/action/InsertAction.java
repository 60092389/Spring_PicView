package picView.picture.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.swing.ImageIcon;

import jdk.nashorn.internal.parser.JSONParser;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.prism.Image;

import picView.picture.action.Action;
import picView.picture.action.ActionForward;
import picView.picture.model.ImageUtil;
import picView.picture.model.Picture;
import picView.picture.model.PictureDao;

public class InsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String uploadPath = request.getRealPath("upload");
		int size= 20 * 1024 * 1024;
		System.out.println("글제목: " + request.getParameter("title"));
		MultipartRequest multi = 
				new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
			Picture picture = new Picture();
			String b_fname = multi.getFilesystemName("files[]");
			response.setContentType("application/json");
			String f_name = uploadPath + "\\" +b_fname;   
		    File src = new File(f_name);	
		    ImageUtil.resize(src);
		    
		    System.out.println("사진제목= " + multi.getParameter("title"));
		    System.out.println("사진내용= " + multi.getParameter("content"));
		    System.out.println("태그= " + multi.getParameter("tag"));
		    System.out.println("회원번호= " + multi.getParameter("mem_no"));
		    System.out.println("카테고리번호= " + multi.getParameter("category"));
		    
		    
		    
			picture.setPic_title(multi.getParameter("title")); //사진제목
			picture.setPic_content(multi.getParameter("content")); //사진내용
			picture.setTag_name(multi.getParameter("tag")); //태그
			picture.setPic_add(b_fname); //사진경로
			picture.setMem_no(Integer.parseInt(multi.getParameter("mem_no")));//회원번호
			picture.setCategory_no(Integer.parseInt(multi.getParameter("category")));//카테고리번호
			picture.setPic_info_1(""); //추가정보1
			picture.setPic_info_2(""); //추가정보2
			picture.setPic_info_3(""); //추가정보3
			picture.setPic_open("");   //사진 공개범위
			
			JSONObject jsono = new JSONObject();
	        jsono.put("name", f_name);
	        jsono.put("size",  b_fname.length());
	        jsono.put("url", f_name);
	        jsono.put("thumbnail_url", f_name);
	        jsono.put("delete_url", f_name);
	        jsono.put("delete_type", "POST");
	        jsono.put("data", f_name);
	        String str = jsono.toString();
	         
	        System.out.println(str);     
	        response.getWriter().print(str);
	        
	        PictureDao dao = PictureDao.getInstance();
	        
	        int re = dao.insertPicture(picture);
			ActionForward forward = new ActionForward();
	        forward.setPath("jsp/myRoom/my_Manage.html");
	        forward.setReDirect(false);
			return forward;
	}

}



