package com.example.demo.Repository;

import com.example.demo.Entity.PersonForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Transactional
@RepositoryRestResource(collectionResourceRel = "personForm", path = "personList")
public interface FormRepository extends JpaRepository<PersonForm, Integer> {
}
