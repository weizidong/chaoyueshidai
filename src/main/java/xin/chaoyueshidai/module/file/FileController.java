package xin.chaoyueshidai.module.file;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import xin.chaoyueshidai.utils.FileUtil;

// 文件处理请求
@Controller
@RequestMapping("/rest/file")
public class FileController {
	@Resource
	private FileService fileService;

	// 上传文件
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public Files find(@RequestParam("file") CommonsMultipartFile file) {
		Files f = FileUtil.writeFile(file);
		fileService.save(f);
		return f;
	}
}
