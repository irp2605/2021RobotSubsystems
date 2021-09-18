package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;   
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    SpeedController left, right;
    public Shooter(SpeedController left, SpeedController right)
    {
        this.left = left;
        this.right = right;

    }

    public void moveShooter(double leftSpeed, double rightSpeed)
    {   
        left.set(leftSpeed);
        right.set(rightSpeed);
    }

    public void stopShooter()
    {
        left.stopMotor();
        right.stopMotor();
    }
}