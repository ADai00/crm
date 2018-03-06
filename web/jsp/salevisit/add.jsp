<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加拜访记录</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<!-- 使用日期控件步骤1: 导入js和css -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/js/datepicker/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/datepicker/jquery.datepick.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/datepicker/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript">

</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/visit_add.action"
		method="post" >


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
								<TD class=manageHead>当前位置：拜访记录管理 &gt; 添加拜访记录</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>客户：</td>
								<td >
								   <select name="customer.cid">
									   <option>--请选择--</option>
									   <c:forEach items="${customerList}" var="customer">
										   <option value="${customer.cid}">${customer.custName}</option>
									   </c:forEach>
								   </select>
								</td>
							</TR>
							<TR>
								<td>用户：</td>
								<td >
									<select name="user.uid">
										<option>--请选择--</option>
										<c:forEach items="${userList}" var="user">
											<option value="${user.uid}">${user.username}</option>
										</c:forEach>
									</select>
								</td>
							</TR>
							
							<TR>
								<td>拜访地址：</td>
								<td>
									<INPUT class=textbox id=vaddress
										   style="WIDTH: 180px" maxLength=50 name="vaddress">
								</td>
								<td>拜访内容 ：</td>
								<td >
								<INPUT class=textbox id=vcontent
														style="WIDTH: 180px" maxLength=50 name="vcontent" >
								</td>
							</TR>
							<tr>
								<td rowspan=2><INPUT class=button id=sButton2 type=submit
													 value="保存 " name=sButton2></td>
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
