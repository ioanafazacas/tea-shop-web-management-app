package com.example.demo.repository;

import com.example.demo.model.Tea;
import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//poate e nevoie de adnotari
public interface TeaRepository extends JpaRepository<Tea, Integer> {
    @Query("SELECT t FROM Tea t WHERE t.name = :name")
    Tea findByName(String name);
    List<Tea> findAll();
    List<Tea> findByCategory(Category category);
    @Modifying
    @Query("UPDATE Tea t SET t.quantity = :quantity, t.price = :price, t.description = :description WHERE t.name = :name")
    Tea updateTea(@Param("quantity") int quantity,
                   @Param("price") float price,
                   @Param("description") String description);

}
