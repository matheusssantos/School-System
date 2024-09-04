package br.pucrs.school_system.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
  public ArrayList<Subject> getAll() {
    return this.subjectRepository.findAll();
  }

  /**
   * Registra uma nova disciplina no sistema
   * @param subjetctDto Dados de registro
   * @return Objeto de disciplina
   */
  public Subject create(CreateSubjetctDto subjetctDto) {
    final Subject subject = new Subject(
      subjetctDto.getCode(), 
      subjetctDto.getName(), 
      subjetctDto.getTurn(), 
      subjetctDto.getClassCode()
    );
    this.subjectRepository.create(subject);
    return subject;
  }

  /**
   * Busca a disciplina com base nos códigos de identificação 
   * @param code Código de disciplina
   * @param classCode Código de turma
   * @return Objeto de disciplina
   */
  public Subject getByCodes(String code, Integer classCode) {
    Optional<Subject> subject = this.subjectRepository.findByCodeAndClassCode(code, classCode);
    if (!subject.isPresent()) {
      return null;
    }
    return subject.get();
  }

  /**
   * Busca todos os estudantes matriculados em uma disciplina
   * @param code Código da disciplina
   * @return Lista de estudantes
   */
  public ResponseDto<ArrayList<Student>> getStudents(String code) {
    Optional<Subject> response = this.getByCode(code);
    if (!response.isPresent()) {
      return new ResponseDto<>("Erro ao buscar matéria");
    }

    final Subject subject = response.get();

    List<Registration> registrations = this.registrationRespository.findAllBySubjectCode(subject.getCode());

    ArrayList<Student> students = new ArrayList<>();
    
    registrations.forEach(registration -> {
      if (registration.getSubject().getCode().equals(subject.getCode())) {
        students.add(registration.getStudent());
      }
    });

    return new ResponseDto<>(students);
  }

  /**
   * Busca todas as disciplinas com base no código
   * @param code Código
   * @return Objecto de disciplina, caso exista
   */
  private Optional<Subject> getByCode(String code) {
    return this.subjectRepository.findByCode(code);
  }
}
