package com.github.valkyrie.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.IntStack;
import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;

%%

%{
private static int let_balance = 0;
private static int comment_balance = 0;
private static boolean case_appearence = false;
private static String quote_balance = "";
private static IntStack brace_stack = new IntStack(9);

public _ValkyrieLexer() {
    this((java.io.Reader)null);
    init();
}
private static void init() {
    let_balance = 0;
    comment_balance = 0;
    case_appearence = false;
    quote_balance = "";
    brace_stack.clear();
}
public void state_begin(int state) {
    brace_stack.push(state);
    yybegin(state);
}
public void state_hold() {
    brace_stack.push(yystate());
}
public void state_end() {
    if (brace_stack.size() == 0) {
        yybegin(YYINITIAL);
    }
    else if (brace_stack.size() == 1) {
        brace_stack.pop();
        yybegin(YYINITIAL);
    }
    else {
        brace_stack.pop();
        yybegin(brace_stack.peek());
    }
}
public void match_indent() {
    // length may < indent_balance
    // t = yytext().length() - indent_balance - Length of Newline
    // yypushback(t);
}
%}

%public
%class _ValkyrieLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%eof{
    init();
%eof}

%state ImportExport
%state CommentBlock
%state Let
%state For
%state Forall
%state If
%state Class
%state Trait
%state Define
%state StringInside

