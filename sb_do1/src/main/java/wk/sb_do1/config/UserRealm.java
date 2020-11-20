package wk.sb_do1.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import wk.sb_do1.entity.User;
import wk.sb_do1.service.UserService;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService us;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("正在授权中。。。。");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("正在认证中。。。。。。");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        User currentUser = us.queryByName(userToken.getUsername());

        if (currentUser == null) {
            return null;
        }

//        密码交给shiro自己判断
        return new SimpleAuthenticationInfo("", currentUser.getPwd(), getName());
    }
}
