<?php 
	require_once('../includes/DbOperation.php');
	$response=array();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		if(isset($_POST['username']) and isset($_POST['password']))
		{
			$db=new DbOperation();
			if($db->userLogin($_POST['username'], $_POST['password'])){
				$user=$db->getUserByUsername($_POST['username']);
				$response['error']=false;
				$response['id']=$user['id'];
				$response['email']=$user['email'];
				$response['username']=$user['username'];
			}else{
				$response['error']=true;
				$response['message']="Invalid username and password";
			}
		}else{
			$response['error']=true;
			$response['message']="Required file";
		}
	}
	echo json_encode($response);