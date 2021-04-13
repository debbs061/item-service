package itemservice.service;

import com.google.gson.*;
import itemservice.payload.request.SearchVo;
import itemservice.payload.response.ApiDataResponseVo;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

@Service
public class ItemServiceImpl implements ItemService {

    static String accessToken;

    @Override
    public ApiDataResponseVo getFruitPrice(SearchVo searchVo) throws Exception {
        getFruitAccessToken();
        ApiDataResponseVo vo = new ApiDataResponseVo();
        String name = URLEncoder.encode(searchVo.getItemName(), "UTF-8");
        URL url = new URL("http://fruit.api.postype.net/product?name=" + name);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization", accessToken);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            String result = "";

            while ((line = reader.readLine()) != null) {
                result = result.concat(line);
            }
            vo = parseJsonData2(result);

        } catch (IOException e) {
            throw new RuntimeException();
        }
        return vo;
    }

    @Override
    public ApiDataResponseVo getVegetPrice(SearchVo searchVo) throws IOException {
        getVegetAccessToken();
        ApiDataResponseVo vo = new ApiDataResponseVo();
        String name = URLEncoder.encode(searchVo.getItemName(), "UTF-8");
        URL url = new URL("http://vegetable.api.postype.net/item?name=" + name);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization", accessToken);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            String result = "";

            while ((line = reader.readLine()) != null) {
                result = result.concat(line);
            }
            vo = parseJsonData2(result);

        } catch (IOException e) {
            throw new RuntimeException();
        }
        return vo;
    }

    // 과일 액세스 토큰 조회하기
    public void getFruitAccessToken() throws MalformedURLException {
        URL url = new URL("http://fruit.api.postype.net/token");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));

            String line = "";
            String result = "";

            while ((line = reader.readLine()) != null) {
                result = result.concat(line);
            }

            parseJsonData(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseJsonData(String data) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(data);
        accessToken = jsonObject.get("accessToken").getAsString();
    }

    // 채소 액세스 토큰 조회하기
    public void getVegetAccessToken() throws IOException {
        URL url = new URL("http://vegetable.api.postype.net/token");
        URLConnection conn = url.openConnection();
        accessToken = conn.getHeaderField("Set-Cookie").split(";")[0].split("=")[1];
    }

    // 가격 조회하기
    public ApiDataResponseVo parseJsonData2(String data) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(data);
        Gson gson = new Gson();
        ApiDataResponseVo vo = gson.fromJson(jsonObject, ApiDataResponseVo.class);
        return vo;
    }

}
