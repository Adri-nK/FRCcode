// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.Timer;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

//import java.beans.Encoder;

//import edu.wpi.first.wpilibj.AnalogPotentiometer;
//import edu.wpi.first.wpilibj.Compressor;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class Robot extends TimedRobot {

  boolean True = true;
  private final CANSparkMax leftFront = new CANSparkMax(11, MotorType.kBrushless);
  private final CANSparkMax leftBack = new CANSparkMax(5, MotorType.kBrushless);
  private final CANSparkMax rightFront = new CANSparkMax(6, MotorType.kBrushless);
  private final CANSparkMax rightBack = new CANSparkMax(8, MotorType.kBrushless);
  private final MotorControllerGroup m_leftSide = new MotorControllerGroup(leftFront, leftBack);
  private final MotorControllerGroup m_rightSide = new MotorControllerGroup(rightFront, rightBack);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftSide, m_rightSide);

 // private final Timer timer = new Timer();

  private static final int kEncoderTicksPerRev = 42;
  private static final double kTargetDegrees = 90;
  private static final double kSpeed = 0.05;
  private double targetPosition;

  private final XboxController m_stick = new XboxController(0);

  AbsoluteEncoder encoderALF = leftFront.getAbsoluteEncoder(Type.kDutyCycle);
  AbsoluteEncoder encoderALB = leftBack.getAbsoluteEncoder(Type.kDutyCycle);
  AbsoluteEncoder encoderARF = rightFront.getAbsoluteEncoder(Type.kDutyCycle);
  AbsoluteEncoder encoderARB = rightBack.getAbsoluteEncoder(Type.kDutyCycle);

  /// I2C.Port.kMxp
  // SerialPort.Port.kMXP
   private AHRS navx;

   public Robot(){
    try{
       navx = new AHRS( SPI.Port.kMXP);
    } catch(Exception e){
      System.out.println(e.getMessage());
    }
   }
  // private final Compressor pcmCompressor = new Compressor(0,
  // PneumaticsModuleType.CTREPCM);
  // private final double scale = 250, offset = -25;
  /*
   * private final DoubleSolenoid dFl_solenoid = new
   * DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
   * private final DoubleSolenoid dBl_solenoid = new
   * DoubleSolenoid(PneumaticsModuleType.CTREPCM, 7, 6);
   * private final DoubleSolenoid dFr_solenoid = new
   * DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 2);
   * private final DoubleSolenoid dBr_solenoid = new
   * DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5);
   */
  // private final AnalogPotentiometer pressureTransducer = new
  // AnalogPotentiometer(0, scale, offset);

  @Override
  public void robotInit() {

    encoderALF.setPositionConversionFactor(360 / kEncoderTicksPerRev);
    encoderALB.setPositionConversionFactor(360 / kEncoderTicksPerRev);
    encoderARF.setPositionConversionFactor(360 / kEncoderTicksPerRev);
    encoderARB.setPositionConversionFactor(360 / kEncoderTicksPerRev);
    targetPosition = kTargetDegrees / 360.0;

    /*
     * double psi = pressureTransducer.get();
     * 
     * if(psi <= 119) {
     * pcmCompressor.enableDigital();
     * } else if(psi >= 120) {
     * pcmCompressor.disable();
     * }
     */
  }

  @Override
  public void autonomousInit() {
    navx.reset();
   // timer.reset();
   // timer.start();

    m_leftSide.setInverted(True);
    m_rightSide.setInverted(True);

    leftFront.setIdleMode(IdleMode.kBrake);
    leftBack.setIdleMode(IdleMode.kBrake);
    rightFront.setIdleMode(IdleMode.kBrake);
    rightBack.setIdleMode(IdleMode.kBrake);
  }
  @Override
  public void autonomousPeriodic() {
    double randomStuff = navx.getAngle();
    SmartDashboard.putData(navx);
    SmartDashboard.putNumber("NAVXANGLE", randomStuff);
/*
    double time = timer.get();

    if (time > 0 && time < 4) {
      m_robotDrive.arcadeDrive(0, -0.50);
      // xSpeed is zRotation
      // and - is +
      // and reverse
    } else if (time < 6 && time > 4) {
      m_robotDrive.arcadeDrive(0.5, 0);

    } else if (time < 8 && time > 6) {
      m_robotDrive.arcadeDrive(0, -0.5);

    } else {
      m_robotDrive.arcadeDrive(0, 0);
    }*/
    double absolutePositionLF = encoderALF.getPosition();
    double absolutePositionLB = encoderALB.getPosition();
    double absolutePositionRF = encoderARF.getPosition();
    double absolutePositionRB = encoderARB.getPosition();
System.out.println(encoderALF.getPosition());
System.out.println(targetPosition);
while (absolutePositionLF < targetPosition) {
  leftFront.set(kSpeed);
  leftBack.set(kSpeed);
}
/* 
    if (absolutePositionLF < targetPosition) {
      leftFront.set(kSpeed);
      leftBack.set(kSpeed);
    } else {
      leftFront.set(0);
      leftBack.set(0);
    }

    if (absolutePositionRF < targetPosition) {
      rightFront.set(-kSpeed);
      rightBack.set(-kSpeed);
    } else {
      rightFront.set(0);
      rightBack.set(0);
    }*/
 
  }

  @Override
  public void teleopInit() {
    True = false;
    m_leftSide.setInverted(True);
    m_rightSide.setInverted(True);
  }

  @Override
  public void teleopPeriodic() {

    double randomStuff = navx.getAngle();
    SmartDashboard.putData(navx);
    SmartDashboard.putNumber("NAVXANGLE", randomStuff);

    leftFront.setIdleMode(IdleMode.kBrake);
    leftBack.setIdleMode(IdleMode.kBrake);
    rightFront.setIdleMode(IdleMode.kBrake);
    rightBack.setIdleMode(IdleMode.kBrake);
    m_robotDrive.arcadeDrive(m_stick.getRawAxis(4) * 0.8, m_stick.getRawAxis(1) * 0.8);
  }
}