package rw.ac.rca.smsJunit.StudentRepoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import rw.ac.rca.smsJunit.models.Student;
import rw.ac.rca.smsJunit.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	@Test
	public void findAll() {
		List<Student> students=studentRepo.findAll();
		assertEquals(4, students.size());
	}

}
