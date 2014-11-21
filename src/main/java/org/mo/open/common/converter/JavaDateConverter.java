package org.mo.open.common.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 时间戳转化为Date（or String）
 * 
 * @author moziqi
 *
 */
public final class JavaDateConverter {
	
	private JavaDateConverter(){}
	
	public static Date StringConverterDate(String date){
		Date parse =null;
		try {
			Long time = Long.valueOf(date);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
			String format = simpleDateFormat.format(time);
			parse = simpleDateFormat.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse;
	}
}
