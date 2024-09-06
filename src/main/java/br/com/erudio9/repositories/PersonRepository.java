package br.com.erudio9.repositories;

import br.com.erudio9.model.PersonVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonVO, Long> {
}
