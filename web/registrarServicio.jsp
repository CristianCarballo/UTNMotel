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

        <title>UTN Motel - Registrar Servicio</title>
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

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                            Servicio
                        </h1>

                        <form method="POST" action="ServletRegistrarServicio" onsubmit="return validar();">
                            <input type="text" 
                                   name="txtId" 
                                   hidden="" 
                                   value="${id}" 
                                   class="form-control col-md-4" 
                                   placeholder="Id"                                   
                                   />

                            <input type="text" 
                                   name="txtDescripcion" 
                                   id="txtDescripcion" 
                                   value="${descripcion}" 
                                   class="form-control col-md-4" 
                                   placeholder="Descripción"
                                   pattern="(?=.*[a-z])(?=.*[A-Z]){1,20}" 
                                   title="Debe contener entre 1 y 20 caracteres, solo letras"/>
                            <br>

                            <input type="text" 
                                   name="txtPrecio" 
                                   id="txtPrecio" 
                                   value="${precio}" 
                                   class="form-control col-md-4" 
                                   placeholder="Precio"
                                   pattern="{1,10}"
                                   oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
                                   title="Debe contener entre 1 y 10 caracteres, solo números y hasta 1 decimal"/>
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
                                var txtDescripcion = document.getElementById('txtDescripcion');
                                if (txtDescripcion.value === '') {
                                    alert('La Descripción no debe estar vacia');
                                    return false;
                                }

                                var txtPrecio = document.getElementById('txtPrecio');
                                if (txtPrecio.value === '') {
                                    alert('El Precio no debe estar vacio');
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
