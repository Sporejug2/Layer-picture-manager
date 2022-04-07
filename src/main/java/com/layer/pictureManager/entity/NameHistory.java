package com.layer.pictureManager.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "name_history")
public class NameHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "old_name")
	private String old_name;
	
	@Column(name = "creation_time")
	private Timestamp creationTime;
	
	@Column(name = "picture_id")
	private int picture_id;

	public NameHistory() {
		super();
	}

	public NameHistory(String old_name, Timestamp creationTime) {
		super();
		this.old_name = old_name;
		this.creationTime = creationTime;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOld_name() {
		return old_name;
	}

	public void setOld_name(String old_name) {
		this.old_name = old_name;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public int getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(int picture_id) {
		this.picture_id = picture_id;
	}

	@Override
	public String toString() {
		return "NameHistory [id=" + id + ", old_name=" + old_name + ", creationTime=" + creationTime + ", picture_id="
				+ picture_id + "]";
	}
	
}
