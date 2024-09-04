package br.pucrs.school_system.models;

public class Registration {
  private Student student;
  private Subject subject;

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
}
