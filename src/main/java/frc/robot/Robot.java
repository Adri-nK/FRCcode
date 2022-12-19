// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;


public class Robot extends TimedRobot {

  private final CANSparkMax leftFront = new CANSparkMax(11, MotorType.kBrushless);
  private final CANSparkMax leftBack = new CANSparkMax(5, MotorType.kBrushless);
  private final CANSparkMax rightFront = new CANSparkMax(6, MotorType.kBrushless);
  private final CANSparkMax rightBack = new CANSparkMax(8, MotorType.kBrushless);

  private final MotorControllerGroup m_leftSide = new MotorControllerGroup(leftFront, leftBack);
  private final MotorControllerGroup m_rightSide = new MotorControllerGroup(rightFront, rightBack);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftSide, m_rightSide);

  private final XboxController m_stick = new XboxController(0);

  boolean True = true;

  private final Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

  private final double scale = 250, offset = -25;

  private final DoubleSolenoid dFl_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
  private final DoubleSolenoid dBl_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 7, 6);
  private final DoubleSolenoid dFr_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 2);
  private final DoubleSolenoid dBr_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5);

  private final AnalogPotentiometer pressureTransducer = new AnalogPotentiometer(0, scale, offset);


  @Override
  public void robotInit() {

    double psi = pressureTransducer.get();

    if(psi <= 119) {
      pcmCompressor.enableDigital();
    } else if(psi >= 120) {
      pcmCompressor.disable();
    }
  }

  @Override
  public void teleopPeriodic() {

    leftFront.setIdleMode(IdleMode.kCoast);
    leftBack.setIdleMode(IdleMode.kCoast);
    rightFront.setIdleMode(IdleMode.kCoast);
    rightBack.setIdleMode(IdleMode.kCoast);
   
  m_robotDrive.arcadeDrive(m_stick.getRawAxis(4)*0.8, -m_stick.getRawAxis(1)*0.8);

//DOuble Front Left
if(m_stick.getRawButton(4) == True) {
  dFl_solenoid.set(Value.kForward);
}else if(m_stick.getRawButton(4) == false){
  dFl_solenoid.set(Value.kReverse);
}else{
  dFl_solenoid.set(Value.kOff);
}

//DOuble Back Left
if(m_stick.getRawButton(3) == True) {
  dBl_solenoid.set(Value.kForward);
}else if(m_stick.getRawButton(3) == false){
  dBl_solenoid.set(Value.kReverse);
}else{
  dBl_solenoid.set(Value.kOff);
}

//DOuble Front Right
if(m_stick.getRawButton(2) == True) {
  dFr_solenoid.set(Value.kForward);
}else if(m_stick.getRawButton(2) == false){
  dFr_solenoid.set(Value.kReverse);
}else{
  dFr_solenoid.set(Value.kOff);
}

//DOuble Back Right
if(m_stick.getRawButton(1) == True) {
  dBr_solenoid.set(Value.kForward);
}else if(m_stick.getRawButton(1) == false){
  dBr_solenoid.set(Value.kReverse);
}else{
  dBr_solenoid.set(Value.kOff);
}
  }
}
