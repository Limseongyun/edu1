<%@ page language="java" contentType="text/html; charset=EUC-KR"
		pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인/회원가입</title>
	<!-- Google Font: Source Sans Pro -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="/webjars/AdminLTE/3.1.0/plugins/fontawesome-free/css/all.min.css">
	<!-- icheck bootstrap -->
	<link rel="stylesheet" href="/webjars/AdminLTE/3.1.0/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="/webjars/AdminLTE/3.1.0/dist/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
	
	<tiles:insertAttribute name="body"/>
	
	<!-- jQuery -->
	<script src="/webjars/AdminLTE/3.1.0/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="/webjars/AdminLTE/3.1.0/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/webjars/AdminLTE/3.1.0/dist/js/adminlte.min.js"></script>
</body>
</html>