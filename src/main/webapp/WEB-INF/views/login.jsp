<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign In</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="card">
    <h1 class="card-title">Sign In</h1>
    <p class="card-subtitle">Enter your details to continue</p>

    <%-- Success Banner from Registration Redirect --%>
    <% if ("true".equals(request.getParameter("registered"))) { %>
        <div class="alert alert-success">Account created successfully! Please sign in.</div>
    <% } %>

    <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="alert"><%= request.getAttribute("errorMessage") %></div>
    <% } %>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>

        <button type="submit" class="btn">Login</button>
    </form>

    <div style="margin-top: 1.25rem; text-align: center; font-size: 0.85rem; color: var(--text-muted);">
        Don't have an account? <a href="${pageContext.request.contextPath}/register" style="color: var(--primary); text-decoration: none; font-weight: 600;">Register</a>
    </div>
</div>

</body>
</html>