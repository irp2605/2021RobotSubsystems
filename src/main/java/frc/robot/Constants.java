/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    public static final int ENCODER_LIMIT = 1;

    public static final int ELEVATOR_BUTTON = 14;

    public static final int LEFT_ONE_PORT = 0;
    public static final int LEFT_TWO_PORT = 1;
    public static final int RIGHT_ONE_PORT = 2;
    public static final int RIGHT_TWO_PORT = 3;

    public static final double LEFT_ONE_BIAS = 1;
    public static final double LEFT_TWO_BIAS = 1;
    public static final double RIGHT_ONE_BIAS = 1;
    public static final double RIGHT_TWO_BIAS = 1;


    public static final int INTAKE_SC_PORT = 4;
    public static final int TRANSPORT_SC_PORT = 5;
    public static final int PULLEY_SC_PORT = 6;

    public static final int INTAKE_IN_BUTTON = 7;
    public static final int INTAKE_OUT_BUTTON = 8;

    public static final int PULLEY_IN_BUTTON = 9;
    public static final int PULLEY_OUT_BUTTON = 10;

    public static final int SHOOTER_LEFT_PORT = 11;
    public static final int SHOOTER_RIGHT_PORT = 12;

    public static final int SHOOTER_OUT_BUTTON = 13;

    public static final int TRANSPORT_IN_BUTTON = 7;
    public static final int TRANSPORT_OUT_BUTTON = 8;

    public static final double TRANSPORT_IN_SPEED = 0.5;
    public static final double TRANSPORT_OUT_SPEED = -0.8;

    public static final double INTAKE_IN_SPEED = 0.5;
    public static final double INTAKE_OUT_SPEED = -0.8;

    public static final double ARM_TOP_LIMIT = 0.5;
    public static final double ARM_BOTTOM_LIMIT = -0.5;

    public static final int ARM_MOTOR_PORT = 6;
    public static final int ARM_POT_PORT = 7;

    public static final int ARM_UP_BUTTON = 9;
    public static final int ARM_DOWN_BUTTON = 10;

    public static final double WRIST_TOP_LIMIT = 0.5;
    public static final double WRIST_BOTTOM_LIMIT = -0.5;

    
    public static final int WRIST_MOTOR_PORT = 8;
    public static final int WRIST_POT_PORT = 9;
    
    public static final int WRIST_UP_BUTTON = 11;
    public static final int WRIST_DOWN_BUTTON = 12;

    public static final int SOL = 10;
    public static final int HATCH_BUTTON = 13;
    public static final boolean SOL_BOOL = true;
}