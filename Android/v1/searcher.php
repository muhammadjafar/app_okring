<?php
	$db=mysqli_connect("localhost","root", "", "androiddb") or die('Connect error');
	if(mysqli_connect_errno($db)){
		echo "failed to connnect";
	}
	$name=$_POST['query'];
	$sql="select username from user where username like '%$name%'";
	$query=mysqli_query($db, $sql);
	if($query){
		while($row=mysqli_fetch_array($query)){
			$data[]=$row;
		}
		print(json_encode($data));
	}else{
		echo "not found";
	}
	mysqli_close($db);
	
?>