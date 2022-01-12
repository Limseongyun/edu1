<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
hahahahaha
<c:forEach var="item" items="${sample}" varStatus="name">
  body content///${item}///<br/>${item.userNm}
</c:forEach>
</body>
</html>