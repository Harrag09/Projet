package com.oussama.pfe.repository;

import com.oussama.pfe.entity.Resto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoRepository extends JpaRepository<Resto, Long> {
}
