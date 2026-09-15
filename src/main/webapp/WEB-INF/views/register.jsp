<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .name-row {
            display: flex;
            gap: 0.75rem;
        }
        .name-row .form-group {
            flex: 1;
        }
        .auth-footer {
            margin-top: 1.25rem;
            text-align: center;
            font-size: 0.85rem;
            color: var(--text-muted);
        }
        .auth-footer a {
            color: var(--primary);
            text-decoration: none;
            font-weight: 600;
        }
        .auth-footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="card">
    <h1 class="card-title">Create Account</h1>
    <p class="card-subtitle">Sign up to get started</p>

    <%-- Display error if registration fails --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="alert"><%= request.getAttribute("errorMessage") %></div>
    <% } %>

    <form action="${pageContext.request.contextPath}/register" method="post">
        <div class="name-row">
            <div class="form-group">
                <label for="first_name">First Name</label>
                <input type="text" id="first_name" name="first_name" value="${param.first_name}" required>
            </div>
            <div class="form-group">
                <label for="last_name">Last Name</label>
                <input type="text" id="last_name" name="last_name" value="${param.last_name}" required>
            </div>
        </div>

        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" value="${param.username}" required autocomplete="username">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" value="${param.email}" required autocomplete="email">
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required autocomplete="new-password">
        </div>

        <button type="submit" class="btn">Register</button>
    </form>

    <div class="auth-footer">
        Already have an account? <a href="${pageContext.request.contextPath}/login">Sign in</a>
    </div>
</div>

</body>
</html>