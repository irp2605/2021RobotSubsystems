  
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class Elevator extends SubsystemBase{
  
    private SpeedController leftSC, rightSC;
    private Encoder leftEnc, rightEnc;
    private DigitalInput eSwitch;  

    public Elevator(SpeedController leftSC, SpeedController rightSC, Encoder leftEnc, Encoder rightEnc, DigitalInput eSwitch) {
        this.leftSC = leftSC;
        this.rightSC = rightSC;
        this.leftEnc = leftEnc;
        this.rightEnc = rightEnc;
        this.eSwitch = eSwitch;
    }

    public void moveElevator(double speed)
    {
        leftSC.set(speed);
        rightSC.set(speed);
    }

    public void stopElevator() {
        leftSC.stopMotor();
        rightSC.stopMotor();
    }

    @Override
    public void periodic(){
        if(leftEnc.getDistance()>Constants.ENCODER_LIMIT || rightEnc.getDistance()>Constants.ENCODER_LIMIT)
            stopElevator();
    }

}
