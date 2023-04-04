package com.oussama.pfe.repository;

import com.oussama.pfe.entity.Plats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatsRepository extends JpaRepository<Plats, Long> {
}
