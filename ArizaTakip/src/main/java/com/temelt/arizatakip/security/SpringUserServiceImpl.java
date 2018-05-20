package com.temelt.arizatakip.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.temelt.arizatakip.entity.Kullanici;
import com.temelt.arizatakip.service.KullaniciService;

public class SpringUserServiceImpl implements UserDetailsService{

	@Autowired
	private KullaniciService kullaniciService;
	Md5PasswordEncoder encoder =new Md5PasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Kullanici k = kullaniciService.findByUsrnm(username);
		if(k!=null) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
			List<SimpleGrantedAuthority> auth = new ArrayList<SimpleGrantedAuthority>();
			auth.add(authority);
			User user =new User(username, k.getPsw(), auth);
			return user;
		}
		return null;
	}
	
	
	public void kaydet(Kullanici kullanici) {
		String encodedPass = encoder.encodePassword(kullanici.getPsw(), null);
		kullanici.setPsw(encodedPass);
		kullaniciService.save(kullanici);
	}

}
