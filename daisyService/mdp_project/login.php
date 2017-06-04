<?php
    include("connection.php");
    if (isset($_POST["email"]) && isset($_POST["password"])) {
        $email = $_POST["email"];
        $password = $_POST["password"];
        $sql = "SELECT * FROM user WHERE email='$email' and password='$password'";
        $result = mysqli_query($conn, $sql);

        $row = mysqli_fetch_array($result);
        $id_user = $row[0][0];

        if (mysqli_num_rows($result) > 0) {
            echo "login_success-".$id_user;
        }
        else{
			      echo "login_failed";
        }
    }
    else{
        echo "Data tidak lengkap";
    }

?>
