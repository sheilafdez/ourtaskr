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

@Entity
@Table(name = "Status")
public class Status implements Serializable {

	@Id
	@GeneratedValue
	@Column
	private Long statusId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dashboardId", nullable = false)
	private Dashboard dashboard;

	@Column
	private String name;

	@Column
	private Long position;

	@Column
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;

	@OneToOne
	@JoinColumn(name = "createUserId")
	private User createUser;


	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
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

	@Override
	public String toString() {
		return "Status{" +
				"statusId=" + statusId +
				",\n name='" + name + '\'' +
				",\n position=" + position +
				",\n createDate=" + createDate +
				",\n modifiedDate=" + modifiedDate +
				",\n createUser=" + createUser +
				'}';
	}
}
