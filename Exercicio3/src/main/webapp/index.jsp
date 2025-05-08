<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title> Formulário - Lista de Tarefas </title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	
	<body>
		<section class="all">
			<section class="titles">
				<h1> Formulário </h1>
				<h3> Para Adicionar Novas Tarefas à Lista </h3>
			</section>
		
			<form action="formTask" method="post">
				<h3> Nova Tarefa: </h3>
				
				<label> Descrição: </label>
				<input type="text" name="description" id="description" required> <br>
				
				<label> Data: </label>
				<input type="date" name="date" id="date" required>
				
				<input type="submit" value="ADICIONAR">
			</form>
		</section>
	</body>
</html>