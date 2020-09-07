package com.shang.mgtv.controller;

import com.shang.mgtv.bean.Video;
import com.shang.mgtv.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VideoController {

        @Autowired
        VideoRepository videoRepository;

        @ResponseBody
        @GetMapping("/video/{id}")
        public Optional<Video> getUser(@PathVariable("id") Long id){
            Optional<Video> video = videoRepository.findById(id);
            return video;
        }

        @GetMapping("/video")
        public Video insertUser(Video video){
            Video save = videoRepository.save(video);
            return save;
        }
}
