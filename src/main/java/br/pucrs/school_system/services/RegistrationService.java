package br.pucrs.school_system.services;

import java.util.ArrayList;
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
    Student student = this.studentService.getByCode(registrationDto.getStudentCode());
    if (student == null) {
      return new ResponseDto<>("Erro ao buscar dados do estudante");
    }

    Subject subject = this.subjectService.getByCodes(registrationDto.getSubjectCode(), registrationDto.getClassCode());
    if (subject == null) {
      return new ResponseDto<>("Erro ao buscar dados da matéria");
    }

    final Registration registration = new Registration(student, subject);
    this.registrationRespository.create(registration);

    return new ResponseDto<>(registration);
  }

  /**
   * Busca todas as matriculas efetuadas no sistema
   * @return Lista de matriculas
   */
  public ArrayList<Registration> getAll() {
    return this.registrationRespository.findAll();
  }

  /**
   * Busca todas as matriculas de um estudante
   * @param studentCode Código do estudante
   * @return Lista de matriculas
   */
  public List<Registration> getAllByStudentCode(String studentCode) {
    return this.registrationRespository.findAllByStudentCode(studentCode);
  }
}
