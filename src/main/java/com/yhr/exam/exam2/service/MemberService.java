package com.yhr.exam.exam2.service;

import com.yhr.exam.exam2.container.Container;
import com.yhr.exam.exam2.dto.Member;
import com.yhr.exam.exam2.dto.ResultData;
import com.yhr.exam.exam2.repository.MemberRepository;
import com.yhr.exam.exam2.util.Ut;

public class MemberService {
	private MemberRepository memberRepository = Container.memberRepository;

	public ResultData login(String loginId, String loginPw) {
		Member member = memberRepository.getMemberByLoginId(loginId);

		if (member == null) {
			return ResultData.from("F-1", "존재하지 않는 회원의 로그인아이디 입니다.");
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return ResultData.from("F-2", "비밀번호가 일치하지 않습니다.");
		}

		return ResultData.from("S-1", "환영합니다.", "member", member);
	}

	public ResultData findId(String name, String email) {
		Member member = memberRepository.getMemberIdByInfo(name, email);
		
		if (member == null) {
			return ResultData.from("F-1", "존재하지 않는 회원의 이름입니다.");
		}
		if (member.getEmail().equals(email) == false) {
			return ResultData.from("F-2", "이메일이 일치하지 않습니다.");
		}
		
		return ResultData.from("S-1", "일치합니다.", "member", member);
	}

	public ResultData findPw(String loginId, String email) {
		Member member = memberRepository.getMemberIdByInfo2(loginId, email);
		
		if (member == null) {
			return ResultData.from("F-1", "존재하지 않는 회원의 아이디입니다.");
		}
		if (member.getEmail().equals(email) == false) {
			return ResultData.from("F-2", "이메일이 일치하지 않습니다.");
		}
		
		return ResultData.from("S-1", "일치합니다.", "member", member);
	}

	public ResultData join(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {
		
		Member oldMember = getMemberByLoginId(loginId);
		
		if(oldMember != null) {
			return ResultData.from("F-1", Ut.f("%s(은)는 이미 사용중인 아이디입니다.", loginId));
		}
		
		oldMember = getMemberByNameAndEmail(name, email);
		
		if(oldMember != null) {
			return ResultData.from("F-2", Ut.f("%s님은 이메일 주소 '%s'로 이미 가입하셨습니다.", name, email));
		}
		
		int id = memberRepository.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		return ResultData.from("S-1", "가입성공", "id", id);
		
	}

	private Member getMemberByNameAndEmail(String name, String email) {

		return memberRepository.getMemberByNameAndEmail(name, email);
	}

	private Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}

}
