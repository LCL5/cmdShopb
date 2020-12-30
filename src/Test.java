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
                        carts[count++]=product;
                    }
                    System.out.println("继续购买请按1");
                    System.out.println("查看购物车请按2");
                    int choose=sc.nextInt();
                    if(choose==1){
                        for (Product product1:products) {
                            System.out.print(product1.getId());
                            System.out.print("\t" + product1.getName());
                            System.out.print("\t" + product1.getPrice());
                            System.out.println("\t" + product1.getDecs());
                    }
                        System.out.println("请输入商品ID吧该商品加入购物车");
                        Id=sc.next();
                        inProduct=null;
                        inProduct = Class.forName("Test").getResourceAsStream("/products.xlsx");
                        readProductExcel=new ReadProductExcel();
                        product=readProductExcel.getProductById(Id,inProduct);
                        if(product!=null){
                            carts[count++]=product;
                        }
                }
                    else if(choose==2) {
                        System.out.println("当前购物车商品如下");
                        for (Product p : carts) {
                            if (p != null) {
                                System.out.print(p.getId());
                                System.out.print("\t" + p.getName());
                                System.out.print("\t" + p.getPrice());
                                System.out.println("\t" + p.getDecs());
                            }
                        }
                        System.out.println("继续购买请按1");
                        System.out.println("结账请按2");
                        choose=sc.nextInt();
                        if(choose==1){
                            for (Product product1:products) {
                                System.out.print(product1.getId());
                                System.out.print("\t" + product1.getName());
                                System.out.print("\t" + product1.getPrice());
                                System.out.println("\t" + product1.getDecs());
                            }
                            System.out.println("请输入商品ID吧该商品加入购物车");
                            Id=sc.next();
                            inProduct=null;
                            inProduct = Class.forName("Test").getResourceAsStream("/products.xlsx");
                            readProductExcel=new ReadProductExcel();
                            product=readProductExcel.getProductById(Id,inProduct);
                        }
                        else if(choose==2){
                            System.out.println("你输入支付" + product.getPrice() + "元");
                            System.out.println("请输入你的地址");
                            System.out.println("请输入你的电话号码");

                        }
                    }



                    break;
                } else {
                    System.out.println("登录失败");
                }

            }
        }
    }
}
