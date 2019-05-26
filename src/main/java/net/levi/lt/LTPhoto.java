
package net.levi.lt;

import java.util.List;

import com.google.gson.Gson;

public class LTPhoto {
    Gson gson = new Gson();

    public Data parseJSON(String json){
        return gson.fromJson(json, Data.class);
    }
    
    public List<Data> parseJSONList(String json){
        return null;
    }
    
    public class Data{
        int id;
        String title;

        @Override 
        public String toString(){
            return "["+id+"] "+title;
        }

    }

    public static void main(String[] args) {

    }
}
