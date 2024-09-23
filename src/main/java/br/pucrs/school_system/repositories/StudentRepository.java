package br.pucrs.school_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.school_system.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

  Student findByCode(String code);

  List<Student> findByNameContaining(String name);
}
