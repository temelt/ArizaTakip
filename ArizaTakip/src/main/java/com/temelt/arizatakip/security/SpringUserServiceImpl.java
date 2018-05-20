package com.temelt.arizatakip.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.temelt.arizatakip.entity.Kullanici;
import com.temelt.arizatakip.service.KullaniciService;

public class SpringUserServiceImpl implements UserDetailsService{

	@Autowired
	private KullaniciService kullaniciService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Kullanici k = kullaniciService.findByUsrnm(username);
		if(k!=null) {
			User user =new User(username, k.getPsw(), null);
			return user;
		}
		return null;
	}

}
