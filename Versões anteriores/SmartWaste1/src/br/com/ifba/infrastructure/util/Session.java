package br.com.ifba.infrastructure.util;

public class Session {
    
    private static int recoveryCode;
    private static String userName;
    private static Long userId;
    private static String enderecoAtual;
    private static Long enderecoId;

    public static int getRecoveryCode() {
        return recoveryCode;
    }

    public static void setRecoveryCode(int recoveryCode) {
        Session.recoveryCode = recoveryCode;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Session.userName = userName;
    }

    public static String getEnderecoAtual() {
        return enderecoAtual;
    }

    public static void setEnderecoAtual(String enderecoAtual) {
        Session.enderecoAtual = enderecoAtual;
    }

    public static Long getUserId() {
        return userId;
    }

    public static void setUserId(Long userId) {
        Session.userId = userId;
    }

    public static Long getEnderecoId() {
        return enderecoId;
    }

    public static void setEnderecoId(Long enderecoId) {
        Session.enderecoId = enderecoId;
    }

    
}