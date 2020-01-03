package com.igoredm.arangodbbasicservice.model.dbconfig;

import com.arangodb.ArangoDB.Builder;
import com.arangodb.Protocol;
import com.arangodb.entity.LoadBalancingStrategy;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;

import javax.net.ssl.TrustManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

@Configuration
@EnableArangoRepositories(basePackages = {"br.com.accesstage.daycovalservicos"})
@ConfigurationProperties(prefix = "arangodb")
public class ArangoDb implements ArangoConfiguration {

    @Value("${spring.datasource.host}")
    private String host;

    @Value("${spring.datasource.port}")
    private Integer port;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public Builder arango() {

        // Para Conexões SSL - INIT

        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                    throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                    throws CertificateException {
            }
        }};

        SSLContext sc = null;

        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Para Conexões SSL - END

        Builder builder = new Builder()
                .loadBalancingStrategy(LoadBalancingStrategy.ROUND_ROBIN)
                .acquireHostList(true)
                .maxConnections(20)
                .useSsl(false)
                .sslContext(sc)
                .host(host, port)
                .user(user)
                .password(password)
                .useProtocol(Protocol.VST);

        return builder;
    }

    @Override
    public String database() {
        return "daycoval";
    }

}