<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form  modelAttribute="form" method="post">
<sf:hidden  path="uri" value="${uri}"></sf:hidden>


<sf:select path="id" class="form-control border-left-right">
								<sf:option value="0">
									<s:message code="label.selectcourse" />
								</sf:option>
								<sf:options items="${facultyList}" itemValue="id"
									itemLabel="firstName" />
							</sf:select>











</sf:form>
</body>
</html>