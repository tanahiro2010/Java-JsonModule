//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
public class Main {
    public static void main(String[] args) {
        JSON json = new JSON();
//        json.push("Hello", "world");
//        json.push("Good-by", "world");
//        json.Data_print();
//        json.All_print();
        json.parse("{\"Hello\": \"world!\", \"Good-by\": \"world!\"}");
        json.All_print();
        json.Data_print();
    }
}