package com.layer.pictureManager.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "picture")
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name_discription")
	private String nameDiscription;

	@Column(name = "discription")
	private String discription;

	@Column(name = "author")
	private String author;

	@Column(name = "imageUrl")
	private String imageUrl;

	@Column(name = "width")
	private double width;

	@Column(name = "height")
	private double height;

	@Column(name = "properties")
	@Convert(converter = StringMapConverter.class)
	private Map<String, String> properties;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "picture_id")
	private List<NameHistory> nameHistory;

	public Picture() {
		super();
	}

	public Picture(int id, String nameDiscription, String discription, String author, String imageUrl, double width,
			double height, Map<String, String> properties) {
		super();
		this.id = id;
		this.nameDiscription = nameDiscription;
		this.discription = discription;
		this.author = author;
		this.imageUrl = imageUrl;
		this.width = width;
		this.height = height;
		this.properties = properties;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameDiscription() {
		return nameDiscription;
	}

	public void setNameDiscription(String nameDiscription) {
		this.nameDiscription = nameDiscription;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public List<NameHistory> getNameHistory() {
		return nameHistory;
	}

	public void setNameHistory(List<NameHistory> nameHistory) {
		this.nameHistory = nameHistory;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", nameDiscription=" + nameDiscription + ", discription=" + discription
				+ ", author=" + author + ", imageUrl=" + imageUrl + ", width=" + width + ", height=" + height
				+ ", properties=" + properties + "]";
	}

	public void add(NameHistory tempNameHistory) {

		if (nameHistory == null) {
			nameHistory = new ArrayList<>();
		}

		nameHistory.add(tempNameHistory);
	}
}
