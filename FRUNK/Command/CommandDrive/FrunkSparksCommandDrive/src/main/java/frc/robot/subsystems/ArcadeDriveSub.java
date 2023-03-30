// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class ArcadeDriveSub extends SubsystemBase {

  //private final CANSparkMax leftFront = new CANSparkMax(17, MotorType.kBrushless);
  private final CANSparkMax leftBack = new CANSparkMax(4, MotorType.kBrushless);
  //private final CANSparkMax rightFront = new CANSparkMax(10, MotorType.kBrushless);
  private final CANSparkMax rightBack = new CANSparkMax(18, MotorType.kBrushless);
  private final MotorControllerGroup m_leftSide = new MotorControllerGroup( leftBack);
  private final MotorControllerGroup m_rightSide = new MotorControllerGroup( rightBack);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftSide, m_rightSide);
  

  public ArcadeDriveSub(){
    
  }

  /** Creates a new ArcadeDriveSub. */
  public void arcadeDrive(double xSpeed, double zRotation) {
      m_robotDrive.arcadeDrive(xSpeed, zRotation);
   
  }


  @Override
  public void periodic() {
}
}