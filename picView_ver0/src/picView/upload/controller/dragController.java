package picView.upload.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartHttpServletRequest;


import picView.picture.model.Picture;
import picView.upload.model.fileUploadForm;
import picView.upload.service.DragAPIService;

@Controller
public class dragController {
	private String uploadDir = "upload";
	private List<String> file = new ArrayList<String>();
	
	private List<MultipartHttpServletRequest> pic = new ArrayList<MultipartHttpServletRequest>();
	
	fileUploadForm uploadform = new fileUploadForm();
	
	private DragAPIService service;
	
	@Autowired
	public void setService(DragAPIService service) {
		this.service = service;
	}

	@RequestMapping(value = "/jsp/upload/fileUpload", method = RequestMethod.GET)
    public String dragAndDrop() {
        return "upload/upload";
         
    }
	 
	 @RequestMapping(value = "/jsp/upload/fileUpload_submit",method=RequestMethod.POST) 
	    public String post_upload(MultipartHttpServletRequest multipartRequest,Picture picture,HttpServletRequest request) throws IllegalStateException, IOException{ 
		 service.post_upload(multipartRequest,picture,request);
	
		  return "redirect:/jsp/myRoom/manageForm";
	 }
	 
	 
	
	 
}
