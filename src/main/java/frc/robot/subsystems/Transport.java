package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Transport extends SubsystemBase {
    SpeedController sc;
    public Transport(SpeedController sc)
    {
        this.sc = sc;
    }

    public void moveTransport(double speed)
    {
        sc.set(speed);
    }

    public void stopTransport()
    {
        sc.stopMotor();
    }
}