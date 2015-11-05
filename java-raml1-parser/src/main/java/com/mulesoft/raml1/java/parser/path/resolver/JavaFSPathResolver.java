package com.mulesoft.raml1.java.parser.path.resolver;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JavaFSPathResolver implements IJavaPathResolver {

	public String content(String path) {

		return readFile(path);
	}

	public List<String> list(String path) {
		return listFiles(path);
	}

	private List<String> listFiles(String path) {

		File dir = new File(path);
		if (!dir.isDirectory()) {
			return null;
		}
		return Arrays.asList(dir.list());
	}

	private String readFile(String path) {

		try {
			File file = new File(path);
			if (!file.exists()) {
				return null;
			}
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte[] buf = new byte[1024];

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int l = 0;
			while ((l = bis.read(buf)) >= 0) {
				bos.write(buf, 0, l);
			}

			bis.close();

			String result = new String(bos.toByteArray(), "utf-8");
			return result;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
