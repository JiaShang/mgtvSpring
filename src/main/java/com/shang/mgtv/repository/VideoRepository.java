package com.shang.mgtv.repository;

import com.shang.mgtv.bean.Video;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
public interface VideoRepository extends JpaRepository<Video, Long> {
}
