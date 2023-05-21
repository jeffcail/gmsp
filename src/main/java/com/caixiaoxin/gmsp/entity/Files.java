package com.caixiaoxin.gmsp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("gmsp_file")
public class Files implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String filename;
    private String ext;
    private Long size;
    private String url;
    private Boolean isdelete;
    private Boolean isenable;
    private String filemd5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    public Boolean getIsenable() {
        return isenable;
    }

    public void setIsenable(Boolean isenable) {
        this.isenable = isenable;
    }

    public String getFilemd5() {
        return filemd5;
    }

    public void setFilemd5(String filemd5) {
        this.filemd5 = filemd5;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", ext='" + ext + '\'' +
                ", size=" + size +
                ", url='" + url + '\'' +
                ", isdelete=" + isdelete +
                ", isenable=" + isenable +
                ", filemd5='" + filemd5 + '\'' +
                '}';
    }
}
