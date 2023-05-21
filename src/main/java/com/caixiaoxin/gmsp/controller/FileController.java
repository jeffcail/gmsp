package com.caixiaoxin.gmsp.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caixiaoxin.gmsp.common.Result;
import com.caixiaoxin.gmsp.entity.Files;
import com.caixiaoxin.gmsp.entity.User;
import com.caixiaoxin.gmsp.mapper.FileMapper;
import com.caixiaoxin.gmsp.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * 文件上传接口
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${files.upload.path}")
    private String fileUploadPath;

    @Resource
    private FileMapper fileMapper;

    /**
     * 文件上传接口
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();
        String extName = FileUtil.extName(originalFilename);

        // 存储到磁盘 - 可以改为oss
        String uuid = IdUtil.fastSimpleUUID();
        String fileUuid = uuid + StrUtil.DOT + extName;

        // 检车文件目录是否存在
        File uploadFile = new File(fileUploadPath + fileUuid);
        if (!uploadFile.getParentFile().exists()) {
            // 创建
            uploadFile.getParentFile().mkdirs();
        }

        String fileMd5;
        String url;

        file.transferTo(uploadFile);
        url = "http://localhost:9000/uploads/" + fileUuid;


        // 存数据库
        Files saveFile = new Files();
        saveFile.setFilename(originalFilename);
        saveFile.setExt(extName);
        saveFile.setSize(size);
        saveFile.setIsdelete(false);
        saveFile.setIsenable(true);
        saveFile.setUrl(url);
        saveFile.setFilemd5("");
        fileMapper.insert(saveFile);

        return url;
    }

    public Files getFileMd5(String fileMd5) {
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("file_md5", fileMd5);
        List<Files> files = fileMapper.selectList(queryWrapper);
        return files.size() == 0 ? null : files.get(0);
    }

    @GetMapping("/{fileUuid}")
    public void download(@PathVariable String fileUuid, HttpServletResponse response) throws IOException {
        File uploadFile = new File(fileUploadPath + fileUuid);
        ServletOutputStream os = response.getOutputStream();
        // 设置输出流的格式
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUuid, "UTF-8"));
        response.setContentType("application/octet-stream");

        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        Files files = fileMapper.selectById(id);
        files.setIsdelete(true);
        return Result.success(fileMapper.updateById(files));
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", ids);
        List<Files> filesList = fileMapper.selectList(queryWrapper);
        for (Files file : filesList) {
            file.setIsdelete(true);
            fileMapper.updateById(file);
        }

        return Result.success();
    }


    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String filename) {
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        if (!"".equals(filename)) {
            queryWrapper.like("filename", filename);
        }
        queryWrapper.eq("isdelete", false);
        queryWrapper.orderByDesc("id");
        return Result.success(fileMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @PostMapping("/update")
    public Result save(@RequestBody Files files) {
        return Result.success(fileMapper.updateById(files));
    }
}
