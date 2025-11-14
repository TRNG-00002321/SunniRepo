class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("ellOZ");
        stringBuilder.insert(0, "H");
        stringBuilder.deleteCharAt(5);
        stringBuilder.setCharAt(4, 'o');
        stringBuilder.append(" World!");
        System.out.println(stringBuilder.toString());

    }
}
