package com.shang.mgtvspring;

import com.shang.mgtvspring.xml.ReadXml;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MgtvspringApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(MgtvspringApplication.class, args);
        ReadXml xml = new ReadXml();
        String msg = xml.getPath();
        System.out.println(msg);
//        FtpTestController ftpTestController = new FtpTestController();
//        ftpTestController.FtpTest(HttpServletResponse response);
//        String dir = ftpOperation.getCURRENT_DIR();
//        System.out.println(dir);
    }

}
