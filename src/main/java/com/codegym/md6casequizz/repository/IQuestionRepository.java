package com.codegym.md6casequizz.repository;

import com.codegym.md6casequizz.model.Category;
import com.codegym.md6casequizz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IQuestionRepository extends JpaRepository<Question,Long> {
    @Query(value = "call searchQuestion(:contents,:type_id,:category_id,:level_id)",nativeQuery = true)
    Iterable<Question> searchQuestion(String contents,Long type_id,Long category_id, Long level_id);
    Iterable<Question> findAllByCategory(Category category);
    @Query(value = "select * from questions order by id desc limit 1",nativeQuery = true)
    Optional<Question> findNeweastQuestion();
    @Query(value = "select * from questions order by id desc ;",nativeQuery = true)
    Iterable<Question> findAllOrderByDate();
}
