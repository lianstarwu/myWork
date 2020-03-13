public enum  EnumDemoTest {
    OK(0, "成功"),
    ERROR_A(100, "错误A"),
    ERROR_B(200, "错误B");

    EnumDemoTest(int number, String description) {

        this.code = number;
        this.description = description;
    }
    private int code;
    private String description;
    public int getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "EnumDemoTest{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }

    public static void main(String args[]) { // 静态方法
//        for (EnumDemoTest s : EnumDemoTest.values()) {
//            System.out.println("code: " + s.getCode() + ", description: " + s.getDescription());
//        }
        System.out.println(EnumDemoTest.ERROR_A.getCode());
    }
}
