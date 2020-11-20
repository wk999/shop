package wk.sb_do1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import wk.sb_do1.dao.UserMapper;
import wk.sb_do1.entity.User;
import wk.sb_do1.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper um;

    @Override
    public User queryByName(String name) {
        return um.queryByName(name);
    }
}
