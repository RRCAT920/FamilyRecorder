package com.rrcat920;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
//        循环
//        打印界面
//        读取输入并返回
//        打印相应界面
        int input = 0;
        int balance = (int) 1e4;
        Scanner in = new Scanner(System.in);
        String indent = "\t\t";
        String details = "收支\t账户金额\t收支金额\t说 明\n";
        String slash16 = "----------------";
        String slash50 = slash16 + slash16 + "-------------";
        String logInfo = slash16 + "---" + "登记完成" + "---" + slash16;
        String errorInfo = "输入有误，请重新输入(1-4): ";
        String numberError = "输入错误，请输入4位数以内的数字: ";
        String descriptionError = "输入有误，请输入长度为在8以内的说明: ";

        do {
            System.out.println(slash16 + "家庭收支记账软件" + slash16);
            System.out.println();
            System.out.println(indent + "1.收支明细");
            System.out.println(indent + "2.登记收入");
            System.out.println(indent + "3.登记支出");
            System.out.println(indent + "4.退出");
            System.out.println();
            System.out.print(indent + "请选择(1-4): ");

            while (true) {
                try {
                    input = Integer.parseInt(in.nextLine());
                    if (input == 1 || input == 2 || input == 3 || input == 4) {
                        break;
                    }
                    System.out.print(errorInfo);
                } catch (NumberFormatException exception) {
                    System.out.print(errorInfo);
                }
            }

            if (input == 4) {
                System.out.println();
                System.out.print("确认是否退出(Y/N): ");
                while (true) {
                    String yes = in.nextLine().toUpperCase();
                    if ("N".equals(yes)) {
                        input = -1;
                        break;
                    } else if ("Y".equals(yes)) {
                        break;
                    }
                    System.out.print("输入有误，请重新输入(Y/N/y/n): ");
                }
            }

            String info = "";
            switch (input) {
                case 1:
                    System.out.println(slash16 + "当前收支明细记录" + slash16);
                    System.out.print(details);
                    System.out.println(slash50);
                    break;
                case 2:
                    System.out.print("请输入收入金额: ");
                    int income = 0;
                    while (true) {
                        try {
                            String val = in.nextLine();
                            if (val.length() > 4) {
                                System.out.print(numberError);
                                continue;
                            }
                            income = Integer.parseInt(val);
                            break;
                        } catch (NumberFormatException exception) {
                            System.out.print(numberError);
                        }
                    }
                    balance = balance + income;
                    System.out.print("请输入收入说明: ");
                    while ((info = in.nextLine()).length() > 8) {
                        System.out.print(descriptionError);
                    }
                    details = details + "收入\t" + balance + "\t\t" + income + "\t\t" + info + "\n";
                    System.out.println(logInfo);
                    break;
                case 3:
                    System.out.print("请输入支出金额: ");
                    int outcome = 0;
                    while (true) {
                        try {
                            String val = in.nextLine();
                            if (val.length() > 4) {
                                System.out.print(numberError);
                                continue;
                            }
                            outcome = Integer.parseInt(val);
                            break;
                        } catch (NumberFormatException exception) {
                            System.out.print(numberError);
                        }
                    }
                    balance = balance - outcome;
                    System.out.print("请输入支出说明: ");
                    while ((info = in.nextLine()).length() > 8) {
                        System.out.print(descriptionError);
                    }
                    details = details + "支出\t" + balance + "\t\t" + outcome + "\t\t" + info + "\n";
                    System.out.println(logInfo);
                    break;
            }
        } while (input != 4);
    }
}
