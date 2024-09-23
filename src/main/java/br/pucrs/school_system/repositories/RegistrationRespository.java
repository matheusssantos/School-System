package br.pucrs.school_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.school_system.models.Registration;
import br.pucrs.school_system.models.Subject;

@Repository
public interface RegistrationRespository extends JpaRepository<Registration, Integer> {

  List<Registration> findByStudentCode(String code);

  List<Registration> findBySubjectCode(String code);
}
