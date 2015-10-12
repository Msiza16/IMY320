<?php

$username = "";
$password = "";
$hostname = "localhost"; 

//connection to the database
$dbhandle = mysql_connect($hostname, $username, $password) 
 or die("Unable to connect to MySQL");
echo "Connected to MySQL<br>";

//select a database to work with
$selected = mysql_select_db("imy320_db",$dbhandle) 
  or die("Could not select imy320_db");
  
  
  // check for required fields
if (isset($_POST['name']) && isset($_POST['password'])) {
 
    $name = $_POST['name'];
    $password = $_POST['password'];
  


$sql = "INSERT INTO Users (name, passwod) VALUES ('$name', '$password')";
if ($conn->query($sql) === TRUE)
{
	echo "New record created successfully";
}
else 
{
    echo "Error: " . $sql . "<br>" . $conn->error;
}


//fetch tha data from the database 
/*while ($row = mysql_fetch_array($result)) {
   echo "ID:".$row{'id'}." Name:".$row{'model'}."Year: ". //display the results
   $row{'year'}."<br>";
}

*/

//close the connection
mysql_close($dbhandle);

?>