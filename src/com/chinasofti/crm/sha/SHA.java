package com.chinasofti.crm.sha;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class SHA {
	public static String getSHA(String str){
		MessageDigest digest;
		String output="";
	    try {
	        digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(str.getBytes("UTF-8"));
	        output = Hex.encodeHexString(hash);
	        //System.out.println(output);
	    } catch (NoSuchAlgorithmException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }catch (UnsupportedEncodingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return output;
	}
	/*public static void main(String[] args) {
		System.out.println(java.util.UUID.randomUUID());
	}*/
}
