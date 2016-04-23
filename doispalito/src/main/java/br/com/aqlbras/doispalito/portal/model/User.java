package br.com.aqlbras.doispalito.portal.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

/**
 * This class represents a standard system user
 * @author Willian Antunes
 * @version 1.0.0
 */
@Entity
public class User extends AbstractEntity
{
	@NotNull
	@Length(min = 3, max = 100)
	private String name;
	
	@NotNull
	@Column(length = 128)
	private String password;
	
	@Column(nullable=false)
	@Type(type= "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime birthday;
	
	@Column(nullable=false)
	@Type(type= "org.jadira.usertype.dateandtime.joda.PersistentDateTime")		
	private DateTime registerDate;
	
	@Column(unique = true)
	private String email;
	
	@Length(max=400)
	private String description;	
	
	@OneToOne(optional=false, cascade=CascadeType.ALL)
	private UserProfile userProfile;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Phone> phones;
	
	@Null
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Collection<CustomerOrder> orders;
	
	@ManyToOne(optional=true, cascade=CascadeType.MERGE)
	private Establishment establishment;
	
	@Null
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Collection<Recommendation> recommendations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(DateTime birthday) {
		this.birthday = birthday;
	}

	public DateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(DateTime registerDate) {
		this.registerDate = registerDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Collection<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}

	public Collection<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(Collection<CustomerOrder> orders) {
		this.orders = orders;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public Collection<Recommendation> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(Collection<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}
}
