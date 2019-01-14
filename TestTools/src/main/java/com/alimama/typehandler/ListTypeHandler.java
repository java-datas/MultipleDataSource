package com.alimama.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 自定义TypeHandler
 *
 * List -> "element1,element2,element3"
 * "element1,element2,element3" -> List
 * 如果数据库中的列为null， 则返回的List字段也为null。
 */
public class ListTypeHandler extends BaseTypeHandler<List> {
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, StringTool.getStringByList(parameter));
	}

	@Override
	public List getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String s = rs.getString(columnName);
		return StringTool.getStringListByStr(s);
	}

	@Override
	public List getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String s = rs.getString(columnIndex);
		return StringTool.getStringListByStr(s);
	}

	@Override
	public List getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String s = cs.getString(columnIndex);
		return StringTool.getStringListByStr(s);
	}
}
