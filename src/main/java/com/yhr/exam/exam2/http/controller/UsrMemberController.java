package com.yhr.exam.exam2.http.controller;

import com.yhr.exam.exam2.container.Container;
import com.yhr.exam.exam2.dto.Member;
import com.yhr.exam.exam2.dto.ResultData;
import com.yhr.exam.exam2.http.Rq;
import com.yhr.exam.exam2.service.MemberService;
import com.yhr.exam.exam2.util.Ut;

public class UsrMemberController extends Controller {
	private MemberService memberService = Container.memberService;

	@Override
	public void performAction(Rq rq) {
		switch (rq.getActionMethodName()) {
		case "login":
			actionShowLogin(rq);
			break;
		case "doLogin":
			actionDoLogin(rq);
			break;
		case "doLogout":
			actionDoLogout(rq);
			break;
		case "join":
			actionShowJoin(rq);
			break;
		case "findId":
			actionShowFindId(rq);
			break;
		case "doFindId":
			actionDoFindId(rq);
			break;
		case "findPw":
			actionShowFindPw(rq);
			break;
		case "doFindPw":
			actionDoFindPw(rq);
			break;
		default:
			rq.println("존재하지 않는 페이지 입니다.");
			break;
		}
	}

	private void actionDoFindPw(Rq rq) {
		String loginId = rq.getParam("loginId", "");
		String email = rq.getParam("email", "");

		if (loginId.length() == 0) {
			rq.historyBack("이름을 입력해주세요.");
			return;
		}

		if (email.length() == 0) {
			rq.historyBack("이메일을 입력해주세요.");
			return;
		}

		ResultData findPwRd = memberService.findPw(loginId, email);

		if (findPwRd.isFail()) {
			rq.historyBack(findPwRd.getMsg());
			return;
		}

		Member member = (Member) findPwRd.getBody().get("member");

		String memPw = member.getLoginId();

		rq.replace("비밀번호는 " + memPw + "입니다. 잊어버리지 마세요", "../home/main");


	}

	private void actionShowFindPw(Rq rq) {
		rq.jsp("usr/member/findPw");
		
	}

	private void actionDoFindId(Rq rq) {
		String name = rq.getParam("name", "");
		String email = rq.getParam("email", "");

		if (name.length() == 0) {
			rq.historyBack("이름을 입력해주세요.");
			return;
		}

		if (email.length() == 0) {
			rq.historyBack("이메일을 입력해주세요.");
			return;
		}

		ResultData findIdRd = memberService.findId(name, email);

		if (findIdRd.isFail()) {
			rq.historyBack(findIdRd.getMsg());
			return;
		}

		Member member = (Member) findIdRd.getBody().get("member");

		String memId = member.getLoginId();

		rq.replace("아이디는 " + memId + "입니다. 잊어버리지 마세요", "../home/main");

	}

	private void actionShowFindId(Rq rq) {
		rq.jsp("usr/member/findId");

	}

	private void actionDoLogout(Rq rq) {
		rq.removeSessionAttr("loginedMemberJson");
		rq.replace(null, "../../");
	}

	private void actionDoLogin(Rq rq) {
		String loginId = rq.getParam("loginId", "");
		String loginPw = rq.getParam("loginPw", "");

		if (loginId.length() == 0) {
			rq.historyBack("loginId를 입력해주세요.");
			return;
		}

		if (loginPw.length() == 0) {
			rq.historyBack("loginPw를 입력해주세요.");
			return;
		}

		ResultData loginRd = memberService.login(loginId, loginPw);

		if (loginRd.isFail()) {
			rq.historyBack(loginRd.getMsg());
			return;
		}

		Member member = (Member) loginRd.getBody().get("member");

		rq.setSessionAttr("loginedMemberJson", Ut.toJson(member, ""));

		String redirectUri = rq.getParam("redirectUri", "../article/list");

		rq.replace(loginRd.getMsg(), redirectUri);
	}

	private void actionShowLogin(Rq rq) {
		rq.jsp("usr/member/login");
	}

	private void actionShowJoin(Rq rq) {
		rq.jsp("usr/member/join");
	}
}
