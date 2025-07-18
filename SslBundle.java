package com.example.demo3A;

import javax.net.ssl.SSLContext;

public interface SslBundle {
	
	SslStoreBundle getStore();
	SslManagerBundle getManagers();
	SSLContext createSSLContext();

}
