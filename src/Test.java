import java.io.InputStream;
import java.util.Scanner;

public class Test {

    static Product carts[]=new Product[3];//�������ﳵ
    static Scanner choose = new Scanner(System.in);
    public static void main(String[] args) throws ClassNotFoundException {

        boolean bool = true;
        while (bool) {

            java.io.InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            java.io.InputStream inProduct = Class.forName("Test").getResourceAsStream("/products.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();
            User users[] = readExcel.readExcel(in);

            System.out.println("please input username:");//��ʾ�û������û���
            Scanner sc = new Scanner(System.in);
            String username = sc.next();

            System.out.println("please input password:");//��ʾ�û���������
            String password = sc.next();

            for (int i=0;i<users.length;i++) {
                if (username.equals(users[i].getUsername().trim()) && password.equals(users[i].getPassword().trim())) {

                    bool = false;
                    //��¼�ɹ���ʾ��Ʒ����Ʒ�˵�
                    ReadProductExcel readProductExcel = new ReadProductExcel();
                    Product products[] = readProductExcel.readExcel(inProduct);
                    for (Product product : products) {
                        System.out.print(product.getId());
                        System.out.print("\t" + product.getName());
                        System.out.print("\t" + product.getPrice());
                        System.out.println("\t" + product.getDecs());
                    }


                    while (true) {
                        System.out.println("���������밴1");
                        System.out.println("�鿴���ﳵ�밴2");
                        System.out.println("�����밴3");
                        System.out.println("�˳��밴4");

                        int choose = sc.nextInt();
                        if (choose == 1) {
                            shopping(inProduct);

                        } else if (choose == 2) {
                            viewcarts();

                        } else if (choose == 3) {

                        } else if (choose == 4) {
                            break;
                        }
                    }
                }


                break;
            } else {
                    System.out.println("��¼ʧ��");
                }

            }
        }
    }
    static void shopping(InputStream inProduct) throws ClassNotFoundException {
        int count=0;
        ReadProductExcel readProductExcel=new ReadProductExcel();
        Product products[]=readProductExcel.readExcel(inProduct);
        System.out.println("��������ƷID�ɸ���Ʒ���빺�ﳵ");
        String Id=sc.next();
        ReadUserExcel readUserExcel1=new ReadUserExcel();
        inProduct=null;
        inProduct = Class.forName("Test").getResourceAsStream("/products.xlsx");
        Product product=readProductExcel.getProductById(Id,inProduct);
        if(product!=null){
            carts[count++]=product;
        }
        for (Product product1:products) {
            System.out.print(product1.getId());
            System.out.print("\t" + product1.getName());
            System.out.print("\t" + product1.getPrice());
            System.out.println("\t" + product1.getDecs());
        }

    }
    static void viewcarts(){
        System.out.println("��ǰ���ﳵ��Ʒ����");
        for (Product p : carts) {
            if (p != null) {
                System.out.print(p.getId());
                System.out.print("\t" + p.getName());
                System.out.print("\t" + p.getPrice());
                System.out.println("\t" + p.getDecs());
            }
    }
}
