package kh.java.byte_object;

import java.io.Serializable;

/**
 * 객체입출력스트림 ObjectInput/OutputStream은 반드시 직렬화(Serializable) 인터페이스 구현할 것.
 * - 필드 또한 모두 직렬화인터페이스를 구현해야 함. 대부분의 필드는 직렬화를 구현함 컨트롤 클릭으로 확인해보기
 * 
 *
 */
public class User implements Serializable{

	private String id;
	private String password;
	private String phone;
	
	public User() {
	}
	
	public User(String id, String password, String phone) {
		this.id = id;
		this.password = password;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", phone=" + phone + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
