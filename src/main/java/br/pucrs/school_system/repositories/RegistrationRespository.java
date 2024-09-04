package br.pucrs.school_system.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.school_system.models.Registration;


@Repository
public class RegistrationRespository {
  
  private ArrayList<Registration> registrations;

  public RegistrationRespository() {
    this.registrations = new ArrayList<>();
  }

  public boolean create(Registration registration) {
    this.registrations.add(registration);
    return true;
  }

  public ArrayList<Registration> findAll() {
    return this.registrations;
  }

  public List<Registration> findAllByStudentCode(String studentCode) {
    return this.registrations.stream()
        .filter(registration -> registration.getStudent().getCode().equals(studentCode))
        .toList();
  }

  public List<Registration> findAllBySubjectCode(String subjectCode) {
    return this.registrations.stream()
        .filter(registration -> registration.getSubject().getCode().equals(subjectCode))
        .toList();
  }
}
