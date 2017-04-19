package br.com.smartschool.converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import org.neo4j.ogm.typeconversion.AttributeConverter;

public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Long> {

	@Override
	public Long toGraphProperty(LocalDateTime value) {
		return value.atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli();
	}

	@Override
	public LocalDateTime toEntityAttribute(Long value) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(value), TimeZone.getDefault().toZoneId());
	}

}
