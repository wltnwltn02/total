package org.itbank.app.model;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	SqlSessionTemplate sql;

	// �����ͺ��̽� ���
	public boolean addOne(Map map) {
		sql.insert("member.addBasic", map);
		sql.insert("member.addDetail", map);
		return true;
	}


	// id�� email�� �Ӱ�, pass�� ���� �����Ͱ� �ִ��� Ȯ���Ҷ�
	public int existOne(Map map) {
		return sql.selectOne("member.checkByIdmailAndPass", map);
	}

	// id�� email�� �Ӱ�, pass�� ���� �����Ͱ� �ִ��� Ȯ���Ҷ�
	public HashMap readOne(Map map) {
		return sql.selectOne("member.readOne", map);
	}
}
