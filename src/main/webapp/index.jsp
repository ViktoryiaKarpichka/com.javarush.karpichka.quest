<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <title>Квест</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container text-center">
<h1>Добро пожаловать в квест!</h1>

<c:if test="${not empty sessionScope.gamesPlayed}">
  <p><strong>Игр сыграно:</strong> ${sessionScope.gamesPlayed}</p>
  <p><strong>Побед:</strong> ${sessionScope.gamesWon}</p>
</c:if>

<a href="quest" class="btn btn-primary">Начать игру</a>
</body>
</html>

