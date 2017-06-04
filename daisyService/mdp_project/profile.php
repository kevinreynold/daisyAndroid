<?php
    include("connection.php");
    if (isset($_GET["userid"])) {
        $id = intval($_GET["userid"]);
        $sql = "SELECT * FROM user WHERE id_user=$id";
        $query = mysqli_query($conn, $sql);
        $row = mysqli_fetch_array($query);

        $result = array();
        $result['id_user'] =  $row[0];
        $result['nama_user'] =  $row[1];
        $result['email'] =  $row[2];
        $result['password'] =  $row[3];
        $result['profile_foto_url'] =  $row[4];
        $result['status'] =  $row[5];

        $result['moment'] = array();
        //getMyMoment
        $sql_moment =
          "SELECT m.id_moment, m.description, m.tanggal, m.waktu, m.like_count, m.comment_count, m.media_url, m.longitude, m.latitude FROM user u, h_moment m where u.id_user = m.id_user AND u.id_user = $id ORDER BY m.tanggal DESC, m.waktu DESC";
        $query = mysqli_query($conn,$sql_moment);
        while($moment = mysqli_fetch_array($query)){
          $result['moment'][]['id'] = $moment[0];
          $result['moment'][]['description'] = $moment[1];
          $result['moment'][]['tanggal'] = $moment[2];
          $result['moment'][]['waktu'] = $moment[3];
          $result['moment'][]['like_count'] = $moment[4];
          $result['moment'][]['comment_count'] = $moment[5];
          $result['moment'][]['media_url'] = $moment[6];
          $result['moment'][]['longitude'] = $moment[7];
          $result['moment'][]['latitude'] = $moment[8];
          $result['moment'][]['comment'] = array();
          $result['moment'][]['like'] = array();

          //comment
          $sql_comment = "SELECT c.id_comment, c.tanggal, c.waktu, c.message, u.nama_user FROM user u, h_moment m, h_comment c WHERE u.id_user = m.id_user AND m.id_moment = c.id_moment AND m.id_moment = $moment[0] ORDER BY c.tanggal DESC, c.waktu DESC";
          $query = mysqli_query($conn,$sql_comment);
          while($comment = mysqli_fetch_array($query)){
              $result['moment']['comment'][]['id'] = $comment[0];
              $result['moment']['comment'][]['tanggal'] = $comment[1];
              $result['moment']['comment'][]['waktu'] = $comment[2];
              $result['moment']['comment'][]['message'] = $comment[3];
              $result['moment']['comment'][]['nama_user'] = $comment[4];
          }

          //like
          $sql_like = "SELECT u.nama_user, l.tanggal, l.waktu FROM user u, h_moment m, d_like_moment l WHERE u.id_user = m.id_user AND m.id_moment = l.id_moment AND m.id_moment = $moment[0] ORDER BY l.tanggal DESC, l.waktu DESC";
          $query = mysqli_query($conn,$sql_like);
          while($like = mysqli_fetch_array($query)){
              $result['moment']['like'][]['id'] = $like[0];
              $result['moment']['like'][]['tanggal'] = $like[1];
              $result['moment']['like'][]['waktu'] = $like[2];
          }
        }
        echo json_encode($result);
    }
    else{
        echo "Data tidak lengkap";
    }

?>
