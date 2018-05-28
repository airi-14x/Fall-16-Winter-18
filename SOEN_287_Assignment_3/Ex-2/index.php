<!DOCTYPE html>
<html>
<head>
    <title> URL Parsing </title>
    <meta charset = "utf-8" />
    <style type="text/css">
    table{
      border: 1px black solid;
   }
    tr{
      height: 50px;
   }
   td{
      border: 1px black solid;
      padding: 20px;
   }
    </style>
</head>
<body>


<?php

   // http://www.site.com/index.php?age=22&name=Obi+Wan+Kenobi&number=5435432156 //
   //echo ($_GET["name"]);
   $name =($_GET["name"]);
   //echo ($_GET["age"]);
   $age = $_GET["age"];
   //echo ($_GET["number"]);
   $number = $_GET["number"];
   echo "<table>";
   echo "<tr>
         <td>Name</td>";


   /* FOR MAC: http://localhost:8888/index.php?age=22&names=Obi+Wan+Kenobi&number=5435432156 */
   // This will led to "No Query String date Found for name" //
   if($name == "")
      echo "<td>No query string data found.</td>";
   else
         echo"<td>$name</td>";
   echo "</tr>";

   echo "<tr>
         <td>Age</td>";
   if($age == "")
      echo "<td>No query string data found.</td>";
   else
         echo"<td>$age</td>";
   echo "</tr>";

   echo "<tr>
         <td>Number</td>";
   if($number == "")
      echo "<td>No query string data found.</td>";
   else
         echo"<td>$number</td>";
   echo "</tr>";

   echo "</table>";

?>
</body>
</html>
