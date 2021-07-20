<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원가입" />
<%@ include file="../part/head.jspf"%>

<section class="section section-member-join px-4">
	<div class="container mx-auto">

		<div class="card bordered shadow-lg">
			<div class="card-title">
				<a href="javascript:history.back();" class="cursor-pointer"> <i
					class="fas fa-chevron-left"></i>
				</a> <span>회원가입</span>
			</div>

			<div class="px-4 py-4">
				<script>
					let MemberLogin__submitDone = false;
					function MemberLogin__submit(form) {
						if (MemberLogin__submitDone) {
							return;
						}

						if (form.title.value.length == 0) {
							alert('제목을 입력해주세요.');
							form.title.focus();

							return;
						}

						if (form.body.value.length == 0) {
							alert('내용을 입력해주세요.');
							form.body.focus();

							return;
						}

						form.submit();
						MemberLogin__submitDone = true;
					}
				</script>
				<form action="../member/doJoin" method="POST"
					onsubmit="MemberLogin__submit(this); return false;">

					<input type="hidden" name="redirectUri"
						value="${param.afterLoginUri}" />

					<div class="form-control">
						<label class="label"> <span class="label-text">아이디</span>
						</label>
						<div>
							<input class="input input-bordered w-full" maxlength="100"
								name="loginId" type="text" placeholder="아이디를 입력해주세요." />
						</div>
					</div>

					<div class="form-control">
						<label class="label"> <span class="label-text">비밀번호</span>
						</label>
						<div>
							<input class="input input-bordered w-full" maxlength="100"
								name="loginPw" type="password" placeholder="비밀번호를 입력해주세요." />
						</div>
					</div>
					
					<div class="form-control">
						<label class="label"> <span class="label-text">이름</span>
						</label>
						<div>
							<input class="input input-bordered w-full" maxlength="100"
								name="name" type="text" placeholder="이름을 입력해주세요." />
						</div>
					</div>
					
					<div class="form-control">
						<label class="label"> <span class="label-text">별명</span>
						</label>
						<div>
							<input class="input input-bordered w-full" maxlength="100"
								name="nickname" type="text" placeholder="별명을 입력해주세요." />
						</div>
					</div>
					
					<div class="form-control">
						<label class="label"> <span class="label-text">이메일</span>
						</label>
						<div>
							<input class="input input-bordered w-full" maxlength="100"
								name="email" type="text" placeholder="이메일을 입력해주세요." />
						</div>
					</div>
					
					<div class="form-control">
						<label class="label"> <span class="label-text">전화번호</span>
						</label>
						<div>
							<input class="input input-bordered w-full" maxlength="100"
								name="cellphoneNo" type="text" placeholder="전화번호를 입력해주세요." />
						</div>
					</div>

					<div class="btns">
						<button type="submit" class="btn btn-link">회원가입</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<%@ include file="../part/foot.jspf"%>