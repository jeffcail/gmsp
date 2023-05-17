package com.caixiaoxin.gmsp.mapper;

import com.caixiaoxin.gmsp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM `user`")
    List<User> findAll();

}
