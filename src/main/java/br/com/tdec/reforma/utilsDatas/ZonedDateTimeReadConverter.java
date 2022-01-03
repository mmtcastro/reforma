package br.com.tdec.reforma.utilsDatas;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class ZonedDateTimeReadConverter implements Converter<Date, ZonedDateTime> {

	@Override
	public ZonedDateTime convert(Date date) {
		return date.toInstant().atZone(ZoneOffset.UTC);
	}

	public class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, Date> {
		@Override
		public Date convert(ZonedDateTime zonedDateTime) {
			return Date.from(zonedDateTime.toInstant());
		}
	}

}
