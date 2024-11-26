package com.example.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class InsertAdministratorForm {
	/** 名前 */
	@NotBlank(message="名前を入力してください")
	@Length(max=255, message="255文字以下で入力してください")
	private String name;
	/** メールアドレス */
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="正しいメールアドレスの形式で入力してください")
	@Length(max=255, message="255文字以下で入力してください")
	private String mailAddress;
	/** パスワード */
	@Length(min=6, max=16, message="6文字以上、16文字以下で入力してください")
	private String password;
	/** 確認用パスワード */
	@Length(min=6, max=16, message="6文字以上、16文字以下で入力してください")
	private String passwordConfirmation;

	/**
	 * パスワードと確認用パスワードが同値かどうかを確認する。trueでなければエラーになる。
	 * @return boolean 
	 */
	@AssertTrue(message = "パスワードと確認用パスワードが異なります")
	public boolean isPasswordValid() {
		if (password == null || password.isEmpty()) {
			return true;
		}
		
		return password.equals(passwordConfirmation);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}

}
