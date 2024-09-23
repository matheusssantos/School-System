package br.pucrs.school_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucrs.school_system.dtos.CreateRegistrationDto;
import br.pucrs.school_system.dtos.ResponseDto;
import br.pucrs.school_system.models.Registration;
import br.pucrs.school_system.models.Student;
import br.pucrs.school_system.models.Subject;
import br.pucrs.school_system.repositories.RegistrationRespository;


@Service
public class RegistrationService {

  @Autowired
  private RegistrationRespository registrationRespository;

  @Autowired
  private StudentService studentService;

  @Autowired
  private SubjectService subjectService;

  /**
   * Registra uma nova matricula
   * @param registrationDto Dados de registro
   * @return Objeto de matricula
   */
  public ResponseDto<Registration> register(CreateRegistrationDto registrationDto) {
    try {
      ResponseDto<Student> studentResponse = this.studentService.getByCode(registrationDto.getStudentCode());
      if (!studentResponse.isSuccess()) {
        return new ResponseDto<>("Erro ao buscar dados do estudante");
      }
  
      Subject subject = this.subjectService.getByCodes(registrationDto.getSubjectCode(), registrationDto.getClassCode());
      if (subject == null) {
        return new ResponseDto<>("Erro ao buscar dados da matéria");
      }
  
      Registration newRegistration = new Registration(studentResponse.getMessage(), subject);
      Registration registration = this.registrationRespository.save(newRegistration);
      if (registration == null) {
        return new ResponseDto<>("Erro salvar nova matricula");
      }

      return new ResponseDto<>(registration);
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }

  /**
   * Busca todas as matriculas efetuadas no sistema
   * @return Lista de matriculas
   */
  public ResponseDto<List<Registration>> getAll() {
    try {
      return new ResponseDto<>(this.registrationRespository.findAll());
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }

  /**
   * Busca todas as matriculas de um estudante
   * @param studentCode Código do estudante
   * @return Lista de matriculas
   */
  public ResponseDto<List<Registration>> findRegistrationsOfStudent(String studentCode) {
    try {
      return new ResponseDto<>(this.registrationRespository.findByStudentCode(studentCode));
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }
}
