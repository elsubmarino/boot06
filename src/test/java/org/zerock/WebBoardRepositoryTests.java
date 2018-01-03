package org.zerock;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.WebBoard;
import org.zerock.repository.WebBoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class WebBoardRepositoryTests {
	@Autowired
	WebBoardRepository repo;
	@Test
	@Ignore
	public void insertBoardDummies() {
		List<WebBoard> list=new ArrayList<>();
		IntStream.range(1,100).forEach(i->{
			WebBoard board=new WebBoard();
			board.setTitle("Sample Board Title "+i);
			board.setContent("Content Sapmle ..."+i+" of Board ");
			board.setWriter("user0"+ (i%10));
			list.add(board);
		});
		repo.saveAll(list);
	}
	
	@Test
	@Ignore
	public void testList1() {
		PageRequest pageable = new PageRequest(0, 20,Direction.DESC,"bno");
		Page<WebBoard> result=repo.findAll(repo.makePredicate(null, null),pageable);
		log.info("PAGE: "+result.getPageable());
		log.info("----------------------");
		result.getContent().forEach(board->log.info(""+board));
		
	}
	
	@Test
	public void testList2() {
		PageRequest pageable = PageRequest.of(0, 20,Direction.DESC,"bno");
		Page<WebBoard> result=repo.findAll(repo.makePredicate("t", "10"), pageable);
		log.info("PAGE: "+result.getPageable());
		log.info("-----------------");
		result.getContent().forEach(board->log.info(""+board));
		
		
		
	}
	
}
