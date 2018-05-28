<!DOCTYPE html>
<html>
<head>
    <title> PHP Functions D </title>
    <meta charset = "utf-8" />
</head>
<body>
   <?php
	function splitCapitalizeSort($str1)
	{
		$str_to_fix = explode(' ',$str1);
		$temp_str = $str_to_fix;

		for($i = 0; $i < count($str_to_fix); $i++)
		{
			$to_upper = substr($temp_str[$i],0,1);
			$to_lower = substr($temp_str[$i],1);

			$to_upper = strtoupper($to_upper);
			if($to_lower == '')
				echo ""; //Do Nothing
			else
			{
				$to_lower = strtolower($to_lower);
			}

			$temp_str[$i] = $to_upper.$to_lower;
		}

		// To sort //
		sort($temp_str);

		//print($temp_str);
		// Put it back together //
		$temp_str = implode(' ',$temp_str);
		return $temp_str;

	}

   print("<h3> Split and Capitalize Sort </h3>");
	echo(splitCapitalizeSort("i me lIkE pHP liKe pHP"));
   ?>
</body>
</html>
