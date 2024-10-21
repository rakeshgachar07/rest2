package pkg1.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class InputPageController {
	@Autowired
	LibraryRepo lr;
	
	@GetMapping("/input")
	public String getInput() {
		return "library";
	}
	
	@PostMapping("/status")
	public String getStatus(@ModelAttribute LibraryEntity le,Model model) {
		lr.save(le);
		model.addAttribute("msg","Insterted Successfully");
		return "status1";
	}
}
