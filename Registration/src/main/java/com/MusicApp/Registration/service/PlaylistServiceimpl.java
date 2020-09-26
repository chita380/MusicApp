package com.MusicApp.Registration.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MusicApp.Registration.Exception.PlaylistException;
import com.MusicApp.Registration.dao.Playlistdao;
import com.MusicApp.Registration.model.Playlist;

@Service
public class PlaylistServiceimpl implements PlaylistService {

	@Autowired
	Playlistdao playlistDao;

	@Override
	public Collection<Playlist> getAllPlaylists() {
		return playlistDao.findAll();
	}

	@Override
	public void deletePlaylistById(String id) {
		// TODO Auto-generated method stub
		playlistDao.deleteById(id);
	}

	@Override
	public Playlist updatePlaylist(Playlist pl) {
		// TODO Auto-generated method stub
		return playlistDao.save(pl);
	}

	@Override
	public void addPlaylist(Playlist pl) {
		// TODO Auto-generated method stub

		if (playlistDao.findById(pl.getId()).isPresent()) {
			throw new PlaylistException("Id already exists");
		} else
			playlistDao.save(pl);

	}
}
