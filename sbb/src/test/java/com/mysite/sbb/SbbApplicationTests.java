package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	
	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testJpa() {
		Optional<Answer> oa = this.answerRepository.findById(1); // id가 1인 답변 조회
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(2, a.getQuestion().getId()); // 답변과 연결된 질문의 id가 2인지 확인 
	}

}

//select * from question


// 데이터 생성
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


// select * from 테이블
//List<Question> all = this.questionRepository.findAll();
//assertEquals(2, all.size());
// subject값으로 조회
//Question q = all.get(0);
//assertEquals("sbb가 무엇인가요?", q.getSubject());



// where id로 조회
//Optional<Question> oq = this.questionRepository.findById(1);
//if(oq.isPresent()) {
//	Question q = oq.get();
//	assertEquals("sbb가 무엇인가", q.getSubject());
//}


// 특정 subject, content의 데이터 조회
//Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가", "sbb에대해 알고싶음");
//assertEquals(1, q.getId());


// 제목에 like조건으로 조회
//List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//Question q = qList.get(0);
//assertEquals("sbb가 무엇인가", q.getSubject());


// id가 1인걸 가져와서 있는지 확인하고(true) 있다면 그 객체의 제목을 수정하고 저장
//Optional<Question> oq = this.questionRepository.findById(1);
//assertTrue(oq.isPresent()); // assertTrue는 괄호 안희 값이 true인지 테스트함.
//Question q = oq.get();
//q.setSubject("수정된 제목");
//this.questionRepository.save(q);


// 데이터 삭제
//assertEquals(2, this.questionRepository.count()); // 테이블의 행 갯수 리턴. 2는 기대하는 count가 2라는 뜻. 아니라면 false
//Optional<Question> oq = this.questionRepository.findById(1);
//assertTrue(oq.isPresent());
//Question q = oq.get();
//this.questionRepository.delete(q); // 삭제. save하지않아도 자동으로 save됨
//assertEquals(1, this.questionRepository.count()); // 데이터를 삭제한 다음 1이 되었는지 확인


// 저장데이터 생성
//Optional<Question> oq = this.questionRepository.findById(2); // question열에 데이터를 생성하려면 질문데이터를 조회해야함
//assertTrue(oq.isPresent());
//Question q = oq.get();
//
//Answer a = new Answer();
//a.setContent("네 자동으로 생성됩니다.");
//a.setQuestion(q); // 답변엔티티의 question속성에 질문 데이터를 대입해 답변 데이터를 생성하려면 question 객체가 필요함
//a.setCreateDate(LocalDateTime.now());
//this.answerRepository.save(a);


// 질문 데이터 조회
//Optional<Answer> oa = this.answerRepository.findById(1); // id가 1인 답변 조회
//assertTrue(oa.isPresent());
//Answer a = oa.get();
//assertEquals(2, a.getQuestion().getId()); // 답변과 연결된 질문의 id가 2인지 확인 