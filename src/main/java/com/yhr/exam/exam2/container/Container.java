package com.yhr.exam.exam2.container;

import com.yhr.exam.exam2.http.controller.AdmHomeController;
import com.yhr.exam.exam2.http.controller.Controller;
import com.yhr.exam.exam2.http.controller.UsrArticleController;
import com.yhr.exam.exam2.http.controller.UsrHomeController;
import com.yhr.exam.exam2.http.controller.UsrMemberController;
import com.yhr.exam.exam2.interceptor.BeforeActionInterceptor;
import com.yhr.exam.exam2.interceptor.NeedAdminInterceptor;
import com.yhr.exam.exam2.interceptor.NeedLoginInterceptor;
import com.yhr.exam.exam2.interceptor.NeedLogoutInterceptor;
import com.yhr.exam.exam2.repository.ArticleRepository;
import com.yhr.exam.exam2.repository.BoardRepository;
import com.yhr.exam.exam2.repository.MemberRepository;
import com.yhr.exam.exam2.service.ArticleService;
import com.yhr.exam.exam2.service.BoardService;
import com.yhr.exam.exam2.service.MemberService;

public class Container {
	public static BeforeActionInterceptor beforeActionInterceptor;
	public static NeedLoginInterceptor needLoginInterceptor;
	public static NeedLogoutInterceptor needLogoutInterceptor;
	public static NeedAdminInterceptor needAdminInterceptor;

	public static ArticleRepository articleRepository;
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;

	public static MemberRepository memberRepository;
	public static MemberService memberService;
	public static UsrMemberController usrMemberController;

	public static UsrHomeController usrHomeController;

	public static BoardRepository boardRepository;
	public static BoardService boardService;
	
	public static AdmHomeController admHomeController;

	public static void init() {
		memberRepository = new MemberRepository();
		boardRepository = new BoardRepository();
		articleRepository = new ArticleRepository();
		
		memberService = new MemberService();
		boardService = new BoardService();
		articleService = new ArticleService();

		beforeActionInterceptor = new BeforeActionInterceptor();
		needLoginInterceptor = new NeedLoginInterceptor();
		needLogoutInterceptor = new NeedLogoutInterceptor();
		needAdminInterceptor = new NeedAdminInterceptor();

		usrMemberController = new UsrMemberController();
		usrArticleController = new UsrArticleController();
		usrHomeController = new UsrHomeController();
		
		admHomeController = new AdmHomeController();
	}
}
