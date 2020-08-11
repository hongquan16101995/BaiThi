import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        try {
            do {
                System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---");
                System.out.println("Chọn chức năng theo số để tiếp tục");
                System.out.println("1. Xem danh sách");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Tìm kiếm");
                System.out.println("6. Đọc từ file");
                System.out.println("7. Ghi vào file");
                System.out.println("8. Thoát");
                System.out.println("Chọn chức năng: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        scanner.nextLine();
                        ArrayList<Contact> arrayList = readFile();
                        for (Contact contact : arrayList) {
                            System.out.println(contact);
                        }
                        break;
                    case 2:
                        scanner.nextLine();
                        addContact();
                        break;
                    case 3:
                        scanner.nextLine();
                        if (editContact()) {
                            System.out.println("Sửa thành công!");
                        } else {
                            System.out.println("Không có danh bạ của số điện thoại này!");
                        }
                        break;
                    case 4:
                        scanner.nextLine();
                        if (deleteContact()) {
                            System.out.println("Xóa thành công!");
                        } else {
                            System.out.println("Không có danh bạ của số điện thoại này!");
                        }
                        break;
                    case 5:
                        scanner.nextLine();
                        if (!searchContact()) {
                            System.out.println("Không có danh bạ của số điện thoại này!");
                        }
                        break;
                    case 6:
                        readFile();
                        break;
                    case 7:
                        break;
                    case 8:
                        System.exit(0);
                }
            } while (true);
        } catch (IOException e) {
            System.out.println();
        }
    }

    private void addContact() throws IOException {
        System.out.println("Mời nhập thông tin: ");
        System.out.println("Nhập số điện thoai: ");
        String phonenumber = scanner.nextLine();
        System.out.println("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giớ tính: ");
        String render = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String dateofbirth = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(phonenumber, group, name, render, address, dateofbirth, email);
        ArrayList<Contact> arrayList = readFile();
        arrayList.add(contact);
        clearFile();
        for (Contact contact1 : arrayList) {
            writerFile(contact1);
        }

        System.out.println("Thêm thành công!");
    }

    private boolean editContact() throws IOException {
        boolean check = false;
        System.out.println("Nhập vào số điện thoại: ");
        String phonenumber = scanner.nextLine();
        ArrayList<Contact> arrayList = readFile();
        clearFile();
        for (Contact contact : arrayList) {
            if (contact.getPhonenumber().equals(phonenumber)) {
                edit(contact);
                check = true;
            }
            writerFile(contact);
        }
        return check;
    }

    private void edit(Contact contact) throws IOException {
        System.out.println("Mời nhập thông tin: ");
        System.out.println("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giớ tính: ");
        String render = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String dateofbirth = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();

        contact.setGroup(group);
        contact.setName(name);
        contact.setAddress(address);
        contact.setDateofbirth(dateofbirth);
        contact.setRender(render);
        contact.setEmail(email);
    }

    private boolean deleteContact() throws IOException {
        boolean check = false;
        System.out.println("Nhập vào số điện thoại: ");
        String phonenumber = scanner.nextLine();
        ArrayList<Contact> arrayList = readFile();
        ArrayList<Contact> arrayList1 = new ArrayList<>();
        clearFile();
        for (Contact contact : arrayList) {
            if (contact.getPhonenumber().equals(phonenumber)) {
                check = true;
            }else {
                arrayList1.add(contact);
            }
        }
        for (Contact contact : arrayList1) {
            writerFile(contact);
        }
        return check;
    }

    private boolean searchContact() throws IOException {
        boolean check = false;
        System.out.println("Nhập vào số điện thoại: ");
        String phonenumber = scanner.nextLine();
        ArrayList<Contact> arrayList = readFile();
        for (Contact contact : arrayList) {
            if (contact.getPhonenumber().equals(phonenumber)) {
                System.out.println(contact);
                check = true;
            }
        }
        return check;
    }

    public ArrayList<Contact> readFile() throws IOException {
        FileReader fileReader = new FileReader(new File("contacts.csv"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String contact;
        ArrayList<Contact> arrayList = new ArrayList<>();
        while ((contact = bufferedReader.readLine()) != null) {
            String[] strings = contact.split(",");
            Contact contact1 = new Contact(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6]);
            arrayList.add(contact1);
        }
        return arrayList;
    }

    public void writerFile(Contact contact) throws IOException {
        FileWriter fileWriter = new FileWriter("contacts.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String string = contact.getPhonenumber() + "," + contact.getGroup() + ","
                + contact.getName() + "," + contact.getRender() + ","
                + contact.getAddress() + "," + contact.getDateofbirth() + "," + contact.getEmail() + "\n";
        bufferedWriter.write(string);
        bufferedWriter.close();
    }

    public void clearFile() throws IOException {
        FileWriter fileWriter = new FileWriter("contacts.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String string = "";
        bufferedWriter.write(string);
        bufferedWriter.close();
    }
}
