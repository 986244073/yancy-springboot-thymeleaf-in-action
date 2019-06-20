package com.yancy.repository;

import com.yancy.entity.User;

import java.util.List;

/**
 * @Authur : Yancy
 * @E-mail : 986244073@qq.com
 * @Create : 2019/6/18
 * @Desc :  User Repository 接口
 */

public interface UserRepository {

    /**
     * 创建 修改用户
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除 用户
     */
    void deleteUser(Long id);

    /**
     * 根据Id查询用户
     * */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * */
    List<User> listUsers();
}
