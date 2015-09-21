<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		
		//recupera o ID Máximo das opções
		//para criar as opções com o nome correto para o spring
		function withMaxId() {
		  var max = -1;
		  $('input[name^=option]').each(function() {
		    var namev = parseInt(this.name.replace(/[^\d.]/g, '').replace('.', ''));
		    
		    if (namev > max) {
		      max = namev;
		    }
		  });
		  
		  return max;
		}
		
		$(document).ready(function() {
			
			//adiciona perguntas
			$('#addQuestion').click(function() {
				var id = $('div[id^="divQuestion"]:last').attr("id").slice(-1);
				var wrapper = '#divQuestion' + id;
				id++;
				
				var optionIdx = withMaxId();
				optionIdx++;
				
				console.log(optionIdx);
	
				$('#wrapperQuestion').append('<div id = "divQuestion' + id + '" class="form-horizontal"><div class="form-group"><label class="col-xs-3 control-label">Pergunta</label><div class="col-xs-5"><input type="text" class="form-control" name="question[' + id + '].name" id="question[' + id + ']" required/></div></div><div class="form-group"><label class="col-xs-3 control-label">Tipo de pergunta</label><div class="radio col-xs-5"><label><input type="radio" name="question[' + id + '].type" value="0" checked>Aberta</label><label><input type="radio" name="question[' + id + '].type" id="option' + optionIdx + '" value="1">Múltipla escolha</label></div></div><div class="form-group" id="template' + id + '" style="display: none"><label class="col-xs-3 control-label" id="labelOption' + id + '"> - </label><div class="col-xs-3" id="divOption0"><input type="text" class="form-control" name="option[' + optionIdx + '].name" /><input type="hidden" name="option[' + optionIdx + '].question.id" id="idxOption' + optionIdx + '" value="' + id + '" /></div><div class="col-xs-2"><button type="button" class="btn btn-default addOption">+</button></div><div class="row"><div class="col-md-6"></div><div class="col-md-6"></div></div></div><div class="well"></div></div>');
			});
	
			//adiciona opções
			$(document).on('click','.addOption',function(){
				var wrapper = '#'; 
				var id = $(this).parent().parent().attr("id");
				wrapper +=	id;
				
				console.log(wrapper);
				
				//var lastDivOption  = $(templateDiv + ' > div[id^="divOption"]:last').attr("id");
				//var id = $('div[id^="template"]:last').attr("id").slice(-1);
				
				var option = withMaxId();
				option++;
				
				var optionIdx = $('input[id^="idxOption"]:last').attr("id").slice(-1);
				$(wrapper).append('<label class="col-lg-3 control-label" id="labelOption' + option + '" > - </label><div class="col-lg-3" id="divOption' + option + '"><input type="text" class="form-control" name="option[' + option + '].name" required/><input type="hidden" name="option[' + option + '].question.id" id="idxOption' + optionIdx + '" value="' + id.slice(-1) + '"/></div><div class="col-xs-2"><button type="button" class="btn btn-default removeOption">-</button></div><div class="row"><div class="col-md-6"></div><div class="col-md-6"></div></div>');

			});
							
			//remove opções
			$(document).on('click','.removeOption',function(){
				$(this).parent().prev('div').prev('label').remove();
				$(this).parent().prev('div').remove();
				$(this).parent().next('div').remove();
				$(this).parent().remove();
			});
			
			//caso seja escolhido o tipo de pergunta "fechada", é exibido o campo das opções
			$(document).on('click', 'input:radio', function(event) {
				//OMG! infinitos "parent()"
				var id = $(event.target).parent().parent().parent().parent().attr('id').slice(-1);
				var template = "#template";

				if ($.isNumeric(id)) {
					template += id++;
				}
				
				var radioValue = $('input[name="' + event.target.name + '"]:checked').val();

				if (radioValue == 1) {
					$(template).show();
				} else {
					$(template).hide();
				}
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
					<li><a href="${pageContext.request.contextPath}/list">Listar questionários</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/create">Criar novo questionário</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Questionário</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<form:form method="POST" commandName="questionnarieCommand"	action="${pageContext.request.contextPath}/add" role="form-inline" id="form">
				<div class="row">
					<div class="col-lg-12">
						<!-- /.panel -->
						<div class="panel panel-default">
							<div class="panel-heading">Novo questionário</div>
							<div class="panel-body">
								<div role="form-inline">
									<div class="input-append">
										<label>Nome do questionario</label>
										<input type="text" name="questionnarie.name" required/>
										<input type="hidden" name="questionnarie.user.email" value="${loggedInUser}">
										<button type="submit" class="btn btn-default">Criar Questionário</button>
									</div>
								</div>
							</div>
						</div>
						<!-- /.panel -->
						<div class="panel panel-default" id="panel">
							<div class="panel-heading">
								<button id="addQuestion" type="button" class="btn btn-default addButton">+</button>
								Perguntas
							</div>
							<!-- /.panel-heading -->
							<div class="panel-body" id="wrapperQuestion">
								<div id="divQuestion0" class="form-horizontal">
									<div class="form-group">
										<label class="col-xs-3 control-label">Pergunta</label>
										<div class="col-xs-5">
											<input type="text" class="form-control" name="question[0].name" required/>
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-3 control-label">Tipo de pergunta</label>
										<div class="radio col-xs-5">
											<label>
												<input type="radio" name="question[0].type" value="0" checked>Aberta
											</label>
											<label>
												<input type="radio" name="question[0].type" id="option0" value="1">Múltipla escolha
											</label>
										</div>
									</div>
									
									<div class="form-group" id="template0" style="display: none">
										<label class="col-xs-3 control-label" id="labelOption0"> - </label>
										<div class="col-xs-3" id="divOption0">
											<input type="text" class="form-control" name="option[0].name"/>
											<input type="hidden" name="option[0].question.id" id="idxOption0" value="0" />
										</div>
										<div class="col-xs-2">
											<button type="button" class="btn btn-default addOption">+</button>
										</div>
										<div class="row">
											<div class="col-md-6"></div>
											<div class="col-md-6"></div>
										</div>
									</div>
									<div class="well"></div>
								</div>
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-4 -->
				</div>
			</form:form>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>
</html>
