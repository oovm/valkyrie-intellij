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
  // number | string | boolean | namepath
  static boolean atoms(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atoms")) return false;
    boolean r;
    r = number(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = namepath(b, l + 1);
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
    if (!nextTokenIs(b, "<bitflag item>", SYMBOL_RAW, SYMBOL_XID)) return false;
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
  // BITFLAG modifiers [bitflag_layout] bitflag_block
  public static boolean bitflag_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitflag_statement")) return false;
    if (!nextTokenIs(b, BITFLAG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITFLAG);
    r = r && modifiers(b, l + 1);
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
  static boolean block(PsiBuilder b, int l) {
    return brace_block(b, l + 1, ValkyrieParser::expression, SEMICOLON_parser_);
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
  // BRACE_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACE_R
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

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean brace_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1")) return false;
    brace_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean brace_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && brace_block_1_0_1(b, l + 1, _sp, _item);
    r = r && brace_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean brace_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "brace_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "brace_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean brace_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "brace_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean brace_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
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
  // CASE [identifier* [namepath]] pattern
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

  // [identifier* [namepath]]
  private static boolean case_pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1")) return false;
    case_pattern_1_0(b, l + 1);
    return true;
  }

  // identifier* [namepath]
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

  // [namepath]
  private static boolean case_pattern_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_pattern_1_0_1")) return false;
    namepath(b, l + 1);
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
  // (class_numeric_key | modifiers) COLON type_expression [BIND expression]
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

  // class_numeric_key | modifiers
  private static boolean class_brace_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_brace_item_0")) return false;
    boolean r;
    r = class_numeric_key(b, l + 1);
    if (!r) r = modifiers(b, l + 1);
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
  // COLON type_instance (OP_ADD type_instance)*
  public static boolean class_inherit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_inherit")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_instance(b, l + 1);
    r = r && class_inherit_2(b, l + 1);
    exit_section_(b, m, CLASS_INHERIT, r);
    return r;
  }

  // (OP_ADD type_instance)*
  private static boolean class_inherit_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_inherit_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!class_inherit_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "class_inherit_2", c)) break;
    }
    return true;
  }

  // OP_ADD type_instance
  private static boolean class_inherit_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_inherit_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_ADD);
    r = r && type_instance(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [modifiers] INTEGER
  public static boolean class_numeric_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_numeric_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_NUMERIC_KEY, "<class numeric key>");
    r = class_numeric_key_0(b, l + 1);
    r = r && consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean class_numeric_key_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_numeric_key_0")) return false;
    modifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // kw_class [modifiers] identifier [type_angle] [class_inherit] [class_tuple|class_brace]
  public static boolean class_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_STATEMENT, "<class statement>");
    r = kw_class(b, l + 1);
    r = r && class_statement_1(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && class_statement_3(b, l + 1);
    r = r && class_statement_4(b, l + 1);
    r = r && class_statement_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean class_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_1")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [type_angle]
  private static boolean class_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_3")) return false;
    type_angle(b, l + 1);
    return true;
  }

  // [class_inherit]
  private static boolean class_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_4")) return false;
    class_inherit(b, l + 1);
    return true;
  }

  // [class_tuple|class_brace]
  private static boolean class_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_5")) return false;
    class_statement_5_0(b, l + 1);
    return true;
  }

  // class_tuple|class_brace
  private static boolean class_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_statement_5_0")) return false;
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
  public static boolean define_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::normal_statements, SEMICOLON_parser_);
    exit_section_(b, m, DEFINE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // OP_POW | OP_LT | OP_GT
  //   | macro_call* [modifiers] [DOT2|DOT3] identifier [COLON type_expression] [OP_EQ expression]
  public static boolean define_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_ITEM, "<define item>");
    r = consumeToken(b, OP_POW);
    if (!r) r = consumeToken(b, OP_LT);
    if (!r) r = consumeToken(b, OP_GT);
    if (!r) r = define_item_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // macro_call* [modifiers] [DOT2|DOT3] identifier [COLON type_expression] [OP_EQ expression]
  private static boolean define_item_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = define_item_3_0(b, l + 1);
    r = r && define_item_3_1(b, l + 1);
    r = r && define_item_3_2(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && define_item_3_4(b, l + 1);
    r = r && define_item_3_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // macro_call*
  private static boolean define_item_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!macro_call(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "define_item_3_0", c)) break;
    }
    return true;
  }

  // [modifiers]
  private static boolean define_item_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_1")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [DOT2|DOT3]
  private static boolean define_item_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_2")) return false;
    define_item_3_2_0(b, l + 1);
    return true;
  }

  // DOT2|DOT3
  private static boolean define_item_3_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_2_0")) return false;
    boolean r;
    r = consumeToken(b, DOT2);
    if (!r) r = consumeToken(b, DOT3);
    return r;
  }

  // [COLON type_expression]
  private static boolean define_item_3_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_4")) return false;
    define_item_3_4_0(b, l + 1);
    return true;
  }

  // COLON type_expression
  private static boolean define_item_3_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [OP_EQ expression]
  private static boolean define_item_3_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_5")) return false;
    define_item_3_5_0(b, l + 1);
    return true;
  }

  // OP_EQ expression
  private static boolean define_item_3_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_item_3_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_EQ);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // kw_define [modifiers] namepath_free [old_generic] define_tuple [(COLON|OP_ARROW) type_expression] [define_block| OP_EQ expression]
  public static boolean define_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_STATEMENT, "<define statement>");
    r = kw_define(b, l + 1);
    r = r && define_statement_1(b, l + 1);
    r = r && namepath_free(b, l + 1);
    r = r && define_statement_3(b, l + 1);
    r = r && define_tuple(b, l + 1);
    r = r && define_statement_5(b, l + 1);
    r = r && define_statement_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [modifiers]
  private static boolean define_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_1")) return false;
    modifiers(b, l + 1);
    return true;
  }

  // [old_generic]
  private static boolean define_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_3")) return false;
    old_generic(b, l + 1);
    return true;
  }

  // [(COLON|OP_ARROW) type_expression]
  private static boolean define_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_5")) return false;
    define_statement_5_0(b, l + 1);
    return true;
  }

  // (COLON|OP_ARROW) type_expression
  private static boolean define_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = define_statement_5_0_0(b, l + 1);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON|OP_ARROW
  private static boolean define_statement_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_5_0_0")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, OP_ARROW);
    return r;
  }

  // [define_block| OP_EQ expression]
  private static boolean define_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_6")) return false;
    define_statement_6_0(b, l + 1);
    return true;
  }

  // define_block| OP_EQ expression
  private static boolean define_statement_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = define_block(b, l + 1);
    if (!r) r = define_statement_6_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_EQ expression
  private static boolean define_statement_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_statement_6_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_EQ);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<parenthesis define_item COMMA>>
  public static boolean define_tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_tuple")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, ValkyrieParser::define_item, COMMA_parser_);
    exit_section_(b, m, DEFINE_TUPLE, r);
    return r;
  }

  /* ********************************************************** */
  // else_if condition block
  public static boolean ef_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ef_statement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = else_if(b, l + 1);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, EF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE IF
  static boolean else_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_if")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, IF);
    exit_section_(b, m, null, r);
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
  // op_prefix* term (op_suffix|call_suffix|type_angle|slice_suffix)*
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

  // (op_suffix|call_suffix|type_angle|slice_suffix)*
  private static boolean expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_2", c)) break;
    }
    return true;
  }

  // op_suffix|call_suffix|type_angle|slice_suffix
  private static boolean expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_2_0")) return false;
    boolean r;
    r = op_suffix(b, l + 1);
    if (!r) r = call_suffix(b, l + 1);
    if (!r) r = type_angle(b, l + 1);
    if (!r) r = slice_suffix(b, l + 1);
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
  // EXTENDS modifiers [[OP_PROPORTION] type_angle] [COLON type_expression] trait_block
  public static boolean extends_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement")) return false;
    if (!nextTokenIs(b, EXTENDS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && modifiers(b, l + 1);
    r = r && extends_statement_2(b, l + 1);
    r = r && extends_statement_3(b, l + 1);
    r = r && trait_block(b, l + 1);
    exit_section_(b, m, EXTENDS_STATEMENT, r);
    return r;
  }

  // [[OP_PROPORTION] type_angle]
  private static boolean extends_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_2")) return false;
    extends_statement_2_0(b, l + 1);
    return true;
  }

  // [OP_PROPORTION] type_angle
  private static boolean extends_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = extends_statement_2_0_0(b, l + 1);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [OP_PROPORTION]
  private static boolean extends_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extends_statement_2_0_0")) return false;
    consumeToken(b, OP_PROPORTION);
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
  // KW_EXTENSION identifier COLON namepath_free top_block
  public static boolean extension_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_statement")) return false;
    if (!nextTokenIs(b, KW_EXTENSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_EXTENSION);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && namepath_free(b, l + 1);
    r = r && top_block(b, l + 1);
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
  // OP_LT [<<item>> (<<sp>> <<item>>)* [<<sp>>]] OP_GT
  static boolean generic_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "generic_block")) return false;
    if (!nextTokenIs(b, OP_LT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LT);
    r = r && generic_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, OP_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean generic_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "generic_block_1")) return false;
    generic_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean generic_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "generic_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && generic_block_1_0_1(b, l + 1, _sp, _item);
    r = r && generic_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean generic_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "generic_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!generic_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "generic_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean generic_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "generic_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean generic_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "generic_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // SYMBOL_XID | SYMBOL_RAW
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, "<identifier>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    r = consumeToken(b, SYMBOL_XID);
    if (!r) r = consumeToken(b, SYMBOL_RAW);
    exit_section_(b, l, m, r, false, null);
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
  // namepath_free [KW_AS identifier|(COLON|OP_PROPORTION) import_block]
  public static boolean import_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item")) return false;
    if (!nextTokenIs(b, "<import item>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_ITEM, "<import item>");
    r = namepath_free(b, l + 1);
    r = r && import_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [KW_AS identifier|(COLON|OP_PROPORTION) import_block]
  private static boolean import_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_1")) return false;
    import_item_1_0(b, l + 1);
    return true;
  }

  // KW_AS identifier|(COLON|OP_PROPORTION) import_block
  private static boolean import_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_item_1_0_0(b, l + 1);
    if (!r) r = import_item_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_AS identifier
  private static boolean import_item_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AS);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON|OP_PROPORTION) import_block
  private static boolean import_item_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_item_1_0_1_0(b, l + 1);
    r = r && import_block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON|OP_PROPORTION
  private static boolean import_item_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_item_1_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, OP_PROPORTION);
    return r;
  }

  /* ********************************************************** */
  // kw_import (import_block|import_item)
  public static boolean import_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_STATEMENT, "<import statement>");
    r = kw_import(b, l + 1);
    r = r && import_statement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // import_block|import_item
  private static boolean import_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_1")) return false;
    boolean r;
    r = import_block(b, l + 1);
    if (!r) r = import_item(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "class"|"struct"
  public static boolean kw_class(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_class")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_CLASS, "<kw class>");
    r = consumeToken(b, "class");
    if (!r) r = consumeToken(b, "struct");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "def"
  public static boolean kw_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_define")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_DEFINE, "<kw define>");
    r = consumeToken(b, "def");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "using" | OP_IMPORT
  public static boolean kw_import(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_import")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KW_IMPORT, "<kw import>");
    r = consumeToken(b, "using");
    if (!r) r = consumeToken(b, OP_IMPORT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "namespace" | OP_NAMESAPCE
  public static boolean kw_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kw_namespace")) return false;
    if (!nextTokenIs(b, OP_NAMESAPCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_NAMESAPCE);
    if (!r) r = consumeToken(b, OP_NAMESAPCE);
    exit_section_(b, m, KW_NAMESPACE, r);
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
  // AT namepath_free
  public static boolean macro(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && namepath_free(b, l + 1);
    exit_section_(b, m, MACRO, r);
    return r;
  }

  /* ********************************************************** */
  // macro [macro_item]
  public static boolean macro_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_call")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = macro(b, l + 1);
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
  // [AT|HASH] <<bracket_block (namepath macro_item) COMMA>>
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

  // namepath macro_item
  private static boolean macro_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namepath(b, l + 1);
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
  // (identifier !(PARENTHESIS_L|PARENTHESIS_R|DOT|COLON|SEMICOLON|OP_PROPORTION|COMMA|OP_EQ))+
  public static boolean modifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers")) return false;
    if (!nextTokenIs(b, "<modifiers>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIERS, "<modifiers>");
    r = modifiers_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!modifiers_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifiers", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier !(PARENTHESIS_L|PARENTHESIS_R|DOT|COLON|SEMICOLON|OP_PROPORTION|COMMA|OP_EQ)
  private static boolean modifiers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && modifiers_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(PARENTHESIS_L|PARENTHESIS_R|DOT|COLON|SEMICOLON|OP_PROPORTION|COMMA|OP_EQ)
  private static boolean modifiers_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !modifiers_0_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PARENTHESIS_L|PARENTHESIS_R|DOT|COLON|SEMICOLON|OP_PROPORTION|COMMA|OP_EQ
  private static boolean modifiers_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, PARENTHESIS_L);
    if (!r) r = consumeToken(b, PARENTHESIS_R);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, OP_PROPORTION);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, OP_EQ);
    return r;
  }

  /* ********************************************************** */
  // identifier (OP_PROPORTION identifier)*
  public static boolean namepath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath")) return false;
    if (!nextTokenIs(b, "<namepath>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMEPATH, "<namepath>");
    r = identifier(b, l + 1);
    r = r && namepath_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_PROPORTION identifier)*
  private static boolean namepath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namepath_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namepath_1", c)) break;
    }
    return true;
  }

  // OP_PROPORTION identifier
  private static boolean namepath_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PROPORTION);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier ((DOT|OP_PROPORTION) identifier)*
  public static boolean namepath_free(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_free")) return false;
    if (!nextTokenIs(b, "<namepath free>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMEPATH_FREE, "<namepath free>");
    r = identifier(b, l + 1);
    r = r && namepath_free_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((DOT|OP_PROPORTION) identifier)*
  private static boolean namepath_free_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_free_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namepath_free_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namepath_free_1", c)) break;
    }
    return true;
  }

  // (DOT|OP_PROPORTION) identifier
  private static boolean namepath_free_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_free_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namepath_free_1_0_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT|OP_PROPORTION
  private static boolean namepath_free_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namepath_free_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, OP_PROPORTION);
    return r;
  }

  /* ********************************************************** */
  // kw_namespace namepath_free
  public static boolean namespace_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_statement")) return false;
    if (!nextTokenIs(b, OP_NAMESAPCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = kw_namespace(b, l + 1);
    r = r && namepath_free(b, l + 1);
    exit_section_(b, m, NAMESPACE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // NEW modifiers [type_angle] [COLON type_expression] trait_block
  public static boolean new_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement")) return false;
    if (!nextTokenIs(b, NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW);
    r = r && modifiers(b, l + 1);
    r = r && new_statement_2(b, l + 1);
    r = r && new_statement_3(b, l + 1);
    r = r && trait_block(b, l + 1);
    exit_section_(b, m, NEW_STATEMENT, r);
    return r;
  }

  // [type_angle]
  private static boolean new_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_statement_2")) return false;
    type_angle(b, l + 1);
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
  //   | define_statement
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
    if (!r) r = define_statement(b, l + 1);
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
  // OP_PROPORTION? <<generic_block ([identifier COLON] type_expression) COMMA>>
  public static boolean old_generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "old_generic")) return false;
    if (!nextTokenIs(b, "<old generic>", OP_LT, OP_PROPORTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OLD_GENERIC, "<old generic>");
    r = old_generic_0(b, l + 1);
    r = r && generic_block(b, l + 1, ValkyrieParser::old_generic_1_0, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_PROPORTION?
  private static boolean old_generic_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "old_generic_0")) return false;
    consumeToken(b, OP_PROPORTION);
    return true;
  }

  // [identifier COLON] type_expression
  private static boolean old_generic_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "old_generic_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = old_generic_1_0_0(b, l + 1);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [identifier COLON]
  private static boolean old_generic_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "old_generic_1_0_0")) return false;
    old_generic_1_0_0_0(b, l + 1);
    return true;
  }

  // identifier COLON
  private static boolean old_generic_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "old_generic_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
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
  //   | [expression] OP_PROPORTION [expression]
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

  // [expression] OP_PROPORTION [expression]
  private static boolean slice_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slice_expression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slice_expression_2_0(b, l + 1);
    r = r && consumeToken(b, OP_PROPORTION);
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
  // [identifier] STRING_START STRING_TEXT STRING_END
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = string_0(b, l + 1);
    r = r && consumeTokens(b, 0, STRING_START, STRING_TEXT, STRING_END);
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
    if (!nextTokenIs(b, "<tagged item>", SYMBOL_RAW, SYMBOL_XID)) return false;
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
  // TAGGED modifiers [[OP_PROPORTION] type_angle] tagged_block
  public static boolean tagged_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement")) return false;
    if (!nextTokenIs(b, TAGGED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TAGGED);
    r = r && modifiers(b, l + 1);
    r = r && tagged_statement_2(b, l + 1);
    r = r && tagged_block(b, l + 1);
    exit_section_(b, m, TAGGED_STATEMENT, r);
    return r;
  }

  // [[OP_PROPORTION] type_angle]
  private static boolean tagged_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement_2")) return false;
    tagged_statement_2_0(b, l + 1);
    return true;
  }

  // [OP_PROPORTION] type_angle
  private static boolean tagged_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tagged_statement_2_0_0(b, l + 1);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [OP_PROPORTION]
  private static boolean tagged_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagged_statement_2_0_0")) return false;
    consumeToken(b, OP_PROPORTION);
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
  // <<brace_block top_statements SEMICOLON>>
  public static boolean top_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, ValkyrieParser::top_statements, SEMICOLON_parser_);
    exit_section_(b, m, TOP_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // namespace_statement
  //   | import_statement
  //   | extension_statement
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
    if (!r) r = import_statement(b, l + 1);
    if (!r) r = extension_statement(b, l + 1);
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
  // KW_TRAIT modifiers [type_angle] [COLON type_expression] trait_block
  public static boolean trait_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement")) return false;
    if (!nextTokenIs(b, KW_TRAIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_TRAIT);
    r = r && modifiers(b, l + 1);
    r = r && trait_statement_2(b, l + 1);
    r = r && trait_statement_3(b, l + 1);
    r = r && trait_block(b, l + 1);
    exit_section_(b, m, TRAIT_STATEMENT, r);
    return r;
  }

  // [type_angle]
  private static boolean trait_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "trait_statement_2")) return false;
    type_angle(b, l + 1);
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
  // OP_PROPORTION? <<parenthesis ([identifier COLON] type_expression) COMMA>>
  public static boolean type_angle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_angle")) return false;
    if (!nextTokenIs(b, "<type angle>", OP_PROPORTION, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ANGLE, "<type angle>");
    r = type_angle_0(b, l + 1);
    r = r && parenthesis(b, l + 1, ValkyrieParser::type_angle_1_0, COMMA_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_PROPORTION?
  private static boolean type_angle_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_angle_0")) return false;
    consumeToken(b, OP_PROPORTION);
    return true;
  }

  // [identifier COLON] type_expression
  private static boolean type_angle_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_angle_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_angle_1_0_0(b, l + 1);
    r = r && type_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [identifier COLON]
  private static boolean type_angle_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_angle_1_0_0")) return false;
    type_angle_1_0_0_0(b, l + 1);
    return true;
  }

  // identifier COLON
  private static boolean type_angle_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_angle_1_0_0_0")) return false;
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
  // identifier type_angle?
  public static boolean type_instance(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_instance")) return false;
    if (!nextTokenIs(b, "<type instance>", SYMBOL_RAW, SYMBOL_XID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_INSTANCE, "<type instance>");
    r = identifier(b, l + 1);
    r = r && type_instance_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type_angle?
  private static boolean type_instance_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_instance_1")) return false;
    type_angle(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_TYPE identifier [[OP_PROPORTION] type_angle] [BIND type_expr]
  public static boolean type_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement")) return false;
    if (!nextTokenIs(b, KW_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_TYPE);
    r = r && identifier(b, l + 1);
    r = r && type_statement_2(b, l + 1);
    r = r && type_statement_3(b, l + 1);
    exit_section_(b, m, TYPE_STATEMENT, r);
    return r;
  }

  // [[OP_PROPORTION] type_angle]
  private static boolean type_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2")) return false;
    type_statement_2_0(b, l + 1);
    return true;
  }

  // [OP_PROPORTION] type_angle
  private static boolean type_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_statement_2_0_0(b, l + 1);
    r = r && type_angle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [OP_PROPORTION]
  private static boolean type_statement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2_0_0")) return false;
    consumeToken(b, OP_PROPORTION);
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
  // ((top_statements|normal_statements) [SEMICOLON])*
  static boolean valkyrie(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie")) return false;
    while (true) {
      int c = current_position_(b);
      if (!valkyrie_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "valkyrie", c)) break;
    }
    return true;
  }

  // (top_statements|normal_statements) [SEMICOLON]
  private static boolean valkyrie_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = valkyrie_0_0(b, l + 1);
    r = r && valkyrie_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // top_statements|normal_statements
  private static boolean valkyrie_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie_0_0")) return false;
    boolean r;
    r = top_statements(b, l + 1);
    if (!r) r = normal_statements(b, l + 1);
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
