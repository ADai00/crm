package edu.hnie.crm.salevisit.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.hnie.crm.customer.domain.Customer;
import edu.hnie.crm.customer.service.CustomerService;
import edu.hnie.crm.salevisit.domain.Visit;
import edu.hnie.crm.salevisit.service.VisitService;
import edu.hnie.crm.user.Service.UserService;
import edu.hnie.crm.user.domain.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{

    private VisitService visitService;

    private UserService userService;

    private CustomerService customerService;

    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

   private Visit visit = new Visit();

    @Override
    public Visit getModel() {
        return visit;
    }

    public String toAddPage(){
        HttpServletRequest request = ServletActionContext.getRequest();
        List<User> userList = userService.findAllUser();
        request.setAttribute("userList",userList);

        List<Customer> customerList = customerService.findAllCustomer();
        request.setAttribute("customerList",customerList);
        return "toAddPage";
    }

    public String add(){
        visitService.addVisit(visit);
        return "add";
    }

    public String findAll(){
        List<Visit> visitList = visitService.findAllVisit();
        ServletActionContext.getRequest().setAttribute("visitList",visitList);
        return "findAll";
    }
}
