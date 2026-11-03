class ParkingLot {
    private int twoWheelers=0, fourWheelers=0; private final int twoCap, fourCap; private static long revenue=0;
    ParkingLot(int twoCap, int fourCap) { this.twoCap=twoCap; this.fourCap=fourCap; }
    boolean park(String type) {
        if (type.equalsIgnoreCase("two") && twoWheelers<twoCap) { twoWheelers++; revenue+=20; return true; }
        if (type.equalsIgnoreCase("four") && fourWheelers<fourCap) { fourWheelers++; revenue+=40; return true; }
        System.out.println("Full or invalid type"); return false;
    }
    void leave(String type) { if (type.equalsIgnoreCase("two") && twoWheelers>0) twoWheelers--; else if (type.equalsIgnoreCase("four") && fourWheelers>0) fourWheelers--; }
    public static void main(String[] args) {
        ParkingLot p=new ParkingLot(2,1);
        System.out.println(p.park("two")); System.out.println(p.park("two")); System.out.println(p.park("two"));
        System.out.println(p.park("four")); p.leave("two"); System.out.println(p.park("two"));
        System.out.println("Two-wheelers: "+p.twoWheelers+", Four-wheelers: "+p.fourWheelers);
        System.out.println("Revenue: "+revenue);
    }
}
