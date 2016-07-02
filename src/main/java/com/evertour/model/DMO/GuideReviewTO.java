package com.evertour.model.DMO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GUIDEREVIEW")
public class GuideReviewTO {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private long id;

	@Column(name = "TEXTRATING")
	private String ratingText;
	@Column(name = "RATINGSCORE")
	private int ratingScore;
	@Column(name = "CLIENTID")
	private int clientID;

	public GuideReviewTO(long id, String ratingText, int ratingScore, int clientID) {
		this.id = id;
		this.ratingScore = ratingScore;
		this.ratingText = ratingText;
		this.clientID = clientID;
	}
	
	public GuideReviewTO(){}

	public long getID() {
		return id;
	}

	public String getRatingText() {
		return this.ratingText;
	}

	public int getRatingScore() {
		return this.ratingScore;
	}

	public long getClientID() {
		return this.clientID;
	}

}// end of class
