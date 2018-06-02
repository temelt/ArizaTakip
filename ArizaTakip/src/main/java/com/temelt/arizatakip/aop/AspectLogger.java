package com.temelt.arizatakip.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.temelt.arizatakip.entity.BaseEntity;

@Aspect
@Service
public class AspectLogger {

	@Before("execution(* com.temelt.arizatakip.service.*.save(..))")
	public void logBefore(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		BaseEntity b = (BaseEntity) args[0];
		b.setEkleyen(SecurityContextHolder.getContext().getAuthentication().getName());
		b.setEklenmeTarihi(new Date());
	}
	
}
