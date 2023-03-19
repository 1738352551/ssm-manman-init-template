package cn.chenmanman.ssm.controller;

import cn.chenmanman.ssm.common.BaseResponse;
import cn.chenmanman.ssm.common.ResultUtils;
import cn.chenmanman.ssm.mapper.MyFileMapper;
import cn.chenmanman.ssm.model.entity.MyFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;


@Api(value = "文件上传", tags = {"文件上传"})
@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @Autowired
    private MyFileMapper myFileMapper;

    @PostMapping()
    public BaseResponse uploadFile(@RequestParam("files") MultipartFile[] files, HttpServletRequest httpServletRequest) throws IOException {
//        Map<String, Object> map = new HashMap<>();
//         上传指定的目录，upload文件夹
        String realPath = httpServletRequest.getServletContext().getRealPath("/upload");

        File uploadDir = new File(realPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // 收集上传的文件信息
        MyFile myFile = new MyFile();
        for (MultipartFile multipartFile:files) {
            String oldName = multipartFile.getOriginalFilename();
            String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
            myFile.setFilename(newName);
            myFile.setFilepath("/upload/" + newName);
            myFile.setSize((double) multipartFile.getSize());
            // 上传文件, 文件信息保存到数据表
            multipartFile.transferTo(new File(realPath, newName));
            myFileMapper.addFile(myFile);
        }
        return ResultUtils.success(Arrays.toString(files));
    }
}
