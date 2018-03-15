package cn.com.ulic.op;


import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviseserviceApplicationTests {
	@Autowired
	StringEncryptor stringEncryptor;

	@Test
	public void contextLoads() {

	}

	/**数据库密码加密*/
	@Test
	public void encryptPwd() {
		String result = stringEncryptor.encrypt("35njygshIHjmdbbs");
		System.out.println(result);
	}
}
