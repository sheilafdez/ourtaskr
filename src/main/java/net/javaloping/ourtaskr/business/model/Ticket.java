package net.javaloping.ourtaskr.business.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * @author victormiranda
 */

@Entity
@Table(name = "Ticket")
public class Ticket implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long ticketId;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private Boolean locked;

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

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="User_Ticket",
			joinColumns={@JoinColumn(name="ticketId")},
			inverseJoinColumns={@JoinColumn(name="userId")})
	private Set<User> users = Collections.EMPTY_SET;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "statusId")
	private Status status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dashboardId")
	private Dashboard dashboard;

	@ManyToMany
	@JoinTable(name="Category_Ticket",
			joinColumns={@JoinColumn(name="ticketId")},
			inverseJoinColumns={@JoinColumn(name="categoryId")})
	private Set<Category> categories = Collections.EMPTY_SET;

	@OneToMany
	@JoinColumn(name="ticketId")
	private Set<TicketComment> comments = Collections.EMPTY_SET;


	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
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

	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<TicketComment> getComments() {
		return comments;
	}

	public void setComments(Set<TicketComment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Ticket{" +
				"ticketId='" + ticketId + '\'' +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", locked=" + locked +
				", createDate=" + createDate +
				", modifiedDate=" + modifiedDate +
				", dueDate=" + dueDate +
				", createUser=" + createUser +
				", users=" + users +
				", status=" + status +
				", categories=" + categories +
				", comments=" + comments +
				'}';
	}
}
