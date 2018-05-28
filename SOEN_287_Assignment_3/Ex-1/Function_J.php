<!DOCTYPE html>
<html>
<head>
    <title> PHP Functions J </title>
    <meta charset = "utf-8" />
</head>
<body>
   <?php

   	function findatStartorEnd($str, $word)
   	{
   		if (preg_match("/^$word/",$str) || preg_match("/$word$/",$str))
   		{
   			print "true"."</br>";
   			return true;
   		}
   		else
   			print "false"."</br>";
   			return false;

   	}

   	print"<h3> Find at Start or End </h3>";
   	$str1 = "I love PHP";
   	$str2 = "I love PHP and C++";
   	$word1 = "PHP";
   	findatStartorEnd($str1,$word1);
   	findatStartorEnd($str2,$word1);
   ?>
</body>
</html>
