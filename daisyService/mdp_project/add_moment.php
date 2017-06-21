<?php
    include("connection.php");
    if (isset($_POST["user_id"]) && isset($_POST["desc"])) {
        $user_id = $_POST["user_id"];
        $desc = $_POST["desc"];
        $date = date('Y-m-d');
        $time = date("H:i:s");
        $media_url = (empty($_POST["media_url"]))? "NULL" : "'".$_POST["media_url"]."'";
        $longitude = (empty($_POST["longitude"]))? "NULL" : "'".$_POST["longitude"]."'";
        $latitude = (empty($_POST["latitude"]))? "NULL" : "'".$_POST["latitude"]."'";
        $sql_add_moment = "INSERT INTO h_moment VALUES('','$desc','$date','$time',$user_id,".$media_url.",".$longitude.",".$latitude.")";
        echo $sql_add_moment;
        if (mysqli_query($conn, $sql_add_moment)) {
            echo "add_moment_success";
        }
        else {
            echo "add_moment_failed";
        }
    }
    else{
        echo "Data tidak lengkap";
    }

?>
