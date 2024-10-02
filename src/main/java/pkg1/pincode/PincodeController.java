package pkg1.pincode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class PincodeController {
	@Autowired
	PincodeRepo pr;
	
	@PostMapping("/pincode/add")
	 public PincodeEntity addPincode(@RequestBody PincodeEntity pe) {
		return pr.save(pe);
	}
	@GetMapping("/pincode/fetch")
	 public List<PincodeEntity> fetchPincode() {
		return pr.findAll();
	}
	@GetMapping("/pincode/fetch/{pincode}")
	 public List<PincodeEntity> fetchByPincode(@PathVariable int pincode) {
		return pr.findByPincode(pincode);
	}
	@PostMapping("/upload")
	public String uploadFile(@RequestParam MultipartFile mpf ) throws IOException {
		if(mpf.isEmpty()) {
			return "Please upload a file in String format";
		}
		String dir = "uploads/";
		File  f1 = new File(dir);
		if(!f1.exists()) {
			f1.mkdirs();
		}
		File f2 = new File(dir);
		byte[] arr1 = mpf.getBytes();
		Path path = Paths.get(dir + mpf.getOriginalFilename());
		Files.write(path, arr1);
		return "Success";
	}
}
