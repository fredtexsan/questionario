<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Página de Login">
    <meta name="author" content="Alan Arantes Souza">

    <title>Lista Questionários</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/dist/css/sb-admin-2.css" />" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    
    <!-- Timeline CSS -->
	<link href="<c:url value="/resources/dist/css/timeline.css" />"	rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
     <!-- jQuery -->
    <script src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js" />"></script>

	<!-- Form Validate -->
    <script src="<c:url value="/resources/bower_components/jquery-validation/dist/jquery.validate.min.js" />"></script>

</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
		<div class="navbar-header">
			<a class="navbar-brand" href="listar-questionario.jsp">Questionário</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown">
				<c:if test="${not empty loggedInUser}">
					<a href="${pageContext.request.contextPath}/logout"> Logout</a>
				</c:if>
				<c:if test="${empty loggedInUser}">
					<a href="${pageContext.request.contextPath}/login"> Login</a>
				</c:if>
			</li>
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="${pageContext.request.contextPath}/list">Listar questionários</a></li>
					<c:if test="${not empty loggedInUser}">
						<li><a href="${pageContext.request.contextPath}/create">Criar novo questionário</a></li>
					</c:if>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Questionários</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-heading">
							Lista de questionários
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<!-- Caso ocorra erro ao salvar a resposta, exibe o tooltip -->
	                    	<c:if test="${not empty message}">
								<div class="alert alert-danger fade in">
								    <a href="#" class="close" data-dismiss="alert">&times;</a>
								    <strong>Erro!</strong> ${message}
								</div>
							</c:if>
							<ul class="timeline">
								<c:forEach var="questionnarie" items="${questionnaries}" varStatus="loop">
									<c:choose>
										<c:when test="${loop.index % 2 == 0}">
											<li>
											<div class="timeline-badge info"></div>
										</c:when>
										<c:otherwise>
											<li class="timeline-inverted">
											<div class="timeline-badge success"></div>
										</c:otherwise>
									</c:choose>

									<div class="timeline-panel">
										<div class="timeline-heading">
											<h4 class="timeline-title">
												<a href="${pageContext.request.contextPath}/list/${questionnarie.id}">${questionnarie.name}</a>
											</h4>
										</div>
									</div>
									
									</li>
								</c:forEach>
							</ul>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-4 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>
</html>
