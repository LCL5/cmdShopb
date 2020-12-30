import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {

        boolean bool = true;
        while (bool) {

            java.io.InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            java.io.InputStream inProduct = Class.forName("Test").getResourceAsStream("/products.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();
            User users[] = readExcel.readExcel(in);

            System.out.println("please input username:");//提示用户输入用户名
            Scanner sc = new Scanner(System.in);
            String username = sc.next();

            System.out.println("please input password:");//提示用户输入密码
            String password = sc.next();

            for (int i=0;i<users.length;i++) {
                if (username.equals(users[i].getUsername().trim()) && password.equals(users[i].getPassword().trim())) {
                    System.out.println("登录成功");
                    bool = false;
                    ReadProductExcel readProductExcel=new ReadProductExcel();
                    Product products[]=readProductExcel.readExcel(inProduct);
                    for (Product product:products) {
                        System.out.print(product.getId());
                        System.out.print("\t" + product.getName());
                        System.out.print("\t" + product.getPrice());
                        System.out.println("\t" + product.getDecs());
                    }
                    int count=0;
                    Product carts[]=new Product[3];
                    System.out.println("请输入商品ID吧该商品加入购物车");
                    String Id=sc.next();
                    ReadUserExcel readUserExcel1=new ReadUserExcel();
                    inProduct=null;
                    inProduct = Class.forName("Test").getResourceAsStream("/products.xlsx");
                    Product product=readProductExcel.getProductById(Id,inProduct);
                    if(product!=null){

                    }
                    else if(choose==2){
                        for (Product carts:products) {
                            System.out.print(carts.getId());
                            System.out.print("\t" + carts.getName());
                            System.out.print("\t" + carts.getPrice());
                            System.out.println("\t" + carts.getDecs());

                    }



                    break;
                } else {
                    System.out.println("登录失败");
                }

            }
        }
    }
}