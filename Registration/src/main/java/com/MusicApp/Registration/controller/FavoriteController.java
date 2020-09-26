package com.MusicApp.Registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MusicApp.Registration.model.Favorite;
import com.MusicApp.Registration.model.User;
import com.MusicApp.Registration.service.AddFavoriteService;

@CrossOrigin
@RestController
@RequestMapping("/fav")
public class FavoriteController {
	@Autowired
	private AddFavoriteService addfavoriteService;
	
	@PostMapping(value="/addmusic")
	public Boolean addsongtofav(@RequestBody Favorite fav) throws Exception{
		return addfavoriteService.addSongToFavorite(fav);
	}
	@PutMapping(value="/delfav")
	public Boolean deleteFav(@RequestBody Favorite fav) throws Exception{
		return addfavoriteService.deleteFav(fav);
	}
	
	@GetMapping(value="/{userId}")
	public List<Favorite> viewFav(@PathVariable String userId) {
		return addfavoriteService.viewFav(userId);
	}
	@PutMapping(value="/updfav")
	public Boolean updateFav(@RequestBody Favorite fav) throws Exception{
		return addfavoriteService.addComment(fav);
	}
	

}