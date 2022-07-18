package it.personal.workontursi;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;



/*
		try(BufferedReader br = Files.newBufferedReader()){
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error on load chapter");
		} 
 */
public class LoadChapter {
	
	public static String[] chapterFolderStructure = {"section", "chapter", "lesson"};
	private static String elementToPersist = chapterFolderStructure[chapterFolderStructure.length - 1];
	
	public static void main(String[] args) {
		try {
			String uri = "";
			loadChapter(uri);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadChapter(String uri) throws IOException {
		List<Section> sections = new ArrayList<>();
		for(String elementStructure : chapterFolderStructure) {
			Section section = new Section();
			populateLessons(Paths.get(uri),elementStructure, section);
			sections.add(section);
		}
	}
	
	private static void populateLessons(Path path, String sectionAttribute, Section section) {
		// boolean toPersist = StringUtils.equals(elementStructure, elementToPersist);
		try {
			Files.walk(path).forEach(p -> {
				setSectionAttribute(section,sectionAttribute,p);
			});
		} catch (IOException e) {
			System.out.println("Error loading " + path.toString());
			e.printStackTrace();
		}
	}

	private static void setSectionAttribute(Section section,String sectionAttribute, Path p) {
		
		try {
			Field attribute = section.getClass().getDeclaredField(sectionAttribute);
			attribute.setAccessible(true);
			attribute.set(section, p.getFileName().toString());
			
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			System.err.println("Error setting field: " + sectionAttribute + " as: " + p.toString());
			e.printStackTrace();
		}
	}

	private static void loadLesson(Path lesson) {
		
	}
}
