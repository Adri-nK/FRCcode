// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArcadeDriveSub;
import edu.wpi.first.wpilibj.Timer;

public class AutoCommandDefault extends CommandBase {
  /** Creates a new AutoCommand. */

  private final Timer timer = new Timer();
  private final ArcadeDriveSub m_robotDrive;
  public AutoCommandDefault(ArcadeDriveSub robotDrive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_robotDrive = robotDrive;
    addRequirements(m_robotDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();  
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double time = timer.get();

  if (time > 0 && time < 4 ) { 
    m_robotDrive.arcadeDrive(0, -0.50);

  } else if (time < 6 && time > 4) { 
    m_robotDrive.arcadeDrive(0.5, 0);

  } else if (time < 8 && time > 6) {
    m_robotDrive.arcadeDrive(0, -0.5);

  } else {
    m_robotDrive.arcadeDrive(0, 0);
  }
  } 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
