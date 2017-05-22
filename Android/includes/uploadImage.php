<?php
$con = mysqli_connect("localhost", "root", "","androiddb") or die('unable to connect to db');
if($_SERVER['REQUEST_METHOD']=='POST'){
	$image = $_POST['image'];
	$name = $_POST['name'];
	$deskripsi = $_POST['deskripsi'];
	$sql ="SELECT id FROM barang ORDER BY id ASC";
	$res = mysqli_query($con,$sql);
	$id = 0;
	while($row = mysqli_fetch_array($res)){
		$id = $row['id'];
		}
		$path = "upload/$id.png";
		$actualpath = "http://localhost/Android/includes/$path";
		$sql = "INSERT INTO barang (nama_barang,foto_barang, deskripsi_barang) VALUES ('$name','$actualpath', '$deskripsi')";
		if(mysqli_query($con,$sql)){
		file_put_contents($path,base64_decode($image));
		echo "Successfully Uploaded";
		}
	mysqli_close($con);
}else{
	echo "Error";
}