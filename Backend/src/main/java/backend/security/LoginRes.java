package backend.security;

public class LoginRes {

  private String username;
  private String token;
  private Boolean isAdmin;
  private String email;
  private String fullName;

  public LoginRes(String username, String token, Boolean isAdmin, String email, String fullName) {
    this.username = username;
    this.token = token;
    this.isAdmin = isAdmin;
    this.email = email;
    this.fullName = fullName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Boolean getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
}
