
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package education.stemi.hexapod.appinventor;

import education.stemi.hexapod.Hexapod;

import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
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

  // B0
  @SimpleProperty(description = "Value of an additional data sent to STEMI Hexapod.",
                  category = PropertyCategory.BEHAVIOR)
  public int B0() {
    return hexapod.curr_packet.sliders_array[2];
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
                    defaultValue = "0")
  @SimpleProperty
  public void B0(int x) {
    hexapod.curr_packet.sliders_array[2] = x;
  }

  // B1
  @SimpleProperty(description = "Value of an additional data sent to STEMI Hexapod.",
                  category = PropertyCategory.BEHAVIOR)
  public int B1() {
    return hexapod.curr_packet.sliders_array[3];
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
                    defaultValue = "0")
  @SimpleProperty
  public void B1(int x) {
    hexapod.curr_packet.sliders_array[3] = x;
  }

  // B2
  @SimpleProperty(description = "Value of an additional data sent to STEMI Hexapod.",
                  category = PropertyCategory.BEHAVIOR)
  public int B2() {
    return hexapod.curr_packet.sliders_array[4];
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
                    defaultValue = "0")
  @SimpleProperty
  public void B2(int x) {
    hexapod.curr_packet.sliders_array[4] = x;
  }

  // B3
  @SimpleProperty(description = "Value of an additional data sent to STEMI Hexapod.",
                  category = PropertyCategory.BEHAVIOR)
  public int B3() {
    return hexapod.curr_packet.sliders_array[5];
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
                    defaultValue = "0")
  @SimpleProperty
  public void B3(int x) {
    hexapod.curr_packet.sliders_array[5] = x;
  }

  // B4
  @SimpleProperty(description = "Value of an additional data sent to STEMI Hexapod.",
                  category = PropertyCategory.BEHAVIOR)
  public int B4() {
    return hexapod.curr_packet.sliders_array[6];
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
                    defaultValue = "0")
  @SimpleProperty
  public void B4(int x) {
    hexapod.curr_packet.sliders_array[6] = x;
  }

  // B5
  @SimpleProperty(description = "Value of an additional data sent to STEMI Hexapod.",
                  category = PropertyCategory.BEHAVIOR)
  public int B5() {
    return hexapod.curr_packet.sliders_array[7];
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
                    defaultValue = "0")
  @SimpleProperty
  public void B5(int x) {
    hexapod.curr_packet.sliders_array[7] = x;
  }

  // B6
  @SimpleProperty(description = "Value of an additional data sent to STEMI Hexapod.",
                  category = PropertyCategory.BEHAVIOR)
  public int B6() {
    return hexapod.curr_packet.sliders_array[8];
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
                    defaultValue = "0")
  @SimpleProperty
  public void B6(int x) {
    hexapod.curr_packet.sliders_array[8] = x;
  }

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
   * Regulate the speed of the robot 0..100.
   */
  @SimpleFunction
  public void setSpeed(int speed) {
    hexapod.setPower(speed);
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
