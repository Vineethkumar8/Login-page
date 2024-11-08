<%-- 
    Document   : register
    Created on : 24 Oct, 2024, 12:17:31 PM
    Author     : sensen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: palegoldenrod;
            color: #333;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #4CAF50;
        }

        form {
            max-width: 400px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin: 10px 0 5px;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error {
            color: red;
            font-size: 14px;
            margin-top: -10px;
            margin-bottom: 10px;
        }
        </style>
    <script>
        function validateForm() {
            var name = document.getElementById("name").value;
            var dob = document.getElementById("dob").value;
            var password = document.getElementById("password").value;
            var today = new Date();
            var birthDate = new Date(dob);
            var age = today.getFullYear() - birthDate.getFullYear();
            var monthDiff = today.getMonth() - birthDate.getMonth();
            if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
                age--;
            }
            if (age < 18) {
                alert("You must be at least 18 years old.");
                return false;
            }
            var passwordPattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*]).{6,}$/;
          if (!passwordPattern.test(password)) {
                alert("Password must contain at least one uppercase letter, one number, and one special character.");
                return false;
            }
          checkUsernameAvailability(name, function(isAvailable) {
        if (!isAvailable) {
            return false; 
        } else {
            document.forms[0].submit(); 
        }
    }

    return false;
    }

    function checkUsernameAvailability(name, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "CheckUsernameServlet", true); // Ensure this matches your servlet URL
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                if (xhr.responseText.trim() === "exists") {
                    alert("Name already exists. Please choose a different name.");
                    callback(false);
                } else {
                    callback(true);
                }
            } else {
                alert("An error occurred while checking username availability.");
                callback(false);
            }
        }
    };

    xhr.send("name=" + encodeURIComponent(name));
}

    </script>
    
</head>
<body>
    <h2>Registration Form</h2>
    <form action="register" method="post" onsubmit="return validateForm()">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select><br><br>

        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required ><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Register">
    </form>
</body>
</html>
<