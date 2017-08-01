package br.com.smartschool.business;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BusinessResponse<T> {

	private T content;
	
	private Map<String, String> messages;
	
	private BusinessResponseStatus status;

	public enum BusinessResponseStatus {
		OK, ERROR;
	}
}
