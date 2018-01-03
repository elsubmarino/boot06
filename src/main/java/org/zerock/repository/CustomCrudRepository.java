package org.zerock.repository;

import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.WebBoard;

public interface CustomCrudRepository extends CrudRepository<WebBoard,Long>,CustomWebBoard {
	
}
