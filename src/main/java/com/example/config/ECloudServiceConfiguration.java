package com.example.config;

import com.chinamobile.cmss.sdk.image.ECloudDefaultClient;
import com.chinamobile.cmss.sdk.image.IECloudClient;
import com.chinamobile.cmss.sdk.image.http.constant.Region;
import com.chinamobile.cmss.sdk.image.http.signature.Credential;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ECloudServiceConfiguration {
    public IECloudClient getMyClient(String username,String password){
        Credential credential = new Credential(username, password);
        return new ECloudDefaultClient(credential, Region.POOL_SZ);
    }
}
