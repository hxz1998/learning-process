package com.mrhu.util;

import java.io.UnsupportedEncodingException;
import java.net.*;

public class Encoder {
	private static String result;
	
	public static String EncoderByUTF(String request) throws UnsupportedEncodingException {
		result = URLEncoder.encode(request, "UTF-8");
		return result;
	}
	
	public static String DecoderByUTF(String request) throws UnsupportedEncodingException {
		result = URLDecoder.decode(request, "UTF-8");
		return result;
	}
}
