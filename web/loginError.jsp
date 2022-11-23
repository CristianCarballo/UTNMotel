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

        <title>UTN Motel - Login</title>
        <link rel="shortcut icon" href="http://localhost:8080/UTNMotel/favicon.ico" type="image/x-icon"/>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>

    <body>
    <center>
        <div class="container-fluid">
            <h1 class="mt-4">
                Hola, <br>
                Bienvenido a <br>
                UTN MOTEL <br>
            </h1>
        </div>


        <form method="POST" action="ServletLogin">
            <div class="form-group">

                <div class="alert alert-danger col-md-4" role="alert" >
                    Datos Incorrectos. Intente Nuevamente.
                </div>

                Ingresa a Mi Cuenta
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
                       title="Debe contener al menos un número, una letra mayúscula, una letra minúscula y más de 8 caracteres" required 
                       placeholder="Contraseña">

                <small id="emailHelp" class="form-text text-muted">
                    <a href="registrarse.jsp">¿Aún no tienes cuenta? Regístrate Aquí!</a>
                </small>
            </div>

            <button type="submit" class="btn btn-primary">Ingresar</button>
        </form>
    </center>

    <!-- Menu Toggle Script -->
    <script>
        $("#menu-toggle").click(function (e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });

        function validar() {
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
    </script>

</body>
</html>