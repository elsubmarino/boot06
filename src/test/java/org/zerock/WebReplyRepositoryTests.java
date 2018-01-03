package org.zerock;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.WebBoard;
import org.zerock.domain.WebReply;
import org.zerock.repository.WebReplyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebReplyRepositoryTests {
	@Autowired
	WebReplyRepository repo;
	
	@Test
	public void test() {
		
		Long[]arr= {105L,104L,103L};
		Arrays.stream(arr).forEach(num->{
			
			WebBoard board=new WebBoard();
			board.setBno(num);
			
			IntStream.range(0,10).forEach(i->{
				WebReply reply=new WebReply();
				reply.setReplyText("REPLY ..."+i);
				reply.setReplyer("replyer"+i);
				reply.setBoard(board);
				
				repo.save(reply);
			});
		});
		
	
	}
}
