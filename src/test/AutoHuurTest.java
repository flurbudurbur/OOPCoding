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
    public void testSetAndGetAantalDagen() {
        ah.setAantalDagen(5);
        assertEquals(5, ah.getAantalDagen());
    }

    @Test
    public void testSetAndGetGehuurdeAuto() {
        a = new Auto("Test Car", 100.0);
        ah.setGehuurdeAuto(a);
        assertEquals(a, ah.getGehuurdeAuto());
    }

    @Test
    public void testSetAndGetHuurder() {
        k = new Klant("Test Guy");
        ah.setHuurder(k);
        assertEquals(k, ah.getHuurder());
    }

    @Test
    public void testTotaalPrijsWithNoCar() {
        k = new Klant("Test Guy");
        ah.setHuurder(k);
        assertEquals(0.0, ah.totaalPrijs());
    }

    @Test
    public void testTotaalPrijsWithNoHuurder() {
        a = new Auto("Test Car", 100.0);
        ah.setGehuurdeAuto(a);
        assertEquals(0.0, ah.totaalPrijs());
    }

    @Test
    public void testTotaalPrijsWithCarAndHuurder() {
        a = new Auto("Test Car", 100.0);
        k = new Klant("Test Guy");
        k.setKorting(10.0);
        ah.setGehuurdeAuto(a);
        ah.setHuurder(k);
        ah.setAantalDagen(3);
        assertEquals(270.0, ah.totaalPrijs());
    }

    @Test
    public void testSetAndGetKorting() {
        Klant k = new Klant("Test Guy");
        k.setKorting(10.0);
        assertEquals(10.0, k.getKorting());
    }

    @Test
    public void testKlantToString() {
        Klant k = new Klant("Test Guy");
        k.setKorting(10.0);
        assertEquals("op naam van: Test Guy (korting: 10.0%)", k.toString());
    }

    @Test
    public void testSetAndGetPrijsPerDag() {
        Auto a = new Auto("Test Car", 100.0);
        a.setPrijsPerDag(150.0);
        assertEquals(150.0, a.getPrijsPerDag());
    }

    @Test
    public void testAutoToString() {
        Auto a = new Auto("Test Car", 100.0);
        assertEquals("Test Car met prijs per dag: 100.0", a.toString());
    }

    @Test
    public void testSetAantalDagenNegativeValue() {
        ah.setAantalDagen(-1);
        assertEquals(0, ah.getAantalDagen(), "Aantal dagen cannot be negative.");
    }

    @Test
    public void testSetPrijsPerDagNegativeValue() {
        Auto a = new Auto("Negative Price Car", -50.0);
        assertEquals(-50.0, a.getPrijsPerDag(), "Prijs per dag can technically be negative, but should be handled appropriately.");
    }

    @Test
    public void testTotaalPrijsWithZeroDays() {
        a = new Auto("Test Car", 100.0);
        k = new Klant("Test Guy");
        k.setKorting(20.0);
        ah.setGehuurdeAuto(a);
        ah.setHuurder(k);
        ah.setAantalDagen(0);
        assertEquals(0.0, ah.totaalPrijs(), "Totaal prijs should be 0 if aantal dagen is 0.");
    }

    @Test
    public void testTotaalPrijsWithFullKorting() {
        a = new Auto("Test Car", 100.0);
        k = new Klant("Test Guy");
        k.setKorting(100.0);
        ah.setGehuurdeAuto(a);
        ah.setHuurder(k);
        ah.setAantalDagen(3);
        assertEquals(0.0, ah.totaalPrijs(), "Totaal prijs should be 0 if the korting is 100%.");
    }

    @Test
    public void testTotaalPrijsWithNoAutoOrHuurder() {
        ah.setAantalDagen(5);
        assertEquals(0.0, ah.totaalPrijs(), "Totaal prijs should be 0 if there is no auto or huurder.");
    }

    @Test
    public void testToStringWithAllDetails() {
        a = new Auto("Luxury Car", 200.0);
        k = new Klant("Premium Client");
        k.setKorting(15.0);
        ah.setGehuurdeAuto(a);
        ah.setHuurder(k);
        ah.setAantalDagen(2);
        String expectedOutput =
                "  Luxury Car met prijs per dag: 200.0\n" +
                        "  op naam van: Premium Client (korting: 15.0%)\n" +
                        "  aantal dagen: 2 en dat kost 340.0";
        assertEquals(expectedOutput, ah.toString());
    }

    @Test
    public void testToStringWithoutDetails() {
        String expectedOutput =
                "  er is geen auto bekend\n" +
                        "  er is geen huurder bekend\n" +
                        "  aantal dagen: 0 en dat kost 0.0";
        assertEquals(expectedOutput, ah.toString());
    }

    @Test
    public void testToStringWithOnlyAuto() {
        a = new Auto("Economy Car", 50.0);
        ah.setGehuurdeAuto(a);
        ah.setAantalDagen(2);
        String expectedOutput =
                "  Economy Car met prijs per dag: 50.0\n" +
                        "  er is geen huurder bekend\n" +
                        "  aantal dagen: 2 en dat kost 100.0";
        assertEquals(expectedOutput, ah.toString());
    }

    @Test
    public void testToStringWithOnlyHuurder() {
        k = new Klant("Solo Client");
        k.setKorting(0.0);
        ah.setHuurder(k);
        ah.setAantalDagen(3);
        String expectedOutput =
                "  er is geen auto bekend\n" +
                        "  op naam van: Solo Client (korting: 0.0%)\n" +
                        "  aantal dagen: 3 en dat kost 0.0";
        assertEquals(expectedOutput, ah.toString());
    }

}