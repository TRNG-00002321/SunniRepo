class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("ellOZ");
        stringBuffer.insert(0, "H");
        stringBuffer.deleteCharAt(5);
        stringBuffer.setCharAt(4, 'o');
        stringBuffer.append(" World!");
        System.out.println(stringBuffer.toString());
    }
}
