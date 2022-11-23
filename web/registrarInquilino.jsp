<%
    HttpSession sesion = request.getSession();
    Object usuario = sesion.getAttribute("usuario");

    if (usuario == null) {
        response.sendRedirect("/UTNMotel/ServletLogin?accion=cerrar");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>UTN Motel - Registrar Inquilino</title>
        <link rel="shortcut icon" href="http://localhost:8080/UTNMotel/favicon.ico" type="image/x-icon"/>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!-- Custom styles for this template -->
        <link href="css/simple-sidebar.css" rel="stylesheet">
    </head>

    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar -->
            <div class="bg-light border-right" id="sidebar-wrapper">
                <center>
                    <div class="sidebar-heading alert-dark">UTN Motel</div>
                </center>
                <div class="list-group list-group-flush">
                    <center>
                        <a href="inicio.jsp" class="list-group-item list-group-item-action bg-light">Inicio</a>

                        <div class="sidebar-heading alert-dark"></div>
                        <a href="#" class="list-group-item list-group-item-action bg-light">Registrar Pago</a>
                        <a href="/UTNMotel/ServletRegistrarServicio" class="list-group-item list-group-item-action bg-light">Registrar Servicio</a>
                        <a href="/UTNMotel/ServletRegistrarInquilino" class="list-group-item list-group-item-action bg-light">Registrar Inquilino</a>
                        <a href="/UTNMotel/ServletRegistrarTipoHabitacion" class="list-group-item list-group-item-action bg-light">Registrar Tipo Habitación</a>

                        <div class="sidebar-heading alert-dark"></div>
                        <a href="/UTNMotel/ServletListadoServicio" class="list-group-item list-group-item-action bg-light">Listado Servicios</a>
                        <a href="/UTNMotel/ServletListadoInquilino" class="list-group-item list-group-item-action bg-light">Listado Inquilinos</a>
                        <a href="/UTNMotel/ServletListadoHabitacion" class="list-group-item list-group-item-action bg-light">Listado Habitaciones</a>
                        <a href="/UTNMotel/ServletListadoTipoHabitacion" class="list-group-item list-group-item-action bg-light">Listado Tipo Habitación</a>

                        <div class="sidebar-heading alert-dark"></div>
                        <a href="#" class="list-group-item list-group-item-action bg-light">Reporte N°1</a>
                        <a href="#" class="list-group-item list-group-item-action bg-light">Reporte N°2</a>
                        <a href="#" class="list-group-item list-group-item-action bg-light">Reporte N°3</a>
                        <a href="#" class="list-group-item list-group-item-action bg-light">Reporte N°4</a>

                        <div class="sidebar-heading alert-dark"></div>
                    </center>
                </div>
            </div>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">

                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <button class="btn btn-primary" id="menu-toggle">Menu</button>

                    <button class="navbar-toggler" type="button" 
                            data-toggle="collapse" data-target="#navbarSupportedContent" 
                            aria-controls="navbarSupportedContent" aria-expanded="false" 
                            aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" 
                                   href="#" id="navbarDropdown" 
                                   role="button" 
                                   data-toggle="dropdown" 
                                   aria-haspopup="true" 
                                   aria-expanded="false">
                                    Mi Cuenta
                                </a>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href ="/UTNMotel/ServletLogin?accion=cerrar">Cerrar Sesión</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>

                <center>
                    <div class="container-fluid">
                        <h1 class="mt-4">
                            Inquilino
                        </h1>

                        <form method="POST" action="ServletRegistrarInquilino" onsubmit="return validar();">
                            <input type="text" 
                                   name="txtId" 
                                   hidden="" 
                                   value="${id}" 
                                   class="form-control col-md-4"/>

                            <input type="text" 
                                   name="txtNombre" 
                                   id="txtNombre" 
                                   value="${nombre}" 
                                   class="form-control col-md-4" 
                                   placeholder="Nombre"
                                   pattern="[A-Za-z]{2,20}" 
                                   title="Debe contener entre 2 y 20 caracteres, solo letras"/>
                            <br>

                            <input type="text" 
                                   name="txtApellido" 
                                   id="txtApellido" 
                                   value="${apellido}" 
                                   class="form-control col-md-4" 
                                   placeholder="Apellido"
                                   pattern="[A-Za-z]{2,20}" 
                                   title="Debe contener entre 2 y 20 caracteres, solo letras"/>
                            <br>

                            <input 
                                type="text" 
                                name="txtDni" 
                                id="txtDni" 
                                value="${dni}" 
                                class="form-control col-md-4" 
                                placeholder="DNI"
                                pattern="[0-9]{5,20}" 
                                title="Debe contener entre 5 y 20 caracteres, solo números"/>
                            <br>

                            <input type="text" 
                                   name="txtDomicilio" 
                                   id="txtDomicilio" 
                                   value="${domicilio}" 
                                   class="form-control col-md-4" 
                                   placeholder="Domicilio"
                                   pattern="(?=.*[a-z])(?=.*[A-Z]){5,20}" 
                                   title="Debe contener entre 5 y 20 caracteres, números o letras"/>
                            <br>

                            <input type="text" 
                                   name="txtTelefono" 
                                   id="txtTelefono" 
                                   value="${telefono}" 
                                   class="form-control col-md-4" 
                                   placeholder="Telefono"
                                   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]){5,20}"
                                   title="Debe contener entre 5 y 20 caracteres. Puede utilizar números, letras y +"/>
                            <br>

                            <button type="submit" class="btn btn-primary">Registrar</button>
                        </form>
                    </div>
                </center>
            </div>
            <!-- /#page-content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Menu Toggle Script -->
        <script>
                            $("#menu-toggle").click(function (e) {
                                e.preventDefault();
                                $("#wrapper").toggleClass("toggled");
                            });

                            function validar() {
                                var txtNombre = document.getElementById('txtNombre');
                                if (txtNombre.value === '') {
                                    alert('El Nombre no debe estar vacio');
                                    return false;
                                }

                                var txtApellido = document.getElementById('txtApellido');
                                if (txtApellido.value === '') {
                                    alert('El Apellido no debe estar vacio');
                                    return false;
                                }

                                var txtDni = document.getElementById('txtDni');
                                if (txtDni.value === '') {
                                    alert('El DNI no debe estar vacio');
                                    return false;
                                }

                                var txtDomicilio = document.getElementById('txtDomicilio');
                                if (txtDomicilio.value === '') {
                                    alert('El Domicilio no debe estar vacio');
                                    return false;
                                }

                                var txtTelefono = document.getElementById('txtTelefono');
                                if (txtTelefono.value === '') {
                                    alert('El Télefono no debe estar vacio');
                                    return false;
                                }

                                if (confirm("Esta seguro?")) {
                                    return true;
                                } else {
                                    return false;
                                }
                            }
        </script>
    </body>
</html>
