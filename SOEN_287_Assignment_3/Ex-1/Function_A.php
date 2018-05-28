<!DOCTYPE html>
<html>
<head>
    <title> PHP Functions A </title>
    <meta charset = "utf-8" />
</head>
<body>
<?php

function computeFactorial($num1)
{
         if(preg_match("/A-Za-z/",$num1) || intval($num1) == 0)
         {
            print("Not an Integer! ");
            return false;
         }
         else if($num1 < 0)
         {
            print("Negative Integer is invalid. ");
            return false;
         }
         else {
            if($num1 == 0 || $num1 == 1)
               return 1;
            else {
               $sum = $num1 * computeFactorial($num1 - 1);
            }
   		 return $sum;
         }
}

print("<h3>Compute Factorial</h3>");
echo computeFactorial(8)."</br>";
echo computeFactorial(7.3)."</br>"; // '0' is false
echo computeFactorial(-7.3)."</br>";
echo computeFactorial("ads")."</br>";

?>
</body>
</html>
