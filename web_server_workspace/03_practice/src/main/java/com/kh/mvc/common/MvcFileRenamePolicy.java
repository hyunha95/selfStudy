package com.kh.mvc.common;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MvcFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originalFile) {
		File renamedFile = null;
		
		do {
			// 새파일명 생성
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS_");
			DecimalFormat df = new DecimalFormat("000");
			// 확장자명
			String originalName = originalFile.getName();
			String ext = "";
			int dot = originalName.lastIndexOf(".");
			if(dot > -1)
				ext = originalName.substring(dot);
			String newName = sdf.format(new Date()) + df.format(Math.random() * 999) + ext;
			// 생성을 시도할 새 File 객체
			renamedFile = new File(originalFile.getParent(), newName);
		} while(!createNewFile(renamedFile));
		
		System.out.println("[MvcFileRenamePolicy] parent = " + originalFile.getParent());
		System.out.println("[MvcFileRenamePolicy] renamedFile = " + renamedFile);
		return renamedFile;
	}

	/**
	 * f가 존재하지 않으면 파일생성 후 true를 리턴
	 * f가 존재하면 파일을 생성하지 않고, false를 리턴
	 * @param f
	 * @return
	 */
	private boolean createNewFile(File f) {
		try {
			return f.createNewFile();
		} catch (IOException ignored) {
			return false;
		}
	}

}
