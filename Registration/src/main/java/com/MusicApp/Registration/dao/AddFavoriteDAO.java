package com.MusicApp.Registration.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MusicApp.Registration.Entity.FavouriteEntity;
import com.MusicApp.Registration.model.Favorite;

public interface AddFavoriteDAO extends MongoRepository<FavouriteEntity, String>  {
	public FavouriteEntity findBySongIdAndUserId(String songId ,String userId);
	
	public List<FavouriteEntity> findByUserId(String userId);
	
	
	

}