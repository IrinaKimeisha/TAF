package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseAdapter {
    Gson gson;
    public BaseAdapter(){
        gson = new Gson();
       /* gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() //исключить в дес/сереал поля у которых нет экспоус аннотация
                .create();*/


    }
}
