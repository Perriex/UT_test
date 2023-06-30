package morriex.utility;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class PasswordAuthentication {
  public boolean authenticate(String password, String token) {
    try {
      String[] parts = token.split(":");
      byte[] testHash = hashByte(password, base64Decode(parts[0]));
      byte[] hash = base64Decode(parts[1]);

      int diff = hash.length ^ testHash.length;
      for (int i = 0; i < hash.length && i < testHash.length; i++) {
        diff |= hash[i] ^ testHash[i];
      }
      return diff == 0;
    } catch (Exception e) {
      return false;
    }
  }

  public String hash(String password) {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);

    return hashSalt(password, salt);
  }

  private static String hashSalt(String password, byte[] salt) {
    try {
      return base64Encode(salt) + ":" + base64Encode(hashByte(password, salt));
    } catch (Exception e) {
      return "";
    }
  }

  private static byte[] hashByte(String password, byte[] salt) {
    try {
      KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, 24);
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

      return factory.generateSecret(spec).getEncoded();
    } catch (Exception e) {
      return new byte[0];
    }
  }

  private static String base64Encode(byte[] data) {
    return Base64.getEncoder().encodeToString(data);
  }

  private static byte[] base64Decode(String data) {
    return Base64.getDecoder().decode(data);
  }
}

