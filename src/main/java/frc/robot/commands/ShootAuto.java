package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.Constants;


public class ShootAuto extends CommandBase {

        //move pulley, shooter, transport
        private double pulleySpeed;
        private double shooterLeftSpeed;
        private double shooterRightSpeed;
        private double transportSpeed;

        public ShootAuto(double pulleySpeed, double transportSpeed, double shooterLeftSpeed, double shooterRightSpeed) {
            this.pulleySpeed = pulleySpeed;
            this.shooterLeftSpeed = shooterLeftSpeed;
            this.shooterRightSpeed = shooterRightSpeed;
            this.transportSpeed = transportSpeed;
        }

        public void initialize() {
            Robot.m_robotContainer.getPulley().movePulley(pulleySpeed);
            Robot.m_robotContainer.getTransport().moveTransport(transportSpeed);
            Robot.m_robotContainer.getShooter().moveShooter(shooterLeftSpeed, shooterRightSpeed);   
        }

        public void execute() {
            Robot.m_robotContainer.getPulley().movePulley(pulleySpeed);
            Robot.m_robotContainer.getTransport().moveTransport(transportSpeed);
            Robot.m_robotContainer.getShooter().moveShooter(shooterLeftSpeed, shooterRightSpeed);
        }

        public boolean isFinished() {
            return false;
        }

        public void end() {
            Robot.m_robotContainer.getPulley().stopPulley();
            Robot.m_robotContainer.getShooter().stopShooter();
            Robot.m_robotContainer.getTransport().stopTransport();
        }

        
}