package com.ezen.spg06;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		// 검증할 객체의 클래스 타입 정보
		return ContentDto.class.isAssignableFrom(clazz);
		// 거의 사용되지 않는 메서드.
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		ContentDto dto = (ContentDto)target;
		String sWriter = dto.getWriter();
		String sContent = dto.getContent();
		
		// 널(new String()조차도 실행안된 것)이거나 값이 비었거나("")
		if(sWriter == null || sWriter.trim().isEmpty()) {
			System.out.println("Writer is null or empty");
			errors.rejectValue("writer","trouble");
		}
		if(sContent == null || sContent.trim().isEmpty()) {
			System.out.println("Content is null or empty");
			errors.rejectValue("content","trouble");
		}
	}
}
