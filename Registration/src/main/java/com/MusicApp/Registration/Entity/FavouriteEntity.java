package com.MusicApp.Registration.Entity;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "FavouriteSong")
public class FavouriteEntity {

	@Id
	public String objId;
	
	@Field(name="albumId")
	private String songId;
	
	@Field(name="userName")
	private String userId;
	@Field(name="comments")
	private String comments;
	private String songName;
	private String releasedDate;
	private String songLabel;
	private String songAlbum;
	private String songImage;
	private String songTracks;
	private String songPosts;
	private String songArtists;
	private String songGenres;
	
	
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getReleasedDate() {
		return releasedDate;
	}
	public void setReleasedDate(String releasedDate) {
		this.releasedDate = releasedDate;
	}
	public String getSongLabel() {
		return songLabel;
	}
	public void setSongLabel(String songLabel) {
		this.songLabel = songLabel;
	}
	public String getSongAlbum() {
		return songAlbum;
	}
	public void setSongAlbum(String songAlbum) {
		this.songAlbum = songAlbum;
	}
	public String getSongImage() {
		return songImage;
	}
	public void setSongImage(String songImage) {
		this.songImage = songImage;
	}
	public String getSongTracks() {
		return songTracks;
	}
	public void setSongTracks(String songTracks) {
		this.songTracks = songTracks;
	}
	public String getSongPosts() {
		return songPosts;
	}
	public void setSongPosts(String songPosts) {
		this.songPosts = songPosts;
	}
	public String getSongArtists() {
		return songArtists;
	}
	public void setSongArtists(String songArtists) {
		this.songArtists = songArtists;
	}
	public String getSongGenres() {
		return songGenres;
	}
	public void setSongGenres(String songGenres) {
		this.songGenres = songGenres;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String i) {
		this.userId = i;
	}
	
	
}