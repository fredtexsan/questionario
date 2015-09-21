<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Página de Login">
    <meta name="author" content="Alan Arantes Souza">

    <title>Login</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/dist/css/sb-admin-2.css" />" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">

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
    
	<script>
		//valida o formulário
		$("#userForm").validate();
	</script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Bem vindo ao sistema de questionários!</h3>
                    </div>
                    <div class="panel-body">
                    	<!-- Caso ocorra erro no login, exibe o tooltip -->
                    	<c:if test="${not empty message}">
							<div class="alert alert-danger fade in">
							    <a href="#" class="close" data-dismiss="alert">&times;</a>
							    <strong>Erro!</strong> ${message}
							</div>
						</c:if>
                        <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/login" role="form" id="userForm">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus required>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="" required>
                                </div>
                                <a href="#">
                                    <div class="form-group">
                                        <span class="pull-left"><a href="${pageContext.request.contextPath}/user/add">Registrar</a></span>
                                        <span class="pull-right"><a href="${pageContext.request.contextPath}/list">Entrar sem logar</a></span>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                                <button type="submit" class="btn btn-lg btn-success btn-block">Login</button> 
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
