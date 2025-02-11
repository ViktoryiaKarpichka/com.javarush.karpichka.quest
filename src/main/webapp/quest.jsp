<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Квест</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">

<h2>${question.text}</h2>

<c:forEach var="entry" items="${question.options}">
    <form method="post" action="quest">
        <input type="hidden" name="nextId" value="${entry.value}">
        <button type="submit" class="btn btn-primary">${entry.key}</button>
    </form>
</c:forEach>

<br>
<a href="index.jsp" class="btn btn-danger">Завершить игру</a>

</body>
</html>


