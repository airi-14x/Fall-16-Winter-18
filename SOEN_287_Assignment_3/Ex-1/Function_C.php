<!DOCTYPE html>
<html>
<head>
    <title> PHP Functions C </title>
    <meta charset = "utf-8" />
</head>
<body>
   <?php
   function toUppercaseFirst($str1)
{
   $str_to_fix = explode(' ',$str1);
   $temp_str = $str_to_fix;
   //print_r($str_to_fix);
   //print "</br>";

   for($i = 0; $i < count($str_to_fix); $i++)
   {
      //print $i."</br>";
      $to_upper = substr($temp_str[$i],0,1);
      $to_lower = substr($temp_str[$i],1);
      //print $to_upper."</br>".$to_lower."</br>";

      $to_upper = strtoupper($to_upper);
      if($to_lower == '')
         echo ""; //Do Nothing
      else
      {
         $to_lower = strtolower($to_lower);
      }
      //print $to_upper."</br>".$to_lower."</br>";

      $temp_str[$i] = $to_upper.$to_lower;
   }
   $temp_str = implode(' ',$temp_str);
   //print($temp_str);
   return $temp_str;

}
print("<h3> To Upper Case First </h3>");
echo(toUppercaseFirst("i lIkE pHP"));
   ?>
</body>
</html>
