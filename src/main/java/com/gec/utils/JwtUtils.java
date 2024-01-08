package com.gec.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtils {
    static String secret="asdf564a165asdf13ab2asdfasdfasdf";
    final static long expireTime=1209600L * 1000L;
    private static Date IssueDate(){
        return new Date();
    }
    private static Date ExpireDate(Date date){
        //ms为现在的时间
        long ms = date.getTime();
        //exp为过期时间
        long exp = ms + expireTime;
        return new Date( exp );
    }

    public static String generateJWT(Map<String,Object> userInfo){
        byte[] buff=secret.getBytes();
        SecretKey secretKey = Keys.hmacShaKeyFor(buff);
        Date issueDate = IssueDate();
        Date expireDate = ExpireDate(issueDate);
        String token= Jwts.builder()
                .setClaims(userInfo)
                .setIssuedAt(issueDate)
                .setExpiration(expireDate)
                .setSubject("lie")
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
        return token;
    }
    public static Claims parseJWT(String token){
        byte[] Keys=secret.getBytes();
        Claims claims=Jwts.parser()
                .setSigningKey(Keys)
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }
    public static void checkExpire(Claims claims){
        Date expTime =claims.getExpiration();
        Date curTime=new Date();
        boolean before =expTime.before(curTime);
        if (before){
            throw new RuntimeException("你的Token已过期");
        }

    }

    public static void main(String[] args) {

    }


}
