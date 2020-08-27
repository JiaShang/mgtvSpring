package com.shang.mgtvspring.controller;

import com.shang.mgtvspring.Dao.VideoRepository;
import com.shang.mgtvspring.table.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;

@RestController
@RequestMapping("video")
public class VideosController {

    @Autowired
//    private VideoRepository videoRepository;
    private JdbcTemplate jdbcTemplate;

//    @RequestMapping("/getVideos")
//    @ResponseBody
//    public List<Video> findAll() {
//        List<Video> list = new ArrayList<Video>();
//        list = videoRepository.findAll();
//        return list;
//    }

    @RequestMapping("/getVideo/{vod_id}")
    @ResponseBody
    public Video getByVideoId(int vod_id) {
//        Video video = videoRepository.findByVideoId(vod_id);
//        return video;

        @RequestMapping("/getUsers") //访问路径：/mydb/getUsers
        public List> getDbType(){
            String sql = "select * from emp";
            List> list =  jdbcTemplate.queryForList(sql);

            for (Map map : list) {
                Set> entries = map.entrySet( );

                if(entries != null) {
                    Iterator> iterator = entries.iterator( );

                    while(iterator.hasNext( )) {
                        Entry entry =(Entry) iterator.next( );
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        System.out.println(key+":"+value);
                    }
                }
            }
            return list;
        }

        ---------------------
                本文著作权归作者所有。
        商业转载请联系作者获得授权，非商业转载请注明出处。
        来源地址：https://www.php.cn/blog/detail/774.html
        来源：php中文网(www.php.cn)
© 版权声明：转载请附上博文链接！
        }
    }

//    @RequestMapping("/getVideo/{title}")
//    @ResponseBody
//    public Video getByVideoTitle(String title) {
//        Video video = videoRepository.findByVideoTitle(title);
//        return video;
//    }

//    @RequestMapping("/modifyVideo/{vod_id}")
//    @RequestMapping("/addVideo/{vod_id}")
//    @RequestMapping("/deleteVideo/{vod_id}")

}
