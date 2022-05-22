package com.example.test;

import com.chinamobile.cmss.sdk.image.ECloudDefaultClient;
import com.chinamobile.cmss.sdk.image.ECloudServerException;
import com.chinamobile.cmss.sdk.image.IECloudClient;
import com.chinamobile.cmss.sdk.image.http.constant.Region;
import com.chinamobile.cmss.sdk.image.http.signature.Credential;
import com.chinamobile.cmss.sdk.image.request.EngineImageCarDetectPostRequest;
import com.chinamobile.cmss.sdk.image.request.EngineImageClassifyDetectPostRequest;
import com.chinamobile.cmss.sdk.image.response.EngineImageCarDetectResponse;
import com.chinamobile.cmss.sdk.image.response.EngineImageClassifyDetectResponse;
import com.chinamobile.cmss.sdk.image.response.bean.EngineCar;
import com.chinamobile.cmss.sdk.image.response.bean.EngineClassify;
import com.chinamobile.cmss.sdk.image.util.JacksonUtil;
import java.io.IOException;
import java.util.List;


/**
 * yckj1429
 */
public class ECloudSignatureTest {


    public static void main(String[] args) throws IOException {
         String user_ak;
         String user_sk;
        user_ak = "6a6f35f1504044d98a07f1343322437c";
        user_sk = "8a4e87d19a384afbad2931499dbdf61d";
        //企业云账户：请申请
        Credential credential = new Credential(user_ak, user_sk);

        //初始化ECloud client,Region 为部署资源池OP网关地址枚举类，可自行扩展
        IECloudClient ecloudClient = new ECloudDefaultClient(credential, Region.POOL_SZ);


        //待定义产品request
        try {
            //举例：车辆检测
            //EngineImageCarDetectPostRequest request = new EngineImageCarDetectPostRequest();
            //通用图像识别
            EngineImageClassifyDetectPostRequest request = new EngineImageClassifyDetectPostRequest();
            //驾驶员识别
            //EngineImageDriverDetectPostRequest request = new EngineImageDriverDetectPostRequest();
            //人脸融合
            //EngineImageFaceFusionPostRequest request = new EngineImageFaceFusionPostRequest();
            //安全生产
            //EngineImageHelmetDetectPostRequest request = new EngineImageHelmetDetectPostRequest();
            //活体检测
            //EngineImageLivenessDetectPostRequest request = new EngineImageLivenessDetectPostRequest();
            //行人属性
            //EngineImagePersonDetectPostRequest request = new EngineImagePersonDetectPostRequest();
            //人像背景分割
            //EngineImagePortraitSegmentationPostRequest request = new EngineImagePortraitSegmentationPostRequest();

            //图片base64 ，注意不要包含 {data:image/jpeg;base64,}
            request.setImage("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");
            //人脸融合[2个参数]，其他都是一个image
//            request.setImageSrc();
//            request.setImageTarget();

            // 执行请求，response类型支持泛型,state != OK 的已经抛出异常
            //车辆检测
            //EngineImageCarDetectResponse response = ecloudClient.call(request);
            //通用图像识别
            EngineImageClassifyDetectResponse response = ecloudClient.call(request);
            //驾驶员
            //EngineImageDriverDetectResponse response = ecloudClient.call(request);
            //人脸融合
            //EngineImageFaceFusionResponse response = ecloudClient.call(request);
            //安全生产
            //EngineImageHelmetDetectResult response = ecloudClient.call(request);
            //活体检测
            //EngineImageLivenessDetectResponse response = ecloudClient.call(request);
            //人体检测与属性识别
            //EngineImagePersonDetectResponse response = ecloudClient.call(request);
            //人像背景分割
            //EngineImagePortraitSegmentationResponse response = ecloudClient.call(request);



            if("OK".equals(response.getState())){
                //车辆检测
                //EngineCar body = response.getBody();
                //通用图像识别
                List<EngineClassify> body = response.getBody();
                //驾驶员
                //EngineDriver body = response.getBody();
                //人脸融合
                //EngineFaceFusion body = response.getBody();

                //安全生产
                //List<EngineHelmet> body = response.getBody();
                //活体检测
                //EngineLiveness body = response.getBody();
                //人体检测与属性识别
                //List<EnginePerson> body = response.getBody();
                //人像背景分割
                //EnginePortraitSegmentation body = response.getBody();

                System.out.println(JacksonUtil.toJson(body));
            }
        } catch (IOException|ECloudServerException | IllegalAccessException  e) {
            //todo exception process...
            e.printStackTrace();
        }

    }
}
