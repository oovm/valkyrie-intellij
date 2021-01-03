/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.github.valkyrie.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.IntStack;
import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Valkyrie.flex</tt>
 */
public class _ValkyrieLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int StringQuote = 2;
  public static final int TextContext = 4;
  public static final int TextContextSpace = 6;
  public static final int CodeContext = 8;
  public static final int SelectionStart = 10;
  public static final int SelectionText = 12;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  2,  2,  3,  3,  2,  2,  2, 2
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [12, 6, 3]
   * Total runtime size is 16960 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>9]<<6)|((ch>>3)&0x3f)]<<3)|(ch&0x7)];
  }

  /* The ZZ_CMAP_Z table has 2176 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
    "\20\5\21\1\22\1\21\1\23\1\21\14\24\1\25\50\24\1\26\2\24\1\27\1\30\1\31\1\32"+
    "\25\24\1\33\20\21\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1"+
    "\21\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\21\1\24\1\56\1\57\5\21\2\24\1\60"+
    "\7\21\1\24\1\61\20\21\1\24\1\62\1\21\1\63\13\24\1\64\1\24\1\65\22\21\1\66"+
    "\5\21\1\67\11\21\1\70\1\71\1\72\1\73\1\21\1\74\2\21\1\75\3\21\1\76\2\21\1"+
    "\77\10\21\123\24\1\100\7\24\1\101\1\102\12\24\1\103\24\21\1\24\1\104\u0582"+
    "\21\1\105\u017f\21");

  /* The ZZ_CMAP_Y table has 4480 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\2\0\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\3"+
    "\0\1\17\1\20\1\21\1\20\2\7\1\22\3\7\1\22\71\7\1\23\1\7\1\24\1\0\1\25\1\26"+
    "\2\0\16\27\1\30\1\31\1\32\1\33\2\7\1\34\11\7\1\35\21\7\1\36\1\37\24\7\1\40"+
    "\3\7\1\22\1\41\1\40\4\7\1\0\1\42\4\27\1\43\1\44\1\0\3\7\2\45\3\0\1\27\1\46"+
    "\5\7\1\47\3\27\1\50\1\51\13\7\1\52\1\53\1\54\1\55\1\27\1\56\2\0\1\57\3\7\3"+
    "\27\1\60\12\7\1\61\1\27\1\62\1\0\1\27\1\63\3\7\1\47\1\64\1\20\2\7\1\61\1\65"+
    "\1\66\1\67\2\0\3\7\1\70\10\0\2\7\1\30\1\71\2\0\1\72\1\27\1\73\3\27\1\74\6"+
    "\7\1\75\2\27\1\76\1\7\1\77\1\27\1\40\1\7\1\100\1\101\1\102\2\7\1\103\1\104"+
    "\1\105\1\53\1\106\1\107\1\110\1\77\1\27\1\24\1\0\1\111\1\112\1\102\2\7\1\103"+
    "\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\27\1\122\1\0\1\111\1\35\1\34"+
    "\2\7\1\103\1\123\1\105\1\43\1\124\1\125\1\0\1\77\1\27\1\0\1\41\1\111\1\101"+
    "\1\102\2\7\1\103\1\123\1\105\1\53\1\116\1\121\1\110\1\77\1\27\1\41\1\0\1\126"+
    "\1\127\1\130\1\131\1\132\1\127\1\7\1\133\1\134\1\135\1\136\1\0\1\121\1\27"+
    "\2\0\1\137\1\30\1\103\2\7\1\103\1\7\1\140\1\141\1\135\1\142\1\45\1\77\1\27"+
    "\2\0\1\100\1\30\1\103\2\7\1\103\1\143\1\105\1\141\1\135\1\142\1\144\1\77\1"+
    "\27\1\145\1\0\1\111\1\30\1\103\4\7\1\146\1\141\1\147\1\150\1\151\1\77\1\27"+
    "\1\0\1\37\1\152\1\7\1\22\1\37\2\7\1\34\1\153\1\22\1\154\1\155\1\27\1\121\1"+
    "\27\1\156\1\0\1\40\5\7\1\157\1\46\1\160\1\161\1\27\1\162\4\0\1\163\1\164\1"+
    "\165\1\40\1\166\1\167\1\157\1\170\1\171\1\172\1\27\1\173\4\0\1\125\2\0\1\162"+
    "\1\27\1\162\1\174\1\175\1\7\1\40\3\7\1\25\1\42\1\27\1\141\1\176\1\27\1\42"+
    "\3\27\1\177\1\200\7\0\5\7\1\47\1\27\1\201\1\27\1\162\1\61\1\202\1\203\1\204"+
    "\1\205\1\7\1\206\1\207\1\27\1\172\4\7\1\35\1\210\5\7\1\211\51\7\1\130\1\22"+
    "\1\130\5\7\1\130\4\7\1\130\1\22\1\130\1\7\1\22\7\7\1\130\10\7\1\212\1\0\1"+
    "\42\1\162\1\0\2\7\2\0\12\7\2\71\1\40\114\7\1\101\2\7\1\213\2\7\1\45\11\7\1"+
    "\127\1\7\1\125\1\7\1\30\1\214\1\0\2\7\1\214\1\0\2\7\1\215\1\0\1\7\1\30\1\216"+
    "\1\0\6\7\1\217\3\27\1\220\1\221\1\27\1\162\3\0\1\222\1\27\1\162\13\7\1\0\5"+
    "\7\1\223\10\7\1\71\1\0\3\7\1\22\1\27\1\224\1\27\1\224\1\121\1\27\3\7\1\71"+
    "\1\25\1\0\5\7\1\225\3\7\1\24\1\27\1\46\4\0\2\7\1\160\1\224\6\7\1\176\1\161"+
    "\3\27\1\53\1\27\1\162\1\27\1\162\1\151\1\0\1\27\1\172\10\0\1\226\5\7\1\217"+
    "\1\27\1\226\1\225\1\27\1\162\1\0\1\227\1\224\1\0\1\230\3\7\1\76\1\204\1\27"+
    "\1\63\4\7\1\61\1\27\1\224\1\0\4\7\1\217\2\27\1\0\1\27\1\231\1\27\1\63\3\7"+
    "\1\71\1\7\1\125\10\0\1\232\2\27\1\233\1\234\1\162\30\7\6\27\1\172\1\227\42"+
    "\7\2\71\4\7\2\71\1\7\1\235\3\7\1\71\6\7\1\30\1\171\1\236\1\25\1\237\1\225"+
    "\1\7\1\25\1\236\1\25\1\240\1\241\3\0\1\242\1\0\1\107\1\243\1\0\1\244\1\245"+
    "\2\0\1\41\1\151\2\0\1\7\1\25\6\0\1\27\1\177\1\246\1\27\1\243\1\0\1\247\1\37"+
    "\1\153\1\71\1\26\1\103\1\7\1\250\1\251\1\252\2\0\5\7\1\125\116\0\5\7\1\22"+
    "\5\7\1\22\20\7\1\25\1\253\1\254\1\0\4\7\1\35\1\210\7\7\1\151\1\0\1\107\2\7"+
    "\1\22\1\0\10\22\4\27\1\255\3\0\1\40\1\206\1\256\1\25\1\40\11\7\1\22\1\257"+
    "\1\40\12\7\1\211\1\251\4\7\1\71\1\40\12\7\1\22\2\0\3\7\1\45\6\0\170\7\1\71"+
    "\11\0\72\7\1\71\5\0\21\7\1\25\10\0\5\7\1\71\41\7\1\25\2\7\1\27\1\254\2\0\5"+
    "\7\1\160\1\72\1\260\3\7\1\61\12\7\1\162\3\0\1\151\1\7\1\37\14\7\1\102\3\7"+
    "\1\22\1\7\7\0\1\151\1\7\1\261\1\262\2\7\1\47\3\0\6\7\1\225\1\0\1\63\5\7\1"+
    "\217\1\27\1\172\1\0\1\27\1\162\2\27\1\63\1\263\1\27\1\63\2\7\1\61\1\172\2"+
    "\7\1\160\1\27\1\224\1\0\3\7\1\25\1\74\5\7\1\47\1\27\1\243\1\151\1\27\1\162"+
    "\1\264\1\7\1\27\1\265\5\7\1\76\1\161\1\0\1\262\1\266\1\27\1\162\2\7\1\22\1"+
    "\267\6\7\1\203\1\270\1\223\2\0\1\271\1\7\1\47\1\272\1\0\3\273\1\0\2\22\5\7"+
    "\1\211\1\71\1\0\16\7\1\47\1\274\1\27\1\162\64\7\1\225\1\0\2\7\1\22\1\275\5"+
    "\7\1\225\40\0\55\7\1\71\15\7\1\24\4\0\1\22\1\0\1\275\1\276\1\7\1\103\1\22"+
    "\1\171\1\277\15\7\1\24\3\0\1\275\20\7\1\71\1\165\32\7\1\71\2\0\10\7\1\37\6"+
    "\7\5\0\1\7\1\24\2\27\2\0\2\27\1\300\2\0\1\301\4\0\1\302\1\235\17\7\1\25\2"+
    "\0\1\27\1\162\1\40\2\7\1\303\1\40\2\7\1\45\1\304\6\7\1\61\3\7\1\22\3\37\1"+
    "\305\4\0\1\7\1\143\2\7\1\22\2\7\1\306\1\7\1\71\1\7\1\71\4\0\17\7\1\45\10\0"+
    "\6\7\1\25\20\0\1\307\20\0\3\7\1\25\6\7\1\125\1\0\1\243\3\0\4\7\2\0\3\7\1\45"+
    "\4\7\1\61\1\46\3\7\1\71\4\7\1\225\1\7\1\256\5\0\23\7\1\71\1\27\1\162\4\7\1"+
    "\225\4\7\1\225\5\7\1\0\6\7\1\225\23\0\46\7\1\22\1\0\2\7\1\71\1\0\1\7\23\0"+
    "\1\71\1\103\4\7\1\35\1\310\2\7\1\71\1\0\2\7\1\22\1\0\3\7\1\22\10\0\2\7\1\311"+
    "\1\0\2\7\1\71\1\0\3\7\1\24\10\0\7\7\1\304\10\0\1\312\1\72\1\143\1\40\2\7\1"+
    "\225\1\115\4\0\3\7\1\25\3\7\1\25\4\0\1\7\1\40\2\7\1\313\3\0\6\7\1\71\1\0\2"+
    "\7\1\71\1\0\2\7\1\45\1\0\2\7\1\24\15\0\11\7\1\125\6\0\6\7\1\45\1\0\6\7\1\45"+
    "\41\0\1\230\6\7\1\27\1\161\3\0\1\121\1\27\1\0\1\107\1\230\5\7\1\27\1\46\2"+
    "\0\3\7\1\125\1\27\1\162\1\230\3\7\1\160\1\27\1\141\1\27\2\0\4\7\1\314\1\0"+
    "\1\230\5\7\1\47\1\27\1\315\1\316\1\27\1\317\4\0\2\7\1\34\2\7\1\217\1\27\1"+
    "\200\10\0\1\22\1\320\1\7\1\35\1\7\1\125\5\7\1\160\1\27\1\46\1\27\1\162\1\137"+
    "\1\101\1\102\2\7\1\103\1\123\1\105\1\53\1\116\1\136\1\251\1\77\2\177\21\0"+
    "\6\7\1\176\1\27\1\201\1\45\1\27\1\162\4\0\6\7\2\27\1\321\1\0\1\27\1\162\24"+
    "\0\5\7\1\160\1\172\1\27\1\243\2\0\1\266\4\0\6\7\2\27\1\322\1\0\1\27\1\162"+
    "\4\0\5\7\1\47\1\27\1\0\1\27\1\162\6\0\3\7\1\323\1\27\1\224\1\27\1\162\54\0"+
    "\10\7\1\27\1\162\1\0\1\151\70\0\7\7\1\125\40\0\1\7\1\103\3\7\1\160\1\161\1"+
    "\27\1\125\1\0\1\27\1\162\2\0\1\37\3\7\1\324\2\27\1\42\1\161\51\0\63\7\1\24"+
    "\14\0\15\7\1\22\2\0\30\7\1\225\27\0\5\7\1\22\72\0\10\7\1\22\67\0\7\7\1\125"+
    "\3\7\1\22\1\27\1\162\14\0\3\7\1\71\1\177\1\0\6\7\1\161\1\0\1\225\1\0\1\27"+
    "\1\162\1\275\2\7\1\251\2\7\56\0\10\7\1\25\1\0\1\76\4\27\1\161\1\0\1\107\1"+
    "\230\1\7\10\0\1\125\3\0\75\7\1\25\2\0\36\7\1\45\41\0\1\24\77\0\15\7\1\45\1"+
    "\7\1\25\1\7\1\125\1\7\1\325\130\0\1\301\1\326\1\46\1\227\1\327\1\224\3\0\1"+
    "\330\22\0\1\316\67\0\12\7\1\30\10\7\1\30\1\331\1\332\1\7\1\333\1\143\7\7\1"+
    "\35\1\334\2\30\3\7\1\335\1\171\1\37\1\103\51\7\1\71\3\7\1\103\2\7\1\211\3"+
    "\7\1\211\2\7\1\30\3\7\1\30\2\7\1\22\3\7\1\22\3\7\1\103\3\7\1\103\2\7\1\211"+
    "\1\336\14\27\1\161\1\227\5\27\1\177\1\307\1\0\1\244\2\0\1\227\1\42\1\27\52"+
    "\0\1\161\2\27\1\337\1\340\1\46\72\0\30\7\1\25\1\0\1\161\5\0\10\7\1\217\1\46"+
    "\1\27\1\162\24\0\1\143\3\7\1\163\1\40\1\211\1\341\1\247\1\342\1\163\1\235"+
    "\1\163\2\211\1\120\1\7\1\34\1\7\1\225\1\343\1\34\1\7\1\225\50\0\32\7\1\22"+
    "\5\0\106\7\1\25\1\0\33\7\1\71\120\7\1\24\53\0\3\7\1\71\134\0\36\27\2\0");

  /* The ZZ_CMAP_A table has 1824 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\1\1\3\2\1\1\3\2\0\1\1\1\0\1\10\1\4\1\25\5\0\1\5\2\0\1\26\1\14\1\2"+
    "\12\12\1\0\1\24\1\21\1\0\1\22\2\0\6\13\16\6\1\16\5\6\1\0\1\11\1\0\1\23\1\6"+
    "\1\0\1\42\1\13\1\44\1\45\1\31\1\30\1\6\1\40\1\27\2\6\1\32\1\41\1\36\1\34\2"+
    "\6\1\35\1\33\1\43\1\15\1\6\1\37\3\6\1\17\1\0\1\20\7\0\1\1\2\0\1\1\11\0\1\6"+
    "\12\0\1\6\1\0\1\7\7\6\1\0\2\6\4\0\4\6\6\0\5\6\7\0\1\6\1\0\1\6\1\0\10\7\5\6"+
    "\1\0\2\6\3\0\3\6\1\0\1\6\6\0\1\6\1\7\3\6\1\0\1\6\1\0\4\6\1\0\13\6\1\0\3\6"+
    "\1\0\5\7\2\0\6\6\1\0\7\6\1\0\1\6\7\0\15\7\1\0\1\7\1\0\2\7\1\0\2\7\1\0\1\7"+
    "\3\6\5\0\3\7\5\0\3\6\7\7\4\0\2\6\1\7\13\6\1\0\1\6\7\7\2\0\6\7\2\6\2\7\1\0"+
    "\4\7\2\6\2\7\3\6\2\0\2\6\1\7\6\6\3\7\2\0\11\6\3\7\1\6\6\0\2\7\6\6\4\7\2\6"+
    "\2\0\2\7\1\6\11\7\1\6\3\7\1\6\5\7\2\0\1\6\3\7\4\0\6\6\6\0\6\7\1\0\11\7\6\6"+
    "\3\7\1\6\2\7\1\6\7\7\2\6\2\7\2\0\2\7\1\6\3\7\1\0\10\6\2\0\2\6\2\0\6\6\1\0"+
    "\7\6\1\0\1\6\3\0\4\6\2\0\1\7\1\6\3\7\2\0\3\7\1\6\10\0\1\7\4\0\2\6\1\0\1\6"+
    "\1\0\3\7\1\0\6\6\4\0\2\6\1\0\2\6\1\0\2\6\1\0\2\6\2\0\1\7\1\0\5\7\4\0\2\7\2"+
    "\0\3\7\3\0\1\7\7\0\4\6\1\0\1\6\7\0\4\7\3\6\1\7\2\0\1\6\1\0\2\6\1\0\3\6\2\7"+
    "\1\0\3\7\2\0\1\6\11\0\1\7\1\6\1\0\6\6\3\0\3\6\1\0\4\6\3\0\2\6\1\0\1\6\1\0"+
    "\2\6\3\0\2\6\3\0\2\6\4\0\5\7\3\0\3\7\1\0\4\7\2\0\1\6\6\0\5\7\1\0\5\6\3\0\1"+
    "\6\7\7\1\0\2\7\5\0\2\7\1\0\4\6\1\0\3\6\6\0\1\6\2\0\2\6\5\0\3\6\2\0\1\6\3\7"+
    "\1\0\4\7\1\6\5\0\3\6\1\7\7\0\1\6\2\0\2\7\1\0\7\6\1\0\1\6\4\0\1\7\4\0\6\7\1"+
    "\0\1\7\3\0\2\7\4\0\1\6\1\7\1\6\5\7\7\6\10\7\1\0\2\7\7\0\2\6\1\0\1\6\2\0\2"+
    "\6\1\0\1\6\2\0\1\6\6\0\4\6\1\0\3\6\1\0\1\6\1\0\1\6\2\0\2\6\1\0\3\6\2\7\1\0"+
    "\2\7\1\6\2\0\5\6\1\0\1\6\1\0\6\7\2\0\2\7\2\0\4\6\5\0\1\7\1\0\1\7\1\0\1\7\4"+
    "\0\2\7\5\6\10\7\11\0\1\7\1\0\7\7\1\6\2\7\4\6\3\7\1\6\3\7\2\6\7\7\3\6\4\7\5"+
    "\6\14\7\1\6\1\7\5\0\1\6\2\0\3\6\1\0\7\6\2\0\3\7\1\1\11\6\3\7\3\0\2\6\2\7\4"+
    "\0\1\6\1\0\2\7\4\0\4\6\10\7\3\0\1\6\4\0\1\6\1\7\5\0\3\7\2\0\1\6\1\7\1\6\5"+
    "\0\4\7\4\0\4\6\4\0\5\7\3\6\3\0\10\7\5\6\2\7\3\0\3\6\3\7\1\0\5\7\4\6\1\7\4"+
    "\6\3\7\2\6\2\0\1\6\1\0\1\6\1\0\1\6\1\0\1\6\2\0\3\6\1\0\6\6\2\0\2\6\13\1\5"+
    "\0\2\1\5\0\1\1\1\7\13\0\1\7\12\0\1\1\1\0\1\7\3\0\3\7\2\0\1\6\4\0\3\6\2\0\4"+
    "\6\5\0\5\6\4\0\1\6\4\0\4\6\3\7\2\6\4\0\1\1\4\0\3\6\1\0\5\6\3\0\2\7\2\0\3\6"+
    "\6\7\1\0\3\6\1\7\3\6\1\7\4\6\1\7\4\6\3\0\1\6\1\0\1\6\2\0\5\6\1\7\2\6\2\7\5"+
    "\6\1\0\4\6\2\7\4\0\1\6\3\7\2\6\1\7\5\6\2\7\3\0\3\6\4\0\3\6\2\7\2\0\6\6\1\0"+
    "\3\7\1\0\2\7\5\0\5\6\5\0\1\6\1\7\3\6\1\0\2\6\1\0\2\6\3\0\2\7\10\0\3\7\1\0"+
    "\1\6\1\0\1\6\3\0\4\6\4\0\1\7\6\0\2\6\2\0\3\6\3\0\3\6\1\0\2\6\1\0\1\6\5\0\1"+
    "\7\2\0\1\6\3\0\1\6\2\0\4\6\1\0\2\6\2\0\1\6\3\7\1\0\2\7\1\0\5\6\2\7\1\0\3\6"+
    "\1\7\2\0\1\6\1\0\1\7\4\6\5\0\3\7\3\0\2\7\1\6\1\0\1\6\3\0\1\6\1\0\4\6\1\0\1"+
    "\6\4\7\2\6\1\0\1\6\1\7\3\0\1\6\3\0\2\6\3\0\3\7\2\0\6\7\2\6\3\0\2\7\1\0\2\7"+
    "\3\0\6\7\2\0\3\7\2\0\4\7\4\0\1\6\2\0\2\6\2\0\4\6\1\0\4\6\1\0\1\6\1\0\6\6\2"+
    "\0\5\6\1\0\4\6\1\0\4\6\2\0\3\7\2\0\7\7\1\0\2\7\1\0\2\7\1\0\1\6\1\0\1\6\5\0"+
    "\1\6\1\0\1\6\1\0\3\6\1\0\3\6\1\0\3\6");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\1\2\1\1\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\11\4"+
    "\1\16\1\17\1\16\1\20\2\0\1\21\1\22\10\4"+
    "\4\23\1\24\1\0\1\25\1\4\1\26\4\4\1\27"+
    "\2\16\1\30\1\31\4\4\2\16\1\32\1\33\1\34"+
    "\1\35\1\16";

  private static int [] zzUnpackAction() {
    int [] result = new int[72];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\46\0\114\0\162\0\230\0\276\0\344\0\u010a"+
    "\0\u0130\0\230\0\230\0\230\0\230\0\230\0\230\0\230"+
    "\0\230\0\230\0\u0156\0\u017c\0\u01a2\0\u01c8\0\u01ee\0\u0214"+
    "\0\u023a\0\u0260\0\u0286\0\u02ac\0\230\0\u02d2\0\230\0\u02f8"+
    "\0\u031e\0\u0130\0\u0130\0\u0344\0\u036a\0\u0390\0\u03b6\0\u03dc"+
    "\0\u0402\0\u0428\0\u044e\0\u02ac\0\230\0\u0474\0\u049a\0\u04c0"+
    "\0\u04e6\0\u0130\0\u050c\0\u0130\0\u0532\0\u0558\0\u057e\0\u05a4"+
    "\0\u0130\0\u05ca\0\u05f0\0\230\0\u0130\0\u0616\0\u063c\0\u0662"+
    "\0\u0688\0\u06ae\0\u0474\0\u0130\0\u0130\0\u0130\0\u0130\0\u06d4";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[72];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\1\6\1\7\1\6\1\10\1\5\1\11\4\5"+
    "\1\11\1\12\2\11\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\4\11"+
    "\1\27\1\11\1\30\1\11\1\31\1\32\1\33\10\34"+
    "\1\35\1\36\34\34\56\5\1\37\35\5\47\0\1\6"+
    "\1\0\1\6\44\0\1\40\2\0\1\41\40\0\3\10"+
    "\1\0\42\10\6\0\2\11\2\0\2\11\1\0\2\11"+
    "\10\0\17\11\6\0\2\11\2\0\2\11\1\0\2\11"+
    "\10\0\1\11\1\42\5\11\1\43\7\11\6\0\2\11"+
    "\2\0\2\11\1\0\2\11\10\0\5\11\1\44\11\11"+
    "\6\0\2\11\2\0\2\11\1\0\2\11\10\0\3\11"+
    "\1\45\13\11\6\0\2\11\2\0\2\11\1\0\2\11"+
    "\10\0\2\11\1\46\14\11\6\0\2\11\2\0\2\11"+
    "\1\0\2\11\10\0\11\11\1\47\5\11\6\0\2\11"+
    "\2\0\2\11\1\0\2\11\10\0\13\11\1\50\3\11"+
    "\6\0\2\11\2\0\2\11\1\0\2\11\10\0\6\11"+
    "\1\51\10\11\6\0\2\11\2\0\2\11\1\0\2\11"+
    "\10\0\3\11\1\52\13\11\6\0\2\11\2\0\2\11"+
    "\1\0\2\11\10\0\2\11\1\53\14\11\10\34\1\0"+
    "\35\34\10\54\1\55\4\54\1\56\1\57\27\54\2\0"+
    "\1\60\43\0\5\41\1\61\40\41\6\0\2\11\2\0"+
    "\2\11\1\0\2\11\10\0\6\11\1\62\10\11\6\0"+
    "\2\11\2\0\2\11\1\0\2\11\10\0\4\11\1\63"+
    "\12\11\6\0\2\11\2\0\2\11\1\0\2\11\10\0"+
    "\14\11\1\64\2\11\6\0\2\11\2\0\2\11\1\0"+
    "\2\11\10\0\1\65\16\11\6\0\2\11\2\0\2\11"+
    "\1\0\2\11\10\0\14\11\1\66\2\11\6\0\2\11"+
    "\2\0\2\11\1\0\2\11\10\0\13\11\1\67\3\11"+
    "\6\0\2\11\2\0\2\11\1\0\2\11\10\0\13\11"+
    "\1\70\3\11\6\0\2\11\2\0\2\11\1\0\2\11"+
    "\10\0\1\11\1\71\15\11\10\34\1\0\1\34\2\72"+
    "\14\34\2\72\10\34\1\72\1\34\2\72\10\34\1\0"+
    "\1\34\2\73\14\34\2\73\10\34\1\73\1\34\2\73"+
    "\3\60\1\0\42\60\2\41\1\74\2\41\1\61\40\41"+
    "\6\0\2\11\2\0\2\11\1\0\2\11\10\0\2\11"+
    "\1\75\14\11\6\0\2\11\2\0\2\11\1\0\2\11"+
    "\10\0\3\11\1\76\13\11\6\0\2\11\2\0\2\11"+
    "\1\0\2\11\10\0\15\11\1\77\1\11\6\0\2\11"+
    "\2\0\2\11\1\0\2\11\10\0\1\100\16\11\6\0"+
    "\2\11\2\0\2\11\1\0\2\11\10\0\4\11\1\101"+
    "\12\11\10\34\1\0\1\34\2\102\14\34\2\102\10\34"+
    "\1\102\1\34\2\102\10\34\1\0\1\34\2\103\14\34"+
    "\2\103\10\34\1\103\1\34\2\103\6\0\2\11\2\0"+
    "\2\11\1\0\2\11\10\0\2\11\1\104\14\11\6\0"+
    "\2\11\2\0\2\11\1\0\2\11\10\0\11\11\1\105"+
    "\5\11\6\0\2\11\2\0\2\11\1\0\2\11\10\0"+
    "\14\11\1\106\2\11\6\0\2\11\2\0\2\11\1\0"+
    "\2\11\10\0\4\11\1\107\12\11\10\34\1\0\1\34"+
    "\2\110\14\34\2\110\10\34\1\110\1\34\2\110\10\34"+
    "\1\0\1\34\2\54\14\34\2\54\10\34\1\54\1\34"+
    "\2\54";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1786];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\4\0\1\11\4\1\11\11\12\1\1\11\1\1\1\11"+
    "\2\0\13\1\1\11\3\1\1\0\12\1\1\11\14\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[72];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
private static int indent_balance = 0;
private static IntStack brace_stack = new IntStack(9);

public _ValkyrieLexer() {
	this((java.io.Reader)null);
}

public void brace_block(int state) {
    brace_stack.push(state);
    yybegin(CodeContext);
}

public void brace_recover() {
    if (brace_stack.empty()) {
        yybegin(YYINITIAL);
    }
    else {
        yybegin(brace_stack.pop());
    }
}

public void count_indent() {
    // yytext().last_line.count_indent
}
public void match_indent() {
    // length may < indent_balance
    // t = yytext().length() - indent_balance - Length of Newline
    // yypushback(t);
}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _ValkyrieLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 30: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 31: break;
          case 3: 
            { return COMMENT_LINE;
            } 
            // fall through
          case 32: break;
          case 4: 
            { return SYMBOL;
            } 
            // fall through
          case 33: break;
          case 5: 
            { return DOT;
            } 
            // fall through
          case 34: break;
          case 6: 
            { return BRACE_L;
            } 
            // fall through
          case 35: break;
          case 7: 
            { return BRACE_R;
            } 
            // fall through
          case 36: break;
          case 8: 
            { return ANGLE_L;
            } 
            // fall through
          case 37: break;
          case 9: 
            { return ANGLE_R;
            } 
            // fall through
          case 38: break;
          case 10: 
            { return ACCENT;
            } 
            // fall through
          case 39: break;
          case 11: 
            { return SEMICOLON;
            } 
            // fall through
          case 40: break;
          case 12: 
            { return DOLLAR;
            } 
            // fall through
          case 41: break;
          case 13: 
            { return HYPHEN;
            } 
            // fall through
          case 42: break;
          case 14: 
            { return STRING_CHAR;
            } 
            // fall through
          case 43: break;
          case 15: 
            { yybegin(CodeContext);
	return STRING_QUOTE;
            } 
            // fall through
          case 44: break;
          case 16: 
            { yybegin(StringQuote);
    return STRING_QUOTE;
            } 
            // fall through
          case 45: break;
          case 17: 
            { return IF;
            } 
            // fall through
          case 46: break;
          case 18: 
            { return IN;
            } 
            // fall through
          case 47: break;
          case 19: 
            { return STRING_ESCAPE;
            } 
            // fall through
          case 48: break;
          case 20: 
            { return COMMENT_DOCUMENT;
            } 
            // fall through
          case 49: break;
          case 21: 
            { return FOR;
            } 
            // fall through
          case 50: break;
          case 22: 
            { return LET;
            } 
            // fall through
          case 51: break;
          case 23: 
            { return DEF;
            } 
            // fall through
          case 52: break;
          case 24: 
            { return COMMENT_BLOCK;
            } 
            // fall through
          case 53: break;
          case 25: 
            { return ELSE;
            } 
            // fall through
          case 54: break;
          case 26: 
            { return WHILE;
            } 
            // fall through
          case 55: break;
          case 27: 
            { return MATCH;
            } 
            // fall through
          case 56: break;
          case 28: 
            { return TRAIT;
            } 
            // fall through
          case 57: break;
          case 29: 
            { return CLASS;
            } 
            // fall through
          case 58: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
