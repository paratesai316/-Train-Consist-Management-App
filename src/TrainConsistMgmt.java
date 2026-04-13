public class TrainConsistMgmt {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String newCargo) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") && newCargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = newCargo;
                System.out.println("Cargo assigned successfully -> " + this.cargo);
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
                throw e;
            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie\n");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("=========================================================\n");

        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        try {
            cylindricalBogie.assignCargo("Petroleum");
        } catch (CargoSafetyException ignored) {
            // Caught in method, logged, and re-thrown. Handled here to prevent crash.
        }

        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");
        try {
            rectangularBogie.assignCargo("Petroleum");
        } catch (CargoSafetyException ignored) {
            // Expected failure
        }

        System.out.println("UC15 runtime handling completed...");
    }
}