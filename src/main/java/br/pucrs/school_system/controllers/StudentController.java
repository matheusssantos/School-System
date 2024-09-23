package br.pucrs.school_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.pucrs.school_system.dtos.CreateStudentDto;
import br.pucrs.school_system.dtos.ResponseDto;
import br.pucrs.school_system.models.Student;
import br.pucrs.school_system.services.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @PostMapping("/create")
  public ResponseDto<Student> createStudent(@RequestBody CreateStudentDto data) {
    return this.studentService.register(data);
  }

  @GetMapping("/code/{code}")
  public ResponseDto<Student> findStudentByCode(@PathVariable String code) {
    return this.studentService.getByCode(code);
  }

  @GetMapping("/name/{name}")
  public ResponseDto<List<Student>> findStudentsByName(@PathVariable String name) {
    return this.studentService.getByName(name);
  }
  
  @GetMapping("")
  public ResponseDto<List<Student>> findStudents() {
    return this.studentService.getAll();
  }
}
