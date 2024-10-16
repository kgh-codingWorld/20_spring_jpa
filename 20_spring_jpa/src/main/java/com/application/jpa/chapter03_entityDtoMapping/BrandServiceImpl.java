package com.application.jpa.chapter03_entityDtoMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.jpa.data.Brand;
import com.application.jpa.data.BrandDTO;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	
	@Override
	public List<BrandDTO> getAllBrands() {
		
//		List<Brand> temps = brandRepository.findAll();
//		List<BrandDTO> brands = BrandMapper.toDtoList(temps);
//		
//		return brands;
		
		// JPA Repository의 Entity 객체를 DTO 객체로 변환
		return BrandMapper.toDtoList(brandRepository.findAll());
	}

	@Override
	public BrandDTO getBrandById(Long brandId) {

		// brandId를 사용하여 entity타입으로 데이터를 조회
		Brand brand = brandRepository.findById(brandId).orElse(null);
		
		// 정적(static) 메서드 매핑
		BrandDTO brandDTO = BrandMapper.toDTO(brand);
		
		return brandDTO;
		
	}

	@Override
	public void createBrand(BrandDTO brandDTO) {
	
		//brandRepository.save(brandDTO); (오류)
		
		// 정적(static) 메서드 매핑
		Brand brand = BrandMapper.toEntity(brandDTO);
		brandRepository.save(brand);

	}

	@Override
	public void updateBrand(Long brandId, BrandDTO brandDTO) {
		
		Brand brand = brandRepository.findById(brandId).orElse(null);
		brand.setBrandNm(brandDTO.getBrandNm());
		brand.setActiveYn(brandDTO.getActiveYn());
		brand.setEnteredDt(brandDTO.getEnteredDt());
		
		brandRepository.save(brand);
		
	}

	@Override
	public void deleteBrand(Long brandId) {
		brandRepository.deleteById(brandId);
	}

}
