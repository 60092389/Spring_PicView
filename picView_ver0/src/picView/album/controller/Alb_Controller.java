package picView.album.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import picView.album.model.Album;
import picView.album.model.CommandAlbum;
import picView.album.model.Group_Pic;
import picView.album.service.AlbumService;
import picView.picture.model.Picture;

@Controller
public class Alb_Controller {

	AlbumService service;

	@Autowired
	public void setService(AlbumService service) {
		this.service = service;
	}

	@RequestMapping("/jsp/myRoom/my_album")
	// mem_no를 세션값 유지하면서 가져다닌다는 가정하에 request 사용
	public String my_alb(Model model) {
		int mem_no = 1;
		model.addAttribute("mem_no", mem_no);
		// 여기서 앨범 리스트가 출력되야함
		List<Album> albumlist = service.albumlist(mem_no);
		List<String> albumpiclist = service.albumpiclist(mem_no);
		model.addAttribute("albumpiclist", albumpiclist);
		model.addAttribute("albumlist", albumlist);

		return "myRoom/my_album";
	}

	@RequestMapping("/jsp/myRoom/album_add")
	public String alb_add(Model model, @RequestParam int mem_no, @RequestParam String getalb_word) {
		
		model.addAttribute("mem_no", mem_no);
		model.addAttribute("getalb_word", getalb_word);
		
		// 사진리스트 출력
		List<Picture> listpic = service.listpic(mem_no);
		model.addAttribute("listpic", listpic);
		return "myRoom/my_album_add";
	}
	

	

	@RequestMapping("/jsp/myRoom/album_add_re")
	public String alb_add_re(CommandAlbum ca, Model model) {
		
		try {
			System.out.println("ca alb_word : " + ca.getAlb_word());
			
			List<Album> album = service.albumlist(ca.getMem_no());
		
			for (int i = 0; i < album.size(); i++) {
				System.out.println("album_word : " + album.get(i).getAlb_word());
				if (ca.getAlb_word().equals(album.get(i).getAlb_word())) {
					System.out.println("pic_no 어케오니 :"+ca.getPic_no());
					model.addAttribute("getalb_word", ca.getAlb_word());
					model.addAttribute("mem_no", ca.getMem_no());	
					service.updateget(ca);
					System.out.println("ca 가안되? "+ca.getAlb_word());
					return "redirect:album_add";
				} 
			}
			service.insertAlbum(ca);
			return "redirect:my_album";

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "redirect:/jsp/myRoom/my_album";
	

	}

	@RequestMapping("/jsp/myRoom/my_album_detail")
	public String alb_detail(@RequestParam int mem_no, @RequestParam int alb_no, Model model) {
		model.addAttribute("mem_no", mem_no);
		model.addAttribute("alb_no", alb_no);
		List<String> detailAlbumPic = service.detailAlbumPic(alb_no);	
		Album detailAlbum = service.detailAlbum(alb_no);
		model.addAttribute("detailAlbum", detailAlbum);
		model.addAttribute("detailAlbumPic", detailAlbumPic);
		// 여기서는 앨범에 담겨져있는 사진내용을 가져와야함
		return "myRoom/my_album_detail";
	}

	@RequestMapping("/jsp/myRoom/my_album_delete")
	public String alb_delete(@RequestParam int alb_no) {
		service.deleteAlbum(alb_no);
		return "redirect:/jsp/myRoom/my_album";
	}
	
	
	@RequestMapping("/jsp/myRoom/my_album_update")
	public String my_album_update(Model model,@RequestParam int alb_no, @RequestParam int mem_no){
		System.out.println("update 여기까진와야지");
		List<Picture> listpic = service.listpic(mem_no);
		model.addAttribute("listpic", listpic);
		List<Picture> detailAlbumPic_add = service.grouplist(alb_no);
		Album album = service.detailAlbum(alb_no);
		//List<String> detailAlbumPic_add = service.detailAlbumPic(alb_no);	
		model.addAttribute("detailAlbumPic_add", detailAlbumPic_add);
		model.addAttribute("album", album);
		model.addAttribute("mem_no", mem_no);
	
		
		return "myRoom/my_album_add_update";
	}
	
	@RequestMapping("/jsp/myRoom/album_add_updae_re")
	public String album_add_updae_re(Model model, CommandAlbum ca, @RequestParam int alb_no){
		System.out.println("삭제되나?");
		service.deleteAlbum(alb_no);
		System.out.println("삭제되네");
		try {
			System.out.println("ca alb_word : " + ca.getAlb_word());
			
			List<Album> album = service.albumlist(ca.getMem_no());
			System.out.println("albumlist 되네");
			for (int i = 0; i < album.size(); i++) {
				System.out.println("album_word : " + album.get(i).getAlb_word());
				if (ca.getAlb_word().equals(album.get(i).getAlb_word())) {
					System.out.println("pic_no 어케오니 :"+ca.getPic_no());
					model.addAttribute("getalb_word", ca.getAlb_word());
					model.addAttribute("mem_no", ca.getMem_no());	
					service.updateget(ca);
					System.out.println("ca 가안되? "+ca.getAlb_word());
					return "redirect:album_add";
				} 
			}
			service.insertAlbum(ca);
			System.out.println("수정확인해보장");
			return "redirect:my_album";

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "redirect:/jsp/myRoom/my_album";
	}
	
	
}
