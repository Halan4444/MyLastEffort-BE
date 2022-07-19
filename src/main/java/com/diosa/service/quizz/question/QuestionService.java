package com.diosa.service.quizz.question;


import com.diosa.model.quizz.Category;
import com.diosa.model.quizz.Question;
import com.diosa.repository.IQuestionRepository;
import com.diosa.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private ITestRepository testRepository;


    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question save(Question question) {
       return questionRepository.save(question);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Iterable<Question> searchQuestion(String contents, Long type_id, Long category_id, Long level_id) {
        return questionRepository.searchQuestion(contents,type_id,category_id,level_id);
    }

    @Override
    public Iterable<Question> findAllByCategory(Category category) {
        return questionRepository.findAllByCategory(category);
    }

    @Override
    public Optional<Question> findNeweastQuestion() {
        return questionRepository.findNeweastQuestion();
    }

    @Override
    public Iterable<Question> findAllOrderByDate() {
        return questionRepository.findAllOrderByDate();
    }

}
