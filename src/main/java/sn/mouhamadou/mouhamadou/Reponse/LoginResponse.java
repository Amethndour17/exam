package sn.mouhamadou.mouhamadou.Reponse;

public class LoginResponse {
    String message;
    boolean statu;

    public LoginResponse() {
    }

    public LoginResponse(String message, boolean statu) {
        this.message = message;
        this.statu = statu;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatu() {
        return statu;
    }

    public void setStatu(boolean statu) {
        this.statu = statu;
    }
}
