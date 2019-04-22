package com.mrhu.util;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class EncoderTest {

	@Test
	public void testEncoderByUTF() throws UnsupportedEncodingException {
		String encode = Encoder.EncoderByUTF("呼啸中");
		System.out.println(encode);
	}

	@Test
	public void testDecoderByUTF() throws UnsupportedEncodingException {
		String decode = Encoder.DecoderByUTF("%E5%91%BC%E5%95%B8%E4%B8%AD");
		System.out.println(decode);
	}

}
