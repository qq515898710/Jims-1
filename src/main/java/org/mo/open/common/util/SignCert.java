package org.mo.open.common.util;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Date;

import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateValidity;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

public class SignCert {

	public static void main(String[] args) throws Exception{
		//签发者信息
		FileInputStream fis = new FileInputStream("D:/2tools/java/jdk1.8.0_18/bin/rootStore");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(fis, "p@ssw0rd888168".toCharArray());
		Certificate c1 = ks.getCertificate("rootTest");
		PrivateKey caprk = (PrivateKey) ks.getKey("rootTest", "p@ssw0rd888168".toCharArray());//证书私钥
		fis.close();
		byte[] encode1 = c1.getEncoded();
		X509CertImpl cimpl = new X509CertImpl(encode1);
		X509CertInfo cinfol = (X509CertInfo) cimpl.get(X509CertImpl.NAME+"."+X509CertImpl.INFO);
		X500Name issuer = (X500Name) cinfol.get(X509CertInfo.SUBJECT+"."+CertificateIssuerName.DN_NAME);
		
		//待签发者
		FileInputStream fis2 = new FileInputStream("D:/2tools/java/jdk1.8.0_18/bin/www.comserverdomian.com.cer");
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		Certificate c2 = cf.generateCertificate(fis2);
		fis2.close();
		byte[] encode2 = c2.getEncoded();
		X509CertImpl cimp2 = new X509CertImpl(encode2);
		X509CertInfo cinfo2 = (X509CertInfo) cimp2.get(X509CertImpl.NAME+"."+X509CertImpl.INFO);
		Date begindate = new Date();//设置有效期
		Date enddate = new Date(begindate.getTime()+3000*24*60*60*1000L);
		CertificateValidity cv = new CertificateValidity(begindate,enddate);
		cinfo2.set(X509CertInfo.VALIDITY, cv);
		int sn = (int) (begindate.getTime()/1000);//设置证书的序列号
		CertificateSerialNumber csn = new CertificateSerialNumber(sn);
		cinfo2.set(X509CertInfo.SERIAL_NUMBER, csn);
		cinfo2.set(X509CertInfo.ISSUER+"."+CertificateIssuerName.DN_NAME, issuer);//设置证书的签发者是谁
		AlgorithmId algorithm = new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);//设置证书的算法
		cinfo2.set(CertificateAlgorithmId.NAME+"."+CertificateAlgorithmId.ALGORITHM, algorithm);
		X509CertImpl newcert = new X509CertImpl(cinfo2);//创建一个证书并使用签发者的私钥对待签发者进行签名
		newcert.sign(caprk, "MD5WithRSA");
		System.out.println(newcert);
		ks.setCertificateEntry("signedCer", newcert);//将新条目存入到密钥库中
		FileOutputStream fos = new FileOutputStream("D:/2tools/java/jdk1.8.0_18/bin/newsSingedStore");//再把密钥库输出到一个新的密钥库中
		ks.store(fos, "newsSingedPass".toCharArray());
		fos.close();
	}
}
