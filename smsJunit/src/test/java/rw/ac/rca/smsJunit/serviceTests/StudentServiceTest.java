package rw.ac.rca.smsJunit.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import rw.ac.rca.smsJunit.models.Student;
import rw.ac.rca.smsJunit.repositories.StudentRepository;
import rw.ac.rca.smsJunit.services.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

	@Mock
	private StudentRepository studentRepoMock;
	
	@InjectMocks
	private  StudentService service;
	
	@Test
	public void getAllElts() {
		
		when(studentRepoMock.findAll()).thenReturn(Arrays.asList(new Student(1,"delila",14),new Student(2,"Bethtiane",14)));
	
		assertEquals("delila", service.getAllStudents().get(0).getName());
	}
	
	@Test 
	public void createStd() {
		Student stdStudent=new Student(7,"kalibu",16);
		when(studentRepoMock.save(ArgumentMatchers.any(Student.class))).thenReturn(stdStudent);
		assertEquals(16, service.createStudent().getAge());
	}
	
	@Test
	public void getStd() {
		Student std=new Student(7,"kalibu",16);
		when(studentRepoMock.findStd(std.getId())).thenReturn(std);
		assertEquals("kalibu", service.findStudent(std.getId()).getName());
		
		
	}
	
	
//	@Test
//	public void updateStd() {} 

}
