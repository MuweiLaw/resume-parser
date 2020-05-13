package com.dc.common.util.base;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

/**
 * Utils - RSA加密解密
 */
public final class RSAUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(RSAUtils.class);

	/** 安全服务提供者 */
	private static final Provider PROVIDER = new BouncyCastleProvider();

	/** 密钥大小 */
	private static final int KEY_SIZE = 1024;

	/**
	 * 不可实例化
	 */
	private RSAUtils() {
	}

	/**
	 * 生成密钥对
	 * 
	 * @return 密钥对
	 */
	public static KeyPair generateKeyPair() {
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", PROVIDER);
			keyPairGenerator.initialize(KEY_SIZE, new SecureRandom());
			return keyPairGenerator.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 加密
	 * 
	 * @param publicKey
	 *            公钥
	 * @param data
	 *            数据
	 * @return 加密后的数据
	 */
	public static byte[] encrypt(PublicKey publicKey, byte[] data) {
		Assert.notNull(publicKey);
		Assert.notNull(data);
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", PROVIDER);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 加密
	 * 
	 * @param publicKey
	 *            公钥
	 * @param text
	 *            字符串
	 * 
	 * @return Base64编码字符串
	 */
	public static String encrypt(PublicKey publicKey, String text) {
		Assert.notNull(publicKey);
		Assert.notNull(text);
		byte[] data = encrypt(publicKey, text.getBytes());
		return data != null ? Base64.encodeBase64String(data) : null;
	}

	/**
	 * 解密
	 * 
	 * @param privateKey
	 *            私钥
	 * @param data
	 *            数据
	 * @return 解密后的数据
	 */
	public static byte[] decrypt(PrivateKey privateKey, byte[] data) {
		Assert.notNull(privateKey);
		Assert.notNull(data);
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", PROVIDER);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		}
	}

	/**
	 * 解密
	 * 
	 * @param privateKey
	 *            私钥
	 * @param text
	 *            Base64编码字符串
	 * @return 解密后的数据
	 */
	public static String decrypt(PrivateKey privateKey, String text) {
		Assert.notNull(privateKey);
		Assert.notNull(text);
		byte[] data = null;
		try {
			data = decrypt(privateKey, new BASE64Decoder().decodeBuffer(text));//jar包冲突，替换为底层sun-jar包
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data != null ? new String(data) : null;
	}
	
	public static String encrypt( String str, String publicKey ) throws Exception{
		//base64编码的公钥
		byte[] decoded = Base64.decodeBase64(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
		//RSA加密
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
		return outStr;
	}

	public static void main(String[] args) {
//		KeyPair keyPair = generateKeyPair();
//		String code = encrypt(keyPair.getPublic(), "1234");
//		String text = decrypt(keyPair.getPrivate(), code);
//		System.out.println("1234".equals(text));
////		Assert.isTrue("1234".equals(text));
//		try {
//			System.out.println(encrypt);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			//获取key对应的value值

			PublicKey string2PublicKey = string2PublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYHU0nrOAEPPKpm+ZiTUCP22u3RnpKigN5PAPEAg4jkOLU7dbVT+5i6jI82t/0ksfnBz1pzd9n4k8dZBXL6Pie9Jj9sONS2pQzBmwnSkz7DZNT+1CYWxY6wlG33i816UfEluKGn9d4e8xqpbNPpoV+crzi8vcVEQea+/0QSOT0jQIDAQAB");
			String encrypt = encrypt(string2PublicKey, "123456");
			System.out.println(encrypt);
//			String encrypt = encrypt("123456", "8d848cce484f818d3588b5b776b6521f16331399e31a210cffeef342e0657f5ab57c17750c14d641794eb944cdb662218a8971bbf4198a8441395645c80d6a2a049c92647a0979fdb396da71f226fd7106de3ee099ddb681d44e3cc07bcf7ba1f0757f554c7f97d73c76f2122c972c84258c3607e3b2b8abe91b4814437f9b93");
//			encrypt("123456", "AIsmKisbr3R1j6qFSPa5g/90AKtAp5QgAViL7qWMDxgg3VOJHTbrwUun9r7L4EYWSkRdZRrj+bUA\\nVozgscV+NwJ6stMw412/zn6tq7NYX8hE0LWSwK2obyslAaf1bH9jQn1bt8IxLt6odp44US1ZMZxU\\nz8YIHSRyPiYnptueZ+Jt");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//将Base64编码后的公钥转换成PublicKey对象
		public static PublicKey string2PublicKey(String pubStr) throws Exception{
			//base64编码的公钥
			byte[] keyBytes = Base64.decodeBase64(pubStr);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey publicKey = keyFactory.generatePublic(keySpec);
			return publicKey;
		}
}