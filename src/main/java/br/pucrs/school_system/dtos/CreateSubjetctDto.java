package br.pucrs.school_system.dtos;

public class CreateSubjetctDto {
  private String code;
  private String name;
  private Character turn;
  private Integer classCode;

  public String getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }

  public Integer getClassCode() {
    return this.classCode;
  }

  public Character getTurn() {
    return this.turn;
  }
}
