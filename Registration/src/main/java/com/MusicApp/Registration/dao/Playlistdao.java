package com.MusicApp.Registration.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MusicApp.Registration.model.Playlist;

@Repository
public interface Playlistdao extends MongoRepository<Playlist, String> {

}
