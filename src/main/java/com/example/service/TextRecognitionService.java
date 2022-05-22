package com.example.service;

import java.io.File;

public interface TextRecognitionService {

    String sendPicture(String path);

    String textGeneral(String picture);
}
