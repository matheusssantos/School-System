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
    try {
      return new ResponseDto<>(this.studentService.register(data));
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }

  @GetMapping("/code/{code}")
  public ResponseDto<Student> getStudentByCode(@PathVariable String code) {
    try {
      return new ResponseDto<>(this.studentService.getByCode(code));
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }

  @GetMapping("/name/{name}")
  public ResponseDto<List<Student>> getStudentByName(@PathVariable String name) {
    try {
      return new ResponseDto<>(this.studentService.getByName(name));
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }
  
  @GetMapping("")
  public ResponseDto<List<Student>> getAllStudents() {
    try {
      return new ResponseDto<>(this.studentService.getAll());
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }
}
