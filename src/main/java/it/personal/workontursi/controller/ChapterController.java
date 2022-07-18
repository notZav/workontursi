package it.personal.workontursi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.personal.workontursi.model.Chapter;
import it.personal.workontursi.repository.ChapterRepository;

@RestController
@CrossOrigin
public class ChapterController {
		
	@Autowired
	private ChapterRepository chapterRepository;
	
	@GetMapping("getAllChapter")
	public List<Chapter> getAllChapter(){
		return chapterRepository.findAll();
	}
	
	@GetMapping("getAllChapterNames")
	public List<String> getAllChapterNames(){
		return chapterRepository.findAll().stream().map(Chapter::getName).collect(Collectors.toList());
	}
}