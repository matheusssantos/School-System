package br.pucrs.school_system.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.pucrs.school_system.models.Subject;

@Repository
public class SubjectRepository {
  
  private ArrayList<Subject> subjects;

  public SubjectRepository() {
    this.subjects = new ArrayList<>();
  }

  public ArrayList<Subject> findAll() {
    return this.subjects;
  }

  public boolean create(Subject subject) {
    this.subjects.add(subject);
    return true;
  }

  public Optional<Subject> findByCode(String code) {
    return subjects.stream()
        .filter(subject -> subject.getCode().equals(code))
        .findFirst();
  }  

  public Optional<Subject> findByCodeAndClassCode(String code, Integer classCode) {
    return subjects.stream()
        .filter(subject -> (subject.getCode().equals(code) && subject.getClassCode().equals(classCode)))
        .findFirst();
  }  
}
