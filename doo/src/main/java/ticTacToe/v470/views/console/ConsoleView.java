package ticTacToe.v470.views.console;

import ticTacToe.v470.View;
import ticTacToe.v470.controllers.ColocateController;
import ticTacToe.v470.controllers.ContinueController;
import ticTacToe.v470.controllers.OperationController;
import ticTacToe.v470.controllers.StartController;

public class ConsoleView implements View {
	
	private StartView startView;
	
	private GameView gameView;
	
	private ContinueView continueView;
		
	public ConsoleView(){
		BoardView boardView = new BoardView();
		startView = new StartView(boardView);
		gameView = new GameView(boardView);
		continueView = new ContinueView();
	}

	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
	@Override
	public void visit(StartController startController) {
		startView.interact(startController);
	}
	
	@Override
	public void visit(ColocateController colocateController) {
		gameView.interact(colocateController);
	}

	@Override
	public void visit(ContinueController continueController) {
		continueView.interact(continueController);
	}

}
