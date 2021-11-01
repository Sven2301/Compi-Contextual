/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  //Se crea un campo para guardar el separador si es que este existe.
  protected String separator;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  /* CAMBIOS (Austin)
    - Se agregaron las clases for, from, local, range, recursive, repeat, select, skip,
    to, until, when, | , .. 
    - Se eliminó la clase begin
    - Se reindexaron las clases */
  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    ARRAY		  = 4,
    CONST		  = 5,
    DO			  = 6,
    ELSE		  = 7,
    END			  = 8,
    FOR       = 9,
    FROM      = 10,
    FUNC		  = 11,
    IF			  = 12,
    IN			  = 13,
    LET			  = 14,
    LOCAL     = 15,
    OF			  = 16,
    PROC		  = 17,
    RANGE     = 18,
    RECORD	  = 19,
    RECURSIVE = 20,
    REPEAT    = 21,
    SKIP      = 22,
    THEN		  = 23,
    TO        = 24,
    TYPE		  = 25,
    UNTIL     = 26,
    VAR			  = 27,
    WHILE		  = 28,

    // punctuation...
    DOT			  = 29,
    DOUBLEDOT = 30,
    COLON		  = 31,
    SEMICOLON	= 32,
    COMMA		  = 33,
    PIPE      = 34,
    BECOMES   = 35,
    IS			  = 36,

    // brackets...
    LPAREN		= 37,
    RPAREN		= 38,
    LBRACKET	= 39,
    RBRACKET	= 40,
    LCURLY		= 41,
    RCURLY		= 42,

    // special tokens...
    EOT			= 43,
    ERROR		= 44;

  private static String[] tokenTable = new String[] {
    "<int>",        // 0
    "<char>",       // 1
    "<identifier>", // 2
    "<operator>",   // 3
    "array",        // 4
    "const",        // 5
    "do",           // 6
    "else",         // 7
    "end",          // 8
    "for",          // 9
    "from",         // 10
    "func",         // 11
    "if",           // 12
    "in",           // 13
    "let",          // 14
    "local",        // 15
    "of",           // 16
    "proc",         // 17
    "range",        // 18
    "record",       // 19
    "recursive",    // 20
    "repeat",       // 21
    "skip",         // 22
    "then",         // 23
    "to",           // 24
    "type",         // 25
    "until",        // 26
    "var",          // 27
    "while",        // 28
    ".",            // 29
    "..",           // 30
    ":",            // 31
    ":",            // 32
    ",",            // 33
    "|",            // 34
    ":=",           // 35
    "~",            // 36
    "(",            // 37
    ")",            // 38
    "[",            // 39
    "]",            // 40
    "{",            // 41
    "}",            // 42
    "",             // 43
    "<error>"       // 44
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;


  //Retorna su separador. Si se creo algo en el scanner entonces se retorna sino devuelve un "" este metodo es solo
  //Para ser usado en el generador de HTMl (Fernando)
  //El addSeparator solo asigna el nuevo separador.
  public void addSeparator(String separator){
    this.separator = separator;
  }
}
