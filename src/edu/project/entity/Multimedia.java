package edu.project.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Multimedia")
public class Multimedia {
	
	@Id
	protected String _id;
	protected String links;
	protected String videos;
	protected String photos;
	protected String announcements;
	
	
	
	public Multimedia(String links, String videos, String photos, String announcements) {
		super();
		this.links = links;
		this.videos = videos;
		this.photos = photos;
		this.announcements = announcements;
	}
	
	
	
	public Multimedia(String _id, String links, String videos, String photos, String announcements) {
		super();
		this._id = _id;
		this.links = links;
		this.videos = videos;
		this.photos = photos;
		this.announcements = announcements;
	}

	public String get_id() {
		return _id;
	}



	public void set_id(String _id) {
		this._id = _id;
	}



	public String getLinks() {
		return links;
	}
	public void setLinks(String links) {
		this.links = links;
	}
	public String getVideos() {
		return videos;
	}
	public void setVideos(String videos) {
		this.videos = videos;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public String getAnnouncements() {
		return announcements;
	}
	public void setAnnouncements(String announcements) {
		this.announcements = announcements;
	}

	
	
	
}
