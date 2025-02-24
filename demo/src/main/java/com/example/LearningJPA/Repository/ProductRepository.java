package com.example.LearningJPA.Repository;


import com.example.LearningJPA.Entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.PrinterURI;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findBy(Sort sort);
    List<ProductEntity> findByTitle(String title);

//    List<ProductEntity> findByCreatedAtAfter(LocalDateTime);

    List<ProductEntity> findByQuantityGreaterThanAndPiceLessThan(int quantity, BigDecimal price);
}
