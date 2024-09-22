package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findBySubject(String subject); // 엔티티의 subject값으로 데이터 조회
	Question findBySubjectAndContent(String subject, String content); // subject, content 열과 일치하는 데이터 조회
	List<Question> findBySubjectLike(String subject); // 특정 문자열을 포함하는 데이터 조회(like)
	Page<Question> findAll(Pageable pageable);
}
