package rw.ac.rca.smsJunit.serviceTests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import rw.ac.rca.smsJunit.models.Student;
import rw.ac.rca.smsJunit.repositories.StudentRepository;
import rw.ac.rca.smsJunit.services.StudentService;
import rw.ac.rca.smsJunit.utils.Exception.ResourceNotFoundException;

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
	public void getStd() {
		Student std=new Student(7,"kalibu",16);
		when(studentRepoMock.findById(std.getId())).thenReturn(Optional.of(std));
		assertEquals("kalibu", service.findStudent(std.getId()).getName());	
	}

	private Integer anyInt(Class<Integer> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void getOneStd404 () {
		when(studentRepoMock.findById(any(Integer.class))).thenThrow(new ResourceNotFoundException("student","id",9));
		Assertions.assertThrowsExactly(ResourceNotFoundException.class, ()-> {
			service.findStudent(9);
		});
	}
	

	
	
	
	@Test 
	public void createStd() {
		Student stdStudent=new Student(7,"kalibu",16);
		when(studentRepoMock.save(any(Student.class))).thenReturn(stdStudent);
		assertEquals(16, service.createStudent().getAge());
	}
	
//	@Test
//	public void updateStdFail() {
//		Student stdStudent=new Student(7,"kalibu",16);
//		
////		when(studentRepoMock.save(any(Student.class))).thenThrow(new BadRequestException("student can't be created"));
//		
//	}
	
	
	

	
	@Test
	public void updateStd() {
		Student  std=new Student(2,"anne", 12);
		Student stdStudent=new Student("kanyana",14);
		when(studentRepoMock.findById(anyInt(Integer.class))).thenReturn(Optional.of(std));
		when(studentRepoMock.save(any(Student.class))).thenReturn(stdStudent);
		
	}
}
