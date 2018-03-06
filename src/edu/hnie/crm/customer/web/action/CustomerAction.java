package edu.hnie.crm.customer.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.hnie.crm.common.domain.PageBean;
import edu.hnie.crm.customer.domain.Customer;
import edu.hnie.crm.customer.domain.Dict;
import edu.hnie.crm.customer.service.CustomerService;
import edu.hnie.crm.customer.service.DictService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
    private CustomerService customerService;
    private DictService dictService;
    private Customer customer = new Customer();

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setDictService(DictService dictService) {
        this.dictService = dictService;
    }

    @Override
    public Customer getModel() {
        return customer;
    }


    //添加
    public String add(){
        //添加逻辑
        customerService.addCustomer(customer);

        return "add";
    }

//    private List<Customer> customerList;
//
//    public List<Customer> getCustomerList() {
//        return customerList;
//    }

    //客户列表
    public String list(){
        HttpServletRequest request = ServletActionContext.getRequest();
        List<Customer> customerList = customerService.findAllCustomer();
        request.setAttribute("customerList",customerList);
//        customerList = customerService.findAllCustomer();
        return "list";
    }

    //删除
    public String delete(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String value = request.getParameter("cid");
        int cid = Integer.parseInt(value);

        //使用模型驱动来得到表单数据
//        int cid = customer.getCid();
        Customer customer1 = customerService.findCustomerById(cid);
        customerService.deleteCustomer(customer1);
        return "delete";
    }

    public String toEditPage(){
//        int cid = customer.getCid();
        HttpServletRequest request = ServletActionContext.getRequest();
        String value = request.getParameter("cid");
        int cid = Integer.parseInt(value);
        Customer customer1 = customerService.findCustomerById(cid);
        request.setAttribute("customer",customer1);
        return "toEditPage";
    }

    public String update(){
        customerService.updateCustomer(customer);
        return "update";
    }

    /**
     * 分页
     */
    public String limitPage(){
        HttpServletRequest request = ServletActionContext.getRequest();
        int pc = getPc(request);
        int ps = 4;
        PageBean<Customer> pageBean = customerService.findByLimit(pc,ps);
        request.setAttribute("pageBean",pageBean);
        return "limitPage";
    }

    public int getPc(HttpServletRequest request){
        String value = request.getParameter("pc");
        if(value == null){
            return 1;
        }
        return Integer.parseInt(value);
    }

    /**
     * 根据用户名模糊匹配
     * @return
     */
    public String listCondition(){
        if(StringUtils.isNotBlank(customer.getCustName())){
//            String hql = "from Customer where custName Like ?";
            List<Customer> customerList = customerService.findCondition(customer);
            ServletActionContext.getRequest().setAttribute("customerList",customerList);
        }else {
           list();
        }
        return "listCondition";
    }


    /**
     * 根据用户名查找,用于ajax进行用户名校验
     */
    public String findCustomerByName(){
        try{
            HttpServletRequest request =  ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();
            PrintWriter out = response.getWriter();
            String custName = request.getParameter("custName");
            Customer customer = customerService.findCustomerByName(custName);
            if(customer != null){
                out.print("1");//该用户名存在
            }else {
                out.print("0");//该用户名不存在
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return NONE;
    }

    public String toSelectPage(){
        return "toSelectPage";
    }

    public String moreCondition(){
        List<Customer> customerList = customerService.findMoreCondition(customer);
        ServletActionContext.getRequest().setAttribute("customerList",customerList);
        return "moreCondition";
    }

    public String toAddPage(){
        List<Dict> dictList = dictService.findAllDict();
        ServletActionContext.getRequest().setAttribute("dictList",dictList);
        return "toAddPage";
    }

    public String countSource(){
        List list = customerService.findCountSource();
        ServletActionContext.getRequest().setAttribute("list",list);
        return "countSource";
    }

    public String countLevel(){
        List list = customerService.findCountLevel();
        ServletActionContext.getRequest().setAttribute("list",list);
        return "countLevel";
    }
}
