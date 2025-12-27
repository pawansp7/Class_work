package util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Converter
public class DataConverter implements AttributeConverter<String, String> {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "MyNameIsPawanPtl";

    @Override
    public String convertToDatabaseColumn(String attribute) {
        try{
        if(attribute == null)
            return null;
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrepted = cipher.doFinal(attribute.getBytes());
            return Base64.getEncoder().encodeToString(encrepted);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try{
            if(dbData == null) return null;
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decoded = Base64.getDecoder().decode(dbData.getBytes());
            byte[] decryptData = cipher.doFinal(decoded);
            return new String(decryptData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
