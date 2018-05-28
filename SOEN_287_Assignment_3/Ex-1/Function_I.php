<!DOCTYPE html>
<html>
<head>
    <title> PHP Functions I </title>
    <meta charset = "utf-8" />
</head>
<body>
   <?php

	function averageTemp($arr)
	{
		$total = 0.0;
		$num_temp = count($arr);
		$low_temp1 = '';
		$low_temp2 = '';
		$low_temp3 = '';
		$low_temp4 = '';

		$high_temp1 = '';
		$high_temp2 = '';
		$high_temp3 = '';
		$high_temp4 = '';

		sort($arr);

		//print_r($arr);

		$low_temp1 = $arr[0];
		$low_temp2 = $arr[1];
		$low_temp3 = $arr[2];
		$low_temp4 = $arr[3];


		$high_temp4= end($arr);
		$high_temp3= prev($arr);
		$high_temp2= prev($arr);
		$high_temp1= prev($arr);

		for($i = 0; $i < count($arr); $i++)
		{
			$total = $total + $arr[$i];
		}

		print("Average Temperature is: ");
		print($total/$num_temp);
		print "</br>";

		print("List of four lowest temperatures: ");
		print($low_temp1.", ".$low_temp2.", ".$low_temp3.", ".$low_temp4);
		print("</br>");
		print("List of four highest temperatures: ");
		print($high_temp1.", ".$high_temp2.", ".$high_temp3.", ".$high_temp4);
	}

	$arr1 = array(78,60,62,68,71,-17,52, 68,
				  73, 85, 66,64, 76, 63, 75,
				  76, 73, 68, 62, 73,-10, 72,
				  65, 80, 74,62, 62, 65, 64, 0,
				  68, 73,75, 79, 73,77);
	print("<h3>Find Average Tempature</h3>");
	averageTemp($arr1);
   ?>
</body>
</html>
