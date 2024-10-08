package br.pucrs.school_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.pucrs.school_system.dtos.CreateRegistrationDto;
import br.pucrs.school_system.dtos.ResponseDto;
import br.pucrs.school_system.models.Registration;
import br.pucrs.school_system.services.RegistrationService;


@RestController
@RequestMapping("/registrations")
public class RegistrationController {

  @Autowired
  private RegistrationService registrationService;

  @PostMapping("/new")
  public ResponseDto<Registration> newRegistration(@RequestBody CreateRegistrationDto data) {
    return this.registrationService.register(data);
  }

  @GetMapping("")
  public ResponseDto<List<Registration>> findRegistrations() {
    return this.registrationService.getAll();
  }

  @GetMapping("/student/{code}")
  public ResponseDto<List<Registration>> getRegistrationsByStudent(@PathVariable String code) {
    return this.registrationService.findRegistrationsOfStudent(code);
  }
}
