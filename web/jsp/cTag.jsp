<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" 
     uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<%-- 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:formatNumber>
使用指定的格式或精度格式化数字
<fmt:parseNumber>
解析一个代表着数字，货币或百分比的字符串
<fmt:formatDate>
使用指定的风格或模式格式化日期和时间
<fmt:parseDate>
解析一个代表着日期或时间的字符串
<fmt:bundle>
绑定资源
<fmt:setLocale>
指定地区
<fmt:setBundle>
绑定资源
<fmt:timeZone>
指定时区
<fmt:setTimeZone>
指定时区
<fmt:message>
显示资源配置文件信息
<fmt:requestEncoding>
设置request的字符编码 --%>

<%--
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<c:forEach var="item" items="${datas.datas}" varStatus="index">
	<c:choose>
	      <c:when test="${index.count mod 2 eq 1}">
	          <tr>
	      </c:when>
	      <c:otherwise>
	          <tr class="list-tr-odd">
	      </c:otherwise>
	</c:choose>
</c:forEach>
<c:if test="${fn:length(obj.meetingName) <= 26}">
	${obj.meetingName}
</c:if>
<c:if test="${fn:length(obj.meetingName) > 26}">
	${fn:substring(obj.meetingName,0,26)} ...
</c:if>	
--%>

</body>
</html>