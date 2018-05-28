<!DOCTYPE html>
<html>
<head>
    <title> PHP Functions B </title>
    <meta charset = "utf-8" />
</head>
<body>
   <?php

   function findMostFrequent($arr1)
   {
      $max_count = 0;
      $max_element = '';
      $arr2 = array();
      $count_arr = array();
      $arr1 = strtolower($arr1);

      for($i=0; $i < strlen($arr1); $i++)
      {
         // Not in the arr2: Distinct Elements //
         if(!in_array($arr1[$i],$arr2))
         {
            array_push($arr2,$arr1[$i]);
            array_push($count_arr,0);
         }
         // It is within the arr2 //
         if(in_array($arr1[$i],$arr2))
         {
            for($j = 0; $j < count($arr2); $j++)
            {
               if($arr1[$i] == $arr2[$j])
               {
                  $count_arr[$j]++;
               }
            }
         }

      }

      for($i=0; $i<count($count_arr); $i++)
      {
         if($max_count < $count_arr[$i])
         {
            $max_count = $count_arr[$i];
            $max_element = $arr2[$i];
         }

      }

      echo "Most Frequent Element: ",$max_element;
      echo " </br>";
      echo "Frequency of Repetition: ",$max_count;
      echo " </br>";
   }
   print("<h3>Compute Most Frequent</h3>");
   findMostFrequent("daddel");
   findMostFrequent("daddwddel");
   findMostFrequent("Hello");
   ?>
</body>
</html>
