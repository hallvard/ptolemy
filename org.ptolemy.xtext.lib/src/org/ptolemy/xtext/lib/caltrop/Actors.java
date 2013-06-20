package org.ptolemy.xtext.lib.caltrop;

import org.ptolemy.xtext.lib.caltrop.tokens.Token;

public class Actors {

	public interface Actor01<O1> extends Actor {
		Token<O1> prefire	();
		Token<O1> fire		();
		Token<O1> postfire	();
	}
	public static class Actor01Impl<O1> extends Actor.Impl implements Actor01<O1> {
		public Token<O1> prefire() 	{ return null;}
		public Token<O1> fire() 	{ return null;}
		public Token<O1> postfire() { return null;}
	}

	public interface Actor10<I1> extends Actor {
		void prefire	(Token<I1> i1);
		void fire		(Token<I1> i1);
		void postfire	(Token<I1> i1);
	}
	public static class Actor10Impl<I1> extends Actor.Impl implements Actor10<I1> {
		public void prefire		(Token<I1> i1)	{}
		public void fire		(Token<I1> i1)	{}
		public void postfire	(Token<I1> i1)	{}
	}
	
	public interface Actor11<I1,O1> extends Actor {
		Token<O1> prefire	(Token<I1> i1);
		Token<O1> fire		(Token<I1> i1);
		Token<O1> postfire	(Token<I1> i1);
	}
	public static class Actor11Impl<I1,O1> extends Actor.Impl implements Actor11<I1,O1> {
		public Token<O1> prefire	(Token<I1> i1) { return null;}
		public Token<O1> fire		(Token<I1> i1) { return null;}
		public Token<O1> postfire	(Token<I1> i1) { return null;}
	}
	
	public interface Actor21<I1,I2,O1> extends Actor {
		Token<O1> prefire	(Token<I1> i1, Token<I2> i2);
		Token<O1> fire		(Token<I1> i1, Token<I2> i2);
		Token<O1> postfire	(Token<I1> i1, Token<I2> i2);
	}	
	public static class Actor21Impl<I1,I2,O1> extends Actor.Impl implements Actor21<I1,I2,O1> {
		public Token<O1> prefire	(Token<I1> i1, Token<I2> i2) { return null;}
		public Token<O1> fire		(Token<I1> i1, Token<I2> i2) { return null;}
		public Token<O1> postfire	(Token<I1> i1, Token<I2> i2) { return null;}
	}

	public interface Actor22<I1,I2,O1,O2> extends Actor {
		Pair<Token<O1>,Token<O2>> prefire	(Token<I1> i1, Token<I2> i2);
		Pair<Token<O1>,Token<O2>> fire		(Token<I1> i1, Token<I2> i2);
		Pair<Token<O1>,Token<O2>> postfire	(Token<I1> i1, Token<I2> i2);
	}
	public static class Actor22Impl<I1,I2,O1,O2> extends Actor.Impl implements Actor22<I1,I2,O1,O2> {
		public Pair<Token<O1>, Token<O2>> prefire	(Token<I1> i1, Token<I2> i2) { return null;}
		public Pair<Token<O1>, Token<O2>> fire		(Token<I1> i1, Token<I2> i2) { return null;}
		public Pair<Token<O1>, Token<O2>> postfire	(Token<I1> i1, Token<I2> i2) { return null;}
	}
}
