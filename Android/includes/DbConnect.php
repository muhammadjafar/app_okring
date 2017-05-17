<?php
class DbConnect{
	private $conn;
	function __construct(){
		
	}
	function connect(){
		include_once dirname(__FILE__).'/Constants.php';
		$this->conn=new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);
		if(mysqli_connect_errno()){
			echo "failed to connect with database".mysqli_connect_error();
		}
		return $this->conn;
	}
}