package com.example.geolocation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

    public class getAPIData {

        public Object APIDatagetter(int v1, int v2, int key) {
            Object list = getXml(v1, v2);
            @SuppressWarnings("unchecked")
            Object AS = ((Hashtable<Integer, Object>) list).get(key);
            //System.out.println(((Structure) AS).getValue("reh"));
            return AS;
        }




        public static Object getXml(double v1, double v2) {
        Map<String, Object> map = getGridxy(v1, v2);
        Hashtable<Integer, Object> List = new Hashtable<Integer, Object>();
        String xml = "";
        Structure A = new Structure();
        try {

            String addr = "http://www.kma.go.kr/wid/queryDFS.jsp?gridx=" + map.get("x") + "&gridy=" + map.get("y");
            URL url = new URL(addr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setConnectTimeout(10000);
            http.setUseCaches(true);
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                sb.append(line);
            }
            xml = sb.toString();
            br.close();
            http.disconnect();

        } catch (Exception e) {
            System.out.println("다운로드 에러" + e.getMessage());

        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentbuilder = factory.newDocumentBuilder();
            InputStream is = new ByteArrayInputStream(xml.getBytes());
            Document doc = documentbuilder.parse(is);
            Element element = doc.getDocumentElement();
            NodeList list1 = element.getElementsByTagName("data");
            int b = 0;
            for (int i = 0; i < list1.getLength(); i++) {
                for (Node node = list1.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
                    String category = node.getNodeName();

                    if(category.equals("hour"))
                    {
                        A = new Structure();
                        List.put(b, A);
                        b++;
                    }
                    String Value = node.getTextContent().toString();
                    A.setValue(category, Value);
                }
            }

        } catch (Exception e) {
            System.out.println("파싱에러" + e.getMessage());
        }

        return List;
    }



    public static Map<String, Object> getGridxy(double v1, double v2) {
        double RE = 6371.00877;
        double GRID = 5.0;
        double SLAT1 = 30.0;
        double SLAT2 = 60.0;
        double OLON = 126.0;
        double OLAT = 38.0;
        double XO = 43;
        double YO = 136;
        double DEGRAD = Math.PI / 180.0;

        double re = RE / GRID;
        double slat1 = SLAT1 * DEGRAD;
        double slat2 = SLAT2 * DEGRAD;
        double olon = OLON * DEGRAD;
        double olat = OLAT * DEGRAD;

        double sn = Math.tan(Math.PI * 0.25 + slat2 * 0.5) / Math.tan(Math.PI * 0.25 + slat1 * 0.5);
        sn = Math.log(Math.cos(slat1) / Math.cos(slat2)) / Math.log(sn);
        double sf = Math.tan(Math.PI * 0.25 + slat1 * 0.5);
        sf = Math.pow(sf, sn) * Math.cos(slat1) / sn;
        double ro = Math.tan(Math.PI * 0.25 + olat * 0.5);
        ro = re * sf / Math.pow(ro, sn);
        Map<String, Object> map = new HashMap<String, Object>();

        double ra = Math.tan(Math.PI * 0.25 + (v1) * DEGRAD * 0.5);
        ra = re * sf / Math.pow(ra, sn);
        double theta = v2 * DEGRAD - olon;
        if (theta > Math.PI)
            theta -= 2.0 * Math.PI;
        if (theta < -Math.PI)
            theta += 2.0 * Math.PI;
        theta *= sn;
        map.put("lat", v1);
        map.put("lng", v2);
        map.put("x", (int)Math.floor(ra * Math.sin(theta) + XO + 0.5));
        map.put("y", (int)Math.floor(ro - ra * Math.cos(theta) + YO + 0.5));

        return map;
    }
}