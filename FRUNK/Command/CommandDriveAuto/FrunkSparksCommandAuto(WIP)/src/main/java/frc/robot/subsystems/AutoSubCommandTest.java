// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.ArcadeDriveSub;
import edu.wpi.first.wpilibj.Timer;

public class AutoSubCommandTest extends SubsystemBase {
  /** Creates a new AutoSubCommandTest. */
  private final ArcadeDriveSub m_robotDrive;
  private final Timer timer = new Timer();
  public AutoSubCommandTest(ArcadeDriveSub robotDrive) {
    m_robotDrive = robotDrive;
  }
@Override
public void initialize() {
  timer.reset();  
  timer.start();
}
  @Override
  public void periodic() {
    
  }
}
