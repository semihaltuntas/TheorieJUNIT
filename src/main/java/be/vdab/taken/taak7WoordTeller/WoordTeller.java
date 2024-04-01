package be.vdab.taken.taak7WoordTeller;

import java.util.StringTokenizer;

public class WoordTeller {
    public int telWoorden(String zin) {
        if (zin != null) {
            return new StringTokenizer(zin, " ,").countTokens();
//              zin.split("[,\\s]+").length;
        } else {
            throw new IllegalArgumentException("zin is null");
        }


//        int aantalWoorden = 0;
//        int index = 0;
//        while (index != zin.length()) {
//            while (index != zin.length() &&
//                    (zin.charAt(index) == ' ' || zin.charAt(index) == ',')) {
//                index++;
//            }
//            if (index != zin.length()) {
//                aantalWoorden++;
//                while (index != zin.length() &&
//                        zin.charAt(index) != ' ' && zin.charAt(index) != ',') {
//                    index++;
//                }
//            }
//        }
//        return aantalWoorden;
//    }
    }
}
