package exception;

import logic.Logic;

public class PlaneMoveFailedException extends Exception{
	
	private static final long serialVersionUID = -6215045959477281408L;

	public PlaneMoveFailedException() {
		Logic.getPlane().setPlaneSpeed(0);
		Logic.setLeftClick(false);
		Logic.setRightClick(false);
		if(Logic.getPlane().getX()<0) {
			Logic.getPlane().setX(0);
		}
		else if(Logic.getPlane().getX()>600-Logic.getPlane().getWidth()) {
			Logic.getPlane().setX(600-Logic.getPlane().getWidth());
		}
	}
}
