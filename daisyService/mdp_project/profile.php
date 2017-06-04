<?php
    include("connection.php");
    if (isset($_POST["email"]) && isset($_POST["password"])) {
        $email = $_POST["email"];
        $password = $_POST["password"];
        $sql = "SELECT * FROM user WHERE email='$email' and password='$password'";
        $result = mysqli_query($conn, $sql);
        if (mysqli_num_rows($result) > 0) {
            echo "login_success";
        }
        else{
			      echo "login_failed";
        }
    }
    else{
        echo "Data tidak lengkap";
    }

?>
