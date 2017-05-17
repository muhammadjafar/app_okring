<?php
class detail{
public $conn;
	function __construct(){
		require_once dirname(__FILE__).'/DbConnect.php';
		$db=new DbConnect();
		$this->conn=$db->connect();
	}
}
$db=new detail();
$sql="select * from barang";
$result=mysqli_query($db->conn, $sql);
	while($row=mysqli_fetch_array($result)){
		echo json_encode($row);
	}
	
	//memanggil file koneksi
/*	$con=mysqli_connect("localhost", "root","","workshop");
	$sql="select * from mahasiswa";
	$result=mysqli_query($con,$sql);
	//menampilkan isi dari array ke dalam format json
	while($row=mysqli_fetch_object($result)){
		$json=json_encode($row);
		echo $json;
		//membuat file bernama data.json
		$fh=fopen("data.json","a");
		fwrite($fh, $json);
		//tutup file data.json
		fclose($fh);
	}*/

?>