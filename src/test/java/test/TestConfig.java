package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import xin.chaoyueshidai.utils.Configs;

public class TestConfig {
	private static Logger logger = LogManager.getLogger(TestConfig.class);

	@Test
	public void test1() {
		logger.debug(Configs.Appid);
	}
}