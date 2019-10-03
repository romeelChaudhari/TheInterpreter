
Requirements :

1. Implement ALL the ByteCode classes listed in the table on page {129 or page 5 of this document}. Be sure to create the correct abstractions for the bytecodes. It is possible to have multiple abstractions within the set of byte codes classes.
2. Complete the implementation of the following classes a.ByteCodeLoader
b.Program
c.RuntimeStack
        d.Virtual Machine
      The Interpreter and CodeTable class have already been
      implemented for you. The Interpreter class is the entry
      point to this project. All projects will be graded using
      this entry point.
3.Make sure that all variables have their correct modifiers.
     Projects with all members being public will lose points.
4.Make sure not to break encapsulation. Projects that contain objects or classes trying to access members that it should not be allowed to will lose points. For example, if a bytecode needs to access or write to the runtime stack, it should NOT be allowed to. It needs to request these operations from the virtual machine. Then the virtual machine will carry out the operation.
     It is ill advised to take the naive approach and make a
     method in the virtual machine for each byte code, while it
     would work, this solution will produce a lot of duplicate
     code AND points will be deducted for this type of solution.
Notes about the attached pages.
• Some of the information in the attached pages may be out of date. BUT not much. For example, the pages call to use a vector for the runtime stack. Vectors in java, while they still exist are deprecated and new projects should not use them. You may use an ArrayList in its place.
