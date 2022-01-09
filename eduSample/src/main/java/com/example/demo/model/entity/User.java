package com.example.demo.model.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

//@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_user")
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "tb_user_seq", sequenceName = "tb_user_seq")
public class User extends Base implements UserDetails {
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_user_seq")
	@Column(name = "user_sn")
	private Long userSn;
	
	@Column(name = "user_nm")
	private String userNm;
	
	@Column(name = "user_id", unique = true)
	private String userId;
	
	@Column(name = "user_pw")
	private String userPw;
	
	@Column(name = "user_sttus_code")
	private String userSttusCode;
	
	@Column(name = "user_ty_code")
	private String userTyCode;

	//USER Detail Impl ----------------
	@Transient
	private Collection<SimpleGrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.userPw;
	}

	@Override
	public String getUsername() {//sn
		return String.valueOf(this.userSn);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
