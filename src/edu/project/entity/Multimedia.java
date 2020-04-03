package edu.project.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Multimedia")
public class Multimedia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	protected String id; 	
	
	@Field(name = "links")    //array
	protected String links[];
	
	@Field(name = "videos")
	protected String videos[];     //array
	
	@Field(name = "photos")
	protected String photos[];      //array
	
	@Field(name = "announcements")
	protected String announcements[];    //array

	
	
	public Multimedia() {
		super();
	}

	public Multimedia( String[] links, String[] videos, String[] photos, String[] announcements) {
		super();
		this.links = links;
		this.videos = videos;
		this.photos = photos;
		this.announcements = announcements;
	}

	public Multimedia(String id, String[] links, String[] videos, String[] photos, String[] announcements) {
		super();
		this.id = id;
		this.links = links;
		this.videos = videos;
		this.photos = photos;
		this.announcements = announcements;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getLinks() {
		return links;
	}

	public void setLinks(String[] links) {
		this.links = links;
	}

	public String[] getVideos() {
		return videos;
	}

	public void setVideos(String[] videos) {
		this.videos = videos;
	}

	public String[] getPhotos() {
		return photos;
	}

	public void setPhotos(String[] photos) {
		this.photos = photos;
	}

	public String[] getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(String[] announcements) {
		this.announcements = announcements;
	}
	

	
	
	
}
