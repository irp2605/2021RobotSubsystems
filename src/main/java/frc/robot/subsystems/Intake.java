  
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase
{
    private SpeedController sc;
    public Intake(SpeedController sc)
    {
        this.sc = sc;
    }

    public void moveIntake(double speed)
    {
        sc.set(speed);
    }

    public void stopIntake()
    {
        sc.stopMotor();
    }

}