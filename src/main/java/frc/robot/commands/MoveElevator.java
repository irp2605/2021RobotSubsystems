package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveElevator extends CommandBase
{
    private double speed;
	private Boolean interrupted;

    public MoveElevator(double speed)
    {
        this.speed = speed;
    }

    @Override
    public void initialize()
    {
        Robot.m_robotContainer.getElevator().moveElevator(speed);
    }

    @Override
    public void execute()
    {
        Robot.m_robotContainer.getElevator().moveElevator(speed);

    }

    @Override
    public boolean isFinished()
    {
        return !Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.ELEVATOR_BUTTON);
    }

    @Override
    public void end(boolean interrupted)
    {
		Robot.m_robotContainer.getElevator().stopElevator();
    }
}