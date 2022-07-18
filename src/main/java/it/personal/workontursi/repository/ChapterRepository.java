package it.personal.workontursi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.personal.workontursi.model.Chapter;

public interface ChapterRepository extends MongoRepository<Chapter, String>{

	public long count();
	
}
