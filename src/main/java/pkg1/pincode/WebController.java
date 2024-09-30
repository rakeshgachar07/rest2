package pkg1.pincode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/web")
	public String getDetails() {
		return "index";
	}
	
}
