/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package wpi.parking;

import java.util.TimerTask;

/**
 * The TollboothGateCloser is a TimerTask that closes the given TollboothGate
 * 
 * @author Chris Casola
 * @version Jan 15, 2013
 */
public class TollboothGateCloser extends TimerTask {
	
	private final TollboothGate gate;
	
	/**
	 * Constructor that allows specification of the TollboothGate to close
	 * @param gate the TollboothGate to close
	 */
	public TollboothGateCloser(TollboothGate gate) {
		this.gate = gate;
	}

	/**
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		try {
			gate.close();
		} catch (WPIPSException e) {
			// Error occurred when automatically closing the gate.
			e.printStackTrace();
		}
	}

}
