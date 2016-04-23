package br.com.aqlbras.doispalito.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserProfile
{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	@Column(nullable = false, columnDefinition="TINYINT(1) DEFAULT 5")
	private int timeOutTreatment;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UserProfileType userProfileType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTimeOutTreatment() {
		return timeOutTreatment;
	}

	public void setTimeOutTreatment(int timeOutTreatment) {
		this.timeOutTreatment = timeOutTreatment;
	}

	public UserProfileType getUserProfileType() {
		return userProfileType;
	}

	public void setUserProfileType(UserProfileType userProfileType) {
		this.userProfileType = userProfileType;
	}
}