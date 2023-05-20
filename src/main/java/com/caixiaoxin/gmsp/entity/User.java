package com.caixiaoxin.gmsp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author 太阳上的雨天
 * @since 2023-05-20
 */
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String phone;

    private String address;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public String getUsername() {
        return username;
    }

      public void setUsername(String username) {
          this.username = username;
      }
    
    public String getPassword() {
        return password;
    }

      public void setPassword(String password) {
          this.password = password;
      }
    
    public String getNickname() {
        return nickname;
    }

      public void setNickname(String nickname) {
          this.nickname = nickname;
      }
    
    public String getEmail() {
        return email;
    }

      public void setEmail(String email) {
          this.email = email;
      }
    
    public String getPhone() {
        return phone;
    }

      public void setPhone(String phone) {
          this.phone = phone;
      }
    
    public String getAddress() {
        return address;
    }

      public void setAddress(String address) {
          this.address = address;
      }
    
    public LocalDateTime getCreateAt() {
        return createAt;
    }

      public void setCreateAt(LocalDateTime createAt) {
          this.createAt = createAt;
      }
    
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

      public void setUpdateAt(LocalDateTime updateAt) {
          this.updateAt = updateAt;
      }

    @Override
    public String toString() {
        return "User{" +
              "id=" + id +
                  ", username=" + username +
                  ", password=" + password +
                  ", nickname=" + nickname +
                  ", email=" + email +
                  ", phone=" + phone +
                  ", address=" + address +
                  ", createAt=" + createAt +
                  ", updateAt=" + updateAt +
              "}";
    }
}
