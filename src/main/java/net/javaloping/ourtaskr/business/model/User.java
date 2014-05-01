package net.javaloping.ourtaskr.business.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "User")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long userId;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private String password;

	@Column
	private String emailAddress;

	@Column
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;

	@Column
	@Temporal(TemporalType.DATE)
	private Date lastLoginDate;

	@Column
	private Long failedLoginsAttemps;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="User_Dashboard",
			joinColumns={@JoinColumn(name="userId")},
			inverseJoinColumns={@JoinColumn(name="dashboardId")})
	private Set<Dashboard> dashboards = Collections.EMPTY_SET;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserPreferences preferences;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Long getFailedLoginsAttemps() {
		return failedLoginsAttemps;
	}

	public void setFailedLoginsAttemps(Long failedLoginsAttemps) {
		this.failedLoginsAttemps = failedLoginsAttemps;
	}

	public Set<Dashboard> getDashboards() {
		return dashboards;
	}

	public void setDashboards(Set<Dashboard> dashboards) {
		this.dashboards = dashboards;
	}

	public UserPreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(UserPreferences preferences) {
		this.preferences = preferences;
	}


	@Override
	public String toString() {

		Set<Dashboard> dashboards = getDashboards();

		StringBuffer dashboardNameList = new StringBuffer();

		for (Dashboard d : dashboards) {
			dashboardNameList.append("[").append(d.getDashboardId())
				.append("-").append(d.getName()).append("]");
		}

		return "User{" +
				"userId=" + userId +
				",\n password='" + password + '\'' +
				",\n name='" + name + '\'' +
				",\n surname='" + surname + '\'' +
				",\n emailAddress='" + emailAddress + '\'' +
				",\n createDate=" + createDate +
				",\n modifiedDate=" + modifiedDate +
				",\n lastLoginDate=" + lastLoginDate +
				",\n failedLoginsAttemps=" + failedLoginsAttemps +
				",\n dashboards=" + dashboardNameList.toString() +
				",\n preferences=" + preferences +
				'}';
	}
}
