/*
 * @(#)AppStatusTypeHandler.java $version 2014年5月24日
 *
 * Copyright 2014 51gotour.com. All rights Reserved.
 * 51gotour.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import cn.cuizuoli.weibo.enumeration.AppStatus;

/**
 * weibo
 * cn.cuizuoli.weibo.typehandler.AppStatusTypeHandler.java
 * @author cuizuoli
 * @date 2014年5月24日
 */
public class AppStatusTypeHandler extends BaseTypeHandler<AppStatus> {

	@Override
	public AppStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
		AppStatus appStatus = null;
		String s = rs.getString(columnName);
		if (StringUtils.isNotEmpty(s)) {
			appStatus = AppStatus.getObject(s);
		}
		return appStatus;
	}

	@Override
	public AppStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		AppStatus appStatus = null;
		String s = rs.getString(columnIndex);
		if (StringUtils.isNotEmpty(s)) {
			appStatus = AppStatus.getObject(s);
		}
		return appStatus;
	}

	@Override
	public AppStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		AppStatus appStatus = null;
		String s = cs.getString(columnIndex);
		if (StringUtils.isNotEmpty(s)) {
			appStatus = AppStatus.getObject(s);
		}
		return appStatus;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, AppStatus parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.getCode());
	}

}
