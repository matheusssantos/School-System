package br.pucrs.school_system.dtos;

public class CreateRegistrationDto {
  
  private String studentCode;
  private String subjectCode;
  private Integer classCode;

  public Integer getClassCode() {
    return this.classCode;
  }

  public String getStudentCode() {
    return this.studentCode;
  }

  public String getSubjectCode() {
    return this.subjectCode;
  }
}
