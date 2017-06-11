<?php
    include("connection.php");
    if (isset($_POST["user_id"]) && isset($_POST["id_following"])) {
        $user_id = $_POST["user_id"];
        $id_following = $_POST["id_following"];
        $sql_insert = "INSERT INTO friend VALUES($user_id,$id_following)";
        if (mysqli_query($conn, $sql_insert)) {
            echo "follow_success";
        }
        else {
            echo "follow_failed";
        }
    }
    else{
        echo "Data tidak lengkap";
    }

?>
