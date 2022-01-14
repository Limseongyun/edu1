//package com.example.demo.mvc.model.entity;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//import javax.persistence.UniqueConstraint;
//
//import org.hibernate.annotations.DynamicInsert;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
////@Builder
//@ToString
////@Entity
//@Getter
//@Setter
//@Table(name = "tb_user", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "user_ty_code"}))
//@DynamicInsert
//@EntityListeners(AuditingEntityListener.class)
//@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "tb_user_seq", sequenceName = "tb_user_seq")
//public class User extends Base implements UserDetails {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_user_seq")
//	@Column(name = "user_sn")
//	private Long userSn;
//	
//	@Column(name = "user_nm")
//	private String userNm;
//	
//	@Column(name = "user_id")
//	private String userId;
//	
//	@Column(name = "user_pw")
//	private String userPw;
//	
//	@OneToOne
//	@JoinColumn(name = "user_sttus_code")
//	private CmmnCodeDetail userSttusCode;
//	
//	@OneToOne
//	@JoinColumn(name = "user_ty_code")
//	private CmmnCodeDetail userTyCode;
//	
//	@JsonManagedReference// Jackson Serialize시 무한 참조 오류(Serial 정상진행)
//	@OneToMany(mappedBy = "userSn", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private List<UserRole> userRoles = new ArrayList<>();
//	
//	public void addRoles(UserRole userRole) {
//		this.userRoles.add(userRole);
//		userRole.setUserSn(this);
//	}
//
//	//USER Detail Impl ----------------
//	@Transient
//	private Collection<SimpleGrantedAuthority> authorities;
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return this.authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return this.userPw;
//	}
//
//	@Override
//	public String getUsername() {//sn
//		return String.valueOf(this.userSn);
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//}
//
//
////	@OneToOne
////	@JoinColumns({
////		@JoinColumn(name = "code_id", referencedColumnName = "code_id"),
////		@JoinColumn(name = "code_value", referencedColumnName = "code_value")
////	})
////	private CmmnCodeDetail userSttusCode;
//	
////	@OneToOne
////	@JoinColumns({
////		@JoinColumn(name = "code_id", referencedColumnName = "code_id"),
////		@JoinColumn(name = "code_value", referencedColumnName = "code_value")
////	})
////	private CmmnCodeDetail userTyCode;