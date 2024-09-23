package br.pucrs.school_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.school_system.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

  Subject findByCode(String code);

  Subject findByCodeAndClassCode(String code, Integer classCode);
}
