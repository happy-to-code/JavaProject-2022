package com.yida.spider;

import com.alibaba.fastjson.JSONObject;
import com.yida.model.Label;
import com.yida.model.SubLabel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetLabelCloud {
    public static void main(String args[]) throws IOException {
        String cookie = "_ga=GA1.2.1448607064.1644289539; etherscan_cookieconsent=True; amp_fef1e8=7d032248-cf7c-47c4-ad7e-90467076f3c7R...1fti3aab8.1fti3acgb.2.1.3; cf_clearance=VdrtuOmz3cYm1dIS4P_FynRaYyyMzxUtKVHyP4rFL2A-1648868545-0-250; ASP.NET_SessionId=ufmmolysz2avavhxoc40be5a; _gid=GA1.2.37869000.1650984587; __cflb=02DiuFnsSsHWYH8WqVXaqGvd6BSBaXQLTFVxkKQgTrxNY; __cf_bm=BMdI1xNhFAZcjhf0ST.b3.eGCmyG2hcjO9cuHnm074M-1651029047-0-AVeaIrvN7EeaIM0zOi8mwUY0v2Q13orjvoSy2lY0BBkd4UTqbhet6vHdMoqH9XauxKJtonvqBGY3gUYw9scoxeYIj6FCRc/TXPu5zQaYOYP7LfDpvJ0GAbq8tYvu4MTTjQ==; _gat_gtag_UA_46998878_6=1";

        String url = "https://etherscan.io/labelcloud";
        //取得dom对象
        Document doc = Jsoup.connect(url).cookie("cookie", cookie).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36").proxy("10.1.4.251", 8848).get();

        Elements elements = doc.select("div[class=row mb-3]").select("div[class=col-md-4 col-lg-3 mb-3 secondary-container]");
        for (Element ele : elements) {
            Label label = new Label();

            String labelName = ele.select("button[class=btn btn-sm btn-block btn-custom btn-custom-toggle dropdown-toggle]").select("span").text();
            String totalCount = ele.select("button[class=btn btn-sm btn-block btn-custom btn-custom-toggle dropdown-toggle]").select("span[class=badge badge-secondary ml-1]").text();

            // 设置标签名称和总数
            label.setTotalCount(totalCount);
            label.setName(dealLabelName(labelName, totalCount).trim());

            List<SubLabel> subLabelList = new ArrayList<SubLabel>(10);
            // 子元素
            Elements subElements = ele.select("div[class=dropdown]").select("a");
            for (Element subElement : subElements) {
                SubLabel subLabel = new SubLabel();

                String href = subElement.attr("href");
                String subLabelName = subElement.text();

                subLabel.setHref(href);
                subLabel.setName(subLabelName.substring(0, subLabelName.lastIndexOf("(")).trim());
                subLabel.setCount(getSubLabelCount(subLabelName));

                // subLabel 添加到集合
                subLabelList.add(subLabel);
            }

            label.setSubLabelList(subLabelList);

            String labelJsonStr = JSONObject.toJSON(label).toString();


            System.out.println("labelJsonStr = " + labelJsonStr);
            // System.out.println("----------------------------------------------");
        }

    }


    public static HashMap<String, String> convertCookie(String cookie) {
        HashMap<String, String> cookiesMap = new HashMap<String, String>();
        String[] items = cookie.trim().split(";");
        for (String item : items) cookiesMap.put(item.split("=")[0], item.split("=")[1]);
        return cookiesMap;
    }

    private static String dealLabelName(String labelName, String totalCount) {
        int i = labelName.lastIndexOf(totalCount);
        labelName = labelName.substring(0, i);

        i = labelName.lastIndexOf(totalCount);
        labelName = labelName.substring(0, i);
        return labelName;
    }


    private static String getSubLabelCount(String labelName) {
        int begin = labelName.lastIndexOf("(");
        int end = labelName.lastIndexOf(")");
        return labelName.substring(begin + 1, end);
    }

}
