<?php
    include("connection.php");
    if (isset($_POST["moment_id"]) && isset($_POST["user_id"]) && isset($_POST["message"])) {
        $moment_id = $_POST["moment_id"];
        $user_id = $_POST["user_id"];
        $message = $_POST["message"];
        $date = date('Y-m-d');
        $time = date("H:i:s");
        $sql_add_comment = "INSERT INTO h_comment VALUES('','$date','$time','$message',$moment_id,$user_id)";
        if (mysqli_query($conn, $sql_add_comment)){
            echo "add_comment_success";
        }
        else {
            echo "add_comment_failed";
        }
    }
    else{
        echo "Data tidak lengkap";
    }

?>
