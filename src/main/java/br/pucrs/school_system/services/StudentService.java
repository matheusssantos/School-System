package br.pucrs.school_system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucrs.school_system.dtos.CreateStudentDto;
import br.pucrs.school_system.models.Student;
import br.pucrs.school_system.repositories.StudentRepository;


@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  /**
   * Registra um novo estudante
   * @param studentDto Dados de registro
   * @return Objecto de estudante
   */
  public Student register(CreateStudentDto studentDto) {
    final String code = this.generateCode();
    final Student student = new Student(studentDto.getName(), studentDto.getRg(), studentDto.getAddress(), code);
    this.studentRepository.create(student);
    return student;
  }

  /**
   * Gera um código de estudante
   * @return Código
   */
  private String generateCode() {
    return "CODE" + Math.random();
  }

  /**
   * Busca um estudante pelo código
   * @param code Código
   * @return Objeto de estudante
   */
  public Student getByCode(String code) {
    Optional<Student> student = this.studentRepository.findByCode(code);
    if (!student.isPresent()) {
      return null;
    }
    return student.get();
  }

  /**
   * Busca todos os estudantes cadastrados
   * @return Lista de estudantes
   */
  public List<Student> getAll() {
    return this.studentRepository.findAll();
  }

  /**
   * Busca uma lista de estudantes com base no nome
   * @param name Trecho de nome
   * @return Lista de estudantes
   */
  public List<Student> getByName(String name) {
    return this.studentRepository.findByName(name);
  }
}
