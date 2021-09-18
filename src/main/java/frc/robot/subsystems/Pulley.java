package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;   
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pulley extends SubsystemBase {
    SpeedController sc;
    public Pulley(SpeedController sc)
    {
        this.sc = sc;
    }

    public void movePulley(double speed)
    {
        sc.set(speed);
    }

    public void stopPulley()
    {
        sc.stopMotor();
    }
}