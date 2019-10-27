package com.kyle.ssh.converters;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class SSHDateConverters extends StrutsTypeConverter{

	private DateFormat dateFormat;
	
	{
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}
	/*
	 * ��ʾ��String����ת������������
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class  toClass) {
		if(toClass == Date.class){
			try {
				return dateFormat.parse(values[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * ��ʾת����String����
	 */
	@Override
	public String convertToString(Map arg0, Object arg1) {
        if(arg1 instanceof Date){
        	return dateFormat.format((Date)arg1);
        }
		return null;
	}

	
}
