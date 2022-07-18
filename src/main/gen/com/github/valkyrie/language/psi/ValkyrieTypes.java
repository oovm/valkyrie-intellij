// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.valkyrie.language.psi_node.*;

public interface ValkyrieTypes {

  IElementType AS = new ValkyrieTokenType("AS");
  IElementType BITFLAG_BLOCK = new ValkyrieTokenType("BITFLAG_BLOCK");
  IElementType BITFLAG_ITEM = new ValkyrieTokenType("BITFLAG_ITEM");
  IElementType BITFLAG_LAYOUT = new ValkyrieTokenType("BITFLAG_LAYOUT");
  IElementType BITFLAG_STATEMENT = new ValkyrieTokenType("BITFLAG_STATEMENT");
  IElementType BLOCK = new ValkyrieTokenType("BLOCK");
  IElementType BOOLEAN = new ValkyrieTokenType("BOOLEAN");
  IElementType CALL_SUFFIX = new ValkyrieTokenType("CALL_SUFFIX");
  IElementType CASE_PATTERN = new ValkyrieTokenType("CASE_PATTERN");
  IElementType CLASS_BRACE = new ValkyrieTokenType("CLASS_BRACE");
  IElementType CLASS_BRACE_ITEM = new ValkyrieTokenType("CLASS_BRACE_ITEM");
  IElementType CLASS_NUMERIC_KEY = new ValkyrieTokenType("CLASS_NUMERIC_KEY");
  IElementType CLASS_STATEMENT = new ValkyrieTokenType("CLASS_STATEMENT");
  IElementType CLASS_TUPLE = new ValkyrieTokenType("CLASS_TUPLE");
  IElementType CLASS_TUPLE_ITEM = new ValkyrieTokenType("CLASS_TUPLE_ITEM");
  IElementType CONDITION = new ValkyrieTokenType("CONDITION");
  IElementType DEF_BLOCK = new ValkyrieTokenType("DEF_BLOCK");
  IElementType DEF_ITEM = new ValkyrieTokenType("DEF_ITEM");
  IElementType DEF_ITEM_SIGN = new ValkyrieTokenType("DEF_ITEM_SIGN");
  IElementType DEF_STATEMENT = new ValkyrieTokenType("DEF_STATEMENT");
  IElementType DEF_TUPLE = new ValkyrieTokenType("DEF_TUPLE");
  IElementType EF_STATEMENT = new ValkyrieTokenType("EF_STATEMENT");
  IElementType ELSE_STATEMENT = new ValkyrieTokenType("ELSE_STATEMENT");
  IElementType EXPRESSION = new ValkyrieTokenType("EXPRESSION");
  IElementType EXTENDS_STATEMENT = new ValkyrieTokenType("EXTENDS_STATEMENT");
  IElementType EXTENSION_STATEMENT = new ValkyrieTokenType("EXTENSION_STATEMENT");
  IElementType FORALL_BLOCK = new ValkyrieTokenType("FORALL_BLOCK");
  IElementType FORALL_STATEMENT = new ValkyrieTokenType("FORALL_STATEMENT");
  IElementType FOR_STATEMENT = new ValkyrieTokenType("FOR_STATEMENT");
  IElementType IDENTIFIER = new ValkyrieTokenType("IDENTIFIER");
  IElementType IF_GUARD = new ValkyrieTokenType("IF_GUARD");
  IElementType IF_STATEMENT = new ValkyrieTokenType("IF_STATEMENT");
  IElementType IMPORT_BLOCK = new ValkyrieTokenType("IMPORT_BLOCK");
  IElementType IMPORT_DOT = new ValkyrieTokenType("IMPORT_DOT");
  IElementType IMPORT_ITEM = new ValkyrieTokenType("IMPORT_ITEM");
  IElementType IMPORT_RENAME = new ValkyrieTokenType("IMPORT_RENAME");
  IElementType IMPORT_STATEMENT = new ValkyrieTokenType("IMPORT_STATEMENT");
  IElementType LET_STATEMENT = new ValkyrieTokenType("LET_STATEMENT");
  IElementType LET_TYPE_HINT = new ValkyrieTokenType("LET_TYPE_HINT");
  IElementType LIST = new ValkyrieTokenType("LIST");
  IElementType MACRO_CALL = new ValkyrieTokenType("MACRO_CALL");
  IElementType MACRO_ITEM = new ValkyrieTokenType("MACRO_ITEM");
  IElementType MACRO_LIST = new ValkyrieTokenType("MACRO_LIST");
  IElementType MATCH_BLOCK = new ValkyrieTokenType("MATCH_BLOCK");
  IElementType MATCH_EXPRESSION = new ValkyrieTokenType("MATCH_EXPRESSION");
  IElementType MATCH_STATEMENT = new ValkyrieTokenType("MATCH_STATEMENT");
  IElementType MODIFIER_SYMBOLS = new ValkyrieTokenType("MODIFIER_SYMBOLS");
  IElementType NAMESPACE = new ValkyrieTokenType("NAMESPACE");
  IElementType NAMESPACE_STATEMENT = new ValkyrieTokenType("NAMESPACE_STATEMENT");
  IElementType NEW_STATEMENT = new ValkyrieTokenType("NEW_STATEMENT");
  IElementType NORMAL_PATTERN = new ValkyrieTokenType("NORMAL_PATTERN");
  IElementType NUMBER = new ValkyrieTokenType("NUMBER");
  IElementType NUMBER_LITERAL = new ValkyrieTokenType("NUMBER_LITERAL");
  IElementType PAIR = new ValkyrieTokenType("PAIR");
  IElementType PATTERN_ITEM = new ValkyrieTokenType("PATTERN_ITEM");
  IElementType PATTERN_PAIR = new ValkyrieTokenType("PATTERN_PAIR");
  IElementType PATTERN_VALUE = new ValkyrieTokenType("PATTERN_VALUE");
  IElementType SLICE_EXPRESSION = new ValkyrieTokenType("SLICE_EXPRESSION");
  IElementType SLICE_SUFFIX = new ValkyrieTokenType("SLICE_SUFFIX");
  IElementType STRING = new ValkyrieTokenType("STRING");
  IElementType STRING_LITERAL = new ValkyrieTokenType("STRING_LITERAL");
  IElementType TAGGED_BLOCK = new ValkyrieTokenType("TAGGED_BLOCK");
  IElementType TAGGED_ITEM = new ValkyrieTokenType("TAGGED_ITEM");
  IElementType TAGGED_STATEMENT = new ValkyrieTokenType("TAGGED_STATEMENT");
  IElementType TRAIT_BLOCK = new ValkyrieTokenType("TRAIT_BLOCK");
  IElementType TRAIT_STATEMENT = new ValkyrieTokenType("TRAIT_STATEMENT");
  IElementType TUPLE = new ValkyrieTokenType("TUPLE");
  IElementType TYPE_ANGLE = new ValkyrieTokenType("TYPE_ANGLE");
  IElementType TYPE_EXPRESSION = new ValkyrieTokenType("TYPE_EXPRESSION");
  IElementType TYPE_STATEMENT = new ValkyrieTokenType("TYPE_STATEMENT");
  IElementType WHILE_STATEMENT = new ValkyrieTokenType("WHILE_STATEMENT");

