package org.example.posbackend.repository;

import org.example.posbackend.entity.OderDeatiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OderDeatilesRepository extends JpaRepository<OderDeatiles,String> {
    @Query("SELECT MAX(i.oderDeatiles_id) FROM OderDeatiles i")
    String findLastOderDeatilesId();
}
