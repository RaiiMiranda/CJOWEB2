<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Página de Boas-vindas</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    	<link href="css/styles.css" rel="stylesheet">
    	
    	<style>
			body{
				margin: 50px auto;
			}
			
			h1, p{
				text-align: center;
			}
			
			a{
				margin: 0 10px;
			}
    	</style>
	</head>
	
	<body>
		<div class="container">
			<div class="col-lg-4 offset-lg-4 col-sm-12">
			    <h1>Bem-vindo!</h1> <br>
			    
			    <p>
			    	<a class="btn btn-primary" href="registerUser.jsp">Cadastre-se</a>
			    	<a class="btn btn-secondary" href="loginUser.jsp">Faça login</a>
			    </p>
		  </div>
		</div>
	</body>
</html>
