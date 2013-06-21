package org.ptolemy.xtext.lib.caltrop;

import ptolemy.actor.IOPort;
import ptolemy.actor.TypedIOPort;
import ptolemy.actor.util.BooleanDependency;
import ptolemy.actor.util.CausalityInterface;
import ptolemy.actor.util.Dependency;
import ptolemy.data.Token;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

public abstract class AbstractConversionRelationActor<T, S> extends AbstractCaltropActor {

	protected TypedIOPort input, output;

	protected TypedIOPort _createInputPort() throws NameDuplicationException, IllegalActionException {
		TypedIOPort port = new TypedIOPort(this, "input", true, false);
		port.setMultiport(false);
		// subclass must ensure to set type
		return port;
	}

	protected TypedIOPort _createOutputPort() throws NameDuplicationException, IllegalActionException {
		TypedIOPort port = new TypedIOPort(this, "output", false, true);
		port.setMultiport(false);
		// subclass must ensure to set type
		return port;
	}

	protected abstract T _getInputTokenValue(final Token input) throws IllegalActionException;


	protected abstract Token _createOutputToken(final S output) throws IllegalActionException;

	public AbstractConversionRelationActor(final CompositeEntity parent, final String name) throws NameDuplicationException, IllegalActionException {
		super(parent, name);
		this.input = _createInputPort();
		this.output = _createOutputPort();
	}

	protected Pair<Integer,AbstractActionImpl> _fireImpl() throws IllegalActionException {
		if (_actionImpls[0].match()) return new Pair.Impl<Integer, AbstractActionImpl>(-1, _actionImpls[0]);
		return null;
	}

	@SuppressWarnings("all")
	public abstract class ConversionAction extends AbstractActionImpl {
		private T input;

		public boolean match() throws IllegalActionException {
			if (! hasToken(AbstractConversionRelationActor.this.input, 0, 1)) return false;
			input = _getInputTokenValue(AbstractConversionRelationActor.this.input.get(0));
			return true; 
		}

		public abstract S _convert(T input) throws Throwable;

		public void output() throws IllegalActionException {
			S output = null;
			try {
				output = _convert(input);
			} catch (Throwable e1) {
			}
			send(AbstractConversionRelationActor.this.output, 0, _createOutputToken(output), -1);
		}

		public Pair<Pair<IOPort,IOPort>,Dependency>[] getDependencies() {
			return new Pair[]{
					new Pair.Impl(new Pair.Impl(AbstractConversionRelationActor.this.input, AbstractConversionRelationActor.this.output), BooleanDependency.valueOf(true)), new Pair.Impl(new Pair.Impl(AbstractConversionRelationActor.this.input, AbstractConversionRelationActor.this.output), BooleanDependency.valueOf(true)), 
			};
		}
	}

	protected abstract ConversionAction _createConversionAction();
	
	private final AbstractActionImpl[] _actionImpls = new AbstractActionImpl[]{
			_createConversionAction(), 
	}
	;

	public CausalityInterface getCausalityInterface() throws IllegalActionException {
		return _getCausalityInterface(_actionImpls);

	}
}
