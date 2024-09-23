package br.pucrs.school_system.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registrations")
public class Registration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
 
  @ManyToOne
  @JoinColumn(name = "idStudent", nullable = false)
  private Student student;

  @ManyToOne
  @JoinColumn(name = "idSubject", nullable = false)
  private Subject subject;

  public Registration() {}

  public Registration(Student student, Subject subject) {
    this.student = student;
    this.subject = subject;
  }
  
  public Student getStudent() {
    return this.student;
  }

  public Subject getSubject() {
    return this.subject;
  }

  public Integer getId() {
    return this.id;
  }
}
