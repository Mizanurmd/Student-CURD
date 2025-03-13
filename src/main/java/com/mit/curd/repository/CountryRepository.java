package com.mit.curd.repository;

import com.mit.curd.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsBycCode(String cCode);
}
