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

  private final CANSparkMax leftFront = new CANSparkMax(11, MotorType.kBrushless);
  private final CANSparkMax leftBack = new CANSparkMax(5, MotorType.kBrushless);
  private final CANSparkMax rightFront = new CANSparkMax(6, MotorType.kBrushless);
  private final CANSparkMax rightBack = new CANSparkMax(8, MotorType.kBrushless);
  private final MotorControllerGroup m_leftSide = new MotorControllerGroup(leftFront, leftBack);
  private final MotorControllerGroup m_rightSide = new MotorControllerGroup(rightFront, rightBack);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftSide, m_rightSide);
  

  /** Creates a new ArcadeDriveSub. */
  public ArcadeDriveSub(double xSpeed, double zRotation) {
      m_robotDrive.arcadeDrive(xSpeed, zRotation);
   
  }


  @Override
  public void periodic() {
}
}