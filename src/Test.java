import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

        boolean bool = true;
        while (bool) {

            java.io.InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();
            User users[] = readExcel.readExcel(in);

            System.out.println("please input username:");//��ʾ�û������û���
            Scanner sc = new Scanner(System.in);
            String username = sc.next();

            System.out.println("please input password:");//��ʾ�û���������
            String password = sc.next();

            for (int i=0;i<users.length;i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("��¼�ɹ�");
                    bool = false;
                    break;
                } else {
                    System.out.println("��¼ʧ��");
                }

            }
        }
    }
}