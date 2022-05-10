package com.example.validatingforminput;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PersonForm {

	@NotNull
	@Size(min = 3)
	private String email;

	@NotNull
	@Size(min = 5)
	@Pattern(regexp = ".*([a-z].*[A-Z]|[A-Z].*[a-z]).*")
	private String password;

	@NotNull
	private String passwordConf;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConf()
	{
		return passwordConf;
	}

	public void setPasswordConf(String passwordConf)
	{
		this.passwordConf = passwordConf;
	}

	@Override
	public String toString()
	{
		return "PersonForm{" +
				"email='" + email + '\'' +
				", password='" + password + '\'' +
				", passwordConf='" + passwordConf + '\'' +
				'}';
	}
}
