package com.kh.security.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.security.model.dao.SecurityDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SecurityService implements UserDetailsService {

	@Autowired
	private SecurityDao securityDao;
	/**
	 * username으로 db 조회 시 회원이 있는 경우, UserDetails(Member)객체 반환
	 * username으로 db 조회 시 회원이 없는 경우, UsernameNotFoundException예외 던지기
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails member = securityDao.loadUserByUsername(username);
		log.info("member = {}", member);
		if(member == null)
			throw new UsernameNotFoundException(username);
		
		return member;
	}

}
