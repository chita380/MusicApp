package com.MusicApp.Registration.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MusicApp.Registration.model.Playlist;
import com.MusicApp.Registration.service.PlaylistService;

@CrossOrigin
@RestController
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;

	@PostMapping(value = "/add")
	public ResponseEntity<String> addEmp(@RequestBody Playlist pl) {

		// server side validation
		playlistService.addPlaylist(pl);
		return new ResponseEntity<String>("New PlayList created.", HttpStatus.OK);
	}

	@GetMapping(value = "/getall")
	public Collection<Playlist> getAll() {

		return playlistService.getAllPlaylists();
	}

	@PutMapping(value = "/update/{playlist-id}")
	public String update(@PathVariable(value = "playlist-id") String id, @RequestBody Playlist pl) {
		pl.setId(id);
		playlistService.updatePlaylist(pl);
		return "Playlist-id= " + id + " updated.";
	}

	@DeleteMapping(value = "/delete/{employee-id}")
	public String delete(@PathVariable(value = "employee-id") String id) {
		playlistService.deletePlaylistById(id);
		return "playlist-id= " + id + " deleted.";
	}

}
