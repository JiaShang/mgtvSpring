package com.shang.mgtvspring.ftp;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.SocketException;

@Component
public class FtpConnect {
    private static Logger logger = LoggerFactory.getLogger(FtpConnect.class);

    // FTP 登录用户名
    @Value("${ftp.client.username}")
    private String userName = "shang";
    // FTP 登录密码
    @Value("${ftp.client.password}")
    private String pwd = "shang";
    // FTP 服务器地址IP地址
    @Value("${ftp.client.host}")
    private String host = "127.0.0.1";
    // FTP 端口
    @Value("${ftp.client.port}")
    private int port = 21;

    /**
     * 连接ftp
     *
     * @return
     * @throws Exception
     */
    public FTPClient getFTPClient() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            logger.info("地址：" + host + "-" + port);
            ftpClient.connect(host, port);// 连接FTP服务器
            logger.info("用户名：" + userName);
            ftpClient.login(userName, pwd);// 登陆FTP服务器
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                logger.info("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                logger.info("FTP连接成功。");
            }
            ftpClient.enterLocalPassiveMode();// 设置被动模式
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//设置二进制传输
        } catch (SocketException e) {
            logger.error("连接ftp失败！");
            logger.info("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            logger.error("连接ftp失败！");
            logger.info("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }

    /**
     * 关闭连接
     *
     * @param ftpClient
     */
    public void close(FTPClient ftpClient) {
        try {
            if (ftpClient != null) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            logger.error("ftp连接关闭失败！");
        }
    }

}
