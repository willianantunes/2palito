package br.com.aqlbras.doispalito.portal.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;

@Entity
public class CustomerOrder extends AbstractEntity
{
	@NotNull
	private String idOrder;
	
	@Column(nullable = false, columnDefinition = "BIT DEFAULT 0", length = 1, insertable=false, updatable=true)
	private boolean favourite;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CustomerOrderStatus customerOrderStatus;
	
	@Column(nullable=false)
	@Type(type= "org.jadira.usertype.dateandtime.joda.PersistentDateTime")		
	private DateTime registerDate;

	@Column(nullable=true)
	@Type(type= "org.jadira.usertype.dateandtime.joda.PersistentDateTime")	
	private DateTime lastUpdateDate;	
		
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	private User user;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	private Establishment establishment;	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", nullable = false)
	private Collection<ProductItem> productItems;

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public boolean isFavourite() {
		return favourite;
	}

	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}

	public CustomerOrderStatus getCustomerOrderStatus() {
		return customerOrderStatus;
	}

	public void setCustomerOrderStatus(CustomerOrderStatus customerOrderStatus) {
		this.customerOrderStatus = customerOrderStatus;
	}

	public DateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(DateTime registerDate) {
		this.registerDate = registerDate;
	}

	public DateTime getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(DateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public Collection<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(Collection<ProductItem> productItems) {
		this.productItems = productItems;
	}
}
