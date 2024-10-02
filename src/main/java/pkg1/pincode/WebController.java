package pkg1.pincode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
	@Autowired
	PincodeRepo pr;
	@GetMapping("/web")
	public String getDetails() {
		return "index";
	}
	@GetMapping("/fileupload")
	public String getFileUpload() {
		return "fileupload";
	}
	@PostMapping("/details")
	public String postDetails(@ModelAttribute PincodeEntity pe, Model model ) {
		pr.save(pe);
		model.addAttribute("msg","succesfully inserted");
		return "details";
	}
}
