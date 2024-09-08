package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가", "sbb에대해 알고싶음");
		assertEquals(1, q.getId());
	}

}


//Question q1 = new Question();
//q1.setSubject("sbb가 무엇인가");
//q1.setContent("sbb에대해 알고싶음");
//q1.setCreateDate(LocalDateTime.now());
//this.questionRepository.save(q1);
//
//Question q2 = new Question();
//q2.setSubject("스프링부트 모델 질문입니다");
//q2.setContent("id는 자동생성되나요");
//q2.setCreateDate(LocalDateTime.now());
//this.questionRepository.save(q2);


//List<Question> all = this.questionRepository.findAll();
//assertEquals(2, all.size());
//
//Question q = all.get(0);
//assertEquals("sbb가 무엇인가요?", q.getSubject());



//Optional<Question> oq = this.questionRepository.findById(1);
//if(oq.isPresent()) {
//	Question q = oq.get();
//	assertEquals("sbb가 무엇인가", q.getSubject());
//}
