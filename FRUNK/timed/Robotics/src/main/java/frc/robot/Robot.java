// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {

  boolean True = true;
  private final CANSparkMax leftFront = new CANSparkMax(11, MotorType.kBrushless);
  //private final CANSparkMax leftBack = new CANSparkMax(5, MotorType.kBrushless);
  private final CANSparkMax rightFront = new CANSparkMax(6, MotorType.kBrushless);
  private final CANSparkMax rightBack = new CANSparkMax(8, MotorType.kBrushless);
  public final WPI_TalonFX rightBackFX = new WPI_TalonFX(6);
  private final MotorControllerGroup m_leftSide = new MotorControllerGroup(leftFront, rightBackFX); //leftback
  private final MotorControllerGroup m_rightSide = new MotorControllerGroup(rightFront, rightBack);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftSide, m_rightSide);

  private final XboxController m_stick = new XboxController(0);

@Override
public void robotPeriodic(){
}

  @Override
  public void robotInit() {
    m_leftSide.setInverted(True);
    m_rightSide.setInverted(True);
    leftFront.setIdleMode(IdleMode.kBrake);
    //leftBack.setIdleMode(IdleMode.kBrake);
    rightFront.setIdleMode(IdleMode.kBrake);
    rightBack.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void teleopInit() {
    True = false;
    //camera vvv
    UsbCamera camera = CameraServer.startAutomaticCapture();
  }

  @Override
  public void teleopPeriodic() {
    rightBackFX.set(1);
    //m_robotDrive.arcadeDrive(m_stick.getRawAxis(4) * 0.8, m_stick.getRawAxis(1) * 0.8);
  }
}