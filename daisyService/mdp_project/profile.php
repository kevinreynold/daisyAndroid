<?php
    include("connection.php");
    if (isset($_GET["user_id"])) {
        $id = intval($_GET["user_id"]);
        $sql = "SELECT * FROM user WHERE id_user=$id";
        $query = mysqli_query($conn, $sql);
        $row = mysqli_fetch_array($query);

        $result = array();
        $result['id_user'] =  intval($row[0]);
        $result['nama_user'] =  $row[1];
        $result['email'] =  $row[2];
        $result['password'] =  $row[3];
        $result['profile_foto_url'] =  $row[4];
        $result['status'] =  $row[5];
        $result['following'] = array();
        $result['follower'] = array();
        $result['moment'] = array();
        $result['friend_suggestion'] = array();

        //getFollowing
        $sql_following = "SELECT f.id_user2, u.nama_user FROM friend f, user u WHERE f.id_user2 = u.id_user AND f.id_user1 = $id ORDER BY u.nama_user";
        $query_following = mysqli_query($conn,$sql_following);
        $idx_following = 0;
        while($following = mysqli_fetch_array($query_following)){
          $result['following'][$idx_following]['id'] = intval($following[0]);
          $result['following'][$idx_following]['nama_user'] = $following[1];
          $idx_following = $idx_following + 1;
        }

        //getFollower
        $sql_follower = "SELECT f.id_user1, u.nama_user FROM friend f, user u WHERE f.id_user1 = u.id_user AND f.id_user2 = $id ORDER BY u.nama_user";
        $query_follower = mysqli_query($conn,$sql_follower);
        $idx_follower = 0;
        while($follower = mysqli_fetch_array($query_follower)){
          $result['follower'][$idx_follower]['id'] = intval($follower[0]);
          $result['follower'][$idx_follower]['nama_user'] = $follower[1];
          $idx_follower = $idx_follower + 1;
        }

        //getMyMoment
        $sql_moment =
          "SELECT m.id_moment, m.description, m.tanggal, m.waktu, m.media_url, m.longitude, m.latitude FROM user u, h_moment m where u.id_user = m.id_user AND u.id_user = $id ORDER BY m.tanggal DESC, m.waktu DESC";
        $query_moment = mysqli_query($conn,$sql_moment);
        $idx_moment = 0;
        while($moment = mysqli_fetch_array($query_moment)){
          $result['moment'][$idx_moment]['id'] = intval($moment[0]);
          $result['moment'][$idx_moment]['description'] = $moment[1];
          $result['moment'][$idx_moment]['tanggal'] = $moment[2];
          $result['moment'][$idx_moment]['waktu'] = $moment[3];
          $result['moment'][$idx_moment]['media_url'] = $moment[4];
          $result['moment'][$idx_moment]['longitude'] = $moment[5];
          $result['moment'][$idx_moment]['latitude'] = $moment[6];
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

          //friend_suggestion
          $sql_friend_suggestion = "SELECT u.id_user, u.nama_user FROM user u WHERE u.id_user <> $id AND u.id_user NOT IN (SELECT f.id_user2 FROM friend f, user u WHERE f.id_user2 = u.id_user AND f.id_user1 = $id)";
          $query_friend_suggestion = mysqli_query($conn, $sql_friend_suggestion);
          $idx_friend_suggestion = 0;
          while($friend_suggestion = mysqli_fetch_array($query_friend_suggestion)){
            $result['friend_suggestion'][$idx_friend_suggestion]["id"] = intval($friend_suggestion[0]);
            $result['friend_suggestion'][$idx_friend_suggestion]["nama_user"] = $friend_suggestion[1];
            $idx_friend_suggestion = $idx_friend_suggestion + 1;
          }
        }
        echo json_encode($result);
    }
    else{
        echo "Data tidak lengkap";
    }

?>
