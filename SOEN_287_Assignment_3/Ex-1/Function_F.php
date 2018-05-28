<!DOCTYPE html>
<html>
<head>
    <title> PHP Functions E </title>
    <meta charset = "utf-8" />
</head>
<body>
   <?php

	function findUniqueandSort($arr1)
	{
		//print_r($arr1);
		$unique_array = array_unique($arr1);
		sort($unique_array);
		//print_r($unique_array);

		return $unique_array;

	}

	print("<h3> Find Unique and Sort </h3>");
	$a = [1,3,2,1,3];
	print_r(findUniqueandSort($a));
   ?>
</body>
</html>
