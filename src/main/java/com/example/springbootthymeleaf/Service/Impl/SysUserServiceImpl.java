package com.example.springbootthymeleaf.Service.Impl;

import com.example.springbootthymeleaf.Service.SysUserService;
import com.example.springbootthymeleaf.entity.SysUser;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

@Service
public class SysUserServiceImpl implements SysUserService {
    public void add(SysUser sysUser){
        String password=DigestUtils.sha1DigestAsHex("111111");
        System.out.println(password);
    }
}
