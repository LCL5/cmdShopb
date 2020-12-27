import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

        boolean bool = true;
        while (bool) {

            java.io.InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();
            User users[] = readExcel.readExcel(in);

            System.out.println("please input username:");//提示用户输入用户名
            Scanner sc = new Scanner(System.in);
            String username = sc.next();

            System.out.println("please input password:");//提示用户输入密码
            String password = sc.next();

            for (int i=0;i<users.length;i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登录成功");
                    bool = false;
                    break;
                } else {
                    System.out.println("登录失败");
                }

            }
        }
    }
}