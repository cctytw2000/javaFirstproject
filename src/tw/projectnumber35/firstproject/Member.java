package tw.projectnumber35.firstproject;

public class Member {
	private String account;
	private String newpassword;
	private String password;
	private int VerificationCode;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getVerificationCode() {
		return VerificationCode;
	}

	public void setVerificationCode(int verificationCode) {
		VerificationCode = verificationCode;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

}
