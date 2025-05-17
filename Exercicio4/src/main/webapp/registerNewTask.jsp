<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title> Página de Cadastro de Nova Tarefa </title>
		
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
			rel="stylesheet">
		<link rel="stylesheet" href="css/styles.css">
		
		<style>
			body{
				margin: 50px auto;
			}
		</style>
	</head>
	
	<body>
		<div class="container">
			<div class="col-lg-4 offset-lg-4 col-sm-12">
				<c:if test="${result == 'success'}">
					<div class="alert alert-success alert-dismissible fade show" role="alert">
						Tarefa cadastrada com sucesso.
						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
				<c:if test="${result == 'fail'}">
					<div class="alert alert-danger alert-dismissible fade show" role="alert">
						Tarefa não cadastrada. Faça o login.
						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
					
				<form action="registerTask" method="post" id="form1">
					<h1 class="text-center">Nova Tarefa</h1>
					
					<div class="mb-2">
						<label for="description">Descrição*</label> 
						<input type="text" name="description" id="description" class="form-control" required="required">
					</div>
					
					<div class="mb-2">
						<label for="date">Data*</label> 
						<input type="date" name="date" id="date" class="form-control" required="required">
					</div>

					<div class="col-12 mb-2">
						<button type="submit" class="btn btn-primary">Salvar</button>
					</div>
				</form>
			</div>
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	</body>
</html>