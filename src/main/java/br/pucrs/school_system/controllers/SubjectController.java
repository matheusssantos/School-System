package br.pucrs.school_system.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.pucrs.school_system.dtos.CreateSubjetctDto;
import br.pucrs.school_system.dtos.ResponseDto;
import br.pucrs.school_system.models.Student;
import br.pucrs.school_system.models.Subject;
import br.pucrs.school_system.services.SubjectService;


@RestController
@RequestMapping("/subjects")
public class SubjectController {

  @Autowired
  private SubjectService subjectService;
  
  @GetMapping("")
  public ResponseDto<List<Subject>> geAllSubjects() {
    try {
      return new ResponseDto<>(this.subjectService.getAll());
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }

  @PostMapping("/create")
  public ResponseDto<Subject> createSubject(@RequestBody CreateSubjetctDto data) {
    try {
      return new ResponseDto<>(this.subjectService.create(data));
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }      
  }

  @GetMapping("/{code}/students")
  public ResponseDto<ArrayList<Student>> getSubjectStudents(@PathVariable String code) {
    return this.subjectService.getStudents(code);
  }
}
