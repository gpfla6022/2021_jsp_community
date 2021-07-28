package com.yhr.exam.exam2.repository;

import com.yhr.exam.exam2.dto.Member;
import com.yhr.mysqliutil.MysqlUtil;
import com.yhr.mysqliutil.SecSql;

public class MemberRepository {

	public Member getMemberByLoginId(String loginId) {
		SecSql sql = new SecSql();
		sql.append("SELECT M.*");
		sql.append("FROM member AS M");
		sql.append("WHERE M.loginId = ?", loginId);
		
		return MysqlUtil.selectRow(sql, Member.class);
	}

	public Member getMemberIdByInfo(String name, String email) {
		SecSql sql = new SecSql();
		sql.append("SELECT *");
		sql.append("FROM member");
		sql.append("WHERE name = ?", name);
		sql.append("AND email = ?", email);
		
		return MysqlUtil.selectRow(sql, Member.class);
	}

	public Member getMemberIdByInfo2(String loginId, String email) {
		SecSql sql = new SecSql();
		sql.append("SELECT *");
		sql.append("FROM member");
		sql.append("WHERE loginId = ?", loginId);
		sql.append("AND email = ?", email);
		
		return MysqlUtil.selectRow(sql, Member.class);
	}


}
