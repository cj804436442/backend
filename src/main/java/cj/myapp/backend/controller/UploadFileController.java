package cj.myapp.backend.controller;

import cj.myapp.backend.mapper.ImgMapper;
import cj.myapp.backend.util.Response;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
public class UploadFileController {

    /**
     * 接收上传的文件，并且将上传的文件存储在指定路径下
     *
     * @param
     * @return
     */
    @Resource
    ImgMapper imgMapper;


    @RequestMapping(value = "/upload")
    public Response upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (ObjectUtils.isEmpty(file)) {
            return new Response(500, "文件是空的", "");
        }
        String filename = file.getOriginalFilename();// 文件的名字。
        File descFile = new File("/home/file/pic/" + filename);//如果不确定位置可以使用绝对路径进行测试
        if (!descFile.exists()) {
            descFile.createNewFile();
        } else {
            return new Response(200, "文件已存在", "");
        }
        try {
            file.transferTo(descFile); // 文件保存
//            #{img_name},#{img_path},#{createTime}),#{userId},#{userName}
//            imgMapper.addImg();
            return new Response(200, "上传成功", "");
        } catch (Exception e) {
            System.out.println("文件保存出现异常了");
            e.printStackTrace();
            return new Response(500, "文件保存出现异常", "");
        }
    }

    @RequestMapping(value = "/getImgeList")
    public Response getImg(HttpServletResponse response) throws IOException {
        return new Response(200, "上传成功", "");
    }
}