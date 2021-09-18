// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveElevator;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.MoveIntake;
import frc.robot.commands.MovePulley;
import frc.robot.commands.MoveShooter;
import frc.robot.commands.MoveTransport;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Transport;
import frc.robot.subsystems.Pulley;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private SpeedController leftOne, leftTwo, rightOne, rightTwo;
  private SpeedControllerGroup left, right;
  private DifferentialDrive drive;
  private static DriveTrain driveTrain;
  private SpeedController intakeSC;
  
  private SpeedController transportSC;
  private Transport transport;

  private Intake intake;
  private static Joystick joy; 
  private Button intakeIn, intakeOut;

  private Button transportIn, transportOut;

  private Button pulleyIn, pulleyOut;
  private SpeedController pulleySC;
  private Pulley pulley;

  private Shooter shooter;
  private SpeedController shooterL, shooterR;
  private Button shooterOut;

  private SpeedController leftElevatorController, rightElevatorController;
  private Encoder leftElevatorEncoder, rightElevatorEncoder;
  private DigitalInput elevatorSwitch;
  private Elevator elevator;
  private Button elevatorDownButton;
  private Button elevatorUpButton;

  private Button elevatorMove;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    leftOne = new SteelTalonsController(Constants.LEFT_ONE_PORT, false, Constants.LEFT_ONE_BIAS);
    leftTwo = new SteelTalonsController(Constants.LEFT_TWO_PORT, false, Constants.LEFT_TWO_BIAS);
    rightOne = new SteelTalonsController(Constants.RIGHT_ONE_PORT, false, Constants.RIGHT_ONE_BIAS);
    rightTwo = new SteelTalonsController(Constants.RIGHT_TWO_PORT, false, Constants.RIGHT_TWO_BIAS);

    left = new SpeedControllerGroup(leftOne, leftTwo);
    right = new SpeedControllerGroup(rightOne, rightTwo);

    drive = new DifferentialDrive(left, right);

    driveTrain = new DriveTrain(left, right, drive);
    driveTrain.setDefaultCommand(new DriveWithJoystick());

    intakeSC = new SteelTalonsController(Constants.INTAKE_SC_PORT, false, 1);
    intake = new Intake(intakeSC);

    transportSC = new SteelTalonsController(Constants.TRANSPORT_SC_PORT, false, 1);
    transport = new Transport(transportSC);

    pulleySC = new SteelTalonsController(Constants.PULLEY_SC_PORT, false, 1);
    pulley = new Pulley(pulleySC);

    shooterL = new SteelTalonsController(Constants.SHOOTER_LEFT_PORT, false, 1);
    shooterR = new SteelTalonsController(Constants.SHOOTER_RIGHT_PORT, false, 1);
    shooter = new Shooter(left, right);

    leftElevatorController = new SteelTalonsController(Constants.SHOOTER_LEFT_PORT, false, 1);
    rightElevatorController = new SteelTalonsController(Constants.SHOOTER_RIGHT_PORT, false, 1);
    elevator = new Elevator(leftElevatorController, rightElevatorController, leftElevatorEncoder, rightElevatorEncoder, elevatorSwitch);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    joy = new Joystick(0);

    intakeIn = new JoystickButton(joy, Constants.INTAKE_IN_BUTTON);
    intakeOut = new JoystickButton(joy, Constants.INTAKE_OUT_BUTTON);

    intakeIn.whileHeld(new MoveIntake(Constants.INTAKE_IN_SPEED));
    intakeOut.whileHeld(new MoveIntake(Constants.INTAKE_OUT_SPEED));
    

    transportIn = new JoystickButton(joy, Constants.TRANSPORT_IN_BUTTON);
    transportOut = new JoystickButton(joy, Constants.TRANSPORT_OUT_BUTTON);

    transportIn.whileHeld(new MoveTransport(Constants.TRANSPORT_IN_SPEED));
    transportOut.whileHeld(new MoveTransport(Constants.TRANSPORT_OUT_SPEED));
    
    pulleyIn = new JoystickButton(joy, Constants.PULLEY_IN_BUTTON);
    pulleyOut = new JoystickButton(joy, Constants.PULLEY_OUT_BUTTON);

    pulleyIn.whileHeld(new MovePulley(Constants.PULLEY_IN_BUTTON));
    pulleyOut.whileHeld(new MovePulley(Constants.PULLEY_OUT_BUTTON));

    shooterOut = new JoystickButton(joy, Constants.SHOOTER_OUT_BUTTON);

    shooterOut.whileHeld(new MoveShooter(Constants.SHOOTER_OUT_BUTTON));

    elevatorMove = new JoystickButton(joy, Constants.ELEVATOR_BUTTON);

    elevatorMove.whileHeld(new MoveElevator(Constants.ELEVATOR_BUTTON));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

   
  public DriveTrain getDriveTrain()
  {
    return driveTrain;
  }

  public Joystick getJoystick()
  {
    return joy;
  }

  public Intake getIntake()
  {
    return intake;
  }

  public Transport getTransport(){
    return transport;
  }

  public Pulley getPulley(){
    return pulley;
  }

  public Shooter getShooter(){
    return shooter;
  }

  public Elevator getElevator(){
    return elevator;
  } 

}
