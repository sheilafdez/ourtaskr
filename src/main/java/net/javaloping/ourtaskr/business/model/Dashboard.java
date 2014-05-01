package net.javaloping.ourtaskr.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author victormiranda
 */

@Table
@Entity(name = "Dashboard")
public class Dashboard implements Serializable {

	@Id
	@GeneratedValue
	@Column
	private Long dashboardId;

	@Column
	private String name;

	@Column
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dueDate;

	@OneToOne
	@JoinColumn(name = "createUserId")
	private User createUser;

	@ManyToMany(mappedBy = "dashboards")
	private Set<User> users = Collections.EMPTY_SET;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dashboard")
	private Set<Category> categories = Collections.EMPTY_SET;

	@OneToMany(mappedBy = "dashboard")
	private Set<Ticket> tickets = Collections.EMPTY_SET;

	@OneToMany(mappedBy = "dashboard")
	private Set<Status> statuses = Collections.EMPTY_SET;

	public Long getDashboardId() {
		return dashboardId;
	}

	public void setDashboardId(Long dashboardId) {
		this.dashboardId = dashboardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Set<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(Set<Status> statuses) {
		this.statuses = statuses;
	}


	@Override
	public String toString() {

		Set<User> users = getUsers();

		StringBuffer usersNameList = new StringBuffer();

		for (User u : users) {
			usersNameList.append("[").append(u.getUserId())
					.append("-").append(u.getName()).append("]");
		}
		return "Dashboard{" +
				"dashboardId=" + dashboardId +
				",\n name='" + name + '\'' +
				",\n createDate=" + createDate +
				",\n modifiedDate=" + modifiedDate +
				",\n dueDate=" + dueDate +
				",\n createUser=" + createUser +
				",\n users=" + usersNameList +
				",\n categories=" + categories +
				",\n statuses=" + statuses +
				'}';
	}
}
