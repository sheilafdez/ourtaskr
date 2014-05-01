package net.javaloping.ourtaskr.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "TicketComment")
public class TicketComment implements Serializable {

	@Id
	@GeneratedValue
	@Column
	private Long ticketCommentId;

	@Column
	private String comment;

	@Column
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;

	@OneToOne
	@JoinColumn(name = "createUserId")
	private User createUser;

	public Long getTicketCommentId() {
		return ticketCommentId;
	}

	public void setTicketCommentId(Long ticketCommentId) {
		this.ticketCommentId = ticketCommentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "TicketComment{" +
				"ticketCommentId=" + ticketCommentId +
				", comment='" + comment + '\'' +
				", createDate=" + createDate +
				", modifiedDate=" + modifiedDate +
				", createUser=" + createUser +
				'}';
	}
}
