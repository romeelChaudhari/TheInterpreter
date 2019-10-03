
package interpreter;
import interpreter.ByteCode.ByteCode;
import interpreter.ByteCodeLoader.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() throws IOException{
        Program program=new Program();
        ArrayList<String> al =new ArrayList<String>();
        String Lcode =byteSource.readLine();
        
        while(Lcode!=null)
        {
            al.clear();
          StringTokenizer token = new StringTokenizer(Lcode);
          

            String store_token = token.nextToken();

            if (store_token != null) {
                String codeClass = CodeTable.getClassName(store_token);
                while(token.hasMoreTokens() ) {           
                   al.add(token.nextToken());
                }

                try{
                    if (codeClass != null){
                        ByteCode byteCode = (ByteCode)(Class.forName("interpreter.ByteCode."+codeClass).newInstance());             
                        byteCode.init(al);            
                        program.add(byteCode);
                    }
                     Lcode = byteSource.readLine();
                }
                catch(InstantiationException |IllegalAccessException | ClassNotFoundException  e)
                {
                   System.out.println(" " + e +"has occured"+ "\n");  
        }
       return null;
    }

