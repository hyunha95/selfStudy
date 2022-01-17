package com.kh.spring.member.model.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * Security가 Member를 관리하기 위한 규격 UserDetails
 * - getUsername
 * - getPassword
 * - isEnabled
 * - getAuthorities
 * 
 * - isAccountNonExpired
 * - isAccountNonLocked
 * - isCredentialsNonExpired
 * 
 * @Builder 
 * 	- class level에 사용하면 @AllArgsConstructor 인자에 대한 builder생성
 *  - 생성자 level에 사용하면 해당 생성자의 인자에 대해 builder생성
 * 
 * 
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Member extends MemberEntity implements Serializable, UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<SimpleGrantedAuthority> authorities;
	
	@Builder
	public Member(String id, String password, String name, String gender, Date birthday, String email, String phone,
			String address, String[] hobby, Date enrollDate, boolean enabled,
			List<SimpleGrantedAuthority> authorities) {
		super(id, password, name, gender, birthday, email, phone, address, hobby, enrollDate, enabled);
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return getId();
	}

	// true로 바꿔줄 것
	@Override
	public boolean isAccountNonExpired() { return true;	}

	@Override
	public boolean isAccountNonLocked() { return true; }

	@Override
	public boolean isCredentialsNonExpired() {return true;}

}
