<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
ERR CODE: <%=request.getAttribute("errCode")%>
<br/>
EXCEPTION TYPE: <%=request.getAttribute("exType")%>
<br/>
EXCEPTION MSG: <%=request.getAttribute("exMsg")%>
</html>