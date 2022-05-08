package ai;

import model.Response;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class AiApp {
    public static void main(String[] args) throws UnsupportedEncodingException {
        RebotService qykRebotService = new QYKRebotServiveImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("主人，请给我取个响亮的名字，回车确认");
        String aiName = scanner.nextLine();
        System.out.println("hi,我是你的智能助手" + aiName + "请下达指令");
        while (true){
            System.out.println("请输入指令：");
            String input = scanner.nextLine();
            if (input.equals("886")){
                System.out.println("程序终止，欢迎下次再来，88");
                break;
            }else {
                Response response = qykRebotService.qs(input);
                if (response != null && response.getCode() == 0){
                    System.out.println(aiName + ":" + new String(response.getContent().getBytes(),"UTF-8"));
                }else{
                    System.out.println(aiName + ":" + "主人，该功能还学继续学习");
                }
            }
        }
        scanner.close();
    }
}
