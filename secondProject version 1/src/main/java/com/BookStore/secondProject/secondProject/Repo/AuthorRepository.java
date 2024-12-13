package com.BookStore.secondProject.secondProject.Repo;

import com.BookStore.secondProject.secondProject.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
}
