package br.pucrs.school_system.models;

public class Subject {
  private String code;
  private String name;
  private Character turn;
  private Integer classCode;

  public Subject(String code, String name, Character turn, Integer classCode) {
    this.code = code;
    this.name = name;
    this.turn = turn;
    this.classCode = classCode;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Character getTurn() {
    return this.turn;
  }

  public void setTurn(Character turn) {
    this.turn = turn;
  }

  public Integer getClassCode() {
    return this.classCode;
  }

  public void setClassCode(Integer classCode) {
    this.classCode = classCode;
  }

}
