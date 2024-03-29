package com.ferbator.shelterapi.dao.daoImpl;

import com.ferbator.shelterapi.dao.entities.Cat;
import com.ferbator.shelterapi.dao.enums.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    List<Cat> findAllByColor(Colors color);
}