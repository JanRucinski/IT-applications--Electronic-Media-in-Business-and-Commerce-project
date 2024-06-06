package backend.security;

import backend.model.User;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

  private final String secretKey = "mysecretkey"; // Ideally, this should be stored securely
  private final long accessTokenValidity = TimeUnit.HOURS.toMillis(1);

  private final String TOKEN_HEADER = "Authorization";
  private final String TOKEN_PREFIX = "Bearer ";

  public String createToken(User user) {
    Claims claims = Jwts.claims().setSubject(user.getEmail());
    claims.put("firstName", user.getFirstName());
    claims.put("lastName", user.getLastName());
    // Add roles if necessary
    claims.put("roles", user.getRole());

    Date now = new Date();
    Date expirationDate = new Date(now.getTime() + accessTokenValidity);

    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(now)
        .setExpiration(expirationDate)
        .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
        .compact();
  }

  private Claims parseJwtClaims(String token) {
    return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody();
  }

  public Claims resolveClaims(HttpServletRequest req) {
    try {
      String token = resolveToken(req);
      if (token != null) {
        return parseJwtClaims(token);
      }
      return null;
    } catch (ExpiredJwtException ex) {
      req.setAttribute("expired", ex.getMessage());
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token expired", ex);
    } catch (JwtException | IllegalArgumentException ex) {
      req.setAttribute("invalid", ex.getMessage());
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token", ex);
    }
  }

  public String resolveToken(HttpServletRequest request) {
    String bearerToken = request.getHeader(TOKEN_HEADER);
    if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
      return bearerToken.substring(TOKEN_PREFIX.length());
    }
    return null;
  }

  public boolean validateToken(String token, User user) {
    try {
      Claims claims = parseJwtClaims(token);
      String email = claims.getSubject();
      return email.equals(user.getEmail()) && !isTokenExpired(claims);
    } catch (JwtException | IllegalArgumentException e) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token", e);
    }
  }

  public boolean isTokenExpired(Claims claims) {
    Date expiration = claims.getExpiration();
    return expiration.before(new Date());
  }

  public String getEmail(Claims claims) {
    return claims.getSubject();
  }

  public List<String> getRoles(Claims claims) {
    return (List<String>) claims.get("roles");
  }

  public boolean validateClaims(Claims claims) {
    return !isTokenExpired(claims);
  }
}
