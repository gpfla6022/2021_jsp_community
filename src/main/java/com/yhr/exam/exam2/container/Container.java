package com.yhr.exam.exam2.container;

import java.util.ArrayList;
import java.util.List;

import com.yhr.exam.exam2.app.App;
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
	private static List<ContainerComponent> containerComponents;
	
	public static App app;
	
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
		containerComponents = new ArrayList<>();

		// 의존성 세팅 시작
		app = addContainerComponent(new App());
		memberRepository = addContainerComponent(new MemberRepository());
		boardRepository = addContainerComponent(new BoardRepository());
		articleRepository = addContainerComponent(new ArticleRepository());

		memberService = addContainerComponent(new MemberService());
		boardService = addContainerComponent(new BoardService());
		articleService = addContainerComponent(new ArticleService());

		beforeActionInterceptor = addContainerComponent(new BeforeActionInterceptor());
		needLoginInterceptor = addContainerComponent(new NeedLoginInterceptor());
		needLogoutInterceptor = addContainerComponent(new NeedLogoutInterceptor());
		needAdminInterceptor = addContainerComponent(new NeedAdminInterceptor());

		usrMemberController = addContainerComponent(new UsrMemberController());
		usrArticleController = addContainerComponent(new UsrArticleController());
		usrHomeController = addContainerComponent(new UsrHomeController());

		admHomeController = addContainerComponent(new AdmHomeController());

		// 객체 초기화
		for(ContainerComponent containerComponent : containerComponents) {
			containerComponent.init();
		}
		
	}
		
		private static List<ContainerComponent> addContainerComponent(Object containerComponent) {
		// TODO Auto-generated method stub
		return null;
	}

		private static <T> T addContainerComponent(ContainerComponent containerComponent) {
			containerComponents.add(containerComponent);

			return (T) containerComponent;

		
		
	}
}
