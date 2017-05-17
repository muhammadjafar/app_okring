<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
	$image = $_POST['image'];
				$name = $_POST['name'];
	require_once('dbConnect.php');
	$sql ="SELECT id FROM barang ORDER BY id ASC";
	$res = mysqli_query($con,$sql);
	$id = 0;
	while($row = mysqli_fetch_array($res)){
		$id = $row['id'];
		}
		$path = "$id.png";
		$actualpath = "http://localhost/Android/upload/$path";
		$sql = "INSERT INTO barang (nama_barang,foto_barang) VALUES ('$name','$actualpath')";
		if(mysqli_query($con,$sql)){
		file_put_contents($path,base64_decode($image));
		echo "Successfully Uploaded";
	}
	mysqli_close($con);
}else{
	echo "Error";
}