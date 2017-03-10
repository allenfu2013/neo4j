package org.allen.neo4j.utils;

import java.security.InvalidParameterException;
import java.util.Calendar;

public class IdCardUtil {

    public static int getAge(String idCard) {
        int birthYear = 0;
        if (idCard.length() == 18) {
            birthYear = Integer.parseInt(idCard.substring(6, 10));
        } else if (idCard.length() == 15) {
            birthYear = Integer.parseInt("19" + idCard.substring(6, 8));
        } else {
            throw new InvalidParameterException("'idCard' is invalid");
        }

        return Calendar.getInstance().get(Calendar.YEAR) - birthYear;
    }

    public static String getSex(String idCard) {
        int sexNum = 0;
        if (idCard.length() == 18) {
            sexNum = Integer.parseInt(idCard.substring(16, 17));
        } else if (idCard.length() == 15) {
            sexNum = Integer.parseInt(idCard.substring(14));
        } else {
            throw new InvalidParameterException("'idCard' is invalid");
        }
        return sexNum % 2 == 0 ? "Female" : "Male";
    }

    public static String getCityCode(String idCard) {
        return idCard.substring(0, 6);
    }

    public static void main(String[] args) {
        String idCard = "420115198602010092";
        System.out.println(getAge(idCard));
        System.out.println(getSex(idCard));
        System.out.println(getCityCode(idCard));
    }
}
