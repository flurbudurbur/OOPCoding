package practicum4;

import dev.flur.practicum4.Auto;
import dev.flur.practicum4.AutoHuur;
import dev.flur.practicum4.Klant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutoHuurTest {
    private AutoHuur ah;
    private Klant k;
    private Auto a;

    @BeforeEach
    public void init() {
        ah = new AutoHuur();
    }

    @Test
    public void testTotaalPrijsZonderAuto__0() {
        k = new Klant("Test Guy");
        ah.setHuurder(k);
        assertEquals(0, ah.totaalPrijs());
    }

    @Test
    public void testTotaalPrijsZonderHuuder__0() {
        a = new Auto("Test Auto", 100);
        ah.setGehuurdeAuto(a);
        assertEquals(0, ah.totaalPrijs());
    }

    @Test
    public void testTotaalPrijsMetHuurderEnAuto3Dagen__300() {
        k = new Klant("Test Guy");
        a = new Auto("Test Auto", 100);
        ah.setHuurder(k);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(3);
        assertEquals(300, ah.totaalPrijs());
    }

    @Test
    public void testTotaalPrijsMetHuurder100KortingEnAuto__0() {
        k = new Klant("Test Guy");
        a = new Auto("Test Auto", 100);
        ah.setHuurder(k);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(3);
        k.setKorting(100);
        assertEquals(0, ah.totaalPrijs());
    }

    @Test
    public void testTotaalPrijsZonderHuurderOfAuto__0() {
        assertEquals(0, ah.totaalPrijs());
    }

    @Test
    public void testToStringHuurderBekendAutoBekend() {
        k = new Klant("Test Guy");
        a = new Auto("Test Auto", 100);
        ah.setHuurder(k);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(3);
        assertEquals("  Test Auto met prijs per dag: 100.0\n" +
                "  op naam van: Test Guy (korting: 0.0%)\n" +
                "  aantal dagen: 3 en dat kost 300.0", ah.toString());
    }

    @Test
    public void testToStringHuurderBekendAutoNietBekend() {
        k = new Klant("Test Guy");
        ah.setHuurder(k);
        ah.setAantalDagen(3);
        assertEquals("  er is geen auto bekend\n" +
                "  op naam van: Test Guy (korting: 0.0%)\n" +
                "  aantal dagen: 3 en dat kost 0.0", ah.toString());
    }

    @Test
    public void testToStringHuurderNietBekendAutoNietBekend() {
        ah.setAantalDagen(3);
        assertEquals("  er is geen auto bekend\n" +
                "  er is geen huurder bekend\n" +
                "  aantal dagen: 3 en dat kost 0.0", ah.toString());
    }

    @Test
    public void testToStringHuurderNietBekendAutoBekend() {
        a = new Auto("Test Auto", 100);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(3);
        assertEquals("  Test Auto met prijs per dag: 100.0\n" +
                "  er is geen huurder bekend\n" +
                "  aantal dagen: 3 en dat kost 300.0", ah.toString());
    }

}