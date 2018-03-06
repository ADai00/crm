package edu.hnie.crm.linkman.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.hnie.crm.customer.domain.Customer;
import edu.hnie.crm.customer.service.CustomerService;
import edu.hnie.crm.linkman.domain.LinkMan;
import edu.hnie.crm.linkman.service.LinkManService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

    private LinkManService linkManService;

    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    private LinkMan linkMan = new LinkMan();
    @Override
    public LinkMan getModel() {
        return linkMan;
    }

    public String toAddPage(){
        List<Customer> customerList =  customerService.findAllCustomer();
        ServletActionContext.getRequest().setAttribute("customerList",customerList);
        return "toAddPage";
    }


    /**
     * 上传文件
     * 1.得到文件名，和文件流
     *
     * 创建文件
     * @return
     */
    private File upload;

    private String uploadFileName;

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }



    public String add(){
        if (upload != null){
            File serverFile = new File("F:\\CRM_img\\"+uploadFileName);
            try {
                FileUtils.copyFile(upload,serverFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        linkManService.add(linkMan);
        return "add";
    }

    public String delete(){

        return "delete";
    }

    public String toEditPage(){
        HttpServletRequest request =  ServletActionContext.getRequest();
        String value = request.getParameter("linkid");
        LinkMan linkMan = linkManService.findLinkManById(Integer.parseInt(value));
        request.setAttribute("linkMan",linkMan);
        List<Customer> customerList =  customerService.findAllCustomer();
        request.setAttribute("customerList",customerList);
        return "toEditPage";
    }

    public String update(){
        linkManService.update(linkMan);
        return "update";
    }

    public String findAll(){
        List<LinkMan> linkManList = linkManService.findAllLinkMan();
        ServletActionContext.getRequest().setAttribute("linkManList",linkManList);
        return "findAll";
    }

    public String toSelectPage(){
        List<Customer> customerList =  customerService.findAllCustomer();
        ServletActionContext.getRequest().setAttribute("customerList",customerList);
        return "toSelectPage";
    }

    public String moreCondition(){
        List<LinkMan> linkManList = linkManService.findMoreCondition(linkMan);
        ServletActionContext.getRequest().setAttribute("linkManList",linkManList);
        return "moreCondition";
    }
}
