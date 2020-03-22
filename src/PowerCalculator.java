public class PowerCalculator {
    public static final PowerCalculator INSTANCE = new PowerCalculator();
        private PowerCalculator() {
        }
        int calculate(int base, int exponent) {
            assert exponent >= 0 : "exponent can’t be < 0";
            int result = 1;
            for (int i = 0; i < exponent; ++i) {
                result *= base;
            }
            return result;
        }
}
