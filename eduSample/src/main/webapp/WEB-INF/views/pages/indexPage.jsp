<%@ page language="java" contentType="text/html; charset=EUC-KR"
		pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<div class="content-wrapper">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">¿Œµ¶Ω∫</h1>
				</div><!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
					</ol>
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.container-fluid -->
	</div>

	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<jsp:include page="/WEB-INF/views/parts/idx/cardPart.jsp">
					<jsp:param value="15" name="cnt"/>
					<jsp:param value="subName1" name="subName"/>
					<jsp:param value="bg-info" name="classNm"/>
					<jsp:param value="ion ion-person-add" name="iconNm"/>
					<jsp:param value="/index" name="goUrl"/>
				</jsp:include>
				<jsp:include page="/WEB-INF/views/parts/idx/cardPart.jsp">
					<jsp:param value="15" name="cnt"/>
					<jsp:param value="subName1" name="subName"/>
					<jsp:param value="bg-success" name="classNm"/>
					<jsp:param value="ion ion-person-add" name="iconNm"/>
					<jsp:param value="/index" name="goUrl"/>
				</jsp:include>
				<jsp:include page="/WEB-INF/views/parts/idx/cardPart.jsp">
					<jsp:param value="15" name="cnt"/>
					<jsp:param value="subName1" name="subName"/>
					<jsp:param value="bg-danger" name="classNm"/>
					<jsp:param value="ion ion-person-add" name="iconNm"/>
					<jsp:param value="/index" name="goUrl"/>
				</jsp:include>
				<jsp:include page="/WEB-INF/views/parts/idx/cardPart.jsp">
					<jsp:param value="15" name="cnt"/>
					<jsp:param value="subName1" name="subName"/>
					<jsp:param value="bg-danger" name="classNm"/>
					<jsp:param value="ion ion-person-add" name="iconNm"/>
					<jsp:param value="/index" name="goUrl"/>
				</jsp:include>
			</div>
			<div class="row">
				<div class="col-md-12">
					<!-- USERS LIST -->
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">Latest Members</h3>

							<div class="card-tools">
								<span class="badge badge-danger">8 New Members</span>
								<button type="button" class="btn btn-tool" data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								<button type="button" class="btn btn-tool" data-card-widget="remove">
									<i class="fas fa-times"></i>
								</button>
							</div>
						</div>
						<!-- /.card-header -->
						<div class="card-body p-0">
							<ul class="users-list clearfix">
								<li>
									<img src="/files/imgs/user/defaultuser.jpg" alt="User Image">
									<a class="users-list-name" href="#">Alexander Pierce</a>
									<span class="users-list-date">Today</span>
								</li>
								<li>
									<img src="/files/imgs/user/defaultuser.jpg" alt="User Image">
									<a class="users-list-name" href="#">Norman</a>
									<span class="users-list-date">Yesterday</span>
								</li>
								<li>
									<img src="/files/imgs/user/defaultuser.jpg" alt="User Image">
									<a class="users-list-name" href="#">Jane</a>
									<span class="users-list-date">12 Jan</span>
								</li>
								<li>
									<img src="/files/imgs/user/defaultuser.jpg" alt="User Image">
									<a class="users-list-name" href="#">John</a>
									<span class="users-list-date">12 Jan</span>
								</li>
								<li>
									<img src="/files/imgs/user/defaultuser.jpg" alt="User Image">
									<a class="users-list-name" href="#">Alexander</a>
									<span class="users-list-date">13 Jan</span>
								</li>
								<li>
									<img src="/files/imgs/user/defaultuser.jpg" alt="User Image">
									<a class="users-list-name" href="#">Sarah</a>
									<span class="users-list-date">14 Jan</span>
								</li>
								<li>
									<img src="/files/imgs/user/defaultuser.jpg" alt="User Image">
									<a class="users-list-name" href="#">Nora</a>
									<span class="users-list-date">15 Jan</span>
								</li>
								<li>
									<img src="/files/imgs/user/defaultuser.jpg" alt="User Image">
									<a class="users-list-name" href="#">Nadia</a>
									<span class="users-list-date">15 Jan</span>
								</li>
							</ul>
							<!-- /.users-list -->
						</div>
						<!-- /.card-body -->
						<div class="card-footer text-center">
							<a href="javascript:">View All Users</a>
						</div>
						<!-- /.card-footer -->
					</div>
					<!-- TABLE: LATEST ORDERS -->
					<div class="card">
						<div class="card-header border-transparent">
							<h3 class="card-title">Latest Orders</h3>

							<div class="card-tools">
								<button type="button" class="btn btn-tool" data-card-widget="collapse">
									<i class="fas fa-minus"></i>
								</button>
								<button type="button" class="btn btn-tool" data-card-widget="remove">
									<i class="fas fa-times"></i>
								</button>
							</div>
						</div>
						<!-- /.card-header -->
						<div class="card-body p-0">
							<div class="table-responsive">
								<table class="table m-0">
									<thead>
									<tr>
										<th>Order ID</th>
										<th>Item</th>
										<th>Status</th>
										<th>Popularity</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td><a href="pages/examples/invoice.html">OR9842</a></td>
										<td>Call of Duty IV</td>
										<td><span class="badge badge-success">Shipped</span></td>
										<td>
											<div class="sparkbar" data-color="#00a65a" data-height="20">90,80,90,-70,61,-83,63</div>
										</td>
									</tr>
									<tr>
										<td><a href="pages/examples/invoice.html">OR1848</a></td>
										<td>Samsung Smart TV</td>
										<td><span class="badge badge-warning">Pending</span></td>
										<td>
											<div class="sparkbar" data-color="#f39c12" data-height="20">90,80,-90,70,61,-83,68</div>
										</td>
									</tr>
									<tr>
										<td><a href="pages/examples/invoice.html">OR7429</a></td>
										<td>iPhone 6 Plus</td>
										<td><span class="badge badge-danger">Delivered</span></td>
										<td>
											<div class="sparkbar" data-color="#f56954" data-height="20">90,-80,90,70,-61,83,63</div>
										</td>
									</tr>
									<tr>
										<td><a href="pages/examples/invoice.html">OR7429</a></td>
										<td>Samsung Smart TV</td>
										<td><span class="badge badge-info">Processing</span></td>
										<td>
											<div class="sparkbar" data-color="#00c0ef" data-height="20">90,80,-90,70,-61,83,63</div>
										</td>
									</tr>
									<tr>
										<td><a href="pages/examples/invoice.html">OR1848</a></td>
										<td>Samsung Smart TV</td>
										<td><span class="badge badge-warning">Pending</span></td>
										<td>
											<div class="sparkbar" data-color="#f39c12" data-height="20">90,80,-90,70,61,-83,68</div>
										</td>
									</tr>
									<tr>
										<td><a href="pages/examples/invoice.html">OR7429</a></td>
										<td>iPhone 6 Plus</td>
										<td><span class="badge badge-danger">Delivered</span></td>
										<td>
											<div class="sparkbar" data-color="#f56954" data-height="20">90,-80,90,70,-61,83,63</div>
										</td>
									</tr>
									<tr>
										<td><a href="pages/examples/invoice.html">OR9842</a></td>
										<td>Call of Duty IV</td>
										<td><span class="badge badge-success">Shipped</span></td>
										<td>
											<div class="sparkbar" data-color="#00a65a" data-height="20">90,80,90,-70,61,-83,63</div>
										</td>
									</tr>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.card-body -->
						<div class="card-footer clearfix">
							<a href="javascript:void(0)" class="btn btn-sm btn-info float-left">Place New Order</a>
							<a href="javascript:void(0)" class="btn btn-sm btn-secondary float-right">View All Orders</a>
						</div>
						<!-- /.card-footer -->
					</div>
					<!-- /.card -->
				</div>
				<!-- /.col -->
			</div>
		</div>
	</section>
</div>
</html>