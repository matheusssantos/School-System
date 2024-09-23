package br.pucrs.school_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucrs.school_system.dtos.CreateStudentDto;
import br.pucrs.school_system.dtos.ResponseDto;
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
  public ResponseDto<Student> register(CreateStudentDto studentDto) {
    try {
      final String code = this.generateCode();
      Student newStudent = new Student(studentDto.getName(), studentDto.getRg(), studentDto.getAddress(), code);
      Student student = this.studentRepository.save(newStudent);
      if (student.equals(null)) {
        return new ResponseDto<>("Erro ao criar usuário");
      }
      return new ResponseDto<>(student);
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
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
  public ResponseDto<Student> getByCode(String code) {
    try {
      Student student = this.studentRepository.findByCode(code);
      if (student == null) {
        return new ResponseDto<>("Estudante não encontrado");
      }
      return new ResponseDto<>(student);
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }

  /**
   * Busca todos os estudantes cadastrados
   * @return Lista de estudantes
   */
  public ResponseDto<List<Student>> getAll() {
    try {
      return new ResponseDto<>(this.studentRepository.findAll());
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }

  /**
   * Busca uma lista de estudantes com base no nome
   * @param queryName Trecho de nome
   * @return Lista de estudantes
   */
  public ResponseDto<List<Student>> getByName(String queryName) {
    try {
      List<Student> students = this.studentRepository.findByNameContaining(queryName);
      return new ResponseDto<>(students);
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }
}
