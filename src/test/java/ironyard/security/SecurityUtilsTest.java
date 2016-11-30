package ironyard.security;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by favianalopez on 11/29/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SecurityUtilsTest {

    /**
     * generate valid token
     * @throws Exception
     */
    @Test
    public void genToken() throws Exception {
        String token = null;
        try {
            token = SecurityUtils.genToken();
            System.out.println(token);
            Assert.assertTrue(SecurityUtils.isValidKey(token));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * test fake token should not be valid
     * @throws Exception
     */

    @Test
    public void fakeToken() throws Exception {
        String token = null;
        try {
            token = SecurityUtils.genToken()+"FAKE";
            System.out.println(token);
            Assert.assertFalse(SecurityUtils.isValidKey(token));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}