package com.layer.pictureManager.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.layer.pictureManager.entity.NameHistory;
import com.layer.pictureManager.entity.Picture;
import com.layer.pictureManager.service.PictureService;

@RestController
@RequestMapping("/api")
public class PictureRestController {

	// autowire the pictureservice
	@Autowired
	private PictureService pictureService;

	private String picture_tag = "picture_tag";

	private String profile_tag = "profile_tag";

	private String color_tag = "color_tag";

	// add mapping for GET / pictures
	@GetMapping("/pictures")
	public List<Picture> getpictures() {

		return pictureService.getPictures();
	}

	@GetMapping("/pictures/{pictureId}")
	public Picture getCustomer(@PathVariable int pictureId) {

		Picture thePicture = pictureService.getPicture(pictureId);

		if (thePicture == null) {
			throw new PictureNotFoundException("Picture id not found - " + pictureId);
		}

		return thePicture;
	}

	@GetMapping("/color_tag/{stringTagName}")
	public List<Picture> getPictureByColorTag(@PathVariable String stringTagName) {
		return pictureService.getPictureByColorTag(color_tag, stringTagName);
	}

	@GetMapping("/notcolor_tag/{stringTagName}")
	public List<Picture> getPictureByNotColorTag(@PathVariable String stringTagName) {
		return pictureService.getPictureByNotColorTag(color_tag, stringTagName);
	}

	@GetMapping("/profile_tag/{stringTagName}")
	public List<Picture> getPictureByProfileTag(@PathVariable String stringTagName) {
		return pictureService.getPictureByProfileTag(profile_tag, stringTagName);
	}

	@GetMapping("/notprofile_tag/{stringTagName}")
	public List<Picture> getPictureByNotProfileTag(@PathVariable String stringTagName) {
		return pictureService.getPictureByNotProfileTag(profile_tag, stringTagName);
	}

	@GetMapping("/picture_tag/{stringTagName}")
	public List<Picture> getPictureByPictureTag(@PathVariable String stringTagName) {
		System.out.println("stringTagName: " + stringTagName);
		return pictureService.getPictureByPictureTag(picture_tag, stringTagName);
	}

	@GetMapping("/notpicture_tag/{stringTagName}")
	public List<Picture> getPictureByNotPictureTag(@PathVariable String stringTagName) {
		return pictureService.getPictureByNotPictureTag(picture_tag, stringTagName);
	}

	@GetMapping("/creationTime/{time}/{id}")
	public NameHistory getPictureByTime(@PathVariable String time, @PathVariable int id) {
		System.out.println("time " + time + "id " + id);
		return pictureService.getPictureByTime(time, id);
	}

	@PostMapping("/pictures")
	public Picture addCustomer(@RequestBody Picture thePicture) {

		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item .. instead of update

		thePicture.setId(0);

		pictureService.savePicture(thePicture);

		return thePicture;

	}

	// add mapping for PUT / picture - update existing picture

	@PutMapping("/pictures")
	public Picture updateCustomer(@RequestBody Picture thePicture) {

		pictureService.savePicture(thePicture);

		return thePicture;

	}

	// add mapping for PUT / picture - update existing picture
	@PutMapping("/pictures/{pictureId}")
	public Picture updateCustomer(@RequestBody Picture thePicture, @PathVariable int pictureId) {
		System.out.println("pictureId" + pictureId);
		// pictureService.updatePicture(thePicture, pictureId);
		// pictureService.savePicture2(thePicture, pictureId);
		return thePicture;

	}

	// add mapping for delete / picture/pictureId -delete picture

	@DeleteMapping("/pictures/{pictureId}")
	public String deleteCustomer(@PathVariable int pictureId) {

		Picture tempPicture = pictureService.getPicture(pictureId);

		if (tempPicture == null) {
			throw new PictureNotFoundException("Picture id not found - " + pictureId);
		}
		pictureService.deletePicture(pictureId);

		return "Delete picture id - " + pictureId;
	}
}
