package com.fann.controller.backend;

import com.fann.common.Const;
import com.fann.common.ServerResponse;
import com.fann.pojo.User;
import com.fann.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by b1109_000 on 2017/5/2.
 */
@Controller
@RequestMapping("/manage/user")
public class UserManageController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value="login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){
           ServerResponse<User> serverResponse = iUserService.login(username,password);
            if(serverResponse.isSuccess()){
                User user = serverResponse.getData();
                if(user.getRole() == Const.Role.ROLE_ADMIN){
                    session.setAttribute(Const.CURRENT_USER,user);
                    return serverResponse;
                }else{
                    return ServerResponse.createByErrorMessage("不是管理员，无法登陆");
                }
            }
        return serverResponse;
    }
}
