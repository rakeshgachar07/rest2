package pkg1.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {
	@Autowired
	LibraryRepo lr;
	
	@PostMapping("/book/add")
	public LibraryEntity addBook(@RequestBody LibraryEntity le) {
		return lr.save(le);
	}
	
	@GetMapping("/book/all")
	public List<LibraryEntity> getBooks(){
		return lr.findAll();
	}
	
	@GetMapping("/book/findByID/{id}")
	public LibraryEntity getBookById(@PathVariable int id) {
		LibraryEntity le = lr.findById(id).orElseThrow(()-> new NullPointerException("Id not found"));
		return le;
	}
	@PutMapping("/book/update/{id}")
	public LibraryEntity updateBook(@PathVariable int id,@RequestBody LibraryEntity le) {
		LibraryEntity findBook = lr.findById(id).orElseThrow(()-> new NullPointerException("Id not found"));
		LibraryEntity updateBook = new LibraryEntity(findBook.getId(),le.getBookName(),le.getAuthorName(),le.getPublication(),le.getYearOfPublication());
		return lr.save(updateBook);
	}

}
