package com.example.landmarks;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LandmarksFromXML {
    private Landmark [] landmarks;
    private Context context;

    public LandmarksFromXML(Context context) {
        this.context = context;
        // open a stream to the XML file + a docBuilder + doc
        InputStream stream = null;
        DocumentBuilder builder = null;
        Document xmlDoc= null;

        try {
            stream = this.context.getResources().openRawResource(R.raw.landmarks);
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmlDoc = builder.parse(stream);
        } catch(Exception e) {
            e.printStackTrace();
        }

        //slice xmlDoc to NodeLists#
        NodeList nameList = xmlDoc.getElementsByTagName("name"); //chopping
        NodeList countryList = xmlDoc.getElementsByTagName("country");
        NodeList regionList = xmlDoc.getElementsByTagName("region");
        NodeList urlList = xmlDoc.getElementsByTagName("url");
        NodeList imageList = xmlDoc.getElementsByTagName("image");
        NodeList extraList = xmlDoc.getElementsByTagName("extra");

        //make landmark
        landmarks = new Landmark[nameList.getLength()];
        for (int i=0;i<landmarks.length;i++) {
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String country = countryList.item(i).getFirstChild().getNodeValue();
            String region = regionList.item(i).getFirstChild().getNodeValue();
            String image = imageList.item(i).getFirstChild().getNodeValue();
            String url = urlList.item(i).getFirstChild().getNodeValue();
            String extra = extraList.item(i).getFirstChild().getNodeValue();


            landmarks[i] = new Landmark(name, country, region, url, image, extra);
        }


    }

    public int getLength(){return landmarks.length;}
    public Landmark getLandmark(int Index){return landmarks[Index];}
    public String [] getNames(){
        String [] names = new String[getLength()];
        for(int i=0; i<getLength();i++) {
            names[i] = getLandmark(i).getName();
        }
        return names;
    }

    public String [] getCountries(){
        String [] countries = new String[getLength()];
        for(int i=0; i<getLength();i++) {
            countries[i] = getLandmark(i).getCountry();
        }
        return countries;
    }

    public String [] getRegions(){
        String [] regions = new String[getLength()];
        for(int i=0; i<getLength();i++) {
            regions[i] = getLandmark(i).getLocation();
        }
        return regions;
    }

    public String [] getURL(){
        String [] urls = new String[getLength()];
        for(int i=0; i<getLength();i++) {
            urls[i] = getLandmark(i).getUrl();
        }
        return urls;
    }

    public String [] getExtra(){
        String [] extraList = new String[getLength()];
        for(int i=0; i<getLength();i++) {
            extraList[i] = getLandmark(i).getExtra();
        }
        return extraList;
    }

    public String [] getImage(){
        String [] imageList = new String[getLength()];
        for(int i=0; i<getLength();i++) {
            imageList[i] = getLandmark(i).getExtra();
        }
        return imageList;
    }
}