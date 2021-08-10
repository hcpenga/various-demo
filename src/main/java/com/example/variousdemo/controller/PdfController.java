package com.example.variousdemo.controller;

import com.example.variousdemo.util.Base64Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @className: PdfController
 * @description: Base64流与PDF文件的互换
 * @created: 2021/07/14 10:30
 */
@RestController
@RequestMapping("/pdf")
@Api(tags = "Base64流与PDF文件的互换")
public class PdfController {

    /**
     * 功能描述：
     * 〈base64流转换为PDF--暂时不可直接通过路径用,可能base64String字符串过长,导致无法正常接收〉
     * @Date: 15:05 2021/7/14 0014
     * @param base64String
     * @param filePath
     * @return: java.lang.String
     **/
    @GetMapping("/base64ToPDF")
    @ApiOperation(value = "Base64流转换为PDF文件")
    public String base64ToPDF(@RequestBody String base64String, @RequestBody String filePath){
        Base64Utils.base64StringToPDF(base64String,filePath);
        return "转换为PDF文件完毕";
    }

    /**
     * 功能描述：
     * 〈PDF文件转换为Base64流〉
     * @Date: 15:06 2021/7/14 0014
     * @param file
     * @return: java.lang.String
     **/
    @PostMapping("/pdfToBase64")
    @ApiOperation(value = "PDF文件转化为base64流")
    public String pdfToBase64(MultipartFile file) throws IOException {
        File file1 = multipartFileToFile(file);
        String base64String = Base64Utils.getPDFBinary(file1);
        return base64String;
    }

    /**
     * 功能描述：
     * 〈MultipartFile类型直接转换为File类型〉
     * @Date: 15:17 2021/7/14 0014
     * @param file
     * @return: java.io.File
     **/
    public static File multipartFileToFile(MultipartFile file) throws IOException {
        File toFile = null;
        if(file.equals("") || file.getSize() <= 0){
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins,toFile);
            ins.close();
        }
        return toFile;
    }

    public static void inputStreamToFile(InputStream ins,File file){
        try{
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while((bytesRead = ins.read(buffer,0,8192)) != -1){
                os.write(buffer,0,bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}
