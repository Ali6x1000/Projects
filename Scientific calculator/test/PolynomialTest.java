import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PolynomialTest {
    @Test
    public void testDerivativeOfCube() {
        Polynomial polynomial = new Polynomial(new Variable(), 3);
        Function derivative = polynomial.derivative();
        String actual = derivative.toString();

        if (actual.endsWith(" * 1.0")) {
            actual = actual.substring(0, actual.length() - " * 1.0".length());
        }

        assertEquals("3.0 * x^2.0", actual);
    }
}