  IElementType ACCENT = new ValkyrieTokenType("^");
  IElementType AMP = new ValkyrieTokenType("AMP");
  IElementType ANGLE_L = new ValkyrieTokenType("ANGLE_L");
  IElementType ANGLE_R = new ValkyrieTokenType("ANGLE_R");
  IElementType AT = new ValkyrieTokenType("@");
  IElementType BACKSLASH = new ValkyrieTokenType("\\\\");
  IElementType BANG = new ValkyrieTokenType("BANG");
  IElementType BIND = new ValkyrieTokenType("BIND");
  IElementType BITFLAG = new ValkyrieTokenType("bitset");
  IElementType BRACE_L = new ValkyrieTokenType("{");
  IElementType BRACE_R = new ValkyrieTokenType("}");
  IElementType BRACKET_L = new ValkyrieTokenType("[");
  IElementType BRACKET_R = new ValkyrieTokenType("]");
  IElementType BYTE = new ValkyrieTokenType("Byte");
  IElementType CASE = new ValkyrieTokenType("CASE");
  IElementType CATCH = new ValkyrieTokenType("catch");
  IElementType CLASS = new ValkyrieTokenType("class");
  IElementType COLON = new ValkyrieTokenType("COLON");
  IElementType COMMA = new ValkyrieTokenType(",");
  IElementType COMMENT = new ValkyrieTokenType("Comment");
  IElementType COMMENT_BLOCK = new ValkyrieTokenType("Comment Block");
  IElementType COMMENT_DOCUMENT = new ValkyrieTokenType("Comment Document");
  IElementType COMMENT_LINE = new ValkyrieTokenType("Comment Line");
  IElementType DECIMAL = new ValkyrieTokenType("DECIMAL");
  IElementType DEFINE = new ValkyrieTokenType("def");
  IElementType DOLLAR = new ValkyrieTokenType("$");
  IElementType DOT = new ValkyrieTokenType(".");
  IElementType DOT2 = new ValkyrieTokenType("..");
  IElementType DOT3 = new ValkyrieTokenType("...");
  IElementType DOT_EQ = new ValkyrieTokenType("..=");
  IElementType DOT_LESS = new ValkyrieTokenType("..<");
  IElementType ELSE = new ValkyrieTokenType("else");
  IElementType EQ = new ValkyrieTokenType("==");
  IElementType EXTENDS = new ValkyrieTokenType("extends");
  IElementType EXTENSION = new ValkyrieTokenType("EXTENSION");
  IElementType FOR = new ValkyrieTokenType("for");
  IElementType FORALL = new ValkyrieTokenType("forall");
  IElementType GENERIC_L = new ValkyrieTokenType("::<");
  IElementType GENERIC_R = new ValkyrieTokenType(">::");
  IElementType GREATER = new ValkyrieTokenType("GREATER");
  IElementType HASH = new ValkyrieTokenType("#");
  IElementType IF = new ValkyrieTokenType("if");
  IElementType IMPORT = new ValkyrieTokenType("IMPORT");
  IElementType IN = new ValkyrieTokenType("IN");
  IElementType INTEGER = new ValkyrieTokenType("INTEGER");
  IElementType KW_EXTENSION = new ValkyrieTokenType("extension");
  IElementType KW_IMPORT = new ValkyrieTokenType("using");
  IElementType KW_NAMESPACE = new ValkyrieTokenType("namespace");
  IElementType LESS = new ValkyrieTokenType("LESS");
  IElementType LET = new ValkyrieTokenType("let");
  IElementType MACRO = new ValkyrieTokenType("macro");
  IElementType MATCH = new ValkyrieTokenType("match");
  IElementType MINUS = new ValkyrieTokenType("MINUS");
  IElementType NE = new ValkyrieTokenType("NE");
  IElementType NEW = new ValkyrieTokenType("new");
  IElementType NOT = new ValkyrieTokenType("NOT");
  IElementType OP_ADD = new ValkyrieTokenType("+");
  IElementType OP_ADD_ASSIGN = new ValkyrieTokenType("+=");
  IElementType OP_AND = new ValkyrieTokenType("&");
  IElementType OP_AND_ASSIGN = new ValkyrieTokenType("&=");
  IElementType OP_BIND = new ValkyrieTokenType(":=");
  IElementType OP_COLON = new ValkyrieTokenType(":");
  IElementType OP_DEC = new ValkyrieTokenType("--");
  IElementType OP_DIV = new ValkyrieTokenType("/");
  IElementType OP_DIV_ASSIGN = new ValkyrieTokenType("/=");
  IElementType OP_EQ = new ValkyrieTokenType("=");
  IElementType OP_GEQ = new ValkyrieTokenType(">=");
  IElementType OP_GG = new ValkyrieTokenType(">>");
  IElementType OP_GGG = new ValkyrieTokenType(">>>");
  IElementType OP_GS = new ValkyrieTokenType("/>");
  IElementType OP_GT = new ValkyrieTokenType(">");
  IElementType OP_IN = new ValkyrieTokenType("in");
  IElementType OP_INC = new ValkyrieTokenType("++");
  IElementType OP_IS_A = new ValkyrieTokenType("is");
  IElementType OP_LEQ = new ValkyrieTokenType("<=");
  IElementType OP_LL = new ValkyrieTokenType("<<");
  IElementType OP_LLL = new ValkyrieTokenType("<<<");
  IElementType OP_LS = new ValkyrieTokenType("</");
  IElementType OP_LT = new ValkyrieTokenType("<");
  IElementType OP_MOD = new ValkyrieTokenType("%");
  IElementType OP_MOD_ASSIGN = new ValkyrieTokenType("%=");
  IElementType OP_MUL = new ValkyrieTokenType("*");
  IElementType OP_MUL_ASSIGN = new ValkyrieTokenType("*=");
  IElementType OP_NE = new ValkyrieTokenType("!=");
  IElementType OP_NOT = new ValkyrieTokenType("!");
  IElementType OP_NOT_A = new ValkyrieTokenType("is not");
  IElementType OP_OR = new ValkyrieTokenType("|");
  IElementType OP_OR_ASSIGN = new ValkyrieTokenType("|=");
  IElementType OP_PROPORTION = new ValkyrieTokenType("::");
  IElementType OP_SUB = new ValkyrieTokenType("-");
  IElementType OP_SUB_ASSIGN = new ValkyrieTokenType("-=");
  IElementType PARENTHESIS_L = new ValkyrieTokenType("(");
  IElementType PARENTHESIS_R = new ValkyrieTokenType(")");
  IElementType PLUS = new ValkyrieTokenType("PLUS");
  IElementType PROPORTION = new ValkyrieTokenType("PROPORTION");
  IElementType QUESTION = new ValkyrieTokenType("?");
  IElementType SEMICOLON = new ValkyrieTokenType(";");
  IElementType STRING_CHAR = new ValkyrieTokenType("String Character");
  IElementType STRING_EMPTY = new ValkyrieTokenType("String Empty");
  IElementType STRING_END = new ValkyrieTokenType("'");
  IElementType STRING_START = new ValkyrieTokenType("STRING_START");
  IElementType SYMBOL_RAW = new ValkyrieTokenType("Symbol");
  IElementType SYMBOL_XID = new ValkyrieTokenType("SYMBOL_XID");
  IElementType TAGGED = new ValkyrieTokenType("tagged");
  IElementType TILDE = new ValkyrieTokenType("~");
  IElementType TO = new ValkyrieTokenType("->");
  IElementType TRAIT = new ValkyrieTokenType("trait");
  IElementType TYPE = new ValkyrieTokenType("TYPE");
  IElementType URL = new ValkyrieTokenType("Url");
  IElementType VERTICAL = new ValkyrieTokenType("VERTICAL");
  IElementType WHILE = new ValkyrieTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AS) {
        return new ValkyrieAsNode(node);
      }
      else if (type == BITFLAG_BLOCK) {
        return new ValkyrieBitflagBlockNode(node);
      }
      else if (type == BITFLAG_ITEM) {
        return new ValkyrieBitflagItemNode(node);
      }
      else if (type == BITFLAG_LAYOUT) {
        return new ValkyrieBitflagLayoutNode(node);
      }
      else if (type == BITFLAG_STATEMENT) {
        return new ValkyrieBitflagStatementNode(node);
      }
      else if (type == BLOCK) {
        return new ValkyrieBlockNode(node);
      }
      else if (type == BOOLEAN) {
        return new ValkyrieBooleanNode(node);
      }
      else if (type == CALL_SUFFIX) {
        return new ValkyrieCallSuffixNode(node);
      }
      else if (type == CASE_PATTERN) {
        return new ValkyrieCasePatternNode(node);
      }
      else if (type == CLASS_BRACE) {
        return new ValkyrieClassBraceNode(node);
      }
      else if (type == CLASS_BRACE_ITEM) {
        return new ValkyrieClassBraceItemNode(node);
      }
      else if (type == CLASS_NUMERIC_KEY) {
        return new ValkyrieClassNumericKeyNode(node);
      }
      else if (type == CLASS_STATEMENT) {
        return new ValkyrieClassStatementNode(node);
      }
      else if (type == CLASS_TUPLE) {
        return new ValkyrieClassTupleNode(node);
      }
      else if (type == CLASS_TUPLE_ITEM) {
        return new ValkyrieClassTupleItemNode(node);
      }
      else if (type == CONDITION) {
        return new ValkyrieConditionNode(node);
      }
      else if (type == DEF_BLOCK) {
        return new ValkyrieDefBlockNode(node);
      }
      else if (type == DEF_ITEM) {
        return new ValkyrieDefItemNode(node);
      }
      else if (type == DEF_ITEM_SIGN) {
        return new ValkyrieDefItemSignNode(node);
      }
      else if (type == DEF_STATEMENT) {
        return new ValkyrieDefStatementNode(node);
      }
      else if (type == DEF_TUPLE) {
        return new ValkyrieDefTupleNode(node);
      }
      else if (type == EF_STATEMENT) {
        return new ValkyrieEfStatementNode(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new ValkyrieElseStatementNode(node);
      }
      else if (type == EXPRESSION) {
        return new ValkyrieExpressionNode(node);
      }
      else if (type == EXTENDS_STATEMENT) {
        return new ValkyrieExtendsStatementNode(node);
      }
      else if (type == EXTENSION_STATEMENT) {
        return new ValkyrieExtensionStatementNode(node);
      }
      else if (type == FORALL_BLOCK) {
        return new ValkyrieForallBlockNode(node);
      }
      else if (type == FORALL_STATEMENT) {
        return new ValkyrieForallStatementNode(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ValkyrieForStatementNode(node);
      }
      else if (type == IDENTIFIER) {
        return new ValkyrieIdentifierNode(node);
      }
      else if (type == IF_GUARD) {
        return new ValkyrieIfGuardNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new ValkyrieIfStatementNode(node);
      }
      else if (type == IMPORT_BLOCK) {
        return new ValkyrieImportBlockNode(node);
      }
      else if (type == IMPORT_DOT) {
        return new ValkyrieImportDotNode(node);
      }
      else if (type == IMPORT_ITEM) {
        return new ValkyrieImportItemNode(node);
      }
      else if (type == IMPORT_RENAME) {
        return new ValkyrieImportRenameNode(node);
      }
      else if (type == IMPORT_STATEMENT) {
        return new ValkyrieImportStatementNode(node);
      }
      else if (type == LET_STATEMENT) {
        return new ValkyrieLetStatementNode(node);
      }
      else if (type == LET_TYPE_HINT) {
        return new ValkyrieLetTypeHintNode(node);
      }
      else if (type == LIST) {
        return new ValkyrieListNode(node);
      }
      else if (type == MACRO_CALL) {
        return new ValkyrieMacroCallNode(node);
      }
      else if (type == MACRO_ITEM) {
        return new ValkyrieMacroItemNode(node);
      }
      else if (type == MACRO_LIST) {
        return new ValkyrieMacroListNode(node);
      }
      else if (type == MATCH_BLOCK) {
        return new ValkyrieMatchBlockNode(node);
      }
      else if (type == MATCH_EXPRESSION) {
        return new ValkyrieMatchExpressionNode(node);
      }
      else if (type == MATCH_STATEMENT) {
        return new ValkyrieMatchStatementNode(node);
      }
      else if (type == MODIFIER_SYMBOLS) {
        return new ValkyrieModifierSymbolsNode(node);
      }
      else if (type == NAMESPACE) {
        return new ValkyrieNamespaceNode(node);
      }
      else if (type == NAMESPACE_STATEMENT) {
        return new ValkyrieNamespaceStatementNode(node);
      }
      else if (type == NEW_STATEMENT) {
        return new ValkyrieNewStatementNode(node);
      }
      else if (type == NORMAL_PATTERN) {
        return new ValkyrieNormalPatternNode(node);
      }
      else if (type == NUMBER) {
        return new ValkyrieNumberNode(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new ValkyrieNumberLiteralNode(node);
      }
      else if (type == PAIR) {
        return new ValkyriePairNode(node);
      }
      else if (type == PATTERN_ITEM) {
        return new ValkyriePatternItemNode(node);
      }
      else if (type == PATTERN_PAIR) {
        return new ValkyriePatternPairNode(node);
      }
      else if (type == PATTERN_VALUE) {
        return new ValkyriePatternValueNode(node);
      }
      else if (type == SLICE_EXPRESSION) {
        return new ValkyrieSliceExpressionNode(node);
      }
      else if (type == SLICE_SUFFIX) {
        return new ValkyrieSliceSuffixNode(node);
      }
      else if (type == STRING) {
        return new ValkyrieStringNode(node);
      }
      else if (type == STRING_LITERAL) {
        return new ValkyrieStringLiteralNode(node);
      }
      else if (type == TAGGED_BLOCK) {
        return new ValkyrieTaggedBlockNode(node);
      }
      else if (type == TAGGED_ITEM) {
        return new ValkyrieTaggedItemNode(node);
      }
      else if (type == TAGGED_STATEMENT) {
        return new ValkyrieTaggedStatementNode(node);
      }
      else if (type == TRAIT_BLOCK) {
        return new ValkyrieTraitBlockNode(node);
      }
      else if (type == TRAIT_STATEMENT) {
        return new ValkyrieTraitStatementNode(node);
      }
      else if (type == TUPLE) {
        return new ValkyrieTupleNode(node);
      }
      else if (type == TYPE_ANGLE) {
        return new ValkyrieTypeAngleNode(node);
      }
      else if (type == TYPE_EXPRESSION) {
        return new ValkyrieTypeExpressionNode(node);
      }
      else if (type == TYPE_STATEMENT) {
        return new ValkyrieTypeStatementNode(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new ValkyrieWhileStatementNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
