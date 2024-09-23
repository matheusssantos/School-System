package br.pucrs.school_system.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucrs.school_system.dtos.CreateSubjetctDto;
import br.pucrs.school_system.dtos.ResponseDto;
import br.pucrs.school_system.models.Registration;
import br.pucrs.school_system.models.Student;
import br.pucrs.school_system.models.Subject;
import br.pucrs.school_system.repositories.RegistrationRespository;
import br.pucrs.school_system.repositories.SubjectRepository;


@Service
public class SubjectService {
  
  @Autowired
  private SubjectRepository subjectRepository;

  @Autowired
  private RegistrationRespository registrationRespository;

  /**
   * Busca todas as disciplinas
   * @return Lista de disciplinas
   */
  public ResponseDto<List<Subject>> getAll() {
    try {
      return new ResponseDto<>(this.subjectRepository.findAll());
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }

  /**
   * Registra uma nova disciplina no sistema
   * @param subjetctDto Dados de registro
   * @return Objeto de disciplina
   */
  public ResponseDto<Subject> create(CreateSubjetctDto subjetctDto) {
    try {
      final Subject newSubject = new Subject(
        subjetctDto.getCode(), 
        subjetctDto.getName(), 
        subjetctDto.getTurn(), 
        subjetctDto.getClassCode()
      );
      
      Subject subject = this.subjectRepository.save(newSubject);
      if (subject.equals(null)) {
        return new ResponseDto<>("Erro ao salvar matéria");
      }
      return new ResponseDto<>(subject);
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }  

  }

  /**
   * Busca a disciplina com base nos códigos de identificação 
   * @param code Código de disciplina
   * @param classCode Código de turma
   * @return Objeto de disciplina
   */
  public Subject getByCodes(String code, Integer classCode) {
    Subject subject = this.subjectRepository.findByCodeAndClassCode(code, classCode);
    if (subject.equals(null)) {
      return null;
    }
    return subject;
  }

  /**
   * Busca todos os estudantes matriculados em uma disciplina
   * @param registrationCode Código da disciplina
   * @return Lista de estudantes
   */
  public ResponseDto<List<Student>> getStudents(String registrationCode) {
    try {
      Subject subject = this.getByCode(registrationCode);
      if (subject == null) {
        return new ResponseDto<>("Erro ao buscar matéria");
      }

      List<Registration> registrations = this.registrationRespository.findBySubjectCode(subject.getCode());

      ArrayList<Student> students = new ArrayList<>();
      registrations.forEach(registration -> {
        if (registration.getSubject().getCode().equals(subject.getCode())) {
          students.add(registration.getStudent());
        }
      });

      return new ResponseDto<>(students);
    } catch (Error error) {
      return new ResponseDto<>("Erro interno no servidor");
    }
  }

  /**
   * Busca todas as disciplinas com base no código
   * @param code Código
   * @return Objecto de disciplina, caso exista
   */
  private Subject getByCode(String code) {
    return this.subjectRepository.findByCode(code);
  }
}
