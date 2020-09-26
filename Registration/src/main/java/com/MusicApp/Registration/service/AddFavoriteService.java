package com.MusicApp.Registration.service;

import java.util.List;

import com.MusicApp.Registration.Entity.FavouriteEntity;
import com.MusicApp.Registration.model.Favorite;


public interface AddFavoriteService {
	public Boolean addSongToFavorite(Favorite fav) throws Exception;
	
	public Boolean deleteFav(Favorite fav);

	public List<Favorite> viewFav(String userId);
	
	public Boolean addComment(Favorite fav);

}