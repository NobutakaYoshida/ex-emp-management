package jp.co.sample.form;

public class LoginForm {
	
	// メールアドレス
	public String mailAddress;
	// パスワード
	public String password;

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "loginForm [mailAddress=" + mailAddress + ", password=" + password + "]";
	}

}
