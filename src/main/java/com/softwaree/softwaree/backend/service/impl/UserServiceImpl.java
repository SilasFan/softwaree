package com.softwaree.softwaree.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.softwaree.softwaree.backend.entity.User;
import com.softwaree.softwaree.backend.mapper.UserMapper;
import com.softwaree.softwaree.backend.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softwaree.softwaree.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author fetter
 * @since 2019-11-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Response register(User user) {
        try {
            user.setId(0L);
            user.setPassword(encoder.encode(user.getPassword().trim()));
            this.save(user);
        } catch (Exception e) {
            return new Response("注册失败！", 0);
        }

        return new Response(1);
    }

    // login,logout逻辑，因为涉及到验证暂时放着

    public Response getCurrentUserID(String userName) {
        User user = this.getOne(new QueryWrapper<User>().eq("userName", userName));
        if (user == null) {
            return new Response("用户不存在！", 0);
        }

        return new Response(user.getId().toString(), 1);
    }
}
