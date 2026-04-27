public class Demo {
    public static void main(String[] args) throws Exception {
        // Demo d = new Demo();
        Class.forName("Demo").newInstance();

        // Class.forName("com.mysql.jdbc.Driver");
        //OR
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());

    }

    static{
        System.out.println("Static Block");
    }

    {
        System.out.println("Instance block ==> Non static");
    }
}
