
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package education.stemi.hexapod.appinventor;

import education.stemi.hexapod.Hexapod;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.runtime.*;

/**
 * STEMIHexapod provides access to STEMI hexapod.
 *
 *
 */
@DesignerComponent(version = YaVersion.STEMI_HEXAPOD_COMPONENT_VERSION,
   description = "STEMI hexapod component.",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = "images/extension.png")
@SimpleObject(external = true)
@UsesPermissions(permissionNames = "android.permission.INTERNET, android.permission.ACCESS_WIFI_STATE")
@UsesLibraries(libraries = "hexapod-java.jar")
public class STEMIHexapod extends AndroidNonvisibleComponent implements Component {

  private final ComponentContainer container;
  private static Hexapod hexapod;

  /**
   * Creates a STEMIHexapod.
   *
   * @param container container, component will be placed in
   */
  public STEMIHexapod(ComponentContainer container) {
    super(container.$form());
    this.container = container;
  }

  /**
   * Connect to the STEMI hexapod.
   */
  @SimpleFunction
  public void connect() {
    hexapod = new Hexapod();
    hexapod.connect();
  }

  /**
   * Disconnect from the STEMI hexapod.
   */
  @SimpleFunction
  public void disconnect() {
    hexapod.disconnect();
  }

  /**
   * Command your STEMI hexapd to go forward.
   */
  @SimpleFunction
  public void goForward() {
    hexapod.goForward();
  }

  /**
   * Command your STEMI hexapd to go backward.
   */
  @SimpleFunction
  public void goBackward() {
    hexapod.goBackward();
  }

  /**
   * Command your STEMI hexapd to go left.
   */
  @SimpleFunction
  public void goLeft() {
    hexapod.goLeft();
  }

  /**
   * Command your STEMI hexapd to go right.
   */
  @SimpleFunction
  public void goRight() {
    hexapod.goRight();
  }

  /**
   * Command your STEMI hexapd to stop moving.
   */
  @SimpleFunction
  public void stopMoving() {
    hexapod.stopMoving();
  }

  /**
   * Command your STEMI hexapd to turn counterclockwise.
   */
  @SimpleFunction
  public void turnLeft() {
    hexapod.turnLeft();
  }

  /**
   * Command your STEMI hexapd to turn clockwise.
   */
  @SimpleFunction
  public void turnRight() {
    hexapod.turnRight();
  }

  /**
   * Enable tilting.
   */
  @SimpleFunction
  public void enableTilting() {
    hexapod.setMovingTilt();
  }

  /**
   * Disable tilting.
   */
  @SimpleFunction
  public void disableTilting() {
    hexapod.disableTilt();
  }

  /**
   * Check tilting.
   */
  @SimpleFunction
  public boolean isTiltingEnabled() {
    return hexapod.curr_packet.movingTilt == 1;
  }

  /**
   * Turn ON.
   */
  @SimpleFunction
  public void turnOn() {
    hexapod.turnOn();
  }

  /**
   * Turn OFF.
   */
  @SimpleFunction
  public void turnOff() {
    hexapod.turnOff();
  }

  /**
   * Check ON/OFF.
   */
  @SimpleFunction
  public boolean isOn() {
    return hexapod.curr_packet.onOff == 1;
  }

  /**
   * Set height.
   */
  @SimpleFunction
  public void setHeight(int height) {
    hexapod.setHeight(height);
  }

  /**
   * Get height.
   */
  @SimpleFunction
  public int getHeight() {
    return hexapod.getHeight();
  }

  /**
   * Set accelerometer x axis. Settin Y axis instead of X, and inverted.
   * Hexapod object was intended for a smartphone to be held in landscape mode.
   */
  @SimpleFunction
  public void setAccX(float x) {
    if (x < -4) hexapod.setAccY(40);
    else if (x > 4) hexapod.setAccY(-40);
    else hexapod.setAccY((byte) (int) (-x * 10));
  }

  /**
   * Set accelerometer y axis. Setting X axis instead of Y.
   * Hexapod object was intended for a smartphone to be held in landscape mode.
   */
  @SimpleFunction
  public void setAccY(float y) {
    if (y < -4) hexapod.setAccX(-40);
    else if (y > 4) hexapod.setAccX(40);
    else hexapod.setAccX((byte) (int) (y * 10));
  }
}
