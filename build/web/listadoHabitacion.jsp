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

        <title>UTN Motel - Listado Habitaciones</title>
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
                                Listado de Habitaciones
                            </h1>
                        <c:choose>
                            <c:when test="${empty lista}">
                                <div class="alert alert-danger col-md-4" role="alert" >
                                    Lista de Habitaciones Vacía
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${lista}" var="i">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Id</th>
                                                <th scope="col">Descripcion</th>
                                                <th scope="col">Tipo de Habitacion</th>
                                                <th scope="col">Capacidad</th>
                                                <th scope="col">Precio</th>
                                                <th scope="col"></th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <tr>
                                                <th scope="row">${i.idHabitacion}</th>
                                                <td>${i.descripcion}</td>
                                                <td>${i.getTipoHabitacion().descripcion}</td>
                                                <td>${i.getTipoHabitacion().capacidad}</td>
                                                <td>${i.getTipoHabitacion().precio}</td>
                                                <td><button type="button" class="btn btn-warning" onclick="window.location.href = '/UTNMotel/ServletModificarHabitacionImagen?id=${i.idHabitacion}'">Editar Fotos</button></td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <c:forEach items="${fotos}" var="f">
                                        <c:if test="${f.idHabitacion == i.idHabitacion}">
                                            <img class="img-thumbnail" style="width:250px; height:200px; padding: 10px;" src="${f.descripcion}">
                                        </c:if>
                                    </c:forEach>
                                    <br>
                                    <br>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
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
        </script>
    </body>
</html>

