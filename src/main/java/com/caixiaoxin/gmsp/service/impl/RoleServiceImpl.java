package com.caixiaoxin.gmsp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caixiaoxin.gmsp.entity.Role;
import com.caixiaoxin.gmsp.entity.RoleMenu;
import com.caixiaoxin.gmsp.mapper.RoleMapper;
import com.caixiaoxin.gmsp.mapper.RoleMenuMapper;
import com.caixiaoxin.gmsp.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 太阳上的雨天
 * @since 2023-05-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Transactional
    @Override
    public void setRoleMenu(Integer roleId, List<Integer> menuIds) {
        roleMenuMapper.deleteByRoleId(roleId);

        for (Integer menuId : menuIds) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuMapper.insert(roleMenu);
        }
    }

    @Override
    public List<Integer> getRoleMenu(Integer roleId) {
        return roleMenuMapper.selectByRoleId(roleId);
    }

}
