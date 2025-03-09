package com.example.demo.repository;

import com.example.demo.model.Tea;
import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//poate e nevoie de adnotari
public interface TeaRepository extends JpaRepository<Tea, Integer> {
    @Query("SELECT t FROM Tea t WHERE t.name = :name")
    Tea findByName(String name);
    List<Tea> findAll();
    List<Tea> findByCategory(Category category);
    @Modifying
    @Transactional
    @Query("UPDATE Tea t SET t.quantity = :quantity, t.price = :price, t.description = :description," +
            " t.image = :image, t.category =:category" +
            " WHERE t.name = :name")
    void updateTea(@Param("name") String name,
                  @Param("quantity") int quantity,
                  @Param("price") float price,
                  @Param("description") String description,
                  @Param("image")String image,
                  @Param("category")Category category
                  );
    @Modifying
    @Transactional
    @Query("DELETE FROM Tea t WHERE t.name = :name")
    void deleteByName(@Param("name") String name);

}
