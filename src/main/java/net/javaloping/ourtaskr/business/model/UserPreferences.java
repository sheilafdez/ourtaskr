package net.javaloping.ourtaskr.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author victormiranda
 */

@Table
@Entity(name = "UserPreferences")
public class UserPreferences implements Serializable {

	@Id
	@Column
	@GeneratedValue
	private Long userPreferenceId;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@Column
	private Boolean muteNotifications;

	public Long getUserPreferenceId() {
		return userPreferenceId;
	}

	public void setUserPreferenceId(Long userPreferenceId) {
		this.userPreferenceId = userPreferenceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getMuteNotifications() {
		return muteNotifications;
	}

	public void setMuteNotifications(Boolean muteNotifications) {
		this.muteNotifications = muteNotifications;
	}

	@Override
	public String toString() {
		return "UserPreferences{" +
				"userPreferenceId=" + userPreferenceId +
				", user=" + user +
				", muteNotifications=" + muteNotifications +
				'}';
	}
}
