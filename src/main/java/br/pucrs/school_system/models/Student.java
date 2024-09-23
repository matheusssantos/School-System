package br.pucrs.school_system.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String RG;

  @Column(nullable = false)
  private String code;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "idAddress", nullable = false)
  private Address address;

  public Student() {}

  public Student(String name, String RG, Address address, String code) {
    this.name = name;
    this.RG = RG;
    this.address = address;
    this.code = code;
  }

  public Address getAddress() {
    return address;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public String getRG() {
    return RG;
  }

  public Integer getId() {
    return this.id;
  }
}
