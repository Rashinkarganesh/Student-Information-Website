package springmvc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.POJO.StudentPOJO;
import springmvc.Service.StudentService;



@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;

	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	@GetMapping("/add")
	public String addPage() {
		return "AddStudent";
	}
	
	@PostMapping("/add")
	public String addStudent(@RequestParam String name,
								@RequestParam String email,
								@RequestParam long mobile,
								@RequestParam String address,
								ModelMap map) {
		StudentPOJO pojo = service.addStudent(name, email, mobile, address);
		//Success
		if (pojo != null) {
			map.addAttribute("msg", "Data inserted successfully. ");
			return "AddStudent";
		}
		//Failure
		map.addAttribute("msg", "Data not inserted. ");
		return "AddStudent";
	}

	@GetMapping("/search")
	public String searchPage() {
		return "SearchStudent";
	}

	@GetMapping("/update")
	public String updatePage() {
		return "UpdateStudent";
	}

	@GetMapping("/remove")
	public String removePage() {
		return "RemoveStudent";
	}

}