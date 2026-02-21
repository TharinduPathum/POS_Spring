package org.example.posbackend.repository;

import org.example.posbackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    @Query("SELECT MAX(i.id) FROM Item i")
    Long findLastItemId();

}
