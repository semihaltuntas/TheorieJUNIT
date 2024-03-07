package be.vdab.taken.taak2Rechthoek;

import java.util.Objects;

public class Rechthoek {
    private final int lengte;
    private final int breedte;

    public Rechthoek(int lengte, int breedte) {
        if (lengte<0 || breedte < 0 || lengte < breedte){
            throw new IllegalArgumentException(
                    "Lengte en Breedte mag niet kleiner dan 0 en " +
                            "lengte kan niet kleiner dan breedte zijn!");
        }
        this.lengte = lengte;
        this.breedte = breedte;
    }

    public int getOppervlakte(){
        return lengte * breedte;
    }
    public int getOmtrek(){
        return (lengte + breedte) * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rechthoek rechthoek = (Rechthoek) o;
        return lengte == rechthoek.lengte && breedte == rechthoek.breedte;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lengte, breedte);
    }
}
