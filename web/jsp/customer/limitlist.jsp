<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>客户列表</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css"
          type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css"
          type=text/css rel=stylesheet>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <SCRIPT language=javascript>
        function changePage(pageNum) {
            //alert(pageNum);
            //获得表单
            //将当前页表值放在表单隐藏域中
            $("#currentPageInput").val(pageNum);
            //提交表单
            $("#pageForm").submit();
        }

        function changePageSize(pageSize) {
            $("#currentSizeInput").val(pageSize);
            $("#pageForm").submit();
        }

        function selectCustomer(cust_id, cust_name) {
            //获得添加页面的window对象
            var win = window.opener;
            //获得添加页面的document对象
            var doc = win.document;
            //获得隐藏域,和 文本框,并赋值
            doc.getElementById("cust_id").value = cust_id;
            doc.getElementById("cust_name").value = cust_name;
            //关闭当前窗口
            window.close();
        }
    </SCRIPT>

    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>


<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
    <TBODY>
    <TR>
        <TD width=15><IMG
                src="${pageContext.request.contextPath }/images/new_019.jpg"
                border=0></TD>
        <TD width="100%"
            background="${pageContext.request.contextPath }/images/new_020.jpg"
            height=20></TD>
        <TD width=15><IMG
                src="${pageContext.request.contextPath }/images/new_021.jpg"
                border=0></TD>
    </TR>
    </TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
    <TBODY>
    <TR>
        <TD width=15 background=${pageContext.request.contextPath }
                /images/new_022.jpg><IMG
                src="${pageContext.request.contextPath }/images/new_022.jpg"
                border=0></TD>
        <TD vAlign=top width="100%" bgColor=#ffffff>
            <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                <TR>
                    <TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
                </TR>
                <TR>
                    <TD height=2></TD>
                </TR>
            </TABLE>

            <TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%"
                   align=center border=0>
                <TBODY>
                <TR>
                    <TD height=25>
                        <FORM id="pageForm" name="customerForm"
                              action="${pageContext.request.contextPath }/customer_listCondition.action"
                              method=post>

                            <TABLE cellSpacing=0 cellPadding=2 border=0>
                                <TBODY>
                                <TR>
                                    <TD>客户名称：</TD>
                                    <TD><INPUT class=textbox id=sChannel2
                                               style="WIDTH: 80px" maxLength=50 name="custName"></TD>

                                    <TD><INPUT class=button id=sButton2 type=submit
                                               value=" 筛选 " name=sButton2></TD>
                                </TR>
                                </TBODY>
                            </TABLE>
                        </FORM>
                    </TD>
                </TR>

                <TR>
                    <TD>
                        <TABLE id=grid
                               style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
                               cellSpacing=1 cellPadding=2 rules=all border=0>
                            <TBODY>
                            <TR
                                    style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                <TD>客户名称</TD>
                                <TD>客户级别</TD>
                                <TD>客户来源</TD>
                                <TD>电话</TD>
                                <TD>手机</TD>
                                <TD>操作</TD>
                            </TR>
                            <c:forEach items="${pageBean.beanList}" var="customer">
                                <TR
                                        style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                    <TD>${customer.custName }</TD>
                                    <TD>${customer.dictCustLevel.dname}</TD>
                                    <TD>${customer.custSource }</TD>
                                    <TD>${customer.custPhone }</TD>
                                    <TD>${customer.custMobile }</TD>
                                    <TD>
                                        <a href="${pageContext.request.contextPath }/customer_toEditPage.action?cid=${customer.cid }">修改</a>
                                        &nbsp;&nbsp;
                                        <a href="${pageContext.request.contextPath }/customer_delete.action?cid=${customer.cid }">删除</a>
                                    </TD>
                                </TR>
                            </c:forEach>
                            </TBODY>
                        </TABLE>
                    </TD>
                </TR>

                <table align="center">
                    <tr>
                        <td>第${pageBean.pc}页/共${pageBean.tp}页</td>
                        <td><a href="${pageContext.request.contextPath}/customer_limitPage.action?pc=1">首页</a></td>
                        <c:if test="${pageBean.pc > 1}">
                            <td>
                                <a href="${pageContext.request.contextPath}/customer_limitPage.action?pc=${pageBean.pc-1}">上一页</a>
                            </td>
                        </c:if>
                        <c:choose>
                            <c:when test="${pageBean.tp < 10}">
                                <c:set var="begin" value="1"></c:set>
                                <c:set var="end" value="${pageBean.tp}"></c:set>
                            </c:when>
                            <c:otherwise>
                                <c:set var="begin" value="${pageBean.pc - 5}"></c:set>
                                <c:set var="end" value="${pageBean.pc + 4 }"></c:set>
                                <%--头溢出--%>
                                <c:if test="${begin < 1}">
                                    <c:set var="begin" value="1"></c:set>
                                    <c:set var="end" value="10"></c:set>
                                </c:if>
                                <%--尾溢出--%>
                                <c:if test="${end > pageBean.tp}">
                                    <c:set var="begin" value="${pageBean.tp - 9}"></c:set>
                                    <c:set var="end" value="${pageBean.tp}"></c:set>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach var="i" begin="${begin}" end="${end}">
                            <c:choose>
                                <c:when test="${i == pageBean.pc}">
                                    <td>${i}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/customer_limitPage.action?pc=${i}">[${i}]</a>
                                    </td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>


                        <c:if test="${pageBean.pc < pageBean.tp}">
                            <td>
                                <a href="${pageContext.request.contextPath}/customer_limitPage.action?pc=${pageBean.pc+1}">下一页</a>
                            </td>
                        </c:if>
                        <td>
                            <a href="${pageContext.request.contextPath}/customer_limitPage.action?pc=${pageBean.tp}">尾页</a>
                        </td>
                    </tr>
                </table>
                <%--&lt;%&ndash;<TR>--%>
                <%--<TD><SPAN id=pagelink>--%>
                <%--<DIV--%>
                <%--style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">--%>
                <%--共[<B>${pageBean.totalCount}</B>]条记录,[<B>${pageBean.totalPage}</B>]页--%>
                <%--,每页显示 <select name="pageSize"--%>
                <%--onchange="changePageSize($('#pageSizeSelect option').filter(':selected').val())"--%>
                <%--id="pageSizeSelect">--%>
                <%--<option value="3"--%>
                <%--<c:if test="${pageBean.pageSize==3 }">selected</c:if>>3</option>--%>
                <%--<option value="5"--%>
                <%--<c:if test="${pageBean.pageSize==5 }">selected</c:if>>5</option>--%>
                <%--</select> 条 [<A href="javascript:void(0)"--%>
                <%--onclick="changePage(${pageBean.currentPage-1})">前一页</A>] <B>${page}</B>--%>
                <%--[<A href="javascript:void(0)"--%>
                <%--onclick="changePage(${pageBean.currentPage+1})">后一页</A>] 到 <input--%>
                <%--type="text" size="3" id="page" name="page"--%>
                <%--value="${pageBean.currentPage }" /> 页 <input type="button"--%>
                <%--value="Go" onclick="changePage($('#page').val())" />--%>
                <%--</DIV>--%>
                <%--</SPAN></TD>--%>
                <%--</TR>&ndash;%&gt;--%>
                </TBODY>
            </TABLE>
        </TD>
        <TD width=15
            background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
                src="${pageContext.request.contextPath }/images/new_023.jpg"
                border=0></TD>
    </TR>
    </TBODY>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
    <TBODY>
    <TR>
        <TD width=15><IMG
                src="${pageContext.request.contextPath }/images/new_024.jpg"
                border=0></TD>
        <TD align=middle width="100%"
            background="${pageContext.request.contextPath }/images/new_025.jpg"
            height=15></TD>
        <TD width=15><IMG
                src="${pageContext.request.contextPath }/images/new_026.jpg"
                border=0></TD>
    </TR>
    </TBODY>
</TABLE>

</BODY>
</HTML>
