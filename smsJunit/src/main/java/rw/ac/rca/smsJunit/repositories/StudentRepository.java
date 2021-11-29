package rw.ac.rca.smsJunit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rw.ac.rca.smsJunit.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
 public Student findStd(int id);
}
