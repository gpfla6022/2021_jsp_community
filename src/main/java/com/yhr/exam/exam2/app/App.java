package com.yhr.exam.exam2.app;

import java.io.File;

import com.yhr.exam.exam2.container.Container;
import com.yhr.exam.exam2.util.Ut;
import com.yhr.mysqliutil.MysqlUtil;

import lombok.Getter;

public class App {
	@Getter
	private static boolean ready = false;
	private static String smtpGmailPw;

	public static boolean isDevMode() {
		// 이 부분을 false로 바꾸면 production 모드 이다.
		return true;
	}
	
	public static void init() {
		// DB 세팅
		MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jsp_board");
		MysqlUtil.setDevMode(isDevMode());
		
		//필수적으로 로딩 되어야 하는 내용 불러오기
		smtpGmailPw = Ut.getFileContents("c://work//yhr//SmtpGmailPw.txt");
		
		// 공용 객체 세팅
		Container.init();
		
		if (smtpGmailPw != null && smtpGmailPw.trim().length() > 0) {
			ready = true;
		}
	}
	
	public static String getSmtpGmailId() {
		return "gpfla3503@gmail.com";
	}
	
	public static String getSmtpGmailPw() {
		return smtpGmailPw;
	
	}

	
}
