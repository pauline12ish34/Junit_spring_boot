package rw.ac.rca.smsJunit.controllers;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;

import rw.ac.rca.smsJunit.models.Student;
import rw.ac.rca.smsJunit.services.StudentService;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(Students.class)
public class StudentControllerTest {
	@MockBean
	private StudentService stdServiceMock;
	@Autowired
	private MockMvc mockMvc ;

	@Test 
	public void getAll() throws Exception {
		List<Student> students=Arrays.asList(new Student(1,"pauline",12), new Student(2,"Anna",12));
	when(stdServiceMock.getAllStudents()).thenReturn(students);

	MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/get-all-students")
	.accept(MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc
	.perform(request)
	.andExpect(status().isOk())
	.andExpect(content().json("[{\"id\":1,\"name\":\"pauline\",\"age\":12},{\"id\":2,\"name\":\"Anna\",\"age\":12}]"))
	.andReturn();

	}
	
	@Test
	public void getByOne() throws JsonProcessingException {
		Student item = new Student(1,"Samuel",18);
		
		when(stdServiceMock.findStudent(item.getId())).thenReturn(item);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/getStudent/1")
				.accept(MediaType.APPLICATION_JSON);
				
				 try {
					MvcResult result = mockMvc
							.perform(request)
							.andExpect(status().isNotFound())
							//.andExpect(content().string(""))
							.andExpect(content().json("{\"id\":1,\"name\":\"Samuel\",\"age\":18}"))
							.andReturn();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
	
	@Test
	public void getByOne_404() throws JsonProcessingException {
		Student item = new Student(1,"Samuel",18);
		
		when(stdServiceMock.findStudent(item.getId())).thenReturn(item);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/getStudent/2")
				.accept(MediaType.APPLICATION_JSON);
				
				 try {
					MvcResult result = mockMvc
							.perform(request)
							.andExpect(status().isNotFound())
							//.andExpect(content().string(""))
							.andExpect(content().json("{\"status\":false,\"message\":\"Item not found\"}"))
							.andReturn();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
	
	
	@Test
	public void create_success() throws Exception {

		when(stdServiceMock.createStudent()).thenReturn(new Student(1,"pauline",12));
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/add")
                .contentType(MediaType.APPLICATION_JSON)
	.content("{\"id\":1,\"name\":\"pauline\",\"age\":12}");
		MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().is2xxSuccessful())
//                .andExpect(content().json("{\"id\":1,\"name\":\"pauline\",\"age\":12}"))
                .andReturn();
	
	}
	
	
	@Test 
	public void update_success() throws JsonProcessingException  {
		
		Student std= new Student(2,"kally",15);
		Student updtStudent=new Student("kally",12);
		
		when(stdServiceMock.updateStudent(std.getId(), updtStudent)).thenReturn(new Student(std.getId(),updtStudent.getName(),updtStudent.getAge()));
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .put("/update?id=2")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content("{\"name\":\"kally\",\"age\":12}");

	        try {
				MvcResult result = mockMvc
				        .perform(request)
				        .andExpect(status().isCreated())
				        .andExpect(content().json("{\"name\":\"kally\",\"age\":12}"))
				        .andReturn();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Test 
	public void update_Fail() throws JsonProcessingException  {
		
		Student std= new Student(2,"kally",15);
		Student updtStudent=new Student("kally",12);
		
		when(stdServiceMock.updateStudent(std.getId(), updtStudent)).thenReturn(new Student(std.getId(),updtStudent.getName(),updtStudent.getAge()));
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	                .put("/update?id=5")
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON)
	                .content("{\"name\":\"kally\",\"age\":12}");

	        try {
				MvcResult result = mockMvc
				        .perform(request)
				        .andExpect(status().isCreated())
				        .andExpect(content().json("{\"status\":false,\"message\":\"Apartment not found\"}"))
				        .andReturn();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	
	
	@Test
	public void delete_success() throws Exception {
Student std=new Student(2,"kallvy",12);
when(stdServiceMock.RemoveStudent(std.getId())).thenReturn(std);
	
MockHttpServletRequestBuilder request = MockMvcRequestBuilders
.delete("/remove-student?id=2")
.contentType(MediaType.APPLICATION_JSON)
.accept(MediaType.APPLICATION_JSON);

MvcResult result = mockMvc
.perform(request)
//.andExpect(status().isOk())
.andExpect(status().is2xxSuccessful())
//.andExpect(content().json("{\"name\":\"kallvy\",\"age\":18}"))
.andReturn();
}
	
	@Test
	public void delete_Fail()throws JsonProcessingException {
		
		Student std=new Student(2,"kallvy",12);
	
		when(stdServiceMock.findStudent(std.getId())).thenReturn(std);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
		.get("/get-all-students/23")
		.accept(MediaType.APPLICATION_JSON);

		try {
			MvcResult result = mockMvc
			.perform(request)
			//.andExpect(status().isOk())
			.andExpect(status().isNotFound())
			.andExpect(content().json("{\"status\":false,\"message\":\"Apartment not found\"}"))
			.andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		when(stdServiceMock.RemoveStudent(std.getId())).thenReturn(std);
	}
	
		
		
	}

