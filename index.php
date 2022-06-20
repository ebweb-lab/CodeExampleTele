<?php

use LDAP\Result;

 include('conexion.php');?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla</title>
    <!--Boostrap-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
        integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
    

<div class="container w-25">
        <h1> Lista Usuario </h1>
        <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
      <th scope="col">Profesion</th>
      <th scope="col">Estado</th>
      <th scope="col">Fragis</th>
    </tr>
  </thead>
  <tbody>
  <?php 
    $sql = "SELECT * FROM users"; 
    $query = $connect -> prepare($sql); 
    $query -> execute(); 
    $results = $query -> fetchAll(PDO::FETCH_OBJ); 
    if($query -> rowCount() > 0)   { 
    foreach($results as $result) { 
    echo "<tr>
      <td>".$result -> nombres."</td>
      <td>".$result -> apellidos."</td>
      <td>".$result -> profesion."</td>
      <td>".$result -> estado."</td>
      <td>".$result -> fragis."</td>
    </tr>";
     }
    }
    ?>
  </tbody>
</table>

    </div>
</body>

</html>