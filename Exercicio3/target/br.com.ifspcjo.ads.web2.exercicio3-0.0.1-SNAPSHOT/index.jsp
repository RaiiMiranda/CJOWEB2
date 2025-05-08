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
		<h1> Formulário </h1>
		<h3> para Adicionar Novas Tarefas à Lista </h3>
	
		<form action="formTask" method="post">
			<h3> Nova Tarefa: </h3>
			
			<label> Descrição: </label>
			<input type="text" name="description" id="description">
			
			<label> Data: </label>
			<input type="date" name="date" id="date">
			
			<input type="submit" value="Adicionar">
		</form>
	</body>
</html>