/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package wpi.parking;

import static org.junit.Assert.*;
import org.junit.*;
import wpi.parking.hw.*;

/**
 * Test cases for the TollboothGate class.
 *
 * @author gpollice
 * @version Dec 31, 2012
 */
public class TollboothGateTest
{
	private TestGateController controller;
	private TollboothGate gate;
	
	/**
	 * Create the gate controller that we will use in the tests.
	 * @throws WPIPSException 
	 */
	@Before
	public void setup() throws WPIPSException
	{
		controller = new TestGateController();
		gate = new TollboothGate("gate1", controller);
	}
	
	@Test
	public void specifyGateCloseDelay() throws WPIPSException
	{
		final TollboothGate gate = new TollboothGate("gate1", controller, 5);
		assertEquals(5, gate.getDelayBeforeClose());
	}
	
	/**
	 * A gate should remain open indefinitely by default
	 */
	@Test
	public void gateShouldRemainOpenByDefault()
	{
		assertEquals(0, gate.getDelayBeforeClose());
	}
	
	/**
	 * A deactivated gate should not respond to open messages
	 * @throws WPIPSException
	 */
	@Test
	public void deactivatedGateShouldIgnoreOpen() throws WPIPSException
	{
		gate.deactivate();
		gate.open();
		assertEquals(TollboothGate.TollboothGateState.DEACTIVATED, gate.getState());
	}
	
	/**
	 * A deactivated gate should not respond to close messages
	 * @throws WPIPSException
	 */
	@Test
	public void deactivatedGateShouldIgnoreClose() throws WPIPSException
	{
		gate.deactivate();
		gate.close();
		assertEquals(TollboothGate.TollboothGateState.DEACTIVATED, gate.getState());
	}
	
	/**
	 * Activating an active gate should cause an exception
	 * @throws WPIPSException
	 */
	@Test(expected=WPIPSException.class)
	public void activateAnActivatedGate() throws WPIPSException
	{
		gate.activate();
	}
	
	/**
	 * Activate a deactivated gate. The gate should be put in the closed state.
	 * @throws WPIPSException
	 */
	@Test
	public void activateADeactivatedGate() throws WPIPSException
	{
		gate.deactivate();
		gate.activate();
		assertEquals(TollboothGate.TollboothGateState.CLOSED, gate.getState());
	}
	
	/**
	 * Deactivate a closed gate, this should make the gate deactivated
	 * @throws WPIPSException
	 */
	@Test
	public void deactivateAnActiveGate() throws WPIPSException
	{
		gate.deactivate();
		assertEquals(TollboothGate.TollboothGateState.DEACTIVATED, gate.getState());
	}
	
	/**
	 * Ensure that an initialized tollbooth gate is closed.
	 * @throws WPIPSException
	 */
	@Test
	public void initializedTollboothGateIsClosed() throws WPIPSException
	{
		assertNotNull(gate);
		assertEquals(TollboothGate.TollboothGateState.CLOSED, gate.getState());
	}

	/**
	 * A blank ID should cause an exception.
	 * @throws WPIPSException
	 */
	@Test(expected=WPIPSException.class)
	public void blankIDIsInvalid() throws WPIPSException
	{
		new TollboothGate("", controller);
	}
	
	/**
	 * A null ID should cause an exception.
	 * @throws WPIPSException
	 */
	@Test(expected=WPIPSException.class)
	public void nullIDIsInvalid() throws WPIPSException
	{
		new TollboothGate(null, controller);
	}
	
	/**
	 * Open a closed gate. This should make the gate's state OPEN.
	 * @throws WPIPSException
	 */
	@Test
	public void openAClosedGateShouldGiveAnOpenState() throws WPIPSException
	{
		assertEquals(TollboothGate.TollboothGateState.OPEN, gate.open());
		assertEquals(TollboothGate.TollboothGateState.OPEN, gate.getState());
	}
	
	/**
	 * Close an open gate. This should make the gate's state CLOSED.
	 * @throws WPIPSException
	 */
	@Test
	public void closeAnOpenGateShouldGiveAClosedState() throws WPIPSException
	{
		gate.open();
		assertEquals(TollboothGate.TollboothGateState.CLOSED, gate.close());
		assertEquals(TollboothGate.TollboothGateState.CLOSED, gate.getState());
	}
	
	/**
	 * If there is an error in the gate controller hardware, then the gate should be
	 * in an UNKNOWN state after closing.
	 */
	@Test
	public void errorOnClosingCausesExceptionAndUnknownState()
	{
		controller.setCloseResults(new boolean[] {false});
		TollboothGate gate = null;
		try {
			gate = new TollboothGate("gate1", controller);
			gate.close();		// in case close is not called on initialization
			fail("Expected gate controller exception");
		} catch (WPIPSException e) {
			assertEquals(TollboothGate.TollboothGateState.UNKNOWN, gate.getState());
		}
	}
	
	/**
	 * If there is an error in the gate controller hardware, then the gate should be
	 * in an UNKNOWN state after opening.
	 */
	@Test
	public void errorOnOpeningCausesExceptionAndUnknownState()
	{
		controller.setOpenResults(new boolean[] {false});
		TollboothGate gate = null;
		try {
			gate = new TollboothGate("gate1", controller);
			gate.open();
			fail("Expected gate controller exception");
		} catch (WPIPSException e) {
			assertEquals(TollboothGate.TollboothGateState.UNKNOWN, gate.getState());
		}
	}
}
