package by.itacademy;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //try-with-resources это когда try (FileOutputStream...){
        //InputStream and OutputStream always implements AutoClosable

        String text = "1/BOM/2020\n2/BIM/2021";
        try (FileOutputStream fos = new FileOutputStream("D://mikhalevich//lesson12//files//notes.txt")) {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("The file has been written");


/*        try (FileInputStream fin = new FileInputStream("D://mikhalevich//lesson12//files//notes.txt")) {
            System.out.printf("File size: %d bytes \b", fin.available());
            int i = -1;
            System.out.println();
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // InputStreamReader Здесь уже есть кодировка
        // Если нужен буфер то используем InputStreamReader

        InputStreamReader isReader = new InputStreamReader(System.in);
        BufferedReader bReader = new BufferedReader(isReader);
        System.out.println("Enter anything...");
        String data = null;
        try {
            data = bReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("You entered..." + data);

        try {
            InputStream is = new FileInputStream("D://mikhalevich//lesson12//files//notes.txt");
        Reader isr = new InputStreamReader(is);
        int data0 = isr.read();
        while(data0 != -1){
            char chr = (char) data0;
            System.out.print(chr);
            data0 = isr.read();
        }
        isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();*/

        //Преобразуем строки в объекты

        try(BufferedReader br = new BufferedReader(new FileReader("D://mikhalevich//lesson12//files//notes.txt")))
        {
            String s;
            while((s=br.readLine())!=null){
               String[] p = s.split("/");
               int id = Integer.parseInt(p[0]);
               String name = p[1];
               LocalDate date = LocalDate.now();
               LocalDate localeDate = date.withYear(Integer.parseInt(p[2]));
               Person person = new Person(id, name, localeDate);
                System.out.println(person);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D://mikhalevich//lesson12//files//BufferedWriter.txt")))
        {

            String text1 = "";

/* для добавления в конец строки
            String d = "\n" + text1;
            byte[] buffer = d.getBytes();*/

            while(!(text1=bufferedReader.readLine()).equals("ESC")){
                bufferedWriter.write(text1 + "\n");
                bufferedWriter.flush();
            }

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

/*        Домашнее задание
        purchase
        id/name/date

        Order
        id/date/id/id/id/id*/

Scanner sc = new Scanner(System.in);

        int num1 = -1;
while(num1 != 3){
            System.out.println("Shop");
            System.out.println("Enter 1 to purchases");
            System.out.println("Enter 2 to order");
            System.out.println("Enter 3 to exit");

            num1 = sc.nextInt();

            if(num1 == 3){
                break;
            }
            if(num1 == 1){
                goods();
            }
        }


    }

    private static void goods() {
        int num2 = -1;
        while(num2 != 3){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Goods");
            System.out.println("Enter 1 to add goods"); // Появляется System.in где необходимо воодить через enter id, name,
            System.out.println("Enter 2 delete goods by names");
            System.out.println("Enter 3 show all goods");
            System.out.println("Enter 4 back ");

            //Нужно подумать про ошибки ввода пользователя
            //Вычитываем строку, распарсили, записываем в коллекцию, лучше в Map <id, name>
            //В итоге записываем все в файл
            //Можно использовать swith case
            //Создать два утильных класса со статическими методами для

            num2 = scanner.nextInt();

            if(num2 == 3){
                break;
            }
            if(num2 == 1){
                goods();
            }
        }
    }
}
