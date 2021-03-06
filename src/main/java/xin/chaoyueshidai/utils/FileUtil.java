package xin.chaoyueshidai.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import xin.chaoyueshidai.module.file.Files;

/**
 * 文件工具类
 * 
 * @author WeiZiDong
 *
 */
public class FileUtil {
	public static final String RESOURCE_URL = "userfiles/";
	public static String BASE_PATH = "";
	public static final String DOWNLOAD_URL = "download/";

	static {
		String basePath = System.getProperty("jetty.home");
		if (basePath == null) {
			BASE_PATH = System.getProperty("user.dir") + "/src/main/webapp/";
		} else {
			BASE_PATH = basePath + "/webapps/";
		}
	}

	/**
	 * 写文件到硬盘，返回相对路径
	 */
	public static Files writeFile(CommonsMultipartFile file) {
		try {
			Long start = System.currentTimeMillis();
			// 文件全称
			String fullName = file.getOriginalFilename();
			// 文件名UUID生成
			String fileName = UUIDUtil.get();
			// 后缀
			String ext = fullName.substring(fullName.lastIndexOf("."), fullName.length());
			// 相对路径
			String folder = RESOURCE_URL + DateUtil.dateToString(new Date(), DateUtil.PDATE2) + "/";
			// 绝对路径
			String path = BASE_PATH + folder + fileName + ext;
			// 生成目录
			File store = new File(BASE_PATH + folder);
			if (!store.exists()) {
				store.mkdirs();
			}
			store = new File(path);
			FileUtils.copyInputStreamToFile(file.getInputStream(), store);
			// 返回值
			Files f = new Files();
			f.setName(fullName.substring(0, fullName.length() - ext.length()));
			f.setUrl("/" + folder + fileName + ext);
			f.setSuffix(ext.substring(1));
			f.setTime(System.currentTimeMillis() - start);
			return f;
		} catch (IOException e) {
			throw new RuntimeException("写文件失败", e);
		}
	}

	/**
	 * 删除文件
	 */
	public static void delete(String url) {
		File file = new File(BASE_PATH + url.substring(Configs.hostname.length()));
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}

	/**
	 * 下载文件
	 */
	public static void download(HttpServletResponse response, Files file) {
		response.reset();
		response.setContentType("application/x-download");
		OutputStream out = null;
		InputStream in = null;
		try {
			String filename = URLEncoder.encode(file.getName() + "." + file.getSuffix(), "UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + filename);
			out = response.getOutputStream();
			in = FileUtils.openInputStream(new File(BASE_PATH + file.getUrl().substring(Configs.hostname.length())));
			byte[] buffer = new byte[in.available()];
			in.read(buffer);
			out.write(buffer);
			out.flush();
		} catch (Exception e) {
			throw new RuntimeException("导出失败！", e);
		} finally {
			// 使用的是org.apache.commons.io.IOUtils
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(in);
		}
	}
}
