/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author USER
 */
public class CompoundIfCommand extends Command{
  public CompoundIfCommand (Expression eAST, Command c1AST, ElsifCommand eiAST, Command c2AST,
                    SourcePosition thePosition) {
    super (thePosition);
    E = eAST;
    C1 = c1AST;
    EIC = eiAST;
    C2 = c2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitCompoundIfCommand(this, o);
  }

  public Object visitXML(Visitor v, Object o) {
    return v.visitCompoundIfCommand(this, o);
  }

  public Expression E;
  public Command C1, C2;
  public ElsifCommand EIC;

}
