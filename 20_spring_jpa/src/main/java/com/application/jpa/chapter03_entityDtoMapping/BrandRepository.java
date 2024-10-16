package com.application.jpa.chapter03_entityDtoMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.jpa.data.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

}
