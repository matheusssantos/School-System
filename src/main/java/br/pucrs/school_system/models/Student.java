package br.pucrs.school_system.models;

public class Student {
  private String name;
  private String RG;
  private Address address;
  private String code;

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
}
