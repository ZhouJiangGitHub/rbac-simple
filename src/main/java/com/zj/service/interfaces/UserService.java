package com.zj.service.interfaces;

import com.zj.bean.po.User;
import com.zj.bean.po.UserRole;

import java.util.List;

/**
 * @Author: zj
 * @Description:
 */
public interface UserService {

    Integer add(User user);

    Integer delete(Integer userId);

    Integer update(User user);

    List<User> listUser(User user);

    User selectByPrimaryKey(Integer userId);

    List<UserRole> listUserRoles(UserRole userRole);

}
