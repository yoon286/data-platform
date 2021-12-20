package com.hypers.dao;

import com.hypers.crius.enhance.BaseDao;
import com.hypers.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jsoup.Connection;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author Lynne
 * @date 2021/12/13
 */

@Mapper
public interface UserDao extends BaseDao<User> {
    /**
     * 通过用户名查找用户
     * @param username 用户名
     * @return 用户信息
     */
    User findByUsername(@Param("username") String username);

}
