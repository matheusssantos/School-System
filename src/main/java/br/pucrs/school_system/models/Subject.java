package br.pucrs.school_system.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String code;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Character turn;

  @Column(nullable = false)
  private Integer classCode;

  public Subject() {}

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

  public Integer getId() {
    return this.id;
  }
}
