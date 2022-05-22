package com.example.service.impl;

import com.chinamobile.cmss.sdk.image.IECloudClient;
import com.chinamobile.cmss.sdk.image.request.EngineImageClassifyDetectPostRequest;
import com.chinamobile.cmss.sdk.image.response.EngineImageClassifyDetectResponse;
import com.chinamobile.cmss.sdk.image.response.bean.EngineClassify;
import com.chinamobile.cmss.sdk.image.util.JacksonUtil;
import com.example.config.ECloudServiceConfiguration;
import com.example.service.ItemRecognitionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class ItemRecognitionServiceImpl implements ItemRecognitionService {

    @Resource
    ECloudServiceConfiguration cloudServiceConfiguration;

    @Override
    public String ItemRecognition(String picture) {
        IECloudClient ecloudClient = cloudServiceConfiguration
                .getMyClient("6a6f35f1504044d98a07f1343322437c", "8a4e87d19a384afbad2931499dbdf61d");

        String data = "";
        String[] spl = picture.split(" ");
        for (int i = 0; i<spl.length ; i ++){
            data = data + spl[i];
            if(i!=spl.length-1){
                data = data + "+";
            }
        }


        try {
            EngineImageClassifyDetectPostRequest request = new EngineImageClassifyDetectPostRequest();
            request.setImage(data);
            System.out.println(data);
            EngineImageClassifyDetectResponse response = ecloudClient.call(request);

            if("OK".equals(response.getState())){
                List<EngineClassify> body = response.getBody();
                return JacksonUtil.toJson(body);
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
