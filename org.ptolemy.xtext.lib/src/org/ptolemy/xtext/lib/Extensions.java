package org.ptolemy.xtext.lib;

import java.util.Map;

import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.Pure;

import com.google.common.collect.Iterables;

public class Extensions {

	@Pure
	@Inline(value="com.google.common.collect.Iterables.get($1, $2)", imported=Iterables.class, statementExpression=true)
	public static <T> T operator_index(Iterable<T> iterable, int pos) {
		return Iterables.get(iterable, pos);
	}

	@Pure
	@Inline(value="$1.get($2)", statementExpression=true)
	public static <K,V> V operator_index(Map<K,V> map, K key) {
		return map.get(key);
	}
	
	@Pure
	@Inline(value="$1.get($2)", statementExpression=true)
	public static <V> V operator_index(org.ptolemy.xtext.lib.caltrop.ChannelMap<V> map, int key) {
		return map.get(key);
	}

	@Pure @Inline(value="$1[$2]") public static <T> T operator_index(T[] array, int pos) {
		return array[pos];
	}
	@Pure @Inline(value="$1[$2]") public static boolean operator_index(boolean	[] array, int pos) { return array[pos];}
	@Pure @Inline(value="$1[$2]") public static char 	operator_index(char		[] array, int pos) { return array[pos];}
	@Pure @Inline(value="$1[$2]") public static int 	operator_index(int		[] array, int pos) { return array[pos];}
	@Pure @Inline(value="$1[$2]") public static byte 	operator_index(byte		[] array, int pos) { return array[pos];}
	@Pure @Inline(value="$1[$2]") public static short 	operator_index(short	[] array, int pos) { return array[pos];}
	@Pure @Inline(value="$1[$2]") public static long 	operator_index(long		[] array, int pos) { return array[pos];}
	@Pure @Inline(value="$1[$2]") public static double 	operator_index(double	[] array, int pos) { return array[pos];}
	@Pure @Inline(value="$1[$2]") public static float 	operator_index(float	[] array, int pos) { return array[pos];}

	@Pure
	@Inline(value="$1.charAt($2)", statementExpression=true)
	public static char operator_index(String s, int position) {
		return s.charAt(position);
	}

	@Pure
	@Inline(value="($1 >> $2) & 1")
	public static int operator_index(int i, int bit) {
		return (i >> bit) & 1;
	}
}
