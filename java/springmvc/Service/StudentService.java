package springmvc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



import springmvc.POJO.StudentPOJO;

@Service
public class StudentService {
	
	@Autowired
	private Repository repository;

	public StudentPOJO addStudent(String name, String email,long mobile, String address) {
		StudentPOJO pojo = ((StudentService) repository).addStudent(name, email, mobile, address);
		return pojo;
	}

}