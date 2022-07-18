// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import static com.github.valkyrie.language.psi.ValkyrieParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ValkyrieParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return valkyrie(b, l + 1);
  }

  /* ********************************************************** */
  // "as"
  public static boolean AS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AS")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AS, "<as>");
    r = consumeToken(b, "as");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ANGLE_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] ANGLE_R
  static boolean angle_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block")) return false;
    if (!nextTokenIs(b, ANGLE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANGLE_L);
    r = r && angle_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, ANGLE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean angle_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block_1")) return false;
    angle_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean angle_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && angle_block_1_0_1(b, l + 1, _sp, _item);
    r = r && angle_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean angle_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "angle_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!angle_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "angle_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean angle_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "angle_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean angle_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "angle_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // number | string | boolean | namespace
  static boolean atoms(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atoms")) return false;
    boolean r;
    r = number(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = namespace(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block (bitflag_item | macro_call) SEMICOLON>>
  public static boolean bitflag_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::bitflag_block_0_0, SEMICOLON_parser_);
    exit_section_(b, m, BITFLAG_BLOCK, r);
    return r;
  }

  // bitflag_item | macro_call
  private static boolean bitflag_block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_block_0_0")) return false;
    boolean r;
    r = bitflag_item(b, l + 1);
    if (!r) r = macro_call(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // identifier BIND expression
  public static boolean bitflag_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BITFLAG_ITEM, "<bitflag item>");
    r = identifier(b, l + 1);
    r = r && consumeToken(b, BIND);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L type_expression PARENTHESIS_R
  public static boolean bitflag_layout(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_layout")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && type_expression(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, BITFLAG_LAYOUT, r);
    return r;
  }

  /* ********************************************************** */
  // BITFLAG modifier_symbols [bitflag_layout] bitflag_block
  public static boolean bitflag_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement")) return false;
    if (!nextTokenIs(b, BITFLAG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITFLAG);
    r = r && modifier_symbols(b, l + 1);
    r = r && bitflag_statement_2(b, l + 1);
    r = r && bitflag_block(b, l + 1);
    exit_section_(b, m, BITFLAG_STATEMENT, r);
    return r;
  }

  // [bitflag_layout]
  private static boolean bitflag_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement_2")) return false;
    bitflag_layout(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block expression SEMICOLON>>
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::expression, SEMICOLON_parser_);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // "true" | "false"
  public static boolean boolean_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN, "<boolean $>");
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BRACE_L (<<item>>|<<sp>>)* BRACE_R
  static boolean brace_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<item>>|<<sp>>)*
  private static boolean brace_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_block_1_0(b, l + 1, _item, _sp)) break;
      if (!empty_element_parsed_guard_(b, "brace_block_1", c)) break;
    }
    return true;
  }

  // <<item>>|<<sp>>
  private static boolean brace_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    if (!r) r = _sp.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BRACKET_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACKET_R
  static boolean bracket_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && bracket_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean bracket_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1")) return false;
    bracket_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean bracket_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && bracket_block_1_0_1(b, l + 1, _sp, _item);
    r = r && bracket_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean bracket_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bracket_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "bracket_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean bracket_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean bracket_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis expression COMMA>>
  public static boolean call_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_suffix")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    exit_section_(b, m, CALL_SUFFIX, r);
    return r;
  }

  /* ********************************************************** */
  // CASE [identifier* [namespace]] pattern
  public static boolean case_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && case_pattern_1(b, l + 1);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, CASE_PATTERN, r);
    return r;
  }

  // [identifier* [namespace]]
  private static boolean case_pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1")) return false;
    case_pattern_1_0(b, l + 1);
    return true;
  }

  // identifier* [namespace]
  private static boolean case_pattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_pattern_1_0_0(b, l + 1);
    r = r && case_pattern_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean case_pattern_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_pattern_1_0_0", c)) break;
    }
    return true;
  }

  // [namespace]
  private static boolean case_pattern_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1_0_1")) return false;
    namespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block class_brace_item (COMMA|SEMICOLON)>>
  public static boolean class_brace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_brace")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::class_brace_item, ValkyrieParser::class_brace_0_1);
    exit_section_(b, m, CLASS_BRACE, r);
    return r;
  }

  // COMMA|SEMICOLON
  private static boolean class_brace_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_brace_0_1")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // (class_numeric_key | modifier_symbols) COLON type_expression [BIND expression]
  public static boolean class_brace_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_brace_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_BRACE_ITEM, "<class brace item>");
    r = class_brace_item_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    r = r && class_brace_item_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // class_numeric_key | modifier_symbols
  private static boolean class_brace_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_brace_item_0")) return false;
    boolean r;
    r = class_numeric_key(b, l + 1);
    if (!r) r = modifier_symbols(b, l + 1);
    return r;
  }

  // [BIND expression]
  private static boolean class_brace_item_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_brace_item_3")) return false;
    class_brace_item_3_0(b, l + 1);
    return true;
  }

  // BIND expression
  private static boolean class_brace_item_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_brace_item_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BIND);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [modifier_symbols] INTEGER
  public static boolean class_numeric_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_numeric_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_NUMERIC_KEY, "<class numeric key>");
    r = class_numeric_key_0(b, l + 1);
    r = r && consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifier_symbols]
  private static boolean class_numeric_key_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_numeric_key_0")) return false;
    modifier_symbols(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // CLASS modifier_symbols [[PROPORTION] type_angle] [COLON identifier] [class_tuple|class_brace]
  public static boolean class_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement")) return false;
    if (!nextTokenIs(b, CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS);
    r = r && modifier_symbols(b, l + 1);
    r = r && class_statement_2(b, l + 1);
    r = r && class_statement_3(b, l + 1);
    r = r && class_statement_4(b, l + 1);
    exit_section_(b, m, CLASS_STATEMENT, r);
    return r;
  }

  // [[PROPORTION] type_angle]
  private static boolean class_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_2")) return false;
    class_statement_2_0(b, l + 1);
    return true;
  }

  // [PROPORTION] type_angle
  private static boolean class_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = class_statement_2_0_0(b, l + 1);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [PROPORTION]
  private static boolean class_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_2_0_0")) return false;
    consumeToken(b, PROPORTION);
    return true;
  }

  // [COLON identifier]
  private static boolean class_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_3")) return false;
    class_statement_3_0(b, l + 1);
    return true;
  }

  // COLON identifier
  private static boolean class_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [class_tuple|class_brace]
  private static boolean class_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_4")) return false;
    class_statement_4_0(b, l + 1);
    return true;
  }

  // class_tuple|class_brace
  private static boolean class_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_4_0")) return false;
    boolean r;
    r = class_tuple(b, l + 1);
    if (!r) r = class_brace(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // <<parenthesis class_tuple_item COMMA>>
  public static boolean class_tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_tuple")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::class_tuple_item, COMMA_parser_);
    exit_section_(b, m, CLASS_TUPLE, r);
    return r;
  }

  /* ********************************************************** */
  // type_expression [BIND expression]
  public static boolean class_tuple_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_tuple_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_TUPLE_ITEM, "<class tuple item>");
    r = type_expression(b, l + 1);
    r = r && class_tuple_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [BIND expression]
  private static boolean class_tuple_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_tuple_item_1")) return false;
    class_tuple_item_1_0(b, l + 1);
    return true;
  }

  // BIND expression
  private static boolean class_tuple_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_tuple_item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BIND);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // case_pattern BIND expression | expression
  public static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION, "<condition>");
    r = condition_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // case_pattern BIND expression
  private static boolean condition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_pattern(b, l + 1);
    r = r && consumeToken(b, BIND);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block normal_statements SEMICOLON>>
  public static boolean def_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::normal_statements, SEMICOLON_parser_);
    exit_section_(b, m, DEF_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // def_item_sign | modifier_symbols [(DOT2|DOT3) identifier] [COLON type_expression] [BIND expression]
  public static boolean def_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEF_ITEM, "<def item>");
    r = def_item_sign(b, l + 1);
    if (!r) r = def_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // modifier_symbols [(DOT2|DOT3) identifier] [COLON type_expression] [BIND expression]
  private static boolean def_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modifier_symbols(b, l + 1);
    r = r && def_item_1_1(b, l + 1);
    r = r && def_item_1_2(b, l + 1);
    r = r && def_item_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(DOT2|DOT3) identifier]
  private static boolean def_item_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_item_1_1")) return false;
    def_item_1_1_0(b, l + 1);
    return true;
  }

  // (DOT2|DOT3) identifier
  private static boolean def_item_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_item_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = def_item_1_1_0_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT2|DOT3
  private static boolean def_item_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_item_1_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, DOT2);
    if (!r) r = consumeToken(b, DOT3);
    return r;
  }

  // [COLON type_expression]
  private static boolean def_item_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_item_1_2")) return false;
    def_item_1_2_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean def_item_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_item_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [BIND expression]
  private static boolean def_item_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_item_1_3")) return false;
    def_item_1_3_0(b, l + 1);
    return true;
  }

  // BIND expression
  private static boolean def_item_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_item_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BIND);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ANGLE_L | ANGLE_R
  public static boolean def_item_sign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_item_sign")) return false;
    if (!nextTokenIs(b, "<def item sign>", ANGLE_L, ANGLE_R)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEF_ITEM_SIGN, "<def item sign>");
    r = consumeToken(b, ANGLE_L);
    if (!r) r = consumeToken(b, ANGLE_R);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DEFINE modifier_symbols [[PROPORTION] type_angle] def_tuple [(COLON|TO) type_expression] [def_block| BIND expression]
  public static boolean def_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement")) return false;
    if (!nextTokenIs(b, DEFINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFINE);
    r = r && modifier_symbols(b, l + 1);
    r = r && def_statement_2(b, l + 1);
    r = r && def_tuple(b, l + 1);
    r = r && def_statement_4(b, l + 1);
    r = r && def_statement_5(b, l + 1);
    exit_section_(b, m, DEF_STATEMENT, r);
    return r;
  }

  // [[PROPORTION] type_angle]
  private static boolean def_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement_2")) return false;
    def_statement_2_0(b, l + 1);
    return true;
  }

  // [PROPORTION] type_angle
  private static boolean def_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = def_statement_2_0_0(b, l + 1);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [PROPORTION]
  private static boolean def_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement_2_0_0")) return false;
    consumeToken(b, PROPORTION);
    return true;
  }

  // [(COLON|TO) type_expression]
  private static boolean def_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement_4")) return false;
    def_statement_4_0(b, l + 1);
    return true;
  }

  // (COLON|TO) type_expression
  private static boolean def_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = def_statement_4_0_0(b, l + 1);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON|TO
  private static boolean def_statement_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement_4_0_0")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, TO);
    return r;
  }

  // [def_block| BIND expression]
  private static boolean def_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement_5")) return false;
    def_statement_5_0(b, l + 1);
    return true;
  }

  // def_block| BIND expression
  private static boolean def_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = def_block(b, l + 1);
    if (!r) r = def_statement_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BIND expression
  private static boolean def_statement_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_statement_5_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BIND);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<parenthesis def_item COMMA>>
  public static boolean def_tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "def_tuple")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::def_item, COMMA_parser_);
    exit_section_(b, m, DEF_TUPLE, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE IF condition block
  public static boolean ef_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ef_statement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, IF);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, EF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE block
  public static boolean else_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, m, ELSE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // op_prefix* term (op_suffix|call_suffix|PROPORTION type_angle|slice_suffix)*
  static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr_0(b, l + 1);
    r = r && term(b, l + 1);
    r = r && expr_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // op_prefix*
  private static boolean expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!op_prefix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_0", c)) break;
    }
    return true;
  }

  // (op_suffix|call_suffix|PROPORTION type_angle|slice_suffix)*
  private static boolean expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_2", c)) break;
    }
    return true;
  }

  // op_suffix|call_suffix|PROPORTION type_angle|slice_suffix
  private static boolean expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_suffix(b, l + 1);
    if (!r) r = call_suffix(b, l + 1);
    if (!r) r = expr_2_0_2(b, l + 1);
    if (!r) r = slice_suffix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PROPORTION type_angle
  private static boolean expr_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPORTION);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr (op_binary expr)*
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = expr(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (op_binary expr)*
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_1", c)) break;
    }
    return true;
  }

  // op_binary expr
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = op_binary(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EXTENDS modifier_symbols [[PROPORTION] type_angle] [COLON type_expression] trait_block
  public static boolean extends_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement")) return false;
    if (!nextTokenIs(b, EXTENDS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && modifier_symbols(b, l + 1);
    r = r && extends_statement_2(b, l + 1);
    r = r && extends_statement_3(b, l + 1);
    r = r && trait_block(b, l + 1);
    exit_section_(b, m, EXTENDS_STATEMENT, r);
    return r;
  }

  // [[PROPORTION] type_angle]
  private static boolean extends_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_2")) return false;
    extends_statement_2_0(b, l + 1);
    return true;
  }

  // [PROPORTION] type_angle
  private static boolean extends_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = extends_statement_2_0_0(b, l + 1);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [PROPORTION]
  private static boolean extends_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_2_0_0")) return false;
    consumeToken(b, PROPORTION);
    return true;
  }

  // [COLON type_expression]
  private static boolean extends_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_3")) return false;
    extends_statement_3_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean extends_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EXTENSION identifier
  public static boolean extension_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_statement")) return false;
    if (!nextTokenIs(b, EXTENSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENSION);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, EXTENSION_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // FOR (case_pattern|normal_pattern) IN expression [if_guard] block [else_statement]
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && for_statement_1(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && expression(b, l + 1);
    r = r && for_statement_4(b, l + 1);
    r = r && block(b, l + 1);
    r = r && for_statement_6(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  // case_pattern|normal_pattern
  private static boolean for_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_1")) return false;
    boolean r;
    r = case_pattern(b, l + 1);
    if (!r) r = normal_pattern(b, l + 1);
    return r;
  }

  // [if_guard]
  private static boolean for_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_4")) return false;
    if_guard(b, l + 1);
    return true;
  }

  // [else_statement]
  private static boolean for_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_6")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block (type_expression COLON type_expression) (COMMA|SEMICOLON)>>
  public static boolean forall_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::forall_block_0_0, ValkyrieParser::forall_block_0_1);
    exit_section_(b, m, FORALL_BLOCK, r);
    return r;
  }

  // type_expression COLON type_expression
  private static boolean forall_block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_block_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA|SEMICOLON
  private static boolean forall_block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_block_0_1")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // FORALL <<sequence identifier COMMA>> [forall_block]
  public static boolean forall_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_statement")) return false;
    if (!nextTokenIs(b, FORALL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FORALL);
    r = r && sequence(b, l + 1, ValkyrieParser::identifier, COMMA_parser_);
    r = r && forall_statement_2(b, l + 1);
    exit_section_(b, m, FORALL_STATEMENT, r);
    return r;
  }

  // [forall_block]
  private static boolean forall_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forall_statement_2")) return false;
    forall_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // [AT|HASH](SYMBOL_XID | SYMBOL_RAW)
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    r = identifier_0(b, l + 1);
    r = r && identifier_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [AT|HASH]
  private static boolean identifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_0")) return false;
    identifier_0_0(b, l + 1);
    return true;
  }

  // AT|HASH
  private static boolean identifier_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_0_0")) return false;
    boolean r;
    r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, HASH);
    return r;
  }

  // SYMBOL_XID | SYMBOL_RAW
  private static boolean identifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_1")) return false;
    boolean r;
    r = consumeToken(b, SYMBOL_XID);
    if (!r) r = consumeToken(b, SYMBOL_RAW);
    return r;
  }

  /* ********************************************************** */
  // IF condition
  public static boolean if_guard(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_guard")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && condition(b, l + 1);
    exit_section_(b, m, IF_GUARD, r);
    return r;
  }

  /* ********************************************************** */
  // (IF condition block) [ef_statement* [else_statement]]
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_0(b, l + 1);
    r = r && if_statement_1(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // IF condition block
  private static boolean if_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ef_statement* [else_statement]]
  private static boolean if_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1")) return false;
    if_statement_1_0(b, l + 1);
    return true;
  }

  // ef_statement* [else_statement]
  private static boolean if_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_1_0_0(b, l + 1);
    r = r && if_statement_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ef_statement*
  private static boolean if_statement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ef_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_1_0_0", c)) break;
    }
    return true;
  }

  // [else_statement]
  private static boolean if_statement_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0_1")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block import_item COMMA>>
  public static boolean import_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::import_item, COMMA_parser_);
    exit_section_(b, m, IMPORT_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // PROPORTION | DOT
  public static boolean import_dot(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_dot")) return false;
    if (!nextTokenIs(b, "<import dot>", DOT, PROPORTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_DOT, "<import dot>");
    r = consumeToken(b, PROPORTION);
    if (!r) r = consumeToken(b, DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (identifier import_dot)* import_block | import_rename
  public static boolean import_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_ITEM, "<import item>");
    r = import_item_0(b, l + 1);
    if (!r) r = import_rename(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (identifier import_dot)* import_block
  private static boolean import_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_item_0_0(b, l + 1);
    r = r && import_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (identifier import_dot)*
  private static boolean import_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_item_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_item_0_0", c)) break;
    }
    return true;
  }

  // identifier import_dot
  private static boolean import_item_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && import_dot(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier (import_dot identifier)* [AS identifier]
  public static boolean import_rename(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rename")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_RENAME, "<import rename>");
    r = identifier(b, l + 1);
    r = r && import_rename_1(b, l + 1);
    r = r && import_rename_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (import_dot identifier)*
  private static boolean import_rename_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rename_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_rename_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_rename_1", c)) break;
    }
    return true;
  }

  // import_dot identifier
  private static boolean import_rename_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rename_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_dot(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [AS identifier]
  private static boolean import_rename_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rename_2")) return false;
    import_rename_2_0(b, l + 1);
    return true;
  }

  // AS identifier
  private static boolean import_rename_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rename_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AS(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT import_block
  public static boolean import_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT);
    r = r && import_block(b, l + 1);
    exit_section_(b, m, IMPORT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // LET normal_pattern [let_type_hint] [BIND expression]
  //   | LET case_pattern BIND expression
  public static boolean let_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = let_statement_0(b, l + 1);
    if (!r) r = let_statement_1(b, l + 1);
    exit_section_(b, m, LET_STATEMENT, r);
    return r;
  }

  // LET normal_pattern [let_type_hint] [BIND expression]
  private static boolean let_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && normal_pattern(b, l + 1);
    r = r && let_statement_0_2(b, l + 1);
    r = r && let_statement_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [let_type_hint]
  private static boolean let_statement_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_0_2")) return false;
    let_type_hint(b, l + 1);
    return true;
  }

  // [BIND expression]
  private static boolean let_statement_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_0_3")) return false;
    let_statement_0_3_0(b, l + 1);
    return true;
  }

  // BIND expression
  private static boolean let_statement_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BIND);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LET case_pattern BIND expression
  private static boolean let_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && case_pattern(b, l + 1);
    r = r && consumeToken(b, BIND);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON <<sequence type_expression COMMA>>
  public static boolean let_type_hint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_type_hint")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && sequence(b, l + 1, ValkyrieParser::type_expression, COMMA_parser_);
    exit_section_(b, m, LET_TYPE_HINT, r);
    return r;
  }

  /* ********************************************************** */
  // <<bracket_block expression COMMA>>
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    exit_section_(b, m, LIST, r);
    return r;
  }

  /* ********************************************************** */
  // macro [macro_item]
  public static boolean macro_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_call")) return false;
    if (!nextTokenIs(b, MACRO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MACRO);
    r = r && macro_call_1(b, l + 1);
    exit_section_(b, m, MACRO_CALL, r);
    return r;
  }

  // [macro_item]
  private static boolean macro_call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_call_1")) return false;
    macro_item(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis expression COMMA>>
  //   | <<brace_block pair COMMA>>
  //   | <<brace_block expression SEMICOLON>>
  public static boolean macro_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_item")) return false;
    if (!nextTokenIs(b, "<macro item>", BRACE_L, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_ITEM, "<macro item>");
    r = parenthesis(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    if (!r) r = brace_block(b, l + 1, ValkyrieParser::pair, COMMA_parser_);
    if (!r) r = brace_block(b, l + 1, ValkyrieParser::expression, SEMICOLON_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [AT|HASH] <<bracket_block (namespace macro_item) COMMA>>
  public static boolean macro_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_LIST, "<macro list>");
    r = macro_list_0(b, l + 1);
    r = r && bracket_block(b, l + 1, ValkyrieParser::macro_list_1_0, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [AT|HASH]
  private static boolean macro_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list_0")) return false;
    macro_list_0_0(b, l + 1);
    return true;
  }

  // AT|HASH
  private static boolean macro_list_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list_0_0")) return false;
    boolean r;
    r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, HASH);
    return r;
  }

  // namespace macro_item
  private static boolean macro_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namespace(b, l + 1);
    r = r && macro_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block match_expression SEMICOLON>>
  public static boolean match_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::match_expression, SEMICOLON_parser_);
    exit_section_(b, m, MATCH_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // case_pattern COLON (normal_statements [SEMICOLON])+
  public static boolean match_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_pattern(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && match_expression_2(b, l + 1);
    exit_section_(b, m, MATCH_EXPRESSION, r);
    return r;
  }

  // (normal_statements [SEMICOLON])+
  private static boolean match_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = match_expression_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!match_expression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_expression_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // normal_statements [SEMICOLON]
  private static boolean match_expression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = normal_statements(b, l + 1);
    r = r && match_expression_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SEMICOLON]
  private static boolean match_expression_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_expression_2_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // MATCH identifier* match_block
  public static boolean match_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_statement")) return false;
    if (!nextTokenIs(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MATCH);
    r = r && match_statement_1(b, l + 1);
    r = r && match_block(b, l + 1);
    exit_section_(b, m, MATCH_STATEMENT, r);
    return r;
  }

  // identifier*
  private static boolean match_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_statement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "match_statement_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // identifier+
  public static boolean modifier_symbols(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_symbols")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIER_SYMBOLS, "<modifier symbols>");
    r = identifier(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifier_symbols", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier (PROPORTION identifier)*
  public static boolean namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE, "<namespace>");
    r = identifier(b, l + 1);
    r = r && namespace_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PROPORTION identifier)*
  private static boolean namespace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namespace_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespace_1", c)) break;
    }
    return true;
  }

  // PROPORTION identifier
  private static boolean namespace_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPORTION);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_NAMESPACE identifier
  public static boolean namespace_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_statement")) return false;
    if (!nextTokenIs(b, KW_NAMESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_NAMESPACE);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, NAMESPACE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // NEW modifier_symbols [[PROPORTION] type_angle] [COLON type_expression] trait_block
  public static boolean new_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement")) return false;
    if (!nextTokenIs(b, NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW);
    r = r && modifier_symbols(b, l + 1);
    r = r && new_statement_2(b, l + 1);
    r = r && new_statement_3(b, l + 1);
    r = r && trait_block(b, l + 1);
    exit_section_(b, m, NEW_STATEMENT, r);
    return r;
  }

  // [[PROPORTION] type_angle]
  private static boolean new_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_2")) return false;
    new_statement_2_0(b, l + 1);
    return true;
  }

  // [PROPORTION] type_angle
  private static boolean new_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = new_statement_2_0_0(b, l + 1);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [PROPORTION]
  private static boolean new_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_2_0_0")) return false;
    consumeToken(b, PROPORTION);
    return true;
  }

  // [COLON type_expression]
  private static boolean new_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_3")) return false;
    new_statement_3_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean new_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier* pattern | <<sequence pattern_item COMMA>>
  public static boolean normal_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NORMAL_PATTERN, "<normal pattern>");
    r = normal_pattern_0(b, l + 1);
    if (!r) r = sequence(b, l + 1, ValkyrieParser::pattern_item, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier* pattern
  private static boolean normal_pattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = normal_pattern_0_0(b, l + 1);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean normal_pattern_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_pattern_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "normal_pattern_0_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // if_statement
  //   | for_statement
  //   | while_statement
  //   | match_statement
  //   | let_statement
  //   | def_statement
  //   | type_statement
  //   | forall_statement
  // //  | macro_list
  // //  | macro_call
  //   | expression
  static boolean normal_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_statements")) return false;
    boolean r;
    r = if_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    if (!r) r = match_statement(b, l + 1);
    if (!r) r = let_statement(b, l + 1);
    if (!r) r = def_statement(b, l + 1);
    if (!r) r = type_statement(b, l + 1);
    if (!r) r = forall_statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // number_literal [identifier]
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = number_literal(b, l + 1);
    r = r && number_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [identifier]
  private static boolean number_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_1")) return false;
    identifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BYTE | INTEGER | DECIMAL
  public static boolean number_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
    r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // type_binary | ANGLE_L | ANGLE_R | LESS | GREATER | DOT_LESS | DOT_EQ | DOT2 | DOT
  static boolean op_binary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_binary")) return false;
    boolean r;
    r = type_binary(b, l + 1);
    if (!r) r = consumeToken(b, ANGLE_L);
    if (!r) r = consumeToken(b, ANGLE_R);
    if (!r) r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, DOT_LESS);
    if (!r) r = consumeToken(b, DOT_EQ);
    if (!r) r = consumeToken(b, DOT2);
    if (!r) r = consumeToken(b, DOT);
    return r;
  }

  /* ********************************************************** */
  // PLUS | MINUS | NOT | BANG | AMP | DOT3 | DOT2
  static boolean op_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_prefix")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, AMP);
    if (!r) r = consumeToken(b, DOT3);
    if (!r) r = consumeToken(b, DOT2);
    return r;
  }

  /* ********************************************************** */
  // BANG | QUESTION
  static boolean op_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "op_suffix")) return false;
    if (!nextTokenIs(b, "", BANG, QUESTION)) return false;
    boolean r;
    r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, QUESTION);
    return r;
  }

  /* ********************************************************** */
  // atoms COLON expression
  public static boolean pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PAIR, "<pair>");
    r = atoms(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] PARENTHESIS_R
  static boolean parenthesis(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && parenthesis_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean parenthesis_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1")) return false;
    parenthesis_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean parenthesis_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && parenthesis_1_0_1(b, l + 1, _sp, _item);
    r = r && parenthesis_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean parenthesis_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parenthesis_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "parenthesis_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean parenthesis_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean parenthesis_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis   pattern_pair COMMA>>
  //   | <<bracket_block pattern_pair COMMA>>
  //   | <<brace_block   pattern_pair COMMA>>
  static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::pattern_pair, COMMA_parser_);
    if (!r) r = bracket_block(b, l + 1, ValkyrieParser::pattern_pair, COMMA_parser_);
    if (!r) r = brace_block(b, l + 1, ValkyrieParser::pattern_pair, COMMA_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier* (DOT3|DOT2) identifier | identifier+
  public static boolean pattern_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_ITEM, "<pattern item>");
    r = pattern_item_0(b, l + 1);
    if (!r) r = pattern_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier* (DOT3|DOT2) identifier
  private static boolean pattern_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_item_0_0(b, l + 1);
    r = r && pattern_item_0_1(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean pattern_item_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_item_0_0", c)) break;
    }
    return true;
  }

  // DOT3|DOT2
  private static boolean pattern_item_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_0_1")) return false;
    boolean r;
    r = consumeToken(b, DOT3);
    if (!r) r = consumeToken(b, DOT2);
    return r;
  }

  // identifier+
  private static boolean pattern_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_item_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier* COLON pattern_value | identifier* (DOT3|DOT2) identifier | identifier+
  public static boolean pattern_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_PAIR, "<pattern pair>");
    r = pattern_pair_0(b, l + 1);
    if (!r) r = pattern_pair_1(b, l + 1);
    if (!r) r = pattern_pair_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier* COLON pattern_value
  private static boolean pattern_pair_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_pair_0_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && pattern_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean pattern_pair_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_pair_0_0", c)) break;
    }
    return true;
  }

  // identifier* (DOT3|DOT2) identifier
  private static boolean pattern_pair_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_pair_1_0(b, l + 1);
    r = r && pattern_pair_1_1(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier*
  private static boolean pattern_pair_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_pair_1_0", c)) break;
    }
    return true;
  }

  // DOT3|DOT2
  private static boolean pattern_pair_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_1_1")) return false;
    boolean r;
    r = consumeToken(b, DOT3);
    if (!r) r = consumeToken(b, DOT2);
    return r;
  }

  // identifier+
  private static boolean pattern_pair_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_pair_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!identifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_pair_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier | pattern
  public static boolean pattern_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_VALUE, "<pattern value>");
    r = identifier(b, l + 1);
    if (!r) r = pattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  static boolean sequence(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "sequence")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && sequence_1(b, l + 1, _sp, _item);
    r = r && sequence_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean sequence_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "sequence_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sequence_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "sequence_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean sequence_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "sequence_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean sequence_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "sequence_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // [expression] COLON [expression] COLON [expression]
  //   | [expression] COLON [expression]
  //   | [expression] PROPORTION [expression]
  //   | expression
  public static boolean slice_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SLICE_EXPRESSION, "<slice expression>");
    r = slice_expression_0(b, l + 1);
    if (!r) r = slice_expression_1(b, l + 1);
    if (!r) r = slice_expression_2(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [expression] COLON [expression] COLON [expression]
  private static boolean slice_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_expression_0_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && slice_expression_0_2(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && slice_expression_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean slice_expression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_0_0")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_expression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_0_2")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_expression_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_0_4")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression] COLON [expression]
  private static boolean slice_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_expression_1_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && slice_expression_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean slice_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_1_0")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_expression_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_1_2")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression] PROPORTION [expression]
  private static boolean slice_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_expression_2_0(b, l + 1);
    r = r && consumeToken(b, PROPORTION);
    r = r && slice_expression_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression]
  private static boolean slice_expression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_2_0")) return false;
    expression(b, l + 1);
    return true;
  }

  // [expression]
  private static boolean slice_expression_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_2_2")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<bracket_block slice_expression COMMA>>
  public static boolean slice_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_suffix")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, ValkyrieParser::slice_expression, COMMA_parser_);
    exit_section_(b, m, SLICE_SUFFIX, r);
    return r;
  }

  /* ********************************************************** */
  // [identifier] string_literal
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = string_0(b, l + 1);
    r = r && string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [identifier]
  private static boolean string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_0")) return false;
    identifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STRING_EMPTY | STRING_START STRING_CHAR+ STRING_END
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, "<string literal>", STRING_EMPTY, STRING_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = consumeToken(b, STRING_EMPTY);
    if (!r) r = string_literal_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING_START STRING_CHAR+ STRING_END
  private static boolean string_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_START);
    r = r && string_literal_1_1(b, l + 1);
    r = r && consumeToken(b, STRING_END);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_CHAR+
  private static boolean string_literal_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_CHAR);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, STRING_CHAR)) break;
      if (!empty_element_parsed_guard_(b, "string_literal_1_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block tagged_item (COMMA|SEMICOLON)>>
  public static boolean tagged_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::tagged_item, ValkyrieParser::tagged_block_0_1);
    exit_section_(b, m, TAGGED_BLOCK, r);
    return r;
  }

  // COMMA|SEMICOLON
  private static boolean tagged_block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_block_0_1")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // identifier [class_tuple|class_brace]
  public static boolean tagged_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAGGED_ITEM, "<tagged item>");
    r = identifier(b, l + 1);
    r = r && tagged_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [class_tuple|class_brace]
  private static boolean tagged_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_item_1")) return false;
    tagged_item_1_0(b, l + 1);
    return true;
  }

  // class_tuple|class_brace
  private static boolean tagged_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_item_1_0")) return false;
    boolean r;
    r = class_tuple(b, l + 1);
    if (!r) r = class_brace(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TAGGED modifier_symbols [[PROPORTION] type_angle] tagged_block
  public static boolean tagged_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement")) return false;
    if (!nextTokenIs(b, TAGGED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TAGGED);
    r = r && modifier_symbols(b, l + 1);
    r = r && tagged_statement_2(b, l + 1);
    r = r && tagged_block(b, l + 1);
    exit_section_(b, m, TAGGED_STATEMENT, r);
    return r;
  }

  // [[PROPORTION] type_angle]
  private static boolean tagged_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement_2")) return false;
    tagged_statement_2_0(b, l + 1);
    return true;
  }

  // [PROPORTION] type_angle
  private static boolean tagged_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tagged_statement_2_0_0(b, l + 1);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [PROPORTION]
  private static boolean tagged_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement_2_0_0")) return false;
    consumeToken(b, PROPORTION);
    return true;
  }

  /* ********************************************************** */
  // list | tuple | atoms
  static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    r = list(b, l + 1);
    if (!r) r = tuple(b, l + 1);
    if (!r) r = atoms(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // namespace_statement
  //   | extension_statement
  //   | import_statement
  //   | class_statement
  //   | trait_statement
  //   | tagged_statement
  //   | bitflag_statement
  //   | extends_statement
  //   | new_statement
  //   | SEMICOLON
  static boolean top_statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_statements")) return false;
    boolean r;
    r = namespace_statement(b, l + 1);
    if (!r) r = extension_statement(b, l + 1);
    if (!r) r = import_statement(b, l + 1);
    if (!r) r = class_statement(b, l + 1);
    if (!r) r = trait_statement(b, l + 1);
    if (!r) r = tagged_statement(b, l + 1);
    if (!r) r = bitflag_statement(b, l + 1);
    if (!r) r = extends_statement(b, l + 1);
    if (!r) r = new_statement(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // <<brace_block normal_statements SEMICOLON>>
  public static boolean trait_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::normal_statements, SEMICOLON_parser_);
    exit_section_(b, m, TRAIT_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // TRAIT modifier_symbols [[PROPORTION] type_angle] [COLON type_expression] trait_block
  public static boolean trait_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement")) return false;
    if (!nextTokenIs(b, TRAIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRAIT);
    r = r && modifier_symbols(b, l + 1);
    r = r && trait_statement_2(b, l + 1);
    r = r && trait_statement_3(b, l + 1);
    r = r && trait_block(b, l + 1);
    exit_section_(b, m, TRAIT_STATEMENT, r);
    return r;
  }

  // [[PROPORTION] type_angle]
  private static boolean trait_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_2")) return false;
    trait_statement_2_0(b, l + 1);
    return true;
  }

  // [PROPORTION] type_angle
  private static boolean trait_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = trait_statement_2_0_0(b, l + 1);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [PROPORTION]
  private static boolean trait_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_2_0_0")) return false;
    consumeToken(b, PROPORTION);
    return true;
  }

  // [COLON type_expression]
  private static boolean trait_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_3")) return false;
    trait_statement_3_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean trait_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<parenthesis expression COMMA>>
  public static boolean tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::expression, COMMA_parser_);
    exit_section_(b, m, TUPLE, r);
    return r;
  }

  /* ********************************************************** */
  // <<angle_block ([identifier COLON] type_expression) COMMA>>
  public static boolean type_angle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_angle")) return false;
    if (!nextTokenIs(b, ANGLE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = angle_block(b, l + 1, ValkyrieParser::type_angle_0_0, COMMA_parser_);
    exit_section_(b, m, TYPE_ANGLE, r);
    return r;
  }

  // [identifier COLON] type_expression
  private static boolean type_angle_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_angle_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_angle_0_0_0(b, l + 1);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [identifier COLON]
  private static boolean type_angle_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_angle_0_0_0")) return false;
    type_angle_0_0_0_0(b, l + 1);
    return true;
  }

  // identifier COLON
  private static boolean type_angle_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_angle_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VERTICAL | EQ | NE | PLUS | MINUS | TO
  static boolean type_binary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_binary")) return false;
    boolean r;
    r = consumeToken(b, VERTICAL);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NE);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, TO);
    return r;
  }

  /* ********************************************************** */
  // op_prefix* term (op_suffix|call_suffix|type_angle|slice_suffix)*
  static boolean type_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_expr_0(b, l + 1);
    r = r && term(b, l + 1);
    r = r && type_expr_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // op_prefix*
  private static boolean type_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!op_prefix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_expr_0", c)) break;
    }
    return true;
  }

  // (op_suffix|call_suffix|type_angle|slice_suffix)*
  private static boolean type_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_expr_2", c)) break;
    }
    return true;
  }

  // op_suffix|call_suffix|type_angle|slice_suffix
  private static boolean type_expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expr_2_0")) return false;
    boolean r;
    r = op_suffix(b, l + 1);
    if (!r) r = call_suffix(b, l + 1);
    if (!r) r = type_angle(b, l + 1);
    if (!r) r = slice_suffix(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // type_expr (type_binary type_expr)*
  public static boolean type_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_EXPRESSION, "<type expression>");
    r = type_expr(b, l + 1);
    r = r && type_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (type_binary type_expr)*
  private static boolean type_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_expression_1", c)) break;
    }
    return true;
  }

  // type_binary type_expr
  private static boolean type_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_binary(b, l + 1);
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE identifier [[PROPORTION] type_angle] [BIND type_expr]
  public static boolean type_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE);
    r = r && identifier(b, l + 1);
    r = r && type_statement_2(b, l + 1);
    r = r && type_statement_3(b, l + 1);
    exit_section_(b, m, TYPE_STATEMENT, r);
    return r;
  }

  // [[PROPORTION] type_angle]
  private static boolean type_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2")) return false;
    type_statement_2_0(b, l + 1);
    return true;
  }

  // [PROPORTION] type_angle
  private static boolean type_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_statement_2_0_0(b, l + 1);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [PROPORTION]
  private static boolean type_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2_0_0")) return false;
    consumeToken(b, PROPORTION);
    return true;
  }

  // [BIND type_expr]
  private static boolean type_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_3")) return false;
    type_statement_3_0(b, l + 1);
    return true;
  }

  // BIND type_expr
  private static boolean type_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BIND);
    r = r && type_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((normal_statements|top_statements) [SEMICOLON])*
  static boolean valkyrie(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie")) return false;
    while (true) {
      int c = current_position_(b);
      if (!valkyrie_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "valkyrie", c)) break;
    }
    return true;
  }

  // (normal_statements|top_statements) [SEMICOLON]
  private static boolean valkyrie_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = valkyrie_0_0(b, l + 1);
    r = r && valkyrie_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // normal_statements|top_statements
  private static boolean valkyrie_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0_0")) return false;
    boolean r;
    r = normal_statements(b, l + 1);
    if (!r) r = top_statements(b, l + 1);
    return r;
  }

  // [SEMICOLON]
  private static boolean valkyrie_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // WHILE condition block
  public static boolean while_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  static final Parser COMMA_parser_ = (b, l) -> consumeToken(b, COMMA);
  static final Parser SEMICOLON_parser_ = (b, l) -> consumeToken(b, SEMICOLON);
}
