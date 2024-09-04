package br.pucrs.school_system.dtos;

import br.pucrs.school_system.models.Address;

public class CreateStudentDto {
  private String name;
  private String rg;
  private Address address;

  public String getName() {
    return this.name;
  }

  public String getRg() {
    return this.rg;
  }

  public Address getAddress() {
    return this.address;
  }
}
