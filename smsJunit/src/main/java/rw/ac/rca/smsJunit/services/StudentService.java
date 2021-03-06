package rw.ac.rca.smsJunit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import rw.ac.rca.smsJunit.models.Student;
import rw.ac.rca.smsJunit.repositories.StudentRepository;
import rw.ac.rca.smsJunit.utils.Exception.ResourceNotFoundException;

@Service
public class StudentService {
@Autowired
	StudentRepository studentRepository;


public List<Student> getAllStudents(){
	List<Student>students= studentRepository.findAll();
    return  students;
}

public Student createStudent(){
    return  studentRepository.save(new Student(7,"kalibu",16));
}


public Student findStudent(int id) throws ResourceNotFoundException {
	Optional<Student> stdOptional=studentRepository.findById(id);
	if(stdOptional.isPresent()) {
		return stdOptional.get();
	}
	throw new ResourceNotFoundException("student","id",id);
}

public Student updateStudent(@RequestParam int id,@RequestParam Student std){
	Optional<Student> student=studentRepository.findById(id);
	
	Student updStudent;
	
	if(student.isPresent()) { updStudent=std;}
	else {
		updStudent=null;
	}
	return updStudent;
}

public Student RemoveStudent(@RequestParam int id) {
	Optional<Student> student=studentRepository.findById(id);
	if(student.isPresent()) studentRepository.deleteById(id);
	return   null;
}
}