WHITE_SPACE=[\s\t\r\n]
COMMENT_LINE = ("//")[^\r\n]*
COMMENT_INC = "//+"
COMMENT_DEC = "//-"
SYMBOL_XID=[\p{XID_Start}_][\p{XID_Continue}]*
SYMBOL_RAW=`([^`\\]|\\.)*`
BYTE=(0[bBoOxXfF][0-9A-Fa-f][0-9A-Fa-f_]*)
INTEGER=0|[1-9][0-9_]*
DECIMAL=[0-9]+\.[0-9]+

ESCAPE_SPECIAL= \\.
ESCAPE_UNICODE= \\(u{HEX}{4}|U{HEX}{6})
HEX = [0-9a-fA-F]

DEFINE = "define" | "def" | "func" | "fn";

%%

<YYINITIAL, Class, Trait, ImportExport, Let, For, Forall> {
    {COMMENT_INC}   {
        state_hold();
        comment_balance++;
        yybegin(CommentBlock);
        return COMMENT_LINE;
    }
    {COMMENT_LINE}  { return COMMENT_LINE; }
    {WHITE_SPACE}+  { return WHITE_SPACE; }
}
// ???????????????
<YYINITIAL> {
    "new" { return NEW; }
    "crate" { return MODULE; }
    "extension" { return EXTENSION; }
    "if" { return IF; }
    "else" { return ELSE; }
    "while" { return WHILE; }
    "match" { return MATCH; }
    "type" { return TYPE; }
}
// =====================================================================================================================
<CommentBlock> {COMMENT_INC} {
    comment_balance++;
    return COMMENT_LINE;
}
<CommentBlock> {COMMENT_DEC} {
    if (comment_balance == 1) {
        state_end();
        comment_balance--;
    }
    else {
        comment_balance--;
    }
    return COMMENT_LINE;
}
<CommentBlock> {
    [^/]+ {return COMMENT_LINE;}
    {WHITE_SPACE}+  { return COMMENT_LINE; }
}
// =====================================================================================================================
<YYINITIAL> "using" {
    yybegin(ImportExport);
    return IMPORT;
}
<ImportExport> "*" {
    return SYMBOL_RAW;
}
<ImportExport> ";" {
    yybegin(YYINITIAL);
    return SEMICOLON;
}
<ImportExport> "{" {
    state_begin(ImportExport);
    return BRACE_L;
}
<ImportExport> "}" {
    state_end();
    return BRACE_R;
}
// =====================================================================================================================
// ????????? let ?????????
<YYINITIAL> "let" | "var" | "val" {
    yybegin(Let);
    case_appearence = false;
    return LET;
}
<Let, For> {
    "(" { let_balance += 1 ; return PARENTHESIS_L; }
    ")" { let_balance -= 1 ; return PARENTHESIS_R; }
    "[" { let_balance += 1 ; return BRACKET_L; }
    "]" { let_balance -= 1 ; return BRACKET_R; }
    "{" { let_balance += 1 ; return BRACE_L; }
    "}" { let_balance -= 1 ; return BRACE_R; }
}
<Let> "=" {
    if (let_balance == 0) {
        yybegin(YYINITIAL);
        return BIND;
    }
    else {
        return BIND;
    }
}
<Let, For> "case" {
    if (case_appearence == false) {
        case_appearence = true;
        return CASE;
    }
    else {
        return SYMBOL_XID;
    }
}
<Let> ";" {
    state_begin(YYINITIAL);
    return SEMICOLON;
}
// =====================================================================================================================
// ????????? def ?????????
<YYINITIAL> {DEFINE} {
    return DEFINE;
}
// =====================================================================================================================
// ????????? bitflags ?????????
<YYINITIAL> "for" {
    yybegin(For);
    case_appearence = false;
    return FOR;
}
<For> "in" {
    if (let_balance == 0) {
        yybegin(YYINITIAL);
        return IN;
    }
    else {
        return SYMBOL_XID;
    }
}
// =====================================================================================================================
// ??????????????????, ?????????????????????
<YYINITIAL> "forall" | "???" {
    yybegin(Forall);
    return FORALL;
}
<Forall> {
    "type" {yybegin(Class);return TYPE;}
    "extends" | "impl" | "constructor" {yybegin(Class); return EXTENDS;}
    "class" | "struct" {yybegin(Class);return CLASS;}
    "bitflags" | "bitflag" | "bitset" {yybegin(Class);return BITFLAG;}
    "variant" | "tagged" | "enum" {yybegin(Class);return TAGGED;}
    {DEFINE} {yybegin(Class);return DEFINE;}
    "exists" | "???" {yybegin(Trait);return EXTENDS;}
    "trait" | "interface" {yybegin(Trait);return TRAIT;}
}
// =====================================================================================================================
<YYINITIAL> "class" | "struct" {
    yybegin(Class);
    return CLASS;
}
<YYINITIAL> "bitflags" | "bitflag" | "bitset" {
    yybegin(Class);
    return BITFLAG;
}
<YYINITIAL> "variant" | "tagged" | "enum" {
    yybegin(Class);
    return TAGGED;
}
<Class> {
    "{" {state_begin(Class); return BRACE_L;}
    "}" {state_end();    return BRACE_R;}
    "(" {state_begin(Class); return PARENTHESIS_L;}
    ")" {state_end();    return PARENTHESIS_R;}
}
// =====================================================================================================================
<YYINITIAL> "trait" | "interface" {
    yybegin(Trait);
    return TRAIT;
}
<YYINITIAL> "extends" | "impl" | "constructor" {
    yybegin(Trait);
    return EXTENDS;
}
<YYINITIAL> "exists" | "???" {
    yybegin(Trait);
    return EXTENDS;
}
<Trait> {
    "{" {state_begin(YYINITIAL); return BRACE_L;}
    "}" {state_end();    return BRACE_R;}
    "(" {state_begin(YYINITIAL); return PARENTHESIS_L;}
    ")" {state_end();    return PARENTHESIS_R;}
}
// =====================================================================================================================
<YYINITIAL, Class,Trait, ImportExport, Let, For, Forall> {
    {BYTE} { return BYTE; }
    {INTEGER} { return INTEGER; }
    {DECIMAL} { return DECIMAL; }
    {SYMBOL_XID} { return SYMBOL_XID; }
    {SYMBOL_RAW} { return SYMBOL_RAW; }
}
<YYINITIAL, Class,Trait, ImportExport, Let, For, Forall> {
    // !
    "!=" { return NE; }
    "!" { return BANG; }
    // < >
    "<<" | "???" { return LESS; }
    ">>" | "???" { return GREATER; }
    "{" { return BRACE_L; }
    "}" { return BRACE_R; }
    "<" { return ANGLE_L; }
    ">" { return ANGLE_R; }
    "[" { return BRACKET_L; }
    "]" { return BRACKET_R; }
    "(" { return PARENTHESIS_L; }
    ")" { return PARENTHESIS_R; }
    "^" { return ACCENT; }
    // :
    "???" | "::" { return PROPORTION; }
    ":" { return COLON; }
    ";" { return SEMICOLON; }
    "|" { return VERTICAL; }
    "$" { return DOLLAR; }
    "@" { return AT; }
    "#" { return HASH; }
    "&" { return AMP; }
    "?" { return QUESTION ; }
    // .
    "..." { return DOT3 ; }
    "..=" { return DOT_EQ; }
    "..<" { return DOT_LESS; }
    ".."  { return DOT2; }
    "." { return DOT; }
    "," { return COMMA; }
    "+" { return PLUS; }
    "->" { return TO; }
    "-" { return MINUS; }
    // =
    "==" { return EQ; }
    "=" { return BIND; }
}
// =====================================================================================================================
// String escaped highlight
//<StringQuote> {
//{ESCAPE_UNICODE} {return STRING_ESCAPE;}
//{ESCAPE_SPECIAL} {return STRING_ESCAPE;}
//[^\"]+ {return STRING_CHAR;}
//}
<YYINITIAL> \'+ | \"+ {
    if (yylength()==2) {
        return STRING_EMPTY;
    }
    quote_balance = yytext().toString();
    yybegin(StringInside);
    return STRING_START;
}
<StringInside> \'+ | \"+ {
    if(quote_balance.equals(yytext().toString())) {
        yybegin(YYINITIAL);
        return STRING_END;
    }
    return STRING_CHAR;
}
<StringInside> [^\'\"]+ {
    return STRING_CHAR;
}
// =====================================================================================================================
[^] { return BAD_CHARACTER; }
