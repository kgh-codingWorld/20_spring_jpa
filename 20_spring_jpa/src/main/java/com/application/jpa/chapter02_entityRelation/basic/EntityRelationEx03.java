package com.application.jpa.chapter02_entityRelation.basic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;
import net.bytebuddy.asm.Advice.Local;


/*
 
	3. 필드와 컬럼 매핑


	1) 어노테이션

		@Column : 필드가 매핑될 테이블의 컬럼을 명시한다. (name, nullable, length 등의 속성을 가질 수 있음)
	
		@Temporal : 날짜(java.util.Date, java.util.Calendar)타입의 매핑을 명시한다. (TemporalType.DATE, TemporalType.TIME, TemporalType.TIMESTAMP 중 선택)
	
		@Lob : 이진형 대용량 객체 BLOB(Binary Large Object) , 문자형 대용량 객체 CLOB(Character Large Object)타입의 매핑을 명시한다.
	
		@Enumerated : Enum 타입의 매핑을 명시한다.
	
		@Transient : 필드가 영속성 컨텍스트에 저장되거나 검색되지 않음을 나타낸다.

		


	2) 타입

		2-1) 정수 (Long , Integer)
			Long 	 : 메모리 사용량 8 바이트 , 범위 : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
			Integer  : 메모리 사용량 4 바이트  , 범위 : -2,147,483,648 ~ 2,147,483,647
		
		
		2-2) 실수 (Double)
		
		
		2-3) 문자열 (String , @Lob)
		
			String  : 기본값 255
		
			@Lob
			String	 
			
			[Database마다 다름 MySQL 기준] 
			
			TEXT(최대 65,535자), MEDIUMTEXT(최대 16,777,215자), LONGTEXT(최대 4GB)
			BLOB(최대 65,535바이트), MEDIUMBLOB(최대 16,777,215바이트), LONGBLOB(최대 4GB)
	
	
		2-4) 날짜 (@Temporal , LocalDate , LocalDateTime)
			
			@Temporal(TemporalType.정책) : DATE > 날짜 , TIME > 시간 , TIMESTAMP
			Date
			
			LocalDate 					 : 날짜  > Date 
		
			LocalDateTime 				 : 날짜 + 시간 > Timestamp
		
			
		2-5) enum
		
			Enumerated(EnumType.타입작성) 
			
			@Enumerated(EnumType.ORDINAL) : 기본값 , 순서대로 데이터가 저장됨 (예시 : 0 , 1 , 2 > 불안한 정책) 
			@Enumerated(EnumType.STRING)  : 타입으로 저장됨 (예시 : USER , SELLER , ADMIN > 권장)

*/
	
@Data
@Entity
@Table(name="entity_test3")
public class EntityRelationEx03 {
	@Id
	private Long a;// 정수 예시
	private Integer b;// 정수 예시
	private Double c;// 실수 예시
	private String d1;// 글자 예시1 (length 속성 생략시 기본값은 255이다.)
	
	@Column(length=10) // length는 글자데이터에만 사용한다.
	private String d2;// 글자 예시2
	@Lob // 대용량 문자열
	private String d3;// 글자 예시3	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date f1;// 날짜 예시1 (DATE , TIME , TIMESTAMP)
	
	// 최신하이버네이트 지원
	private LocalDate f2; // 날짜 예시2(Date)
	private LocalDateTime f3; // 날짜 예시3(Date + Time > DateTime)
	
	//@Enumerated(EnumType.ORDINAL) 
	@Enumerated(EnumType.STRING)
	private RoleType g; // enum 예시
	
	@Transient // 데이터베이스에는 존재하지 않지만 Entity에는 존재하게 함
	private String h;// @Transient 예시
	
//	void test() {
//		g.ADMIN
//	}

}
