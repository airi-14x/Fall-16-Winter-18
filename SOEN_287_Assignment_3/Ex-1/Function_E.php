<!DOCTYPE html>
<html>
<head>
    <title> PHP Functions E </title>
    <meta charset = "utf-8" />
</head>
<body>
   <?php
	function dayofNextFriday()
	{
		$days_until = 0;

		$date = date('m/d/Y');

		print $date."</br>";
		print "Current Day is: ";

		// Current Day is ? //
		// " // num // ": Days until Friday //
		switch(date("l"))
		{
			// 5 //
			case "Sunday":
			echo "Sunday";
			$day_until = 5;
			break;

			// 4 //
			case "Monday":
			echo "Monday";
			$day_until = 4;
			break;

			// 3 //
			case "Tuesday":
			echo "Tuesday";
			$day_until = 3;
			break;

			// 2 //
			case "Wednesday":
			echo "Wednesday";
			$day_until = 2;
			break;

			// 1 //
			case "Thursday":
			echo "Thursday";
			$day_until = 1;
			break;

			// 7 //
			case "Friday":
			echo "Friday";
			$day_until = 7;
			break;

			// 6 //
			case "Saturday":
			echo "Saturday";
			$day_until = 6;
			break;
		}

		print "</br>";
		print "Next Friday is: ";
		return date("d/m/Y",mktime(0,0,0,date("m"),date("d")+$day_until, date("y")));
	}
   print("<h3> Day of Next Friday </h3>");
	echo dayofNextFriday();
   ?>
</body>
</html>
