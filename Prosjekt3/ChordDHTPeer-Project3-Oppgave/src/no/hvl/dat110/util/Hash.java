package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static int mbit = 128;			// using SHA-1 compresses/hashes to 160bits

	public static int sbit = 4;			// we use this for the size of the finger table
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		try{
			// we use MD5 with 128 bits digest
			MessageDigest md = MessageDigest.getInstance("MD5");
			// compute the hash of the input 'entity'
			byte[] digest = md.digest(entity.getBytes("utf8"));

			// convert the hash into hex format
			String hex = toHex(digest);

			// convert the hex into BigInteger
			hashint = new BigInteger(hex, 16);

		}catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
			e.printStackTrace();
		}
		// return the BigInteger
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		// get the digest length

		int bytes = hashint.bitLength();

		//BigInteger modulos= new BigInteger("2");

		// compute the number of bits = digest length * 8
		bytes = bytes*8;
		// compute the address size = 2 ^ number of bits
		BigInteger addressSize = new BigInteger(String.valueOf(Math.pow(2, bytes)));
		// return the address size
		
		return addressSize;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		digestlen = addressSize().bitLength();

		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
