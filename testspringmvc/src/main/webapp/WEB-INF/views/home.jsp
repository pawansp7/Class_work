<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home | Login</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background: linear-gradient(120deg, #4e54c8, #8f94fb);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .container {
            background: #fff;
            width: 800px;
            max-width: 90%;
            display: flex;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 15px 40px rgba(0,0,0,0.2);
        }

        .left {
            flex: 1;
            background: #4e54c8;
            color: #fff;
            padding: 40px;
        }

        .left h1 {
            margin-top: 0;
            font-size: 32px;
        }

        .left p {
            font-size: 16px;
            line-height: 1.6;
        }

        .right {
            flex: 1;
            padding: 40px;
        }

        .right h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        .btn {
            width: 100%;
            padding: 12px;
            background: #4e54c8;
            color: #fff;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 10px;
        }

        .btn:hover {
            background: #3c40a0;
        }

        .extra {
            margin-top: 15px;
            text-align: center;
            font-size: 14px;
        }

        .extra a {
            color: #4e54c8;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="container">
    <!-- Left Section -->
    <div class="left">
        <h1>Welcome Back</h1>
        <p>
            This is a simple Spring MVC home page with a secure login section.
            Please login using your email and password to continue.
        </p>
    </div>

    <!-- Right Section -->
    <div class="right">
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" placeholder="Enter your email" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="Enter your password" required>
            </div>

            <button type="submit" class="btn">Login</button>
        </form>

        <div class="extra">
            <p>Don't have an account? <a href="register">Register</a></p>
        </div>
    </div>
</div>

</body>
</html>