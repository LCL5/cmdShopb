import java.io.File;
import java.util.Scanner;

public class Test{
    public static void main(String[] args){

        File file=new File("C:\\Users\\lenovo\\IdeaProjects\\cmdShop\\src\\users.xlsx");
        ReadExcel readExcel=new ReadExcel();
        User users[]=readExcel.readExcel(file);

        System.out.println("please input username:");//��ʾ�û������û���
        Scanner sc =new Scanner(System.in);
        String username=sc.next();

        System.out.println("please input password:");//��ʾ�û���������
        String psaaword=sc.next();

        for (User user:users){

        }
    }
}