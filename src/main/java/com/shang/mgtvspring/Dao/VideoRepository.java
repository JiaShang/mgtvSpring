package com.shang.mgtvspring.Dao;

import com.shang.mgtvspring.table.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

//    Video findByVideoId(int vod_id);
//    Video findByVideoTitle(String title);

}
