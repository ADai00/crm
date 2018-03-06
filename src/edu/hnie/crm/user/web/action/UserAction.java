package edu.hnie.crm.user.web.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.hnie.crm.user.Service.UserService;
import edu.hnie.crm.user.domain.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class UserAction extends ActionSupport {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.checkLogin(username,password);
        if (user != null){
            session.setAttribute("user",user);
            return "loginSuccess";
        }else {
            request.setAttribute("msg","该用户不存在");
            return "toLoginPage";
        }
    }

    public String toLoginPage(){

        return "toLoginPage";
    }
}
