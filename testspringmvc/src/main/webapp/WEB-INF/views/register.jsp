<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
        body{
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg,#4e54c8,#8f94fb);
            height:100vh;
            display:flex;
            justify-content:center;
            align-items:center;
        }
        .box{
            background:#fff;
            width:400px;
            padding:30px;
            border-radius:10px;
            box-shadow:0 15px 40px rgba(0,0,0,0.2);
        }
        h2{text-align:center;margin-bottom:20px;}
        label{font-weight:bold;}
        input{
            width:100%;
            padding:10px;
            margin:8px 0 15px;
            border-radius:5px;
            border:1px solid #ccc;
        }
        button{
            width:100%;
            padding:12px;
            background:#4e54c8;
            border:none;
            color:#fff;
            font-size:16px;
            border-radius:6px;
            cursor:pointer;
        }
        button:hover{background:#3c40a0;}
        p{text-align:center;margin-top:15px;}
        a{color:#4e54c8;text-decoration:none;font-weight:bold;}
    </style>
</head>
<body>

<div class="box">
    <h2>Register</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
    <p>Already have an account?
    <a href="${pageContext.request.contextPath}/home">Login</a>
</p>
        <label>Email</label>
        <input type="email" name="email" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <button type="submit">Create Account</button>
    </form>

    <p>Already have an account? <a href="/">Login</a></p>
</div>

</body>
</html>
