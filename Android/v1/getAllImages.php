<?php
 $con=mysqli_connect("localhost","root","", "androiddb");
 
 $sql = "select foto_barang from barang";
 
 $res = mysqli_query($con,$sql);
 
 $result = array();
 
 while($row = mysqli_fetch_array($res)){
 array_push($result,array('url'=>$row['foto_barang']));
 }
 
 echo json_encode(array("result"=>$result));
 
 mysqli_close($con);
