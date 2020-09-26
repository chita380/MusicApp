package com.MusicApp.Registration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MusicApp.Registration.Entity.FavouriteEntity;
import com.MusicApp.Registration.dao.AddFavoriteDAO;
import com.MusicApp.Registration.model.Favorite;

@Service
public class AddFavoriteServiceImpl implements AddFavoriteService{

	@Autowired
	AddFavoriteDAO dao;
	
	@Override
	public Boolean addSongToFavorite(Favorite fav) throws Exception {
		FavouriteEntity ent1=dao.findBySongIdAndUserId(fav.getSongId(), fav.getEmailId());
		if(ent1!=null) {
			throw new Exception("Song already added to favorite");
		}
		FavouriteEntity ent=new FavouriteEntity();
		ent.setReleasedDate(fav.getReleasedDate());
		ent.setSongAlbum(fav.getSongAlbum());
		ent.setComments(fav.getComment());
		ent.setSongArtists(fav.getSongArtists());
		ent.setSongGenres(fav.getSongGenres());
		ent.setSongImage(fav.getSongImage());
		ent.setSongLabel(fav.getSongLabel());
		ent.setSongName(fav.getSongName());
		ent.setSongPosts(fav.getSongPosts());
		ent.setSongTracks(fav.getSongTracks());
		ent.setSongId(fav.getSongId());
		ent.setUserId(fav.getEmailId());

		if(dao.save(ent)!=null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Boolean deleteFav(Favorite favorite) {
		FavouriteEntity ent=dao.findBySongIdAndUserId(favorite.getSongId(), favorite.getEmailId());
		if(ent!=null) {
			dao.delete(ent);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Favorite> viewFav(String userId) {
		List<FavouriteEntity> ent= dao.findByUserId(userId);
		List<Favorite> list=new ArrayList<>();
		for(FavouriteEntity fav:ent) {
			Favorite favo=new Favorite();
			favo.setComment(fav.getComments());
			favo.setEmailId(fav.getUserId());
			favo.setSongId(fav.getSongId());
			favo.setReleasedDate(fav.getReleasedDate());
			favo.setSongAlbum(fav.getSongAlbum());
			
			favo.setSongArtists(fav.getSongArtists());
			favo.setSongGenres(fav.getSongGenres());
			favo.setSongImage(fav.getSongImage());
			favo.setSongLabel(fav.getSongLabel());
			favo.setSongName(fav.getSongName());
			favo.setSongPosts(fav.getSongPosts());
			favo.setSongTracks(fav.getSongTracks());

			list.add(favo);
		}
		
		return list;
	}

	@Override
	public Boolean addComment(Favorite fav) {
		FavouriteEntity fave=dao.findBySongIdAndUserId(fav.getSongId(), fav.getEmailId());
		if(fave!=null) {
			fave.setComments(fav.getComment());
			dao.save(fave);
		}
		return null;
	}

	
	

}