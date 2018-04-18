package com.zj.service.interfaces;

import com.zj.bean.po.Permisson;
import java.util.List;

/**
 * @Author: zj
 * @Description:
 */
public interface PermissionService {

    Integer add(Permisson permisson);

    Integer delete(Integer permissonId);

    Integer update(Permisson permisson);

    Permisson selectByPrimaryKey(Integer permissonId);

    List<Permisson> listPermissionWithParName(Permisson permisson);

    List<Permisson> listPermission(Permisson permisson);

    List<Permisson> listPermissionView();

    List<Permisson> getUserPermissons(Integer userId);

}
