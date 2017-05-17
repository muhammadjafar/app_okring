<?php
class DbOperation{
	private $conn;
	function __construct(){
		require_once dirname(__FILE__).'/DbConnect.php';
		$db=new DbConnect();
		$this->conn=$db->connect();
	}
	public function createUser($username, $pass, $email, $telp){
		if($this->isUserExist($username, $email)){
			return 0;
		}else{
			$password=md5($pass);
			$stmt=$this->conn->prepare("insert into user values (NULL, ?, ?, ?,?);");
			$stmt->bind_param("ssss", $username, $password, $email, $telp);
			if($stmt->execute()){
				return 1;
			}else{
				return 2;
			}
		}
	}
	public function userLogin($username, $pass){
		$password=md5($pass);
		$stmt=$this->conn->prepare("select id from user where username = ? and password = ?");
		$stmt->bind_param("ss", $username, $password);
		$stmt->execute();
		$stmt->store_result();
		return $stmt->num_rows>0;
	}
	public function getUserByUsername($username){
		$stmt=$this->conn->prepare("select * from user where username=?");
		$stmt->bind_param("s", $username);
		$stmt->execute();
		return $stmt->get_result()->fetch_assoc();
	}
	private function isUserExist($username, $email){
		$stmt=$this->conn->prepare("select id from user where username=? or email=?");
		$stmt->bind_param("ss", $username, $email);
		$stmt->execute();
		$stmt->store_result();
		return $stmt->num_rows>0;
	}
}