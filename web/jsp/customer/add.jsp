<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>添加客户</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
          rel=stylesheet>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
    <script type="text/javascript">


        <%--/*/!*$(document).ready(function(){--%>
        <%----%>
        <%--loadSelect("006","level","cust_level.dict_id"<s:if test="#customer.cust_level!=null">,<s:property value="#customer.cust_level.dict_id" /></s:if>);--%>
        <%--loadSelect("001","industry","cust_industry.dict_id"<s:if test="#customer.cust_industry!=null">,<s:property value="#customer.cust_industry.dict_id" /></s:if>);--%>
        <%--loadSelect("009","source","cust_source.dict_id"<s:if test="#customer.cust_source!=null">,<s:property value="#customer.cust_source.dict_id" /></s:if>);--%>
        <%----%>
        <%--});*!/*/--%>
        var custNameObj;
        var custLevleObj;
        var custSourceObj;
        var custPhoneObj;
        var custMobileObj;
        var nameSpanObj;
        var formObj;
        window.onload = function () {
            custNameObj = document.getElementById("custName");
            nameSpanObj = document.getElementById("nameSpan");
            custLevleObj = document.getElementById("custLevel");
            custSourceObj = document.getElementById("custSource");
            custPhoneObj = document.getElementById("custPhone");
            custMobileObj = document.getElementById("custMobile");
            formObj = document.getElementById("form1");
            custNameObj.onblur = function () {
                var custNameValueObj = custNameObj.value;
                var xmlHttpRequest = new XMLHttpRequest();
                xmlHttpRequest.open("POST", "${pageContext.request.contextPath}/customer_findCustomerByName.action", "true");
                //设置响应头
                xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

                xmlHttpRequest.send("custName=" + custNameValueObj);

                xmlHttpRequest.onreadystatechange = function () {
                    if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
                        var value = xmlHttpRequest.responseText;
                        if (value == 1) {
                            nameSpanObj.innerHTML = "<font color='red'>该用户名已经存在</font>";
                        } else if(value == 0){
                            nameSpanObj.innerHTML = "<font color='blue'>ok</font>";
                        }else{

                        }
                    }
                }
            }
        }

    </script>

    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>

<!-- 文件上传页面3个要求:
        1.表单必须post提交
        2.表单提交类型enctype.必须多段式.
        3.文件上传使用<input type="file" /> 组件
 -->
<FORM id=form1 name=form1
      action="${pageContext.request.contextPath }/customer_add.action"
      method="post" enctype="multipart/form-data">

    <input type="hidden" name="cid"/>

    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
                              border=0></TD>
            <TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
                height=20></TD>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
                              border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
                    src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
            <TD vAlign=top width="100%" bgColor=#ffffff>
                <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                    <TR>
                        <TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>

                <TABLE cellSpacing=0 cellPadding=5 border=0>
                    <TR>
                        <td>客户名称：</td>
                        <td>
                            <INPUT class=textbox id="custName"
                                   style="WIDTH: 180px" maxLength=50 name="custName"/><span id="nameSpan"></span>
                        </td>
                    </TR>
                    <TR>
                        <td>客户级别 ：</td>
                        <td id="level">
                            <select name="dictCustLevel.did">
                                <c:forEach items="${dictList}" var="dict">
                                    <option value="${dict.did}">${dict.dname}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </TR>
                    <TR>
                        <td>信息来源 ：</td>
                        <td id="source">
                            <INPUT class=textbox id="custSource"
                                   style="WIDTH: 180px" maxLength=50 name="custSource"/><span id="sourceSpan"></span>
                        </td>
                    </TR>

                    <TR>
                        <td>固定电话 ：</td>
                        <td>
                            <INPUT class=textbox id="custPhone"
                                   style="WIDTH: 180px" maxLength=50 name="custPhone"/><span id="phoneSpan"></span>
                        </td>
                    </TR>
                    <TR>
                        <td>移动电话 ：</td>
                        <td>
                            <INPUT class=textbox id="custMobile"
                                   style="WIDTH: 180px" maxLength=50 name="custMobile"/><span id="mobileSpan"></span>
                        </td>
                    </TR>
                    <%--<TR>
                        <td>图片上传 ：</td>
                        <td>
                            <input type="file" name="photo" />
                        </td>
                    </TR>--%>
                    <tr>
                        <td rowspan=2>
                            <INPUT class=button id=sButton2 type=submit
                                   value=" 保存 " name=sButton2>
                        </td>
                    </tr>
                </TABLE>


            </TD>
            <TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
                <IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
                              border=0></TD>
            <TD align=middle width="100%"
                background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
                              border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</BODY>
</HTML>
