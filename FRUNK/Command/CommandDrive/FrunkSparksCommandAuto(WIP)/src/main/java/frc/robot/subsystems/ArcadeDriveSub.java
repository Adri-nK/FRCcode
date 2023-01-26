// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class ArcadeDriveSub extends SubsystemBase {

  private static final CANSparkMax leftFront = new CANSparkMax(11, MotorType.kBrushless);
  private static final CANSparkMax leftBack = new CANSparkMax(5, MotorType.kBrushless);
  private static final CANSparkMax rightFront = new CANSparkMax(6, MotorType.kBrushless);
  private static final CANSparkMax rightBack = new CANSparkMax(8, MotorType.kBrushless);
  private static final MotorControllerGroup m_leftSide = new MotorControllerGroup(leftFront, leftBack);
  private static final MotorControllerGroup m_rightSide = new MotorControllerGroup(rightFront, rightBack);
  private static final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftSide, m_rightSide);

  
  public ArcadeDriveSub(){    
  }

  /** Creates a new ArcadeDriveSub. */
  public void arcadeDrive(double xSpeed, double zRotation) {
      m_robotDrive.arcadeDrive(xSpeed, zRotation);
   
  }
 
  @Override
  public void periodic() {
    leftFront.setIdleMode(IdleMode.kBrake);
    leftBack.setIdleMode(IdleMode.kBrake);
    rightFront.setIdleMode(IdleMode.kBrake);
    rightBack.setIdleMode(IdleMode.kBrake);
}
}