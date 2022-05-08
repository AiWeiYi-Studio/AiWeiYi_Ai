package ai;

import com.google.gson.Gson;
import model.Response;
import java.net.URLEncoder;

public class QYKRebotServiveImpl implements RebotService{
    public static final String api = "https://api.qingyunke.com/api.php?key=free&appid=0&msg=%s";
    private static final Gson gson = new Gson();
    @Override
    public Response qs(String msg){
        try{
            String api2 =String.format(api, URLEncoder.encode(msg,"UTF-8"));
            String request = HttpUtis.request(api2);
            Response response = gson.fromJson(request,Response.class);
            return response;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}