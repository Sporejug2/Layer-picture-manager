package com.layer.pictureManager.service;

import java.util.List;

import com.layer.pictureManager.entity.NameHistory;
import com.layer.pictureManager.entity.Picture;

public interface PictureService {
	
	public List<Picture> getPictures();

	public void savePicture(Picture thePicture);

	public Picture getPicture(int theId);

	public void deletePicture(int theId);

	public List<Picture> getPictureByColorTag(String color_tag, String stringTagName);

	public List<Picture> getPictureByNotColorTag(String color_tag, String stringTagName);

	public List<Picture> getPictureByProfileTag(String profile_tag, String stringTagName);

	public List<Picture> getPictureByNotProfileTag(String profile_tag, String stringTagName);

	public List<Picture> getPictureByPictureTag(String picture_tag, String stringTagName);

	public List<Picture> getPictureByNotPictureTag(String picture_tag, String stringTagName);

	public NameHistory getPictureByTime(String time, int id);
}
