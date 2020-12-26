import java.io.File;
import java.util.Scanner;

public class Test{
    public static void main(String[] args){

        File file=new File("C:\\Users\\lenovo\\IdeaProjects\\cmdShop\\src\\users.xlsx");
        ReadExcel readExcel=new ReadExcel();
        User users[]=readExcel.readExcel(file);

        System.out.println("please input username:");//提示用户输入用户名
        Scanner sc =new Scanner(System.in);
        String username=sc.next();

        System.out.println("please input password:");//提示用户输入密码
        String psaaword=sc.next();

        for (User user:users){

        }
    }
}