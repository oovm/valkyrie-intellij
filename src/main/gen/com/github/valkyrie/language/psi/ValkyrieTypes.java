// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.valkyrie.language.psi_node.*;

public interface ValkyrieTypes {

  IElementType AS = new ValkyrieElementType("AS");
  IElementType BITFLAG_BLOCK = new ValkyrieElementType("BITFLAG_BLOCK");
  IElementType BITFLAG_ITEM = new ValkyrieElementType("BITFLAG_ITEM");
  IElementType BITFLAG_LAYOUT = new ValkyrieElementType("BITFLAG_LAYOUT");
  IElementType BITFLAG_STATEMENT = new ValkyrieElementType("BITFLAG_STATEMENT");
  IElementType BLOCK = new ValkyrieElementType("BLOCK");
  IElementType BOOLEAN = new ValkyrieElementType("BOOLEAN");
  IElementType CALL_SUFFIX = new ValkyrieElementType("CALL_SUFFIX");
  IElementType CASE_PATTERN = new ValkyrieElementType("CASE_PATTERN");
  IElementType CLASS_BRACE = new ValkyrieElementType("CLASS_BRACE");
  IElementType CLASS_BRACE_ITEM = new ValkyrieElementType("CLASS_BRACE_ITEM");
  IElementType CLASS_NUMERIC_KEY = new ValkyrieElementType("CLASS_NUMERIC_KEY");
  IElementType CLASS_STATEMENT = new ValkyrieElementType("CLASS_STATEMENT");
  IElementType CLASS_TUPLE = new ValkyrieElementType("CLASS_TUPLE");
  IElementType CLASS_TUPLE_ITEM = new ValkyrieElementType("CLASS_TUPLE_ITEM");
  IElementType CONDITION = new ValkyrieElementType("CONDITION");
  IElementType DEF_BLOCK = new ValkyrieElementType("DEF_BLOCK");
  IElementType DEF_ITEM = new ValkyrieElementType("DEF_ITEM");
  IElementType DEF_ITEM_SIGN = new ValkyrieElementType("DEF_ITEM_SIGN");
  IElementType DEF_STATEMENT = new ValkyrieElementType("DEF_STATEMENT");
  IElementType DEF_TUPLE = new ValkyrieElementType("DEF_TUPLE");
  IElementType EF_STATEMENT = new ValkyrieElementType("EF_STATEMENT");
  IElementType ELSE_STATEMENT = new ValkyrieElementType("ELSE_STATEMENT");
  IElementType EXPRESSION = new ValkyrieElementType("EXPRESSION");
  IElementType EXTENDS_STATEMENT = new ValkyrieElementType("EXTENDS_STATEMENT");
  IElementType EXTENSION_STATEMENT = new ValkyrieElementType("EXTENSION_STATEMENT");
  IElementType FORALL_BLOCK = new ValkyrieElementType("FORALL_BLOCK");
  IElementType FORALL_STATEMENT = new ValkyrieElementType("FORALL_STATEMENT");
  IElementType FOR_STATEMENT = new ValkyrieElementType("FOR_STATEMENT");
  IElementType IDENTIFIER = new ValkyrieElementType("IDENTIFIER");
  IElementType IF_GUARD = new ValkyrieElementType("IF_GUARD");
  IElementType IF_STATEMENT = new ValkyrieElementType("IF_STATEMENT");
  IElementType IMPORT_BLOCK = new ValkyrieElementType("IMPORT_BLOCK");
  IElementType IMPORT_DOT = new ValkyrieElementType("IMPORT_DOT");
  IElementType IMPORT_ITEM = new ValkyrieElementType("IMPORT_ITEM");
  IElementType IMPORT_RENAME = new ValkyrieElementType("IMPORT_RENAME");
  IElementType IMPORT_STATEMENT = new ValkyrieElementType("IMPORT_STATEMENT");
  IElementType LET_STATEMENT = new ValkyrieElementType("LET_STATEMENT");
  IElementType LET_TYPE_HINT = new ValkyrieElementType("LET_TYPE_HINT");
  IElementType LIST = new ValkyrieElementType("LIST");
  IElementType MACRO_CALL = new ValkyrieElementType("MACRO_CALL");
  IElementType MACRO_ITEM = new ValkyrieElementType("MACRO_ITEM");
  IElementType MACRO_LIST = new ValkyrieElementType("MACRO_LIST");
  IElementType MATCH_BLOCK = new ValkyrieElementType("MATCH_BLOCK");
  IElementType MATCH_EXPRESSION = new ValkyrieElementType("MATCH_EXPRESSION");
  IElementType MATCH_STATEMENT = new ValkyrieElementType("MATCH_STATEMENT");
  IElementType MODIFIER_SYMBOLS = new ValkyrieElementType("MODIFIER_SYMBOLS");
  IElementType MODULE_STATEMENT = new ValkyrieElementType("MODULE_STATEMENT");
  IElementType NAMESPACE = new ValkyrieElementType("NAMESPACE");
  IElementType NEW_STATEMENT = new ValkyrieElementType("NEW_STATEMENT");
  IElementType NORMAL_PATTERN = new ValkyrieElementType("NORMAL_PATTERN");
  IElementType NUMBER = new ValkyrieElementType("NUMBER");
  IElementType NUMBER_LITERAL = new ValkyrieElementType("NUMBER_LITERAL");
  IElementType PAIR = new ValkyrieElementType("PAIR");
  IElementType PATTERN_ITEM = new ValkyrieElementType("PATTERN_ITEM");
  IElementType PATTERN_PAIR = new ValkyrieElementType("PATTERN_PAIR");
  IElementType PATTERN_VALUE = new ValkyrieElementType("PATTERN_VALUE");
  IElementType SLICE_EXPRESSION = new ValkyrieElementType("SLICE_EXPRESSION");
  IElementType SLICE_SUFFIX = new ValkyrieElementType("SLICE_SUFFIX");
  IElementType STRING = new ValkyrieElementType("STRING");
  IElementType STRING_LITERAL = new ValkyrieElementType("STRING_LITERAL");
  IElementType TAGGED_BLOCK = new ValkyrieElementType("TAGGED_BLOCK");
  IElementType TAGGED_ITEM = new ValkyrieElementType("TAGGED_ITEM");
  IElementType TAGGED_STATEMENT = new ValkyrieElementType("TAGGED_STATEMENT");
  IElementType TRAIT_BLOCK = new ValkyrieElementType("TRAIT_BLOCK");
  IElementType TRAIT_STATEMENT = new ValkyrieElementType("TRAIT_STATEMENT");
  IElementType TUPLE = new ValkyrieElementType("TUPLE");
  IElementType TYPE_ANGLE = new ValkyrieElementType("TYPE_ANGLE");
  IElementType TYPE_EXPRESSION = new ValkyrieElementType("TYPE_EXPRESSION");
  IElementType TYPE_STATEMENT = new ValkyrieElementType("TYPE_STATEMENT");
  IElementType WHILE_STATEMENT = new ValkyrieElementType("WHILE_STATEMENT");

