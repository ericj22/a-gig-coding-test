<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="card">
    <h1 class="card-title">${user.firstName} ${user.lastName}</h1>
    <p class="card-subtitle">@${user.username}</p>

    <div class="info-list">
        <div class="info-row">
            <span class="info-label">Email</span>
            <span class="info-value">${user.email}</span>
        </div>
        <div class="info-row">
            <span class="info-label">First Name</span>
            <span class="info-value">${user.firstName}</span>
        </div>
        <div class="info-row">
            <span class="info-label">Last Name</span>
            <span class="info-value">${user.lastName}</span>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/logout" method="post">
        <button type="submit" class="btn btn-secondary">Log Out</button>
    </form>
</div>

</body>
</html>