/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * CREADA @Steven
 */
public class VarTDDeclaration extends SingleDeclaration{
    
   public VarTDDeclaration (Identifier iAST, TypeDenoter tAST,
                         SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
    T = tAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitVarTDDeclaration(this, o);
  }
  
  public Identifier I;
  public TypeDenoter T;
    
}
