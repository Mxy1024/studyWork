package com.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;


/**
 * ���ܣ�MD5���ܹ�����
 * ˵����ת����ע�����Ĳ���Сվ---http://www.wenboxz.com
 */
public class MD5Util {
	/**
	 * 1.���ı�����32λСдMD5����
	 * @param plainText Ҫ���м��ܵ��ı�
	 * @return ���ܺ������
	 */
	public static String textToMD5L32(String plainText){
		String result = null;
		//�����ж��Ƿ�Ϊ��
		if(StringUtils.isBlank(plainText)){
			return null;
		}
		try{
			//���Ƚ���ʵ�����ͳ�ʼ��
			MessageDigest md = MessageDigest.getInstance("MD5");
			//�õ�һ������ϵͳĬ�ϵ��ֽڱ����ʽ���ֽ�����
			byte[] btInput = plainText.getBytes();
			//�Եõ����ֽ�������д���
			md.update(btInput);
			//���й�ϣ���㲢���ؽ��
			byte[] btResult = md.digest();
			//���й�ϣ�����õ������ݵĳ���
			StringBuffer sb = new StringBuffer();
			for(byte b : btResult){
				int bt = b&0xff;
				if(bt<16){
					sb.append(0);
				}
				sb.append(Integer.toHexString(bt));
			}
			result = sb.toString();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 2.���ı�����32λMD5��д����
	 * @param plainText Ҫ���м��ܵ��ı�
	 * @return ���ܺ������
	 */
	public static String textToMD5U32(String plainText){
		if(StringUtils.isBlank(plainText)){
			return null;
		}
		String result = textToMD5L32(plainText);
		return result.toUpperCase();
	}
	
	/**
	 * 3.���ı�����16λMD5Сд����
	 * @param plainText ��Ҫ���м��ܵ��ı�
	 */
	public static String textToMD5L16(String plainText){
		if(StringUtils.isBlank(plainText)){
			return null;
		}
		String result = textToMD5L32(plainText);
		return result.substring(8,24);
	}
	
	/**
	 * 4.���ı�����16λMD5��д����
	 * @param plainText ��Ҫ���м��ܵ��ı�
	 * @return
	 */
	public static String textToMD5U16(String plainText){
		if(StringUtils.isBlank(plainText)){
			return null;
		}
		String result = textToMD5L32(plainText);
		return result.toUpperCase().substring(8, 24);
	}
	
	public static void main(String[] args) {
		System.out.println(textToMD5U16("0"));
	}
}
