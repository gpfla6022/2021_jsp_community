package com.yhr.exam.exam2.http.controller;

import com.yhr.exam.exam2.http.Rq;

public class UsrHomeController extends Controller {

	public void performAction(Rq rq) {
		switch (rq.getActionMethodName()) {
		case "main":
			actionShowMain(rq);
		default:
			rq.println("존재하지 않는 페이지 입니다.");
			break;
		}
	}

	private void actionShowMain(Rq rq) {
		rq.jsp("usr/home/main");
		
	}
}