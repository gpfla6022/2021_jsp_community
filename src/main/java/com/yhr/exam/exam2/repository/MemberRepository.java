package com.yhr.exam.exam2.repository;

import com.yhr.exam.exam2.dto.Member;
import com.yhr.mysqliutil.MysqlUtil;
import com.yhr.mysqliutil.SecSql;

public class MemberRepository {

	public void init() {
		
	}

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

	public Member getMemberByNameAndEmail(String name, String email) {
		SecSql sql = new SecSql();
		sql.append("SELECT M.*");
		sql.append("FROM member AS M");
		sql.append("WHERE M.name = ?", name);
		sql.append("AND M.email = ?", email);
		sql.append("LIMIT 1");
		
		return MysqlUtil.selectRow(sql, Member.class);
	}

	public int join(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		SecSql sql = new SecSql();
		sql.append("INSERT INTO `member`");
		sql.append("SET regDate = NOW()");
		sql.append(", updateDate = NOW()");
		sql.append(", loginId = ?", loginId);
		sql.append(", loginPw = ?", loginPw);
		sql.append(", name = ?", name);
		sql.append(", nickname = ?", nickname);
		sql.append(", cellphoneNo = ?", cellphoneNo);
		sql.append(", email = ?", email);
		
		int id = MysqlUtil.insert(sql);
		
		return id;
	}



}
