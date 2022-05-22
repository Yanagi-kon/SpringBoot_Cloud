package com.example.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinamobile.cmss.sdk.ocr.ECloudDefaultClient;
import com.chinamobile.cmss.sdk.ocr.http.constant.Region;
import com.chinamobile.cmss.sdk.ocr.http.signature.Credential;
import com.chinamobile.cmss.sdk.ocr.request.IECloudRequest;
import com.chinamobile.cmss.sdk.ocr.request.ocr.OcrRequestFactory;
import com.chinamobile.cmss.sdk.ocr.util.ImageUtil;
import com.example.service.TextRecognitionService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author CMSS
 */
@Service
public class TextRecognitionServiceImpl implements TextRecognitionService {


    public static String user_ak;
    private static String user_sk;
    private static ECloudDefaultClient client;


    static {

        user_ak = "6a6f35f1504044d98a07f1343322437c";
        user_sk = "8a4e87d19a384afbad2931499dbdf61d";
        Credential credential = new Credential(user_ak, user_sk);
        client = new ECloudDefaultClient(credential, Region.POOL_SZ);
    }

//    static String file = null;
//    public static void main(String[] args) throws IOException {
//        file = "C:\\Users\\Yanagi\\Desktop\\test2.png";
//        String picture= ImageUtil.fileToBase64(file);
//        //通用文档识别
//        textGeneral(picture);
//    }


    /**
     * 通用文字识别-通用印刷体识别
     */
    @Override
    public String textGeneral(String picture) {
        HashMap<String, Object> generalParams = new HashMap<>();
        JSONObject generalOptions = new JSONObject();
        generalOptions.put("rotate_180", true);
        generalOptions.put("language", "zh");
        generalParams.put("options", generalOptions);
        //参数为图片路径
//        IECloudRequest generalRequest = OcrRequestFactory.getOcrRequest("/api/ocr/v1/general",
//                "C:\\Users\\Yanagi\\Desktop\\test.png", generalParams);
        //        参数为图片的base64编码

//        +号会被编译成 空格
        IECloudRequest generalRequestBase64 = OcrRequestFactory.getOcrBase64Request("/api/ocr/v1/general",
                picture,generalParams);

        System.out.println(picture);

        String data = "";
        StringBuilder buffer = new StringBuilder();
        try {
            JSONObject response = (JSONObject) client.call(generalRequestBase64);
            System.out.println(response.toString());
            JSONArray jsonArray = (JSONArray)response.get("items");
            if(jsonArray != null) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject item = (JSONObject) jsonArray.get(i);
                    System.out.println(item.get("itemstring"));
                    buffer.append(item.get("itemstring") + "\n");
                }
            }
            else return null;
        data = String.valueOf(buffer);

            //JSONObject responseBase64 = (JSONObject) client.call(generalRequestBase64);
            //System.out.println(responseBase64.toJSONString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(data);
        return data;
    }

    @Override
    public String sendPicture(String path){
        String picture= ImageUtil.fileToBase64(path);
        return picture;
    }
}
