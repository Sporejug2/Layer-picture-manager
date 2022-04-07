package com.layer.pictureManager.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.layer.pictureManager.entity.NameHistory;
import com.layer.pictureManager.entity.Picture;

@Repository
public class PictureDAOImpl implements PictureDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	boolean reverse = true;

	@Override
	public List<Picture> getPictures() {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Picture> theQuery = currentSession.createQuery("from Picture", Picture.class);

		// execute query and get result list
		List<Picture> pictures = theQuery.getResultList();

		return pictures;
	}

	@Override
	public void savePicture(Picture thePicture) {
		// TODO Auto-generated method stub
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(thePicture);
	}

	@Override
	public Picture getPicture(int theId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Picture thePicture = currentSession.get(Picture.class, theId);

		return thePicture;
	}

	@Override
	public void deletePicture(int theId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Picture where id=:pictureId");
		theQuery.setParameter("pictureId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public List<Picture> getPictureByNotColorTag(String color_tag, String stringTagName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		boolean reverse = true;

		Query<Picture> theQuery = currentSession.createQuery("from Picture", Picture.class);

		// filter
		List<Picture> pictures = theQuery.getResultList();
		List<Picture> picturesToDelete = new ArrayList<>(pictures);

		// filter
		extract(color_tag, stringTagName, pictures, picturesToDelete, reverse);

		return pictures;
	}

	@Override
	public List<Picture> getPictureByColorTag(String color_tag, String stringTagName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		reverse = false;

		Query<Picture> theQuery = currentSession.createQuery("from Picture", Picture.class);

		List<Picture> pictures = theQuery.getResultList();
		List<Picture> picturesToDelete = new ArrayList<>(pictures);

		// filter
		extract(color_tag, stringTagName, pictures, picturesToDelete, reverse);

		return pictures;
	}

	@Override
	public List<Picture> getPictureByProfileTag(String profile_tag, String stringTagName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Picture> theQuery = currentSession.createQuery("from Picture", Picture.class);

		// filter
		List<Picture> pictures = theQuery.getResultList();
		List<Picture> picturesToDelete = new ArrayList<>(pictures);

		extract(profile_tag, stringTagName, pictures, picturesToDelete, reverse);

		return pictures;
	}

	@Override
	public List<Picture> getPictureByNotProfileTag(String profile_tag, String stringTagName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		reverse = false;

		Query<Picture> theQuery = currentSession.createQuery("from Picture", Picture.class);
		// filter
		List<Picture> pictures = theQuery.getResultList();
		List<Picture> picturesToDelete = new ArrayList<>(pictures);

		// filter
		extract(profile_tag, stringTagName, pictures, picturesToDelete, reverse);

		return pictures;
	}

	@Override
	public List<Picture> getPictureByPictureTag(String picture_tag, String stringTagName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Picture> theQuery = currentSession.createQuery("from Picture", Picture.class);

		// filter
		List<Picture> pictures = theQuery.getResultList();
		List<Picture> picturesToDelete = new ArrayList<>(pictures);

		// filter
		extract(picture_tag, stringTagName, pictures, picturesToDelete, reverse);

		return pictures;
	}

	@Override
	// by reverse
	public List<Picture> getPictureByNotPictureTag(String picture_tag, String stringTagName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		reverse = false;

		Query<Picture> theQuery = currentSession.createQuery("from Picture", Picture.class);

		// filter
		List<Picture> pictures = theQuery.getResultList();
		List<Picture> picturesToDelete = new ArrayList<>(pictures);

		extract(picture_tag, stringTagName, pictures, picturesToDelete, reverse);

		return pictures;
	}

	@Override
	public NameHistory getPictureByTime(String time, int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		Timestamp inputTime = Timestamp.valueOf(time);
		Query<NameHistory> theQuery = currentSession.createQuery("from NameHistory", NameHistory.class);

		// filter
		List<NameHistory> history = theQuery.getResultList();
		List<NameHistory> nameHystoryListToDelete = new ArrayList<>(history);
		NameHistory LastEdit = null;

		for (NameHistory nameHystory : nameHystoryListToDelete) {
			if (nameHystory.getPicture_id() != id) {
				history.remove(nameHystory);
			}
		}

		for (int i = 0; i < history.size(); i++) {
			if (history.get(i).getCreationTime().compareTo(inputTime) == 1) {
				LastEdit = history.get(i - 1);
				break;
			}
		}
		return LastEdit;
	}

	private void extract(String color_tag, String stringTagName, List<Picture> pictures, List<Picture> picturesToDelete,
			boolean reverse) {
		for (Picture picture : picturesToDelete) {
			if (reverse == true) {
				if (picture.getProperties().get(color_tag).equals(stringTagName)) {
					pictures.remove(picture);
				}
			} else {
				if (!picture.getProperties().get(color_tag).equals(stringTagName)) {
					pictures.remove(picture);
				}
			}
		}
	}
}
