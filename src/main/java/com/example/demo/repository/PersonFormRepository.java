package com.example.demo.repository;

import com.example.demo.entity.PersonForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Transactional
@RepositoryRestResource(collectionResourceRel = "personForm", path = "personList")
public interface PersonFormRepository extends JpaRepository<PersonForm, Integer> {
}
