<?php
    include("connection.php");
    if (isset($_POST["nama_user"]) && isset($_POST["email"]) && isset($_POST["password"])) {
        $username = $_POST["nama_user"];
        $email = $_POST["email"];
        $password = $_POST["password"];
        $sql = "SELECT * FROM user WHERE email='$email'";
        $result = mysqli_query($conn, $sql);
        if (mysqli_num_rows($result) > 0) {
            echo "email_taken";
        }
        else{
            $sql_insert = "INSERT INTO user VALUES('','$username','$email','$password','default','1')";
            if (mysqli_query($conn, $sql_insert) == true) {
                echo "register_success";
            }
            else {
                echo "register_failed";
            }
        }
    }
    else{
        echo "Data tidak lengkap";
    }

?>
