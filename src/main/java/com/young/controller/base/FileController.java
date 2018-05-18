package com.young.controller.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import com.framework.util.FileUtil;

import com.young.json.BaseJson;
import com.young.services.young.IYoungService;
import com.young.services.young.impl.YoungServiceImpl;
import com.young.vo.TeacherVo;
import org.codehaus.jackson.map.Serializers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/file")
public class FileController extends BaseController {

    @Resource
    private IYoungService youngService;

    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    private ModelAndView uploadFile(@RequestParam("file") CommonsMultipartFile file){
        String filePath="";
        try {
            filePath= FileUtil.saveFile(getHttpRequest(),file,"/web/studyfile");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        TeacherVo teacherVo = getTeacherSession();
        int recode = youngService.upfile(teacherVo.gettId(),file.getOriginalFilename(),filePath);
        if (recode == 1) {
            modelAndView.getModel().put("msg", "上传成功");
            modelAndView.getModel().put("url", "/young/files");
            System.out.println(2);
            modelAndView.setViewName("result");
        } else {
            modelAndView.getModel().put("msg", "上传失败");
            modelAndView.getModel().put("url", "/young/files");
            System.out.println(2);
            modelAndView.setViewName("result");
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/downloadFile/{id}/{Url:.+}", method = RequestMethod.GET)
    private void  downloadFile(@PathVariable("id") int id,
                               @PathVariable("Url") String Url){
        try {
            //根据文件id在数据库中获取文件名
            String fileName = Url;
            long class_id = 1;
            //文件所在目录路径
            String filePath = getHttpRequest().getSession().getServletContext().getRealPath(File.separator)+File.separator+
                    "web"+File.separator+"file"+File.separator+"ClassFile"+File.separator+class_id+File.separator;
            System.out.println(filePath+fileName);
            File file = new File(filePath+fileName);
            if(!file.exists()){
                System.out.println("Have no such file!");
                return;//文件不存在就退出方法
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            //设置Http响应头告诉浏览器下载这个附件
            getHttpResponse().setHeader("Content-Disposition", "attachment;Filename=" + URLEncoder.encode(fileName, "UTF-8"));
            OutputStream outputStream = getHttpResponse().getOutputStream();
            byte[] bytes = new byte[2048];
            int len = 0;
            while ((len = fileInputStream.read(bytes))>0){
                outputStream.write(bytes,0,len);
            }
            fileInputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

