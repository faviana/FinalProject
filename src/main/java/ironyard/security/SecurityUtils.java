package ironyard.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by favianalopez on 11/15/16.
 */
public class SecurityUtils {

        private static String SECRET = "ironyard";

        private static boolean keyMatches(String checkme){
            return checkme.equalsIgnoreCase(SECRET);
        }

    /**
     * generates blowfish token
     * @return base64encoder
     * @throws Throwable
     */

    public static String genToken() throws Throwable {

            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            // build my secret message
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Calendar cal = Calendar.getInstance();
            String date = dateFormat.format(cal.getTime());
            String mySecretMessage = String.format("%s:%s", date, SECRET);

            // do the encrypt message
            byte[] hasil = cipher.doFinal(mySecretMessage.getBytes());
            return new BASE64Encoder().encode(hasil);
        }

    /**
     *decrypts the blowfish token with base64decoder
     * @param decryptMe string to be decrypted
     * @return returns string decrypted
     */

    public static String decrypt(String decryptMe) {
            String decrypted = null;

            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET.getBytes(), "Blowfish");
                Cipher cipher = Cipher.getInstance("Blowfish");
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                byte[] hasil = cipher.doFinal(new BASE64Decoder().decodeBuffer(decryptMe));
                decrypted = new String(hasil);
            }catch (Throwable t){
                //ignore
            }
            return decrypted;
        }

    /**
     * verify key is valid
     * @param key string that is being validated
     * @return returns authorization
     */


    public static boolean isValidKey(String key)  {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Calendar oneYearAgo = Calendar.getInstance();
            oneYearAgo.add(Calendar.MONTH, -12);
            boolean authorized = false;
            if(key != null){
                String decrypted = null;
                try {
                    decrypted = decrypt(key);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                if(decrypted != null) {
                    StringTokenizer st = new StringTokenizer(decrypted, ":");
                    if (st.countTokens() == 2) {
                        try {
                            Date dayOfToken = dateFormat.parse(st.nextToken());
                            // must be within a year
                            authorized = dayOfToken.after(oneYearAgo.getTime());
                            // second part of token should match our key
                            authorized = authorized && SECRET.equals(st.nextToken());
                        } catch (Throwable t) {
                            t.printStackTrace();
                        }
                    }
                }
            }
            return authorized;
        }
}
