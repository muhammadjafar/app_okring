<?php
 $con=mysqli_connect("localhost","root","", "androiddb");
 
 $sql = "select nama_catering, foto_catering from penjual";
 
 $res = mysqli_query($con,$sql);
 
 $result = array();
 
 while($row = mysqli_fetch_array($res)){
 array_push($result,array("name"=>$row['nama_catering'], "image"=>$row['foto_catering']));
 }
 
 echo json_encode(array("result"=>$result));

 mysqli_close($con);
