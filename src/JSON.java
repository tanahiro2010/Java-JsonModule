import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Objects;

public final class JSON {
    String[][] data = new String[1000][2];
    String[][] keys = new String[1000][2];
    public int size = 1;
    public JSON(){
        System.out.println("JSON Constructor");
    }

    public boolean push(String key, String value){
        data[size][0] = key;
        data[size][1] = value;
        keys[size] = new String[]{key};
        if (size >= 1000){
            System.out.println("Can't push more than 1000 elements");
            return false;
        }
        size += 1;
        return true;
    }

    private int firstIndex(String[][] array, String index){
        int length = array.length;
        System.out.println("Length: " + length);

        for (int i = 0; i < length; i++){
            if (Objects.equals(array[i][0], index)){
                System.out.println("Index: " + i);
                return i;
            }
        }

        return 0;
    }

    public boolean pop(String key){
        int index = firstIndex(keys, key);
        if (index == 0){
            return false;
        }
        data[index] = new String[]{"deleted", "deleted"};

        return true;
    }

    void Data_print(){
        System.out.println("Array");
        for (int i = 0; i < size; i++){
            if (!Objects.equals(data[i][0], "deleted")){
                System.out.println(data[i][0] + " : " + data[i][1]);
            }
        }
    }

    public void All_print(){
        String display_data = "{";
        for (int i = 1; i < size; i++){
            if (!Objects.equals(data[i][0], "deleted")){
                display_data += "\"" + keys[i][0] + "\":\"" + data[i][1] + "\",";
            }
        }
        int len = display_data.length();
        display_data = display_data.substring(0, len - 1);

        display_data += "}";
        System.out.println(display_data);
    }

    public void parse(String json){
       char[] parse_data = json.toCharArray();

       if (parse_data[0] == '{' && parse_data[parse_data.length - 1] == '}'){
           parse_data = delete(parse_data, parse_data.length - 1);
           parse_data = delete(parse_data, 0);
           System.out.println(parse_data);

           String[] words = new String(parse_data).split(",");
           int len = words.length;
           String[][] json_final = new String[len*2][2];
           System.out.println("Length: " + len);
           for (int i = 0; i < len; i++){
               System.out.println(words[i]);
               json_final[i] = words[i].split(":");
               keys[i] = new String[]{words[i].split(":")[0]};
           }
           data = json_final;
       }
    }

    private char[] delete(char[] array, int index){
        final int len = array.length;
        System.out.println("Length: " + len);
        char[] returnArray = new char[len - 1];
        for (int j = 0, k = 0; j < len; j++){
            if (j != index){
                returnArray[k++] = array[j];
            }
        }

        return returnArray;
    }

}