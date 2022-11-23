<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>UTN Motel - Registración</title>
        <link rel="shortcut icon" href="http://localhost:8080/UTNMotel/favicon.ico" type="image/x-icon"/>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link href="css/registrarse.css" rel="stylesheet">
    </head>

    <body>
    <center>
        <div class="container-fluid">
            <h1 class="mt-4">
                Registración
            </h1>
        </div>

        <form method="POST" action="ServletRegistrarse">
            <div class="form-group">
                Complete los siguientes datos:
                <input type="email" 
                       id="email" 
                       class="form-control col-md-4" 
                       name="txtUsuario"
                       aria-describedby="emailHelp" 
                       title="Ingrese el Correo Electrónico"
                       placeholder="Correo Electrónico"
                       required>

                <small id="emailHelp" class="form-text text-muted">Nunca compartiremos su correo electrónico.</small>
            </div>

            <div class="form-group">
                <input type="password" 
                       id="psw" 
                       class="form-control col-md-4" 
                       name="txtPass" 
                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                       title="Debe contener al menos un número, una letra mayúscula, una letra minúscula y debe contener entre 8 a 20 caracteres" required 
                       placeholder="Contraseña">

                <small id="emailHelp" class="form-text text-muted">
                    <a href="https://www.clavesegura.org/es/">Generador de Contraseñas Seguras</a>
                </small>
            </div>

            <div id="message">
                <div class="alert col-md-4" role="alert">
                    <label>La contraseña debe contener lo siguiente: </label> <br>
                    <label id="letter" class="invalid">Una Letra <b>Minúscula</b> </label> <br>
                    <label id="capital" class="invalid">Una Letra <b>Mayúscula</b> </label> <br>
                    <label id="number" class="invalid">Un <b>Número</b> </label> <br>
                    <label id="length" class="invalid">Entre <b>8 y 20</b> Caracteres </label> <br>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Registrarse</button>
        </form>
    </center>

    <script>
        var myInput = document.getElementById("psw");
        var letter = document.getElementById("letter");
        var capital = document.getElementById("capital");
        var number = document.getElementById("number");
        var length = document.getElementById("length");

        // When the user clicks on the password field, show the message box
        myInput.onfocus = function () {
            document.getElementById("message").style.display = "block";
        }

        // When the user clicks outside of the password field, hide the message box
        myInput.onblur = function () {
            document.getElementById("message").style.display = "none";
        }

        // When the user starts to type something inside the password field
        myInput.onkeyup = function () {
            // Validate lowercase letters
            var lowerCaseLetters = /[a-z]/g;
            if (myInput.value.match(lowerCaseLetters)) {
                letter.classList.remove("invalid");
                letter.classList.add("valid");
            } else {
                letter.classList.remove("valid");
                letter.classList.add("invalid");
            }

            // Validate capital letters
            var upperCaseLetters = /[A-Z]/g;
            if (myInput.value.match(upperCaseLetters)) {
                capital.classList.remove("invalid");
                capital.classList.add("valid");
            } else {
                capital.classList.remove("valid");
                capital.classList.add("invalid");
            }

            // Validate numbers
            var numbers = /[0-9]/g;
            if (myInput.value.match(numbers)) {
                number.classList.remove("invalid");
                number.classList.add("valid");
            } else {
                number.classList.remove("valid");
                number.classList.add("invalid");
            }

            // Validate length
            if (myInput.value.length >= 8 && myInput.value.length <= 20) {
                length.classList.remove("invalid");
                length.classList.add("valid");
            } else {
                length.classList.remove("valid");
                length.classList.add("invalid");
            }
            var txtUsuario = document.getElementById('txtUsuario');
            if (txtUsuario.value === '') {
                alert('El Nombre de Usuario no debe estar vacio');
                return false;
            }

            var txtPass = document.getElementById('txtPass');
            if (txtPass.value === '') {
                alert('La Contraseña no debe estar vacia');
                return false;
            }
        }
    </script>
</body>
</html>
