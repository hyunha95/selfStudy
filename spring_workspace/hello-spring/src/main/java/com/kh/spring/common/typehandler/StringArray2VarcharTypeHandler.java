package com.kh.spring.common.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * 
 * setNonNullParameter : Vo필드 -> pstmt.setter
 * 
 * getNullableResult : rset(column name) -> Vo필드
 * getNullableResult : rset(column index) -> Vo필드
 * getNullableResult : callable statement용
 *
 */
@MappedTypes(String[].class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class StringArray2VarcharTypeHandler extends BaseTypeHandler<String[]> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType)
			throws SQLException {
		// String[] --> String --> varchar2
		ps.setString(i, String.join(",", parameter));

	}

	@Override
	public String[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String value = rs.getString(columnName); // varchar2 -> String
		return value != null ? value.split(",") : null; // String -> String[]
	}

	@Override
	public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String value = rs.getString(columnIndex); // varchar2 -> String
		return value != null ? value.split(",") : null; // String -> String[]
	}

	@Override
	public String[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String value = cs.getString(columnIndex); // varchar2 -> String
		return value != null ? value.split(",") : null; // String -> String[]
	}

}
