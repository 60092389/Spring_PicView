package picView.upload.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class fileUploadForm implements Serializable{
	private MultipartHttpServletRequest multi;
	//private List<MultipartFile> uploadfile_drag;

	public MultipartHttpServletRequest getMulti() {
		return multi;
	}

	public void setMulti(MultipartHttpServletRequest multi) {
		this.multi = multi;
	}

	
	
}
