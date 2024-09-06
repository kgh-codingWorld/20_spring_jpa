package com.application.jpa.data;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity // JPA 엔티티 사용 선언
@DynamicUpdate // 하이버네이트 스펙에서 지원해주는 기능으로 @DynamicUpdate 애노테이션을 사용하여 변경되는 컬럼만 추적하여 수정한다.
public class Brand {
	
	@Id // import jakarta.persistence.Id;
	private long brandId; // primary key 컬럼으로 지정
	private String brandNm;
	private Date enteredDt;
	private String activeYn;
}
