package Java_Mentor.block_3_OOP;

// 3.4.8
public class ComplexNumbers {

    public static void main(String[] args) {

        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);

        // a.equals(b) must return true
        // a.hashCode() must be equal to b.hashCode()

        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    public static class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            long temp;
            temp = Double.doubleToLongBits(im);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(re);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            return result;

//            int result = 31;
//            result = 17 * result + (getClass() != null ? getClass().hashCode() : 0);
//            return result;


        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            ComplexNumber other = (ComplexNumber) obj;
            if (getRe() != other.re) {
                return false;
            }
            return getIm() == other.im;
        }
    }
}


//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof ComplexNumber)) return false;
//            ComplexNumber that = (ComplexNumber) o;
//            return Double.compare(that.getRe(), getRe()) == 0 && Double.compare(that.getIm(), getIm()) == 0;
//        }

//        @Override
//        public int hashCode() {
//            return java.util.Objects.hash(re, im);
//        }
