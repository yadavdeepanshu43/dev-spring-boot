//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);

        String str= "Dipanshu Yadav";
        System.out.println("Dipanshu");
        //write a program to pint occurance of each character of dipanshu Yadav

        for(int i=0;i<str.length(); i++)
        {
            char ch= str.charAt(i);
            int count=0;

            if(str.indexOf(ch)<i){
                continue;
            }

            for(int j=0;j<str.length();j++)
            {
                if(str.charAt(j)==ch){
                    count++;
                }
            }
            System.out.println(ch+ " " +count);

        }
        }

}