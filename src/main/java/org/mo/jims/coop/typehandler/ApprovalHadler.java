package org.mo.jims.coop.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.mo.jims.coop.enumtype.Approval;

public class ApprovalHadler extends BaseTypeHandler<Approval> {
	
	@Override
	public Approval getNullableResult(ResultSet resultSet, String columnName)
			throws SQLException {
		return getEnum(resultSet.getString(columnName));
	}

	@Override
	public Approval getNullableResult(ResultSet resultSet, int columnIndex)
			throws SQLException {
		return getEnum(resultSet.getString(columnIndex));
	}

	@Override
	public Approval getNullableResult(CallableStatement callableStatement, int parameterIndex)
			throws SQLException {
		return getEnum(callableStatement.getString(parameterIndex));
	}

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i,
			Approval approval, JdbcType jdbcType) throws SQLException {
		preparedStatement.setString(i, approval.getIdent());
	}
	
	private Approval getEnum(String value){
		return Approval.ident(value);
	}

}
