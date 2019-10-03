package interpreter;

import interpreter.ByteCode.ByteCode;
import interpreter.ByteCode.DumpCode;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    public String dumpingState="OFF";

    protected VirtualMachine(Program program) {
        this.program = program;
    }
    public void executeProgram()
    {
        pc=0;
        runStack=new RunTimeStack();
        returnAddrs=new Stack();
        isRunning = true;
        
        while(isRunning)
        {
            ByteCode code= program.getCode(pc);
            code.execute(this);
            if("ON".equals(dumpingState) && !(code instanceof DumpCode))
            {
               runStack.dump();
            }
            
        }
    }

}
