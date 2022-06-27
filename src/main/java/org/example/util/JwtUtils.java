package org.example.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.exception.AccessDeniedException;
import org.springframework.stereotype.Component;
import javax.xml.bind.DatatypeConverter;

@Component
public class JwtUtils {

    private static final String secret = "eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbElkIjoidXNlciJ9.DycFWDWSiI2tMzQ1awUD3LTuMO69CS6P8aRVSOPkdQY";
    public String generateJwt(){

        Claims claims = Jwts.claims();
        claims.put("emailId","user");

        // generate jwt using claims"emailId", "user"
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims verify(String authorization) {

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(secret))
                    .parseClaimsJws(authorization).getBody();

            return claims;
        } catch(Exception e) {
            throw new AccessDeniedException("Access Denied");
        }

    }
}
