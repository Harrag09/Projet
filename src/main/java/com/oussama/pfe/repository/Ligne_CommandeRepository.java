package com.oussama.pfe.repository;

import com.oussama.pfe.entity.Ligne_Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ligne_CommandeRepository extends JpaRepository<Ligne_Commande, Long> {
}
