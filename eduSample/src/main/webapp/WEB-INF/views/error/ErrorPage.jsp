<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
ERR CODE: <%=request.getAttribute("errCode")%>
<br/>
EXCEPTION TYPE: <%=request.getAttribute("exType")%>
<br/>
EXCEPTION MSG: <%=request.getAttribute("exMsg")%>
</body>
</html>