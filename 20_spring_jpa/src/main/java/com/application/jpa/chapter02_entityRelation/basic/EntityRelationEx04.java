package com.application.jpa.chapter02_entityRelation.basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/*
 
 	4. 제약사항 (Constraint)
 
		1) 기본 키는 엔티티의 각 인스턴스를 고유하게 식별한다. 
		  - JPA에서는 @Id와 @GeneratedValue 애노테이션을 사용하여 기본 키를 정의한다.
		
		2) NOT NULL 제약사항은 특정 컬럼이 NULL 값을 가질 수 없도록 한다. 
		  - @Column 애노테이션의 nullable 속성을 사용하여 설정할 수 있다.
		
		3) 유니크 제약사항은 특정 컬럼의 값이 중복되지 않도록 한다. 
		  - @Column 애노테이션의 unique 속성을 사용하거나 @UniqueConstraint 애노테이션을 사용하여 설정할 수 있다.
		
		4) 길이 제약사항
		  - 문자열 길이 제약사항은 @Column 애노테이션의 length 속성을 사용하여 설정할 수 있다.
		
		5) 외래 키 제약사항은 엔티티 간의 관계를 정의하고 무결성을 유지한다. 
		  - @ManyToOne, @OneToMany, @OneToOne, @ManyToMany 애노테이션을 사용하여 설정할 수 있다.

*/
@Entity
@Table(name="entity_test4", uniqueConstraints = @UniqueConstraint(columnNames = {"COL4"}))
public class EntityRelationEx04 {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COL1")
	private Long test1;
	
	@Column(name="COL2" , nullable = false)
	private String test2;
	
	@Column(name="COL3" , unique = true)
	private String test3;
	
	@Column(name="COL4")
	private String test4;
	
	@Column(name="COL5" , columnDefinition = "CHAR(1) DEFAULT 'y'")
	private String test5;
	
	
	private String test6;
	
}
