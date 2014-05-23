/*
 * @(#)AbstractTest.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * weibo
 * cn.cuizuoli.weibo.test.AbstractTest.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:context-datasource.xml",
	"classpath:context-mybatis.xml",
	"classpath:context-service.xml",
	"classpath:context-task.xml"})
@TransactionConfiguration
@Transactional
public abstract class AbstractTest {
}
