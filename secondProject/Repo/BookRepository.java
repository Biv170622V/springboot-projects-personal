package com.BookStore.secondProject.secondProject.Repo;

import com.BookStore.secondProject.secondProject.utility.BookStore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<BookStore,Long> {
    List<BookStore> findAllByyearofpublication(Integer yop);

    String rawQuery = "select * from bookstore where yearofpublication in (:yop)";

    @Query(nativeQuery = true,value = rawQuery)
    List<BookStore> getBooksByYopIn(@Param(("yop")) Set<Integer> yop);
}
