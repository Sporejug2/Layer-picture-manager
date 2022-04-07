package com.layer.pictureManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.layer.pictureManager.dao.PictureDAO;
import com.layer.pictureManager.entity.NameHistory;
import com.layer.pictureManager.entity.Picture;

@Service
public class PictureServiceImpl implements PictureService {

	// need to inject Picture dao
	@Autowired
	private PictureDAO pictureDAO;

	@Override
	@Transactional
	public List<Picture> getPictures() {
		// TODO Auto-generated method stub
		return pictureDAO.getPictures();
	}

	@Override
	@Transactional
	public void savePicture(Picture thePicture) {
		// TODO Auto-generated method stub
		pictureDAO.savePicture(thePicture);
	}

	@Override
	@Transactional
	public Picture getPicture(int theId) {
		// TODO Auto-generated method stub
		return pictureDAO.getPicture(theId);
	}

	@Override
	@Transactional
	public void deletePicture(int theId) {
		// TODO Auto-generated method stub

		pictureDAO.deletePicture(theId);
	}

	@Override
	@Transactional
	public List<Picture> getPictureByColorTag(String color_tag, String stringTagName) {
		// TODO Auto-generated method stub
		return pictureDAO.getPictureByColorTag(color_tag, stringTagName);
	}

	@Override
	@Transactional
	public List<Picture> getPictureByNotColorTag(String color_tag, String stringTagName) {
		// TODO Auto-generated method stub
		return pictureDAO.getPictureByNotColorTag(color_tag, stringTagName);
	}

	@Override
	@Transactional
	public List<Picture> getPictureByProfileTag(String profile_tag, String stringTagName) {
		// TODO Auto-generated method stub
		return pictureDAO.getPictureByProfileTag(profile_tag, stringTagName);
	}

	@Override
	@Transactional
	public List<Picture> getPictureByNotProfileTag(String profile_tag, String stringTagName) {
		// TODO Auto-generated method stub
		return pictureDAO.getPictureByNotProfileTag(profile_tag, stringTagName);
	}

	@Override
	@Transactional
	public List<Picture> getPictureByPictureTag(String picture_tag, String stringTagName) {
		// TODO Auto-generated method stub
		return pictureDAO.getPictureByPictureTag(picture_tag, stringTagName);
	}

	@Override
	@Transactional
	public List<Picture> getPictureByNotPictureTag(String picture_tag, String stringTagName) {
		// TODO Auto-generated method stub
		return pictureDAO.getPictureByNotPictureTag(picture_tag, stringTagName);
	}

	@Override
	@Transactional
	public NameHistory getPictureByTime(String time, int id) {
		// TODO Auto-generated method stub
		return pictureDAO.getPictureByTime(time, id);
	}
}
