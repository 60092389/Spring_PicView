package picView.cate.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.imageio.plugins.common.ImageUtil;

import picView.cate.model.Category;
import picView.cate.model.CategoryDao;
import picView.member.service.Action;
import picView.member.service.ActionForward;

public class insertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Category cate = new Category();
		
		//upload 폴더의 경로
		String uploadPath = request.getRealPath("upload");
		//20mb의 파일을 담을 수 있게하기
		int size = 20 * 1024 * 1024;
		
		//파일을 upload 받기위한 request 객체
		MultipartRequest multi = new MultipartRequest(request, 
				uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		String category_name = multi.getParameter("category_name");
		String category_seq_string = multi.getParameter("category_seq");
		int category_seq = 0;
		
		if(!category_seq_string.equals(null)){
			category_seq = Integer.parseInt(category_seq_string);
		}
		
		if(multi.getFilesystemName("category_img_add") != null){
			String category_img_add = multi.getFilesystemName("category_img_add");
			cate.setCategory_img_add(category_img_add);
			
			String pattern = category_img_add.substring(category_img_add.lastIndexOf(".")+1);
			String headName = category_img_add.substring(0, category_img_add.lastIndexOf("."));
			
			String imagePath = uploadPath + "\\" + category_img_add;
			File src = new File(imagePath);
			
			String thumImagePath = uploadPath + "\\" + headName + "_small."+pattern;
			File dest = new File(thumImagePath);
			
			//썸네일 생성
			if(pattern.equals("jpg") || pattern.equals("gif") || pattern.equals("png")){
				picView.cate.model.ImageUtil.resize(src, dest, 100, picView.cate.model.ImageUtil.RATIO);
			}
			
		}else{
			cate.setCategory_img_add("");
		}
		
		
		
		cate.setCategory_name(category_name);
		cate.setCategory_seq(category_seq);
		
		CategoryDao dao = CategoryDao.getInstatnce();
		
		int re = dao.insertCategory(cate);
		
		ActionForward forward = new ActionForward();
		
		if(re == 1){
			forward.setReDirect(true);
			forward.setPath("category_Admin.html");
		}else{
			forward.setReDirect(true);
			forward.setPath("category_Admin.html");
		}
		
		return forward;
	}

}
