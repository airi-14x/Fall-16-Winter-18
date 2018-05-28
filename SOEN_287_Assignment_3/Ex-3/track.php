<!DOCTYPE html>
<html>
<head>
    <title> Cookie Tracking </title>
    <meta charset = "utf-8" />
</head>
<body>
<?php
   date_default_timezone_set('America/New_York');
   // Hasn't been set yet //
   if(!isset($_COOKIE['counting']))
   {
      echo "Welcome! You're a new customer here.";
      $counter = 1;
      setcookie("counting", $counter);
      $last_visited_date = date('m/d/Y');
      $last_visited_time = date("h:i:sa");
      setcookie("visited_date", $last_visited_date);
      setcookie("visited_time", $last_visited_time);
   }
   else {
      echo "Hello, this is your ".$_COOKIE['counting']." time here.";
      echo "</br>Last visited at: ".$_COOKIE['visited_date']." ".$_COOKIE['visited_time'];
      $counter=++$_COOKIE['counting'];
      setcookie("counting", $counter);
      $last_visited_date = date('m/d/Y');
      $last_visited_time = date("h:i:sa");
      setcookie("visited_date", $last_visited_date);
      setcookie("visited_time", $last_visited_time);
   }


 ?>
</body>

</html>
