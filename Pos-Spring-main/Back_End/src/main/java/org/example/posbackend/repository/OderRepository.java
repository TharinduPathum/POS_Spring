package org.example.posbackend.repository;

import org.example.posbackend.entity.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OderRepository extends JpaRepository<Oder,String> {
    @Query("SELECT MAX(o.oderId) FROM Oder o")
    String findLastOderId();
}
