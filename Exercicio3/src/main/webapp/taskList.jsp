<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,br.com.ifspcjo.ads.web2.Task"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title> Lista de Tarefas Atual </title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	
	<body>
		<section class="all">
			<h1> Lista de Tarefas </h1> <br>
			
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>Descrição:</th>
						<th>Data:</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="task" items="${tasks}">
						<tr>
							<td>${task.id}</td>
							<td>${task.description}</td>
							<td>${task.date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<br><a href="index.jsp">Voltar</a>
		</section>
	</body>
</html>