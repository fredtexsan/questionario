<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Página de Login">
    <meta name="author" content="Alan Arantes Souza">

    <title>Questionário</title>

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
    
    <script>
  		//valida o formulário
	    $("#form").validate();
	    
  		//ao submeter o formulário, preenche o campo "email" de todas as respostas
  		//com o email informado
	    $(document).ready(function() {
	    	$("#form").submit(function( event ) {
	    	  var email = $("#email").val();
	    	  
	    	  $('input[name$=email]').each(function() {
	    		  if(this.name)
	    		  this.value = email;
	    	  });
	    	  
	    	  //$("#email").remove();
	    	});
	    });
    </script>

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
							${questionnarieCommand.questionnarie.name}
						</div>
						<!-- /.panel-heading -->
						<form:form method="POST" commandName="answerCommand" action="${pageContext.request.contextPath}/answer" role="form" id="form">
							<div class="panel-body">
								<ul class="timeline">
									<c:forEach var="question" items="${questionnarieCommand.question}" varStatus="loop">
										<c:choose>
											<c:when test="${loop.index % 2 == 0}">
												<li>
											</c:when>
											<c:otherwise>
												<li class="timeline-inverted">
											</c:otherwise>
										</c:choose>
										
										<c:choose>
											<c:when test="${not question.type}">
												<div class="timeline-badge info"></div>
											</c:when>
											<c:otherwise>
												<div class="timeline-badge warning"></div>
											</c:otherwise>
										</c:choose>
	
										
										<div class="timeline-panel">
											<div class="timeline-heading">
												<h4 class="timeline-title">
													<a href="#">${question.name}</a>
												</h4>
													<div class="panel-body" id="wrapperQuestion">
														<div id="${loop.index}" class="form-horizontal">
															<div class="form-group">
																<label class="col-xs-3 control-label">Resposta</label>
																<div class="col-xs-5">
																	<c:choose>
																		<c:when test="${not question.type}">
																			<textarea class="form-control" rows="5" name="answers[${loop.index}].name" required></textarea>
																		</c:when>
																		<c:otherwise>
																			<select multiple class="form-control" name="answers[${loop.index}].name" required>
																				<c:forEach var="option" items="${questionnarieCommand.option}">
																					<c:if test="${option.question.id == question.id}">
																					    <option value="${option.name}">${option.name}</option>
																				    </c:if>
																			    </c:forEach>
																			</select>
																		</c:otherwise>
																	</c:choose>
																</div>
																
																<div class="col-xs-3">
																	<input type="hidden" class="form-control" name="answers[${loop.index}].email" value=""/>
																	<input type="hidden" class="form-control" name="answers[${loop.index}].question.id" value="${question.id}"/>
																</div>
															</div>
														</div>
													</div>
											</div>
										</div>
										
										</li>
									</c:forEach>
								</ul>
							</div>
							<!-- /.panel-body -->
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="row" id="grid">
										<div class="col-md-4"></div>
			                            <div class="col-md-4">
				                            <div class="form-group">
				                                 <label>Email: </label>
				                                 <input type="email" class="form-control" id="email" placeholder="email@email.com" required/>
				                                 <button type="submit" class="btn btn-success btn-block">Enviar respostas</button>
			                                 </div>
			                             </div>
			                            <div class="col-md-4"></div>
		                         	</div>
		                       	</div>
		                     </div>
						</form:form>
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
