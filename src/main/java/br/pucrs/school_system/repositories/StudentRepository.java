package br.pucrs.school_system.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.pucrs.school_system.models.Student;

@Repository
public class StudentRepository {

  private ArrayList<Student> students;

  public StudentRepository() {
    this.students = new ArrayList<>();
  }

  public ArrayList<Student> findAll() {
    return this.students;
  }

  public boolean create(Student student) {
    this.students.add(student);
    return true;
  }

  public Optional<Student> findByCode(String code) {
    return students.stream()
        .filter(student -> student.getCode().equals(code))
        .findFirst();
  }

  public List<Student> findByName(String name) {
    return students.stream()
        .filter(student -> student.getName().toLowerCase().contains(name.toLowerCase()))
        .toList();
  }
}