  IElementType ACCENT = new ValkyrieTokenType("^");
  IElementType AMP = new ValkyrieTokenType("&");
  IElementType ANGLE_L = new ValkyrieTokenType("<");
  IElementType ANGLE_R = new ValkyrieTokenType(">");
  IElementType AT = new ValkyrieTokenType("@");
  IElementType BACKSLASH = new ValkyrieTokenType("\\\\");
  IElementType BANG = new ValkyrieTokenType("!");
  IElementType BIND = new ValkyrieTokenType("=");
  IElementType BITFLAG = new ValkyrieTokenType("bitset");
  IElementType BRACE_L = new ValkyrieTokenType("{");
  IElementType BRACE_R = new ValkyrieTokenType("}");
  IElementType BRACKET_L = new ValkyrieTokenType("[");
  IElementType BRACKET_R = new ValkyrieTokenType("]");
  IElementType BYTE = new ValkyrieTokenType("Byte");
  IElementType CASE = new ValkyrieTokenType("CASE");
  IElementType CATCH = new ValkyrieTokenType("catch");
  IElementType CLASS = new ValkyrieTokenType("class");
  IElementType COLON = new ValkyrieTokenType(":");
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
  IElementType EXPORT = new ValkyrieTokenType("export");
  IElementType EXTENDS = new ValkyrieTokenType("extends");
  IElementType EXTENSION = new ValkyrieTokenType("extension");
  IElementType FOR = new ValkyrieTokenType("for");
  IElementType FORALL = new ValkyrieTokenType("forall");
  IElementType GREATER = new ValkyrieTokenType(">>");
  IElementType HASH = new ValkyrieTokenType("#");
  IElementType HYPHEN = new ValkyrieTokenType("-");
  IElementType IF = new ValkyrieTokenType("if");
  IElementType IMPORT = new ValkyrieTokenType("using");
  IElementType IN = new ValkyrieTokenType("IN");
  IElementType INTEGER = new ValkyrieTokenType("INTEGER");
  IElementType LESS = new ValkyrieTokenType("<<");
  IElementType LET = new ValkyrieTokenType("let");
  IElementType MACRO = new ValkyrieTokenType("macro");
  IElementType MATCH = new ValkyrieTokenType("match");
  IElementType MINUS = new ValkyrieTokenType("MINUS");
  IElementType MODULE = new ValkyrieTokenType("crate");
  IElementType NE = new ValkyrieTokenType("!=");
  IElementType NEW = new ValkyrieTokenType("new");
  IElementType NOT = new ValkyrieTokenType("NOT");
  IElementType PARENTHESIS_L = new ValkyrieTokenType("(");
  IElementType PARENTHESIS_R = new ValkyrieTokenType(")");
  IElementType PERCENT = new ValkyrieTokenType("%");
  IElementType PIPE = new ValkyrieTokenType("|");
  IElementType PLUS = new ValkyrieTokenType("+");
  IElementType PROPORTION = new ValkyrieTokenType("::");
  IElementType QUESTION = new ValkyrieTokenType("?");
  IElementType SEMICOLON = new ValkyrieTokenType(";");
  IElementType SLASH = new ValkyrieTokenType("/");
  IElementType STAR = new ValkyrieTokenType("*");
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
      else if (type == MODULE_STATEMENT) {
        return new ValkyrieModuleStatementNode(node);
      }
      else if (type == NAMESPACE) {
        return new ValkyrieNamespaceNode(node);
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
