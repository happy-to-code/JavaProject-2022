package com.yida.spider;

import com.alibaba.fastjson.JSONObject;
import com.yida.model.Label;
import com.yida.model.SubLabel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GetSubLabel {
    public static void main(String[] args) throws IOException {
        String url = "https://etherscan.io";

        String cookie = "_ga=GA1.2.1448607064.1644289539; etherscan_cookieconsent=True; amp_fef1e8=7d032248-cf7c-47c4-ad7e-90467076f3c7R...1fti3aab8.1fti3acgb.2.1.3; cf_clearance=VdrtuOmz3cYm1dIS4P_FynRaYyyMzxUtKVHyP4rFL2A-1648868545-0-250; ASP.NET_SessionId=ufmmolysz2avavhxoc40be5a; _gid=GA1.2.37869000.1650984587; __stripe_mid=1af5cd68-19e2-47bc-9f6c-21c723273e0572aa38; etherscan_userid=zhangyifei; etherscan_pwd=4792:Qdxb:XbtZpVnTthIWUA12j2ErV9BJFSX1srtpvCG4nkcEITE=; etherscan_autologin=True; __cflb=02DiuFnsSsHWYH8WqVXaqGvd6BSBaXQLUeGLJ3YpWPj8g; __cf_bm=j.XBy3gR8LF_w_.xXM27rwtTgq3a4vcm_6O7tl7li4U-1651112508-0-AQHUiBE3RuMDtfY4poT6mWuEv3sb4jWK/3rXrUhs8rVRm75/u1AlKFarxXE4jfdiTniY0jk2qENZPzTJm8AS+cmDboilMRLgb1cr0j/WlDAJMb/gcJ/GIuOFbHNhT/JsJg==";

        String fileName = "C:\\myfile\\javaProject\\src\\main\\java\\com\\yida\\spider\\label_cloud_1.txt";
        //一行一行读取文件
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 解析为对象
                Label label = JSONObject.parseObject(line, Label.class);
                List<SubLabel> subLabelList = label.getSubLabelList();
                for (SubLabel subLabel : subLabelList) {
                    String href = subLabel.getHref();
                    String newUrl = url + href;
                    // 取得dom对象
                    Document doc = Jsoup.connect(newUrl).
                            cookie("cookie", cookie).
                            userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36").
                            proxy("10.1.4.251", 8848).get();


                    Elements elements = doc.select("#table-subcatid-0").select("tbody");
                    System.out.println("elements = " + elements);
                    // for (Element element : elements) {
                    //     Elements sub = element.select("tr").select("td");
                    //     sub.
                    //
                    // }


                }


            }
        }
    }
}
