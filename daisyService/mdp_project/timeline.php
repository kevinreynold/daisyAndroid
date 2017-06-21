<?php
    include("connection.php");
    if (isset($_GET["user_id"])) {
        $id = intval($_GET["user_id"]);

        $users = array();
        $users[] = $id;

        $sql_following = "SELECT f.id_user2, u.nama_user FROM friend f, user u WHERE f.id_user2 = u.id_user AND f.id_user1 = $id ORDER BY u.nama_user";
        $query_following = mysqli_query($conn,$sql_following);
        $idx_following = 1;
        while($row = mysqli_fetch_array($query_following)){
          $users[$idx_following++] = intval($row[0]);
        }
        $user_array = implode(",", $users);

        $result = array();
        $result['moment'] = array();

        //getMyMoment
        $sql_moment =
          "SELECT m.id_moment, m.description, m.tanggal, m.waktu, m.like_count, m.comment_count, m.media_url, m.longitude, m.latitude, u.nama_user FROM user u, h_moment m where u.id_user = m.id_user AND u.id_user IN ($user_array) ORDER BY m.tanggal DESC, m.waktu DESC";
        $query_moment = mysqli_query($conn,$sql_moment);
        $idx_moment = 0;
        while($moment = mysqli_fetch_array($query_moment)){
          $result['moment'][$idx_moment]['id'] = intval($moment[0]);
          $result['moment'][$idx_moment]['nama_user'] = $moment[9];
          $result['moment'][$idx_moment]['description'] = $moment[1];
          $result['moment'][$idx_moment]['tanggal'] = $moment[2];
          $result['moment'][$idx_moment]['waktu'] = $moment[3];
          $result['moment'][$idx_moment]['like_count'] = $moment[4];
          $result['moment'][$idx_moment]['comment_count'] = $moment[5];
          $result['moment'][$idx_moment]['media_url'] = $moment[6];
          $result['moment'][$idx_moment]['longitude'] = $moment[7];
          $result['moment'][$idx_moment]['latitude'] = $moment[8];
          $result['moment'][$idx_moment]['comment'] = array();
          $result['moment'][$idx_moment]['like'] = array();

          //comment
          $sql_comment = "SELECT c.id_comment, c.tanggal, c.waktu, c.message, u.nama_user FROM user u, h_moment m, h_comment c WHERE u.id_user = m.id_user AND m.id_moment = c.id_moment AND m.id_moment = $moment[0] ORDER BY c.tanggal DESC, c.waktu DESC";
          $query_comment = mysqli_query($conn,$sql_comment);
          $idx_comment = 0;
          while($comment = mysqli_fetch_array($query_comment)){
              $result['moment'][$idx_moment]['comment'][$idx_comment]['id'] = intval($comment[0]);
              $result['moment'][$idx_moment]['comment'][$idx_comment]['tanggal'] = $comment[1];
              $result['moment'][$idx_moment]['comment'][$idx_comment]['waktu'] = $comment[2];
              $result['moment'][$idx_moment]['comment'][$idx_comment]['message'] = $comment[3];
              $result['moment'][$idx_moment]['comment'][$idx_comment]['nama_user'] = $comment[4];
              $idx_comment = $idx_comment + 1;
          }

          //like
          $sql_like = "SELECT u.id_user, u.nama_user, l.tanggal, l.waktu FROM user u, h_moment m, d_like_moment l WHERE u.id_user = l.id_user AND m.id_moment = l.id_moment AND m.id_moment = $moment[0] ORDER BY l.tanggal DESC, l.waktu DESC";
          $query_like = mysqli_query($conn,$sql_like);
          $idx_like = 0;
          while($like = mysqli_fetch_array($query_like)){
              $result['moment'][$idx_moment]['like'][$idx_like]['id'] = intval($like[0]);
              $result['moment'][$idx_moment]['like'][$idx_like]['nama'] = $like[1];
              $result['moment'][$idx_moment]['like'][$idx_like]['tanggal'] = $like[2];
              $result['moment'][$idx_moment]['like'][$idx_like]['waktu'] = $like[3];
              $idx_like = $idx_like + 1;
          }
          $idx_moment = $idx_moment + 1;
        }
        echo json_encode($result);
    }
    else{
        echo "Data tidak lengkap";
    }

?>
