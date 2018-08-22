package com.learn.reactive_programming.comosition;

public class User {

    private final String username;
    private final String emailAddress;
    private final UserSecurityStatus securityStatus;

    public User(String username, String emailAddress, UserSecurityStatus securityStatus) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.securityStatus = securityStatus;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public UserSecurityStatus getSecurityStatus() {
        return securityStatus;
    }

    public String toJSON() {

        return "    { 'username' : \"" + username + "\", "
                + " 'emailAddress' : \"" + emailAddress + "\","
                + " 'securityStatus' : \"" + securityStatus.toString() + "\"},";
    }
}
