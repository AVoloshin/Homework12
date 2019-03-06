import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class ParseJSON {
    public String getFile () {
        String stringJson = null;
        try {
            URL url = new URL("https://goo.gl/Hc8J4n");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            FileWriter writer = new FileWriter("json.txt")){
            String str;
            while ((str=bufferedReader.readLine())!=null){
                stringBuilder.append(str);
            }
            stringJson = stringBuilder.toString();
            System.out.println(stringJson);
            writer.write(stringBuilder.toString());
            } catch (MalformedInputException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringJson;
    }
    public Person [] parseGson (String stringJson){
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Wife.class, new WifeDeserialise()).create();
        Person [] person = gson.fromJson(stringJson, Person [].class);
        String newJson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Wife.class, new WifeSerialise()).create().toJson(person);
        System.out.println(newJson);
        return person;
    }
    public void parseJackson (String str){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //Person[] person = objectMapper.readValue(new File ("json.txt"), Person[].class);
            Person[] persons = objectMapper.readValue(str , Person[].class);
            String jackson = objectMapper.writeValueAsString(persons);
            System.out.println(jackson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void parseJson (Person[] persons){
        for (Person person: persons){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("age", person.age);
            jsonObject.put("name", person.name);
            jsonObject.put("isStudent", person.isStudent);
            if((person.wife)!=null){
                JSONObject wifeObj = new JSONObject();
                wifeObj.put(person.wife.name, person.wife.age);
                jsonObject.put("wife", wifeObj);
            } else jsonObject.put("wife", "");
            jsonObject.put("pet", person.pet);
            System.out.println(jsonObject.toString());
        }
    }

}
