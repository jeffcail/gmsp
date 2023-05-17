package com.caixiaoxin.gmsp.mapper;

import com.caixiaoxin.gmsp.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM `user`")
    List<User> findAll();

    @Insert("INSERT INTO user(username, password, nickname, email, phone, address) VALUES (#{username}, #{password}, " +
            "#{nickname}, #{email}, #{phone}, #{address})")
    int save(User user);

    int update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(@Param("id") Integer id);

    @Select("SELECT * FROM user limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize);
}
