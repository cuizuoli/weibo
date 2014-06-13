/*
 * @(#)AppTestStatusTypeHandler.java $version 2014年6月12日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import cn.cuizuoli.weibo.enumeration.AppTestStatus;

/**
 * weibo
 * cn.cuizuoli.weibo.typehandler.AppTestStatusTypeHandler.java
 * @author cuizuoli
 * @date 2014年6月12日
 */
public class AppTestStatusTypeHandler extends BaseTypeHandler<AppTestStatus> {

	@Override
	public AppTestStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
		AppTestStatus appTestStatus = null;
		String s = rs.getString(columnName);
		if (StringUtils.isNotEmpty(s)) {
			appTestStatus = AppTestStatus.getObject(s);
		}
		return appTestStatus;
	}

	@Override
	public AppTestStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		AppTestStatus appTestStatus = null;
		String s = rs.getString(columnIndex);
		if (StringUtils.isNotEmpty(s)) {
			appTestStatus = AppTestStatus.getObject(s);
		}
		return appTestStatus;
	}

	@Override
	public AppTestStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		AppTestStatus appTestStatus = null;
		String s = cs.getString(columnIndex);
		if (StringUtils.isNotEmpty(s)) {
			appTestStatus = AppTestStatus.getObject(s);
		}
		return appTestStatus;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, AppTestStatus parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.getCode());
	}

}
