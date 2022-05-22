package com.example.controller;

import com.example.entity.resp.RestBean;
import com.example.service.TextRecognitionService;
import com.example.service.impl.ItemRecognitionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;



@RestController
@RequestMapping("/upload/test")
public class RecognitionController {

    @Resource
    TextRecognitionService recognitionService;
    @Resource
    ItemRecognitionServiceImpl itemRecognitionService;

    @RequestMapping(value = "/path",method = RequestMethod.GET)
    public RestBean<String> get(String picture){
        String result;
        result = recognitionService.textGeneral(picture);
        System.out.println(result);
        return new RestBean<>(200,"调用成功",result);
    }

    @GetMapping("/item")
    public RestBean<String > getItem(String picture){
        String result;
        result = itemRecognitionService.ItemRecognition(picture);
        System.out.println(result);
        return new RestBean<>(200,"调用成功",result);
    }
}
