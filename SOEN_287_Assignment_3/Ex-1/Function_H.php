<!DOCTYPE html>
<html>
<head>
    <title> PHP Functions H </title>
    <meta charset = "utf-8" />
</head>
<body>
   <?php
	function sortHash2($arr, $code)
	{
		switch($code)
		{
			case 1:
				echo "Code 1: ASC for Values</br>";
				asort($arr);
				break;
			case 2:
				echo "Code 2: ASC for Keys</br>";
				ksort($arr);
				break;
			case 3:
				echo "Code 3: DESC for Values</br>";
				arsort($arr);
				break;
			case 4:
				echo "Code 4: DESC for Keys</br>";
				krsort($arr);
				break;
			default:
				echo "Wrong Code</br>";
				echo "No Change</br>";
		}
		print_r($arr);
	}

	print "<h3> SortHash2 </h3>";
	$arr1 = array("Jack"=>"55",
				  "Anita" =>"30",
				  "Ramesh"=>"40",
				  "Sophia"=>"21",
				  "Nastran"=>"41",
				  "William"=>"39",
				  "David"=>"5");

	sortHash2($arr1, 1);
	print("</br>");
	sortHash2($arr1, 2);
	print("</br>");
	sortHash2($arr1, 3);
	print("</br>");
	sortHash2($arr1, 4);
	print("</br>");
	sortHash2($arr1, 5);
   ?>
</body>
</html>
