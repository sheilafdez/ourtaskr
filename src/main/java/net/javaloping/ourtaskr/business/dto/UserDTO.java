package net.javaloping.ourtaskr.business.dto;

import net.javaloping.ourtaskr.util.annotations.NotNull;

import java.util.Date;

/**
 * @author victormiranda
 */
public class UserDTO {

	private Long userId;

	@NotNull
	private String name;

	private String surname;

	private String password;

	private String emailAddress;

	private Date createDate;

	private Date modifiedDate;

	private Date lastLoginDate;

	private Long failedLoginsAttemps;

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
}
