// Create a string "  Hello World!  ". Perform various String methods on it.
public class StringDemo {
    public static void main(String[] args) {
        String hw = "  Hello World!  ";
        System.out.println("Replace: " + hw.replace("World", "sunni".toUpperCase()));
        System.out.println("Trim: " + hw.trim());
        System.out.println("Lower: " + hw.toLowerCase());
        System.out.println(" Hello World! " == hw.trim());
        System.out.println(hw.trim().concat(" " + "Nice To Meet You"));
        System.out.printf("Character at position %d: %c", 4, hw.charAt(4));
    }
}
