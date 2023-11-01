package cstjean.mobile.ecole.travail;

import java.util.MissingFormatArgumentException;
import java.util.regex.Pattern;

public class NumeroCoursUtil {
    public static boolean estNumeroCoursValide(String num) {
        return Pattern.matches("[0-9].[0-9]",num);
    }
}
