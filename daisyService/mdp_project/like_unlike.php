<?php
    include("connection.php");
    if (isset($_POST["moment_id"]) && isset($_POST["user_id"])) {
        $moment_id = $_POST["moment_id"];
        $user_id = $_POST["user_id"];
        $sql = "SELECT * FROM d_like_moment WHERE id_moment=$moment_id and id_user=$user_id";
        $result = mysqli_query($conn, $sql);
        if (mysqli_num_rows($result) > 0) {
            //unlike
            $sql_unlike = "DELETE FROM d_like_moment WHERE id_moment=$moment_id AND id_user=$user_id  ";
            if(mysqli_query($conn, $sql_unlike))
              echo "unlike_success";
            else
              echo "unlike_failed";
        }
        else{
            //like
            $date = date('Y-m-d');
            $time = date("H:i:s");
            $sql_like = "INSERT INTO d_like_moment VALUES($moment_id,$user_id,'$date','$time')";
            if(mysqli_query($conn, $sql_like))
              echo "like_success";
            else
              echo "like_failed";
        }
    }
    else{
        echo "Data tidak lengkap";
    }

?>
