<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body{
            margin:0;
            font-family:Arial, sans-serif;
            background:#f4f6f9;
        }
        .navbar{
            background:#4e54c8;
            color:#fff;
            padding:15px 30px;
            display:flex;
            justify-content:space-between;
            align-items:center;
        }
        .navbar a{
            color:#fff;
            text-decoration:none;
            font-weight:bold;
            background:#ff4d4d;
            padding:8px 14px;
            border-radius:6px;
        }
        .container{
            padding:30px;
        }
        .card{
            background:#fff;
            padding:25px;
            border-radius:10px;
            box-shadow:0 10px 25px rgba(0,0,0,0.1);
            max-width:600px;
        }
        h1{margin-top:0;}
    </style>
</head>
<body>

<div class="navbar">
    <div>Dashboard</div>
    <a href="${pageContext.request.contextPath}/home">Logout</a>
</div>

<div class="container">
    <div class="card">
        <h1>Welcome 🎉</h1>
        <p>You have successfully logged in.</p>
        <p>This is your dashboard page.</p>
    </div>
</div>

</body>
</html>
