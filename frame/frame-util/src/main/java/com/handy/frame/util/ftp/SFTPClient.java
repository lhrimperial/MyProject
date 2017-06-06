package com.handy.frame.util.ftp;

import com.handy.frame.util.file.FileUtil;
import com.jcraft.jsch.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.*;
import java.net.SocketException;
import java.util.List;
import java.util.Properties;

/**
 * @author 龙海仁
 * @date 2016年1月22日下午4:35:21
 * @Description: SFTP工具类，封装FTPClient的文件上传、下载、删除等操作
 */
public class SFTPClient implements InitializingBean, DisposableBean {

	private Logger logger = Logger.getLogger(SFTPClient.class);

	private Session session = null;
	private Channel channel = null;
	private ChannelSftp sftp = null;

	private SFTPConfig sftpConfig;

	public void setFtpConfig(SFTPConfig sftpConfig) {
		this.sftpConfig = sftpConfig;
	}

	/**
	 * 初始化客户端并完成对服务端的连接
	 * @return
	 * @throws SocketException
	 * @throws IOException
	 */
	public boolean connect() throws SocketException, IOException {
		if (this.sftpConfig != null) {
			sftp = this.connect(sftpConfig.getHost(), sftpConfig.getPort(),
					sftpConfig.getUserName(), sftpConfig.getPassword());
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param ftpHost
	 * @param ftpPort
	 * @param ftpUserName
	 * @param ftpPassword
	 * @return
	 */
	public ChannelSftp connect(String ftpHost, int ftpPort, String ftpUserName,
			String ftpPassword) {
		try {
			JSch jsch = new JSch(); // 创建JSch对象
			session = jsch.getSession(ftpUserName, ftpHost, ftpPort); // 根据用户名，主机ip，端口获取一个Session对象
			logger.info("Session created.");
			if (ftpPassword != null) {
				session.setPassword(ftpPassword); // 设置密码
			}
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config); // 为Session对象设置properties
			session.connect(); // 通过Session建立链接
			logger.info("Session connected.");

			logger.info("Opening Channel.");
			channel = session.openChannel("sftp"); // 打开SFTP通道
			channel.connect(); // 建立SFTP通道的连接
		} catch (JSchException e) {
			e.printStackTrace();
		}
		return (ChannelSftp) channel;
	}

	/**
	 * 上传文件
	 * @param directory 上传的目录
	 * @param uploadFile 要上传的文件
	 * @param fileName
	 */
	public void upload(String directory, File uploadFile, String fileName) {
		try {
			this.sftp.cd(directory);
			this.sftp.put(new FileInputStream(uploadFile), fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param uploadFile
	 * @param fileName
	 * @author 龙海仁
	 * @date 2016年1月22日下午6:00:28
	 * @update 
	 */
	public void upload(File uploadFile, String fileName, String path) {
		try {
			FileUtil.existDri(this.sftpConfig.getPath()+path);
			this.sftp.cd(this.sftpConfig.getPath()+path);
			this.sftp.put(new FileInputStream(uploadFile), fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void upload(FileInputStream uploadFile, String fileName, String path) {
		try {
			FileUtil.existDri(this.sftpConfig.getPath()+path);
			this.sftp.cd(this.sftpConfig.getPath()+path);
			this.sftp.put(uploadFile, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void uploadFile(InputStream inputStream, String fileName, String path) {
		try {
			this.sftp.cd(this.sftpConfig.getPath()+path);
			this.sftp.put(inputStream, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 下载文件
	 * @param directory 下载目录
	 * @param downloadFile 下载的文件
	 * @param saveFile 存在本地的路径
	 */
	public void download(String directory, String downloadFile, String saveFile) {
		try {
			this.sftp.cd(directory);
			File file = new File(saveFile);
			this.sftp.get(downloadFile, new FileOutputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件
	 * @param directory 要删除文件所在目录
	 * @param deleteFile 要删除的文件
	 */
	public void delete(String directory, String deleteFile) {
		try {
			this.sftp.cd(directory);
			this.sftp.rm(deleteFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 列出目录下的文件
	 * @param directory
	 * @return
	 * @throws SftpException
	 */
	public List<File> listFiles(String directory)
			throws SftpException {
		return this.sftp.ls(directory);
	}

	/**
	 * 关闭资源
	 */
	public void close() {
		if (channel.isConnected()) {
			channel.disconnect();

		}
		if (session.isConnected()) {
			session.disconnect();
		}
	}

	public void destroy() throws Exception {
		this.close();
	}

	public void afterPropertiesSet() throws Exception {
	}

}
