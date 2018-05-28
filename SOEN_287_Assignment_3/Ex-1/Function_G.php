<!DOCTYPE html>
<html>
<head>
    <title> PHP Functions G </title>
    <meta charset = "utf-8" />
</head>
<body>
   <?php
	function sortHash1($arr)
	{
		asort($arr);
		//print_r($arr);
		echo "<table>
			  <tr>
			  	  <th>Name</th>
				  <th>Annual Salary</th>
			  </tr>";
		foreach ($arr as $name =>$value)
		{
			echo "<tr>";
			echo "<td>".$name."</td>";
			echo "<td>".$value."</td>";
			echo "</tr>";


		}
			echo "</table>";
	}

	print "<h3> SortHash1 </h3>";
	$arr1 = array("Jack"=>"55000",
				  "Anita" =>"30000",
				  "Ramesh"=>"40000",
				  "Sophia"=>"21000",
				  "Nastran"=>"41000",
				  "William"=>"39000",
				  "David"=>"50000");

	sortHash1($arr1);
	print("</br>");
   ?>
</body>
</html>
