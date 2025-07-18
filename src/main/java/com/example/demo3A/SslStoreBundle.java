package com.example.demo3A;

import java.security.KeyStore;

public interface SslStoreBundle {
	
	KeyStore getKeyStore();
	String getKeyStorePassword();
	KeyStore getTrustStore();

}
