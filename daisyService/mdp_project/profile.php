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
        $idx = 0;
        while($moment = mysqli_fetch_array($query)){
          $result['moment'][$idx]['id'] = $moment[0];
          $result['moment'][$idx]['description'] = $moment[1];
          $result['moment'][$idx]['tanggal'] = $moment[2];
          $result['moment'][$idx]['waktu'] = $moment[3];
          $result['moment'][$idx]['like_count'] = $moment[4];
          $result['moment'][$idx]['comment_count'] = $moment[5];
          $result['moment'][$idx]['media_url'] = $moment[6];
          $result['moment'][$idx]['longitude'] = $moment[7];
          $result['moment'][$idx]['latitude'] = $moment[8];
          $result['moment'][$idx]['comment'] = array();
          $result['moment'][$idx]['like'] = array();

          //comment
          $sql_comment = "SELECT c.id_comment, c.tanggal, c.waktu, c.message, u.nama_user FROM user u, h_moment m, h_comment c WHERE u.id_user = m.id_user AND m.id_moment = c.id_moment AND m.id_moment = $moment[0] ORDER BY c.tanggal DESC, c.waktu DESC";
          $query_comment = mysqli_query($conn,$sql_comment);
          $idx_comment = 0;
          while($comment = mysqli_fetch_array($query_comment)){
              $result['moment'][$idx]['comment'][$idx_comment]['id'] = $comment[0];
              $result['moment'][$idx]['comment'][$idx_comment]['tanggal'] = $comment[1];
              $result['moment'][$idx]['comment'][$idx_comment]['waktu'] = $comment[2];
              $result['moment'][$idx]['comment'][$idx_comment]['message'] = $comment[3];
              $result['moment'][$idx]['comment'][$idx_comment]['nama_user'] = $comment[4];
              $idx_comment = $idx_comment + 1;
          }

          //like
          $sql_like = "SELECT u.id_user, u.nama_user, l.tanggal, l.waktu FROM user u, h_moment m, d_like_moment l WHERE u.id_user = m.id_user AND m.id_moment = l.id_moment AND m.id_moment = $moment[0] ORDER BY l.tanggal DESC, l.waktu DESC";
          $query_like = mysqli_query($conn,$sql_like);
          $idx_like = 0;
          while($like = mysqli_fetch_array($query_like)){
              $result['moment'][$idx]['like'][$idx_like]['id'] = $like[0];
              $result['moment'][$idx]['like'][$idx_like]['nama'] = $like[1];
              $result['moment'][$idx]['like'][$idx_like]['tanggal'] = $like[2];
              $result['moment'][$idx]['like'][$idx_like]['waktu'] = $like[3];
              $idx_like = $idx_like + 1;
          }
          $idx = $idx + 1;
        }
        echo json_encode($result);
    }
    else{
        echo "Data tidak lengkap";
    }

?>
