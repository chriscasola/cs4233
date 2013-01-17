/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package wpi.parking;

import java.util.Timer;

import wpi.parking.hw.TollboothGateController;

/**
 * The TollboothGate class encapsulates all control functions for a single
 * gate at a tollbooth in the parking management system.
 *
 * @author gpollice
 * @version Dec 31, 2012
 */
public class TollboothGate
{
	public enum TollboothGateState { UNKNOWN, OPEN, CLOSED, DEACTIVATED };
	private final TollboothGateController controller;
	private TollboothGateState state;
	private Timer gateTimer;
	private final int delayBeforeClose;

	/**
	 * Default constructor.
	 *
	 * @param id the tollbooth gate's ID.
	 * @param controller the hardware tollbooth gate controller for this gate
	 * @throws WPIPSException if there are any errors that occur during the initialization
	 */
	public TollboothGate(String id, TollboothGateController controller) throws WPIPSException
	{
		this(id, controller, 0);
	}

	/**
	 * Constructor that allows specification of the delay in seconds before the gate should close
	 * 
	 * @param id the tollbooth gate's ID.
	 * @param controller the hardware tollbooth gate controller for this gate
	 * @param delayBeforeClose the delay in seconds before an open gate should close
	 * @throws WPIPSException if there are any errors that occur during the initialization
	 */
	public TollboothGate(String id, 
			TollboothGateController controller, 
			int delayBeforeClose) 
					throws WPIPSException
	{
		if (id == null || id.equals("")) {
			throw new WPIPSException("Tollbooth gate ID cannot be blank");
		}
		this.controller = controller;
		state = TollboothGateState.CLOSED;
		this.delayBeforeClose = delayBeforeClose;
		gateTimer = new Timer();
	}

	/**
	 * Open the gate.
	 * @return the gate's state. It will be OPEN or UNKNOWN if there was a problem.
	 * @throws WPIPSException if an error occurred and the gate could not open
	 */
	public TollboothGateState open() throws WPIPSException
	{
		if (state != TollboothGateState.DEACTIVATED) {
			try {
				controller.open();
				state = TollboothGateState.OPEN;
			} catch (WPIPSException e) {
				state = TollboothGateState.UNKNOWN;
				throw e;
			}
			if (delayBeforeClose > 0) {
				gateTimer.cancel();
				gateTimer = new Timer();
				gateTimer.schedule(new TollboothGateCloser(this), delayBeforeClose * 1000);
			}
		}
		else {
			throw new WPIPSException("A deactivated gate cannot be opened");
		}
		return state;
	}

	/**
	 * Close the gate.
	 * @return the gate's state. It will be CLOSED or UNKNOWN if there was a problem.
	 * @throws WPIPSException if an error occurred and the gate could not close
	 */
	public TollboothGateState close() throws WPIPSException
	{
		if (state != TollboothGateState.DEACTIVATED) {
			try {
				controller.close();
				state = TollboothGateState.CLOSED;
				gateTimer.cancel();
			} catch (WPIPSException e) {
				state = TollboothGateState.UNKNOWN;
				throw e;
			}
		}
		else {
			throw new WPIPSException("A deactivated gate cannot be closed");
		}
		return state;
	}

	/**
	 * Deactivate the gate
	 * @throws WPIPSException 
	 * 
	 * @return The new state of the gate
	 */
	public TollboothGateState deactivate() throws WPIPSException
	{
		if (state != TollboothGateState.DEACTIVATED) {
			state = TollboothGateState.DEACTIVATED;
			gateTimer.cancel();
			return state;
		}
		else {
			throw new WPIPSException("This gate is already deactivated");
		}
	}

	/**
	 * Activate the gate and close it.
	 * @throws WPIPSException
	 * 
	 * @return The new state of the gate
	 */
	public TollboothGateState activate() throws WPIPSException
	{
		if (state == TollboothGateState.DEACTIVATED) {
			state = TollboothGateState.UNKNOWN;
			close();
			return state;
		}
		else {
			throw new WPIPSException("You cannot activate an already active gate.");
		}
	}

	/**
	 * @return the tollbooth gate state.
	 */
	public TollboothGateState getState()
	{
		return state;
	}

	/**
	 * @return the delay in seconds before the toolbooth gate will close
	 */
	public int getDelayBeforeClose()
	{
		return delayBeforeClose;
	}
}
