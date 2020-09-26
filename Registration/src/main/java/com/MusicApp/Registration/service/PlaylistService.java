package com.MusicApp.Registration.service;

import java.util.Collection;

import com.MusicApp.Registration.model.Playlist;

public interface PlaylistService {

	public Collection<Playlist> getAllPlaylists();

	public void deletePlaylistById(String id);

	public Playlist updatePlaylist(Playlist pl);

	public void addPlaylist(Playlist pl);
}
