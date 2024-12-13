package com.BookStore.secondProject.secondProject.Repo;

import com.BookStore.secondProject.secondProject.entity.BookAuthor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorRepository extends CrudRepository<BookAuthor,Long> {
    List<BookAuthor> findAllById(Long id);
}
