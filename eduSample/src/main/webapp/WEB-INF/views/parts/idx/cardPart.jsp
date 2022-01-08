<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<div class="col-lg-3 col-6">
	<!-- small box -->
	<div class="small-box ${param.classNm != null ? param.classNm : 'bg-info'}">
		<div class="inner">
			<h3>${param.cnt}</h3>
			<p>${param.subName}</p>
		</div>
		<div class="icon">
			<i class="ion ${param.iconNm != null ? param.iconNm : 'ion-pie-graph'}"></i>
		</div>
		<a href="${param.goUrl != null ? param.goUrl : '#'}" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
	</div>
</div>
</html>