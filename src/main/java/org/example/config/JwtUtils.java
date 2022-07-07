package org.example.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.exception.AccessDeniedException;
import org.example.model.User;
import org.springframework.stereotype.Component;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;

@Component
public class JwtUtils {

    private static final String secret = "This_is_secret";
    private static long expiryDuration = 60 * 60;

    public String generateJwt(User user){

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        // claims
        Claims claims = Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        // optional claims
        claims.put("name", user.getName());
        claims.put("emailId", user.getEmailId());

        // generate jwt using claims
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public Claims verify(String authorization) throws Exception {

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter
                            .parseBase64Binary(secret))
                    .parseClaimsJws(authorization).getBody();
            return claims;
        } catch(Exception e) {
            throw new AccessDeniedException("Access Denied");
        }

    }
}




























//    private static final String secret = "secret";
//    public String generateJwt(User user){
//
//        Claims claims = Jwts.claims();
//        claims.put("emailId","user");
//
//        // generate jwt using claims"emailId","user"
//        return Jwts.builder()
//                .setClaims(claims)
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//    public Claims verify(String Authorization) throws Exception
//            {
//        try {
//            Claims claims = Jwts.parser()
//                    .setSigningKey(DatatypeConverter.parseBase64Binary(secret))
//                    .parseClaimsJws(Authorization).getBody();
//            return claims;
//        }
//        catch(Exception e) {
//            throw new AccessDeniedException("Access Denied");
//        }
//    }
//}
