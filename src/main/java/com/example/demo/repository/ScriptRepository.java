package com.example.demo.repository;

import com.example.demo.model.Script;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ScriptRepository extends JpaRepository<Script, UUID> {
    List<Script> findByUserId(String userId);
}
