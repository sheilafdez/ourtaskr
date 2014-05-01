package net.javaloping.ourtaskr.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author victormiranda
 */

@Table
@Entity(name = "Category")
public class Category implements Serializable {

	@Id
	@GeneratedValue
	@Column
	private Long categoryId;

	@Column
	private String name;

	@Column
	private String color;

	@Column
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;

	@OneToOne
	@JoinColumn(name = "createUserId")
	private User createUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dashboardId", nullable = false)
	private Dashboard dashboard;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	@Override
	public String toString() {
		return "Category{" +
				"categoryId=" + categoryId +
				", name='" + name + '\'' +
				", color='" + color + '\'' +
				", createDate=" + createDate +
				", modifiedDate=" + modifiedDate +
				", createUser=" + createUser +
				", dashboard=" + dashboard +
				'}';
	}
}
