/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * AGREGADO @STEVEN
 */
public class Function extends ProcFunc{

  public Function (Identifier iAST, FormalParameterSequence fpsAST, TypeDenoter tdAST,Expression eAST ,SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
    FPS = fpsAST;
    TD = tdAST;
    E = eAST;
  }
  
  public Object visit(Visitor v, Object o) {
    return v.visitFunction(this, o);
  }

  public Object visitXML(Visitor v, Object o) {
    return v.visitFunction(this, o);
  }
  
  public Identifier I;
  public FormalParameterSequence FPS;
  public TypeDenoter TD;
  public Expression E;    
}
