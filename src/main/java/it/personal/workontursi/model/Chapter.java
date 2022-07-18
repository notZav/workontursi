package it.personal.workontursi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("chapter")
public class Chapter {
	
	@Id
    private String id;
	private String name;
	private String description;
	private String paragraph;
	private Integer numClicked;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getParagraph() {
		return paragraph;
	}
	
	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}
	
	public Integer getNumClicked() {
		return numClicked;
	}
	
	public void setNumClicked(Integer numClicked) {
		this.numClicked = numClicked;
	}
	
	@Override
	public String toString() {
		return "Chapter [id=" + id + ", name=" + name + ", description=" + description + ", paragraph=" + paragraph
				+ ", numClicked=" + numClicked + "]";
	}
	
}
