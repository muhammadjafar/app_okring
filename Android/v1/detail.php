<?php
 define('HOST','localhost');
 define('USER','root');
 define('PASS','');
 define('DB','androiddb');
 
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 /*if($_SERVER['REQUEST_METHOD']=='GET'){
 $id=$_GET['id'];*/
 $sql = "SELECT * FROM user";
 $r = mysqli_query($con,$sql);
 
 $result = array();
 while($res = mysqli_fetch_array($r)){
	array_push($result,array("id"=>$res['id'],"name"=>$res['username'],"email"=>$res['email']));
 }
 echo json_encode(array("result"=>$result));
 mysqli_close($con);
 ?>